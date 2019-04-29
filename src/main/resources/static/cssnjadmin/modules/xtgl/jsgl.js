layui.extend({
    cssnj: 'common/cssnj',
    treetable: 'treetable/treetable'
}).define(['admin', 'form', 'table', 'cssnj', 'treetable'], function (exports) {
    var $ = layui.$
        , admin = layui.admin
        , form = layui.form
        , table = layui.table
        , cssnj = layui.cssnj
        , treetable = layui.treetable;

    var renderTable = function (data) {
        var index = cssnj.loading();
        treetable.render({
            treeColIndex: 1,
            treeSpid: 00,
            treeIdName: 'id',
            treePidName: 'sjjsId',
            treeDefaultClose: false,
            treeLinkage: false,
            elem: '#tbl_jsgl',
            title: '角色管理数据表',
            toolbar: '#tbl_jsgl_toolbar',
            defaultToolbar: [],
            data: data,
            cols: [[
                {field: 'id', title: 'ID', hide: true}
                , {field: 'mc', title: '名称', minWidth: 150}
                , {field: 'qxbs', title: '权限标识', minWidth: 150}
                , {field: 'xh', title: '排序', width: 150}
                , {field: 'yxbz', title: '状态', width: 150}
                , {title: '操作', width: 220, align: 'center', fixed: 'right', toolbar: '#tbl_col_tool'}
            ]]
            //, height: 'full-220'
            , text: {none: '暂无相关数据'}
            , done: function () {
                cssnj.close(index)
            }
        })
    };

    var loadList = function () {
        cssnj.req({
            url: contextPath + '/xtgl/jsgl',
            data: JSON.stringify({
                handle: 'loadList'
            }),
            done: function (res) {
                renderTable(res.data.list);
            }
        });
    };
    loadList();

    table.on('toolbar(tbl_jsgl)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'refresh':
                loadList();
                break;
            case 'add':
                cssnj.window("新增角色", contextPath + '/xtgl/jsgl/jsxx', {
                    width: '585px',
                    height: '490px',
                    btn: ['确定', '取消'],
                    yes: function (index, layero) {
                        var iframeWindow = window['layui-layer-iframe' + index]
                            , submitID = 'jsxx_back_submit'
                            , submit = layero.find('iframe').contents().find('#' + submitID);
                        iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                            cssnj.req({
                                url: contextPath + '/xtgl/jsgl',
                                data: JSON.stringify({
                                    handle: 'saveJsxx',
                                    data: form_data.field
                                }),
                                done: function (res) {
                                    loadList();
                                    cssnj.close(index);
                                }
                            });
                        });
                        submit.trigger('click');
                    }
                });
                break;
        }
    });

    table.on('tool(tbl_jsgl)', function (obj) {
        if (obj.event === 'edit') {
            cssnj.window("编辑角色", contextPath + '/xtgl/jsgl/jsxx?id=' + obj.data.id, {
                width: '585px',
                height: '490px',
                btn: ['确定', '取消'],
                yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index]
                        , submitID = 'jsxx_back_submit'
                        , submit = layero.find('iframe').contents().find('#' + submitID);
                    iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                        cssnj.confirm("确定修改", {
                            yes: function () {
                                cssnj.req({
                                    url: contextPath + '/xtgl/jsgl',
                                    data: JSON.stringify({
                                        handle: 'saveJsxx',
                                        data: form_data.field
                                    }),
                                    done: function (res) {
                                        loadList();
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
                        url: contextPath + '/xtgl/jsgl',
                        data: JSON.stringify({
                            handle: 'delJsxx',
                            data: {id: obj.data.id}
                        }),
                        done: function (res) {
                            loadList();
                            cssnj.close(index);
                        }
                    });
                }
            });
        } else if (obj.event === 'fpgncd') {
            cssnj.window("分配功能菜单", contextPath + '/xtgl/jsgl/js_gncd?id=' + obj.data.id, {
                width: '550px',
                height: '650px',
                btn: ['确定', '取消'],
                yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index]
                        , submitID = 'jsgncd_back_submit'
                        , submit = layero.find('iframe').contents().find('#' + submitID);
                    iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                        cssnj.confirm("确定本次分配", {
                            yes: function () {
                                cssnj.req({
                                    url: contextPath + '/xtgl/jsgl',
                                    data: JSON.stringify({
                                        handle: 'saveJsgncd',
                                        data: form_data.field
                                    }),
                                    done: function (res) {
                                        cssnj.close(index);
                                    }
                                });
                            }
                        })
                    });
                    submit.trigger('click');
                }
            });
        } else if (obj.event === 'sqyh') {
            cssnj.window("授权用户", contextPath + '/xtgl/jsgl/js_yh?id=' + obj.data.id, {
                width: '100%',
                height: '100%'
            });
        }
    });


    exports('jsgl', {})
});