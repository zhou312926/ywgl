/**

 @Name：layuiAdmin 公共业务
 @Author：贤心
 @Site：http://www.layui.com/admin/
 @License：LPPL

 */

layui.define(function (exports) {
    var $ = layui.$
        , layer = layui.layer
        , laytpl = layui.laytpl
        , setter = layui.setter
        , view = layui.view
        , admin = layui.admin


        , cssnjConfirm = function (msg, fun, params) {
        layer.confirm(msg, {
            title: "提示",
            btn: ['确定', '取消']
        }, function (index) {
            layer.close(index);
            if (params == undefined || params == null && params == "")
                return;
            if (params != undefined && params != null && params != "") {
                fun(params);
            } else {
                fun();
            }

        }, function () {

        });
    }
        , cssnjAlert = function (msg, fun, params) {
        layer.alert(msg, {
            title: "提示"
        }, function (index) {
            layer.close(index);
            if (params == undefined || params == null && params == "")
                return;
            if (params != undefined && params != null && params != "") {
                fun(params);
            } else {
                fun();
            }
        });
    }
        , cssnjWindow = function (title, url, params) {
        var obj = {
            'width': '800px',
            'height': '600px',
            'cancel': function (index, layero) {
                return true;
            }
        };
        $.extend(obj, params);
        layer.open({
            title: title,
            type: 2,
            area: [obj.width, obj.height],
            content: url,
            cancel: function (index, layero) {
                obj.cancel(index, layero);
            }
        });
    }
        , cssnjLayer = function (title, dom, params) {
        var obj = {
            'width': '800px',
            'height': '600px',
            'success': function (layero, index) {
                return true;
            }
        };
        $.extend(obj, params);
        return layer.open({
            title: title,
            type: 1,
            area: [obj.width, obj.height],
            content: dom,
            success: function (layero, index) {
                obj.success(layero, index);
            }
        });
    }
        , cssnjClose = function (index) {
        layer.close(index);
    };


    admin.events.logout = function () {
        //执行退出接口
        $("#logout_form").submit();

        // admin.req({
        //   url: layui.setter.base + 'json/user/logout.js'
        //   ,type: 'get'
        //   ,data: {}
        //   ,done: function(res){ //这里要说明一下：done 是只有 response 的 code 正常才会执行。而 succese 则是只要 http 为 200 就会执行
        //
        //     //清空本地记录的 token，并跳转到登入页
        //     admin.exit(function(){
        //       location.href = 'user/login.html';
        //     });
        //   }
        // });
    };


    exports('common', {});
});