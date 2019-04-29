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


    form.on('submit(tzgg_search)', function (data) {
        table.reload('tbl_tzgggl', {
            where: {
                bt: data.field.bt
            }
        });
        return false;
    });

    table.render({
        elem: '#tbl_tzgggl'
        , url: contextPath + '/xtgl/tzgggl/loadList'
        , method: 'post'
        , request: {
            pageName: 'page'
            , limitName: 'limit'
        }
        , where: {
            bt: $("input[name='bt']").val()
        }
        , parseData: function (res) {
            return {
                "code": res.code,
                "msg": res.msg,
                "count": res.data.count,
                "data": res.data.list
            };
        }
        , title: '通知公告数据表'
        , toolbar: '#tbl_tzgggl_toolbar'
        , defaultToolbar: []
        , cols: [[
            {type: 'numbers', fixed: 'left'}
            , {field: 'id', title: 'ID', hide: true}
            , {field: 'bt', title: '标题', minWidth: 100, sort: true}
            , {field: 'gqsj', title: '过期时间', width: 165}
            , {
                field: 'yxbz', title: '状态', width: 160, templet: function (d) {
                    return d.yxbz == 'Y' ? '有效' : '无效';
                }
            }
            , {title: '操作', width: 160, align: 'center', fixed: 'right', toolbar: '#tbl_col_tool'}
        ]]
        , page: true
        , limit: 10
        , limits: [10, 15, 20]
        , height: 'full-124'
        , text: {none: '暂无相关数据'}
    });

    table.on('toolbar(tbl_tzgggl)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'refresh':
                table.reload('tbl_tzgggl');
                break;
            case 'add':
                cssnj.window("新增通知公告", contextPath + '/xtgl/tzgggl/tzgg', {
                    width: '700px',
                    height: '98%',
                    btn: ['预览', '确定', '取消'],
                    skin: 'my-skin',
                    yes: function (index, layero) {
                        var iframeWindow = window['layui-layer-iframe' + index]
                            , submitID = 'tzgg_back_submit'
                            , submit = layero.find('iframe').contents().find('#' + submitID)
                            , preview = layero.find('iframe').contents().find('#tzgg_priview');
                        iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                            cssnj.layer(false, '<div style="padding: 50px; line-height: 22px; background-color: #fff; color: #393D49; font-weight: 300;"><div style="text-align: center;"><h3>' + form_data.field.bt + '</h3></div id="tzggNr">' + form_data.field.nr + '</div>',
                                {
                                    width: '700px',
                                    height: 'auto',
                                    btn: ['确定'],
                                    btnAlign: 'c',
                                    closeBtn: false,
                                    yes: function (i, layero) {
                                        cssnj.close(i);
                                    }
                                });
                            return false;
                        });
                        preview.trigger('click');
                        submit.trigger('click');
                    }, btn2: function (index, layero) {
                        var iframeWindow = window['layui-layer-iframe' + index]
                            , submitID = 'tzgg_back_submit'
                            , submit = layero.find('iframe').contents().find('#' + submitID)
                            , preview = layero.find('iframe').contents().find('#tzgg_priview');
                        iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                            cssnj.confirm("确定保存", {
                                yes: function () {
                                    cssnj.req({
                                        url: contextPath + '/xtgl/tzgggl',
                                        data: JSON.stringify({
                                            handle: 'saveTzgg',
                                            data: form_data.field
                                        }),
                                        done: function (res) {
                                            table.reload('tbl_tzgggl');
                                            cssnj.close(index);
                                        }
                                    });
                                }
                            });
                        });
                        preview.trigger('click');
                        submit.trigger('click');
                        return false;
                    }
                });
                break;
        }
    });

    table.on('tool(tbl_tzgggl)', function (obj) {
        if (obj.event === 'edit') {
            cssnj.window("编辑通知公告", contextPath + '/xtgl/tzgggl/tzgg?id=' + obj.data.id, {
                width: '700px',
                height: '98%',
                btn: ['预览', '确定', '取消'],
                skin: 'my-skin',
                yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index]
                        , submitID = 'tzgg_back_submit'
                        , submit = layero.find('iframe').contents().find('#' + submitID)
                        , preview = layero.find('iframe').contents().find('#tzgg_priview');
                    iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                        cssnj.layer(false, '<div style="padding: 50px; line-height: 22px; background-color: #fff; color: #393D49; font-weight: 300;"><div style="text-align: center;"><h3>' + form_data.field.bt + '</h3></div id="tzggNr">' + form_data.field.nr + '</div>',
                            {
                                width: '700px',
                                height: 'auto',
                                btn: ['确定'],
                                btnAlign: 'c',
                                closeBtn: false,
                                yes: function (i, layero) {
                                    cssnj.close(i);
                                }
                            });
                        return false;
                    });
                    preview.trigger('click');
                    submit.trigger('click');
                }, btn2: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index]
                        , submitID = 'tzgg_back_submit'
                        , submit = layero.find('iframe').contents().find('#' + submitID)
                        , preview = layero.find('iframe').contents().find('#tzgg_priview');
                    iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                        cssnj.confirm("确定修改", {
                            yes: function () {
                                cssnj.req({
                                    url: contextPath + '/xtgl/tzgggl',
                                    data: JSON.stringify({
                                        handle: 'saveTzgg',
                                        data: form_data.field
                                    }),
                                    done: function (res) {
                                        table.reload('tbl_tzgggl');
                                        cssnj.close(index);
                                    }
                                });
                            }
                        });
                    });
                    preview.trigger('click');
                    submit.trigger('click');
                    return false;
                }
            });
        }
    });

    exports('tzgggl', {})
});