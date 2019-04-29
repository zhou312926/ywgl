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
            treePidName: 'sjbmzbId',
            treeDefaultClose: false,
            treeLinkage: false,
            elem: '#tbl_bmzbgl',
            title: '角色管理数据表',
            toolbar: '#tbl_bmzbgl_toolbar',
            defaultToolbar: [],
            data: data,
            cols: [[
                {field: 'id', title: 'ID', hide: true}
                , {field: 'mc', title: '名称', minWidth: 150}
                , {field: 'xh', title: '排序', width: 150}
                , {field: 'yxbz', title: '状态', width: 150}
                , {title: '操作', width: 180, align: 'center', fixed: 'right', toolbar: '#tbl_col_tool'}
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
            url: contextPath + '/xtgl/bmzbgl',
            data: JSON.stringify({
                handle: 'loadList'
            }),
            done: function (res) {
                renderTable(res.data.list);
            }
        });
    };
    loadList();

    table.on('toolbar(tbl_bmzbgl)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'refresh':
                loadList();
                break;
            case 'add':
                cssnj.window("新增部门", contextPath + '/xtgl/bmzbgl/bmzbxx', {
                    width: '600px',
                    height: '438px',
                    btn: ['确定', '取消'],
                    yes: function (index, layero) {
                        var iframeWindow = window['layui-layer-iframe' + index]
                            , submitID = 'bmzbxx_back_submit'
                            , submit = layero.find('iframe').contents().find('#' + submitID);
                        iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                            cssnj.req({
                                url: contextPath + '/xtgl/bmzbgl',
                                data: JSON.stringify({
                                    handle: 'saveBmzbxx',
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


    table.on('tool(tbl_bmzbgl)', function (obj) {
        if (obj.event === 'edit') {
            cssnj.window("编辑部门", contextPath + '/xtgl/bmzbgl/bmzbxx?id=' + obj.data.id, {
                width: '600px',
                height: '438px',
                btn: ['确定', '取消'],
                yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index]
                        , submitID = 'bmzbxx_back_submit'
                        , submit = layero.find('iframe').contents().find('#' + submitID);
                    iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                        cssnj.confirm("确定修改", {
                            yes: function () {
                                cssnj.req({
                                    url: contextPath + '/xtgl/bmzbgl',
                                    data: JSON.stringify({
                                        handle: 'saveBmzbxx',
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
                        url: contextPath + '/xtgl/bmzbgl',
                        data: JSON.stringify({
                            handle: 'delBmzbxx',
                            data: {id: obj.data.id}
                        }),
                        done: function (res) {
                            loadList();
                            cssnj.close(index);
                        }
                    });
                }
            })
        } else if (obj.event === 'bmzbyh') {
            cssnj.window("部门人员", contextPath + '/xtgl/bmzbgl/bmzb_yh?id=' + obj.data.id, {
                width: '924px',
                height: '668px'
            });
        }
    });

    exports('bmzbgl', {})
});