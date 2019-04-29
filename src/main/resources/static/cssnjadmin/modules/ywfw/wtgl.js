layui.extend({
    cssnj: 'common/cssnj'
}).define(['admin', 'form', 'table', 'upload', 'cssnj'], function (exports) {
    var $ = layui.$
        , admin = layui.admin
        , form = layui.form
        , table = layui.table
        , cssnj = layui.cssnj
        , setter = layui.setter
        , upload = layui.upload;

    form.on('select(yyxt)', function (data) {
        cssnj.req({
            url: contextPath + '/ywfw/wtgl',
            data: JSON.stringify({
                handle: 'queryYwmkDm',
                data: {
                    yyxtDm: data.value
                }
            }),
            done: function (res) {
                var optionStr = "<option value='0'>不限</option>";
                $.each(res.data, function (i, item) {
                    optionStr += "<option value='" + item.dm + "' >" + item.mc + "</option>";
                });
                $("select[name='ywmk']").html(optionStr);
                form.render('select');
            }
        });
    });

    form.on('submit(wtxx_search)', function (data) {
        table.reload('tbl_wtgl', {
            where: {
                bt: data.field.bt
                , wtlxDm: data.field.wtlx
                , yyxtDm: data.field.yyxt
                , ywmkDm: data.field.ywmk
            }
        });
        return false;
    });

    table.render({
        elem: '#tbl_wtgl'
        , url: contextPath + '/ywfw/wtgl/loadList'
        , method: 'post'
        , request: {
            pageName: 'page'
            , limitName: 'limit'
        }
        , where: {
            bt: $("input[name='bt']").val()
            , wtlxDm: $("select[name='wtlx']").val()
            , yyxtDm: $("select[name='yyxt']").val()
            , ywmkDm: $("select[name='ywmk']").val()
        }
        , parseData: function (res) {
            return {
                "code": res.code,
                "msg": res.msg,
                "count": res.data.count,
                "data": res.data.list
            };
        }
        , title: '运维问题数据表'
        , toolbar: '#tbl_wtgl_toolbar'
        , defaultToolbar: []
        , cols: [[
            {type: 'numbers', fixed: 'left'}
            , {field: 'id', title: 'ID', hide: true}
            , {field: 'bt', title: '标题', minWidth: 100, sort: true}
            , {field: 'wtlxMc', title: '问题类型', width: 120}
            , {field: 'yyxtMc', title: '应用系统', width: 160, sort: true}
            , {
                field: 'ywmkMc', title: '业务模块', width: 160, templet: function (d) {
                    return d.ywmkMc == null ? '<div style="text-align: center;"></div>' : d.ywmkMc;
                }
            }
            , {field: 'wtztMc', title: '状态', width: 120, sort: true}
            , {field: 'lrryXm', title: '录入人', width: 120}
            , {field: 'lrsj', title: '录入时间', width: 165}
            , {title: '操作', width: 160, align: 'center', fixed: 'right', toolbar: '#tbl_col_tool'}
        ]]
        , page: true
        , limit: 10
        , limits: [10, 15, 20]
        , height: 'full-220'
        , text: {none: '暂无相关数据'}
        , done: function (res, curr, count) {
            var loadIndex;
            upload.render({
                elem: '#mbsc'
                , url: contextPath + '/ywfw/wtgl/upload/template/wtxx'
                , accept: 'file'
                , exts: 'xls|xlsx'
                , acceptMime: '.xls,.xlsx'
                , size: 5120
                , before: function (obj) {
                    loadIndex = cssnj.loading();
                }
                , done: function (res) {
                    cssnj.close(loadIndex);
                    cssnj.alert(res[setter.response.msgName]);
                    if (res[setter.response.statusName] == setter.response.statusCode.ok) {
                        table.reload('tbl_wtgl');
                    }
                }
            });
        }
    });

    table.on('toolbar(tbl_wtgl)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'refresh':
                table.reload('tbl_wtgl');
                break;
            case 'add':
                cssnj.window("新增问题", contextPath + '/ywfw/wtgl/wtxx', {
                    width: '600px',
                    height: '98%',
                    btn: ['确定', '取消'],
                    yes: function (index, layero) {
                        var iframeWindow = window['layui-layer-iframe' + index]
                            , submitID = 'wtxx_back_submit'
                            , submit = layero.find('iframe').contents().find('#' + submitID);
                        iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                            cssnj.req({
                                url: contextPath + '/ywfw/wtgl',
                                data: JSON.stringify({
                                    handle: 'saveWtxx',
                                    data: form_data.field
                                }),
                                done: function (res) {
                                    table.reload('tbl_wtgl');
                                    cssnj.close(index);
                                }
                            });
                        });
                        submit.trigger('click');
                    }
                });
                break;
            case 'batchdel':
                var data = checkStatus.data;
                if (data.length <= 0) {
                    cssnj.alert("至少选择一条待删除问题");
                } else {
                    cssnj.confirm("确定删除？", function () {
                    });
                }
                break;
            case 'mbxz':
                window.open(contextPath + "/download/template/运维问题模板.xlsx?v=1");
                break;
        }
    });

    table.on('tool(tbl_wtgl)', function (obj) {
        if (obj.event === 'edit') {
            cssnj.window("编辑问题", contextPath + '/ywfw/wtgl/wtxx?id=' + obj.data.id, {
                width: '600px',
                height: '98%',
                btn: ['确定', '取消'],
                yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index]
                        , submitID = 'wtxx_back_submit'
                        , submit = layero.find('iframe').contents().find('#' + submitID);
                    iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                        cssnj.confirm("确定修改", {
                            yes: function () {
                                cssnj.req({
                                    url: contextPath + '/ywfw/wtgl',
                                    data: JSON.stringify({
                                        handle: 'saveWtxx',
                                        data: form_data.field
                                    }),
                                    done: function (res) {
                                        table.reload('tbl_wtgl');
                                        cssnj.close(index);
                                    }
                                });
                            }
                        })
                    });
                    submit.trigger('click');
                }
            });
        } else if (obj.event === 'del') {
            cssnj.confirm("确定删除", {
                yes: function (index) {
                    cssnj.req({
                        url: contextPath + '/ywfw/wtgl',
                        data: JSON.stringify({
                            handle: 'delWtxx',
                            data: {id: obj.data.id}
                        }),
                        done: function (res) {
                            table.reload('tbl_wtgl');
                            cssnj.close(index);
                        }
                    });
                }
            })
        } else if (obj.event === 'read') {
            cssnj.window("问题详情", contextPath + '/ywfw/wtgl/wtxx_read?id=' + obj.data.id, {
                width: '1024px',
                height: '98%',
                end: function () {
                    table.reload('tbl_wtgl');
                }
            });
        }
    });

    exports('wtgl', {})
});