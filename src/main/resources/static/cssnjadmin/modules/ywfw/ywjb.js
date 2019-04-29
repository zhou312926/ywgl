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


    form.on('submit(ywjb_search)', function (data) {
        table.reload('tbl_ywjb', {
            where: {
                bt: data.field.bt
                , yyxtDm: data.field.yyxt
            }
        });
        return false;
    });

    table.render({
        elem: '#tbl_ywjb'
        , url: contextPath + '/ywfw/ywjb/loadList'
        , method: 'post'
        , request: {
            pageName: 'page'
            , limitName: 'limit'
        }
        , where: {
            bt: $("input[name='bt']").val()
            , yyxtDm: $("select[name='yyxt']").val()
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
        , toolbar: '#tbl_ywjb_toolbar'
        , defaultToolbar: []
        , cols: [[
            {type: 'numbers', fixed: 'left'}
            , {field: 'id', title: 'ID', hide: true}
            , {field: 'bt', title: '标题', minWidth: 100, sort: true}
            , {field: 'yyxtMc', title: '应用系统', width: 160}
            , {field: 'lrryXm', title: '录入人', width: 120}
            , {field: 'lrsj', title: '录入时间', width: 165}
            , {title: '操作', width: 160, align: 'center', fixed: 'right', toolbar: '#tbl_col_tool'}
        ]]
        , page: true
        , limit: 10
        , limits: [10, 15, 20]
        , height: 'full-130'//171
        , text: {none: '暂无相关数据'}
        , done: function (res, curr, count) {
            debugger;
            var loadIndex;
            upload.render({
                elem: '#mbsc'
                , url: contextPath + '/ywfw/ywjb/upload/template/ywjb'
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
                        table.reload('tbl_ywjb');
                    }
                }
            });
        }
    });

    table.on('toolbar(tbl_ywjb)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'refresh':
                table.reload('tbl_ywjb');
                break;
            case 'add':
                cssnj.window("新增运维脚本", contextPath + '/ywfw/ywjb/ywjb', {
                    width: '600px',
                    height: '98%',
                    btn: ['确定', '取消'],
                    yes: function (index, layero) {
                        var iframeWindow = window['layui-layer-iframe' + index]
                            , submitID = 'ywjb_back_submit'
                            , submit = layero.find('iframe').contents().find('#' + submitID);
                        iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                            cssnj.req({
                                url: contextPath + '/ywfw/ywjb',
                                data: JSON.stringify({
                                    handle: 'saveYwjb',
                                    data: form_data.field
                                }),
                                done: function (res) {
                                    table.reload('tbl_ywjb');
                                    cssnj.close(index);
                                }
                            });
                        });
                        submit.trigger('click');
                    }
                });
                break;
            case 'mbxz':
                window.open(contextPath + "/download/template/运维脚本模板.xlsx?v=1");
                break;
        }
    });

    table.on('tool(tbl_ywjb)', function (obj) {
        if (obj.event === 'edit') {
            cssnj.window("编辑运维脚本", contextPath + '/ywfw/ywjb/ywjb?id=' + obj.data.id, {
                width: '600px',
                height: '98%',
                btn: ['确定', '取消'],
                yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index]
                        , submitID = 'ywjb_back_submit'
                        , submit = layero.find('iframe').contents().find('#' + submitID);
                    iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                        cssnj.confirm("确定修改", {
                            yes: function () {
                                cssnj.req({
                                    url: contextPath + '/ywfw/ywjb',
                                    data: JSON.stringify({
                                        handle: 'saveYwjb',
                                        data: form_data.field
                                    }),
                                    done: function (res) {
                                        table.reload('tbl_ywjb');
                                        cssnj.close(index);
                                    }
                                });
                            }
                        })
                    });
                    submit.trigger('click');
                }
            });
        } else if (obj.event === 'read') {
            cssnj.window("运维脚本详情", contextPath + '/ywfw/ywjb/ywjb_read?id=' + obj.data.id, {
                width: '800px',
                height: '98%',
                end: function () {
                    table.reload('tbl_ywjb');
                }
            });
        }
    });

    exports('ywjb', {})
});