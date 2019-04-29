layui.extend({
    cssnj: 'common/cssnj'
}).define(['admin', 'form', 'table', 'cssnj'], function (exports) {
    var admin = layui.admin
        , form = layui.form
        , table = layui.table
        , cssnj = layui.cssnj;

    form.on('submit(yhxx_search)', function (data) {
        table.reload('tbl_yhgl', {
            where: {
                xm: data.field.xm
                , bmzbId: data.field.bmzbId
            }
        });
        return false;
    });

    table.render({
        elem: '#tbl_yhgl'
        , url: contextPath + '/xtgl/yhgl/loadList'
        , method: 'post'
        //, contentType: 'application/json'
        , request: {
            pageName: 'page',
            limitName: 'limit'
        }
        , where: {
            xm: $("input[name='xm']").val(),
            bmzbId: $("input[name='bmzbId']").val()
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
        , toolbar: '#tbl_yhgl_toolbar'
        , defaultToolbar: []
        , cols: [[
            {type: 'numbers', fixed: 'left'}
            , {field: 'id', title: 'ID', sort: true, hide: false}
            , {field: 'xm', title: '姓名', minWidth: 100, sort: true}
            , {
                field: 'xb', title: '性别', templet: function (d) {
                    switch (d.xb) {
                        case 0:
                            return '女';
                            break;
                        case 1:
                            return '男';
                            break;
                        default:
                            return '-';
                    }
                }
            }
            , {field: 'yddh', title: '移动电话'}
            , {field: 'gddh', title: '固定电话'}
            , {field: 'dzyx', title: '电子邮箱'}
            , {field: 'bmzbMc', title: '部门'}
            , {title: '操作', width: 220, align: 'center', fixed: 'right', toolbar: '#tbl_col_tool'}
        ]]
        , page: true
        , limit: 10
        , limits: [10, 15, 20]
        , height: 'full-220'
        , text: {none: '暂无相关数据'}
    });

    table.on('toolbar(tbl_yhgl)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'refresh':
                table.reload('tbl_yhgl');
                break;
            case 'add':
                cssnj.window("新增用户", contextPath + '/xtgl/yhgl/yhxx', {
                    width: '585px',
                    height: '597px',
                    btn: ['确定', '取消'],
                    yes: function (index, layero) {
                        var iframeWindow = window['layui-layer-iframe' + index]
                            , submitID = 'yhxx_back_submit'
                            , submit = layero.find('iframe').contents().find('#' + submitID);
                        iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                            cssnj.req({
                                url: contextPath + '/xtgl/yhgl',
                                data: JSON.stringify({
                                    handle: 'saveYhxx',
                                    data: form_data.field
                                }),
                                done: function (res) {
                                    table.reload('tbl_yhgl');
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

    table.on('tool(tbl_yhgl)', function (obj) {
        if (obj.event === 'edit') {
            cssnj.window("编辑用户", contextPath + '/xtgl/yhgl/yhxx?id=' + obj.data.id, {
                width: '585px',
                height: '597px',
                btn: ['确定', '取消'],
                yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index]
                        , submitID = 'yhxx_back_submit'
                        , submit = layero.find('iframe').contents().find('#' + submitID);
                    iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                        cssnj.confirm("确定修改", {
                            yes: function () {
                                cssnj.req({
                                    url: contextPath + '/xtgl/yhgl',
                                    data: JSON.stringify({
                                        handle: 'saveYhxx',
                                        data: form_data.field
                                    }),
                                    done: function (res) {
                                        table.reload('tbl_yhgl');
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
                        url: contextPath + '/xtgl/yhgl',
                        data: JSON.stringify({
                            handle: 'delYhxx',
                            data: {id: obj.data.id}
                        }),
                        done: function (res) {
                            table.reload('tbl_yhgl');
                            cssnj.close(index);
                        }
                    });
                }
            })
        } else if (obj.event === 'sqjs') {
            cssnj.window("授权角色", contextPath + '/xtgl/yhgl/yh_js?id=' + obj.data.id, {
                width: '550px',
                height: '650px',
                btn: ['确定', '取消'],
                yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index]
                        , submitID = 'yhjs_back_submit'
                        , submit = layero.find('iframe').contents().find('#' + submitID);
                    iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                        cssnj.confirm("确定授权", {
                            yes: function () {
                                cssnj.req({
                                    url: contextPath + '/xtgl/yhgl',
                                    data: JSON.stringify({
                                        handle: 'saveYhjs',
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
        }
    });

    var onClick = function onClick(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("bmzb_tree"),
            nodes = zTree.getSelectedNodes();
        if (nodes.length > 0) {
            $("#xm").val("");
            $("#bmzbId").val(nodes[0].id);
            $("#bmzb").val(nodes[0].mc);
            table.reload('tbl_yhgl', {
                where: {
                    bmzbId: nodes[0].id
                }
            });
        }
    }, setting = {
        view: {
            dblClickExpand: false
        }, data: {
            key: {
                name: "mc",
                url: "xUrl"
            },
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "sjbmzbId",
                rootPId: null
            }
        }, callback: {
            onClick: onClick
        }
    }, loadBmzbs = function () {
        cssnj.req({
            url: contextPath + '/xtgl/yhgl',
            data: JSON.stringify({
                handle: 'loadBmzbs'
            }),
            done: function (res) {
                $.fn.zTree.init($("#bmzb_tree"), setting, res.data.list);
            }
        });
    };
    loadBmzbs();

    $('#yhxx_reset').bind('click', function () {
        $("#bmzbId").val("");
        var treeObj = $.fn.zTree.getZTreeObj("bmzb_tree"),
            nodes = treeObj.getSelectedNodes();
        if (nodes.length > 0) {
            treeObj.cancelSelectedNode(nodes[0]);
        }
    });

    exports('yhgl', {})
});