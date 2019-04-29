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
            treePidName: 'sjgncdId',
            treeDefaultClose: false,
            treeLinkage: false,
            elem: '#tbl_gngl',
            title: '功能菜单管理数据表',
            toolbar: '#tbl_gngl_toolbar',
            defaultToolbar: [],
            url: contextPath + '/xtgl/gngl',
            where: JSON.stringify({
                handle: 'loadList'
            }),
            parseData: function (res) {
                return {
                    "code": res.code,
                    "msg": res.msg,
                    "data": res.data.resources
                };
            }
            ,
            cols: [[
                {field: 'id', title: 'ID', hide: true}
                , {field: 'mc', title: '名称', minWith: 180}
                , {field: 'qxbs', title: '权限标识', width: 120}
                , {field: 'url', title: '地址', width: 180}
                , {field: 'lx', title: '类型', width: 70}
                , {field: 'dkfs', title: '打开方式', width: 120}
                , {field: 'xh', title: '排序', width: 70}
                , {field: 'icon', title: '图标', width: 60}
                , {field: 'yxbz', title: '状态', width: 70}
                , {title: '操作', width: 160, align: 'center', fixed: 'right', toolbar: '#tbl_col_tool'}
            ]]
            , text: {none: '暂无相关数据'}
            , done: function () {
                cssnj.close(index)
            }
        })
    };
    renderTable();
    // var loadList = function () {
    //     cssnj.req({
    //         url: contextPath + '/xtgl/gngl',
    //         data: JSON.stringify({
    //             handle: 'loadList'
    //         }),
    //         done: function (res) {
    //             renderTable(res.data.resources);
    //         }
    //     });
    // };
    //loadList();

    table.on('toolbar(tbl_gngl)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'refresh':
                renderTable();
                break;
            case 'add':
                cssnj.window("新增功能菜单", contextPath + '/xtgl/gngl/gncdxx', {
                    width: '595px',
                    height: '702px',
                    btn: ['确定', '取消'],
                    yes: function (index, layero) {
                        var iframeWindow = window['layui-layer-iframe' + index]
                            , submitID = 'gncd_back_submit'
                            , submit = layero.find('iframe').contents().find('#' + submitID);
                        iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                            cssnj.req({
                                url: contextPath + '/xtgl/gngl',
                                data: JSON.stringify({
                                    handle: 'saveGncd',
                                    data: form_data.field
                                }),
                                done: function (res) {
                                    renderTable();
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


    table.on('tool(tbl_gngl)', function (obj) {
        if (obj.event === 'edit') {
            cssnj.window("编辑功能菜单", contextPath + '/xtgl/gngl/gncdxx?id=' + obj.data.id, {
                width: '595px',
                height: '702px',
                btn: ['确定', '取消'],
                yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index]
                        , submitID = 'gncd_back_submit'
                        , submit = layero.find('iframe').contents().find('#' + submitID);
                    iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                        cssnj.confirm("确定修改", {
                            yes: function () {
                                cssnj.req({
                                    url: contextPath + '/xtgl/gngl',
                                    data: JSON.stringify({
                                        handle: 'saveGncd',
                                        data: form_data.field
                                    }),
                                    done: function (res) {
                                        renderTable();
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
                        url: contextPath + '/xtgl/gngl',
                        data: JSON.stringify({
                            handle: 'delGncd',
                            data: {id: obj.data.id}
                        }),
                        done: function (res) {
                            renderTable();
                            cssnj.close(index);
                        }
                    });
                }
            })
        }
    });

    exports('gngl', {})
});