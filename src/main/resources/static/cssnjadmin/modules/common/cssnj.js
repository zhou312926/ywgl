layui.define(['layer'], function (exports) {
    var $ = layui.jquery
        , setter = layui.setter
        , cssnj = {
        loading: function () {
            return layer.load(1);
        },
        alert: function (msg, options) {
            var obj = {
                title: "提示",
                end: function () {
                    return;
                }
            };
            $.extend(obj, options);
            layer.alert(msg, {
                title: obj.title
            }, function (index) {
                layer.close(index);
                obj.end();
            });
        },
        confirm: function (msg, options) {
            var obj = {
                title: "提示",
                btn: ['确定', '取消'],
                yes: function (index) {
                    return;
                },
                cancel: function (index) {
                    return;
                }
            };
            $.extend(obj, options);
            layer.confirm(msg, {
                title: obj.title,
                btn: obj.btn
            }, function (index) {
                layer.close(index);
                obj.yes(index);
            }, function (index) {
                obj.cancel(index);
            });
        }

        , window: function (title, url, options) {
            var obj = {
                type: 2
            };
            $.extend(obj, options);
            cssnj.open(title, url, obj);
        }
        , layer: function (title, dom, options) {
            var obj = {
                type: 1
            };
            $.extend(obj, options);
            cssnj.open(title, dom, obj);
        },
        open: function (title, content, options) {
            var obj = {
                type: 1,
                width: '800px',
                height: '600px',
                btn: null,
                skin: null,
                btnAlign: 'r',
                closeBtn: 1,
                success: function (layero, index) {
                    return;
                },
                yes: function (index, layero) {
                    return;
                },
                btn2: function (index, layero) {
                    return;
                }
                , btn3: function (index, layero) {
                    return;
                },
                cancel: function (index, layero) {
                    return;
                },
                end: function () {
                    return;
                }
            };
            $.extend(obj, options);
            layer.open({
                type: obj.type,
                title: title,
                content: content,
                area: [obj.width, obj.height],
                btn: obj.btn,
                skin: obj.skin,
                btnAlign: obj.btnAlign,
                closeBtn: obj.closeBtn,
                resize: false,
                success: function (layero, index) {
                    return obj.success(layero, index);
                },
                yes: function (index, layero) {
                    return obj.yes(index, layero);
                },
                btn2: function (index, layero) {
                    return obj.btn2(index, layero);
                },
                btn3: function (index, layero) {
                    return obj.btn3(index, layero);
                },
                cancel: function (index, layero) {
                    return obj.cancel(index, layero);
                },
                end: function () {
                    return obj.end();
                }
            });
        }
        , close: function (index) {
            layer.close(index);
        }
        , isNull: function (obj) {
            return obj == undefined || obj == null && obj == "";
        }
    };

    cssnj.disabled = function (dom) {
        dom.find("input").attr("disabled", true).addClass("layui-disabled");
        dom.find("select").attr("disabled", true).addClass("layui-disabled");
        dom.find("textarea").attr("disabled", true).addClass("layui-disabled");
    };

    cssnj.readonly = function (dom) {
        dom.find("input").attr("readonly", true);
        dom.find("select").attr("disabled", true);
        dom.find("textarea").attr("readonly", true);
    };
    cssnj.req = function (options) {
        var that = this
            , success = options.success
            , error = options.error
            , request = setter.request
            , response = setter.response
            , loadIndex = cssnj.loading()
            , debug = function () {
            return setter.debug
                ? '<br><cite>URL：</cite>' + options.url
                : '';
        };

        options.data = options.data || {};
        options.headers = options.headers || {};

        if (request.tokenName) {
            var sendData = typeof options.data === 'string' ? JSON.parse(options.data) : options.data;
            options.data[request.tokenName] = request.tokenName in sendData ? options.data[request.tokenName] : (layui.data(setter.tableName)[request.tokenName] || '');
            options.headers[request.tokenName] = request.tokenName in options.headers ? options.headers[request.tokenName] : (layui.data(setter.tableName)[request.tokenName] || '');
        }

        delete options.success;
        delete options.error;

        return $.ajax($.extend({
            type: 'post'
            , dataType: 'json'
            , contentType: "application/json;charset=utf-8"
            , success: function (res) {
                var statusCode = response.statusCode;
                if (res[response.statusName] == statusCode.ok) {
                    typeof options.done === 'function' && options.done(res);
                } else if (res[response.msgName] != '') {
                    var error = [
                        '<cite>Error：</cite> ' + (res[response.msgName] || '返回状态码异常')
                        , debug()
                    ].join('');
                    cssnj.alert(error);
                }
                typeof success === 'function' && success(res);
                cssnj.close(loadIndex);
            }
            , error: function (e, code) {
                var error = [
                    '请求异常，请重试<br><cite>错误信息：</cite>' + code
                    , debug()
                ].join('');
                cssnj.alert(error);
                typeof error === 'function' && error(res);
                cssnj.close(loadIndex);
            }
        }, options));
    };

    cssnj.dateFormat = function (date, fmt) {
        var o = {
            "M+": date.getMonth() + 1,                 //月份
            "d+": date.getDate(),                    //日
            "h+": date.getHours(),                   //小时
            "m+": date.getMinutes(),                 //分
            "s+": date.getSeconds(),                 //秒
            "q+": Math.floor((date.getMonth() + 3) / 3), //季度
            "S": date.getMilliseconds()             //毫秒
        };
        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    };
    exports('cssnj', cssnj);
});