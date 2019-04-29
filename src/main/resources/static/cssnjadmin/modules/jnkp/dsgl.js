layui.extend({
    cssnj: 'common/cssnj'
}).define(['admin', 'form', 'table', 'cssnj'], function (exports) {
    var admin = layui.admin
        , form = layui.form
        , table = layui.table
        , cssnj = layui.cssnj
        , setter = layui.setter
        , upload = layui.upload;

    var onClick = function onClick(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("bmzb_tree"),
            nodes = zTree.getSelectedNodes();
        if (nodes.length > 0) {
            $("#bmzb").attr("value", nodes[0].mc);
            $("#bmzbId").attr("value", nodes[0].id);
        }
        hideBmzbs();
    }, showBmzbs = function showMenu() {
        var bmzbObj = $("#bmzb");
        var bmzbOffset = $("#bmzb").offset();
        var bmzbContent = $("#bmzbContent");
        bmzbContent.css({
            left: bmzbOffset.left + "px",
            top: bmzbOffset.top + bmzbObj.outerHeight() + "px"
        }).slideDown("fast");

        $("body").bind("mousedown", onBodyDown);
    }, hideBmzbs = function hideMenu() {
        $("#bmzbContent").fadeOut("fast");
        $("body").unbind("mousedown", onBodyDown);
    }, onBodyDown = function onBodyDown(event) {
        if (!(event.target.id == "bmzb" || event.target.id == "bmzbContent" || $(event.target).parents("#bmzbContent").length > 0)) {
            hideBmzbs();
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
            url: contextPath + '/jnkp/dsgl',
            data: JSON.stringify({
                handle: 'loadBmzbs'
            }),
            done: function (res) {
                $.fn.zTree.init($("#bmzb_tree"), setting, res.data.list);
            }
        });
    };
    loadBmzbs();
    $('#bmzb').bind('click', function () {
        showBmzbs();
    });

    table.render({
        elem: '#tbl_dsgl'
        , url: contextPath + '/jnkp/dsgl/loadList'
        , method: 'post'
        , request: {
            pageName: 'page'
            , limitName: 'limit'
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
        , title: '导师管理数据表'
        , toolbar: '#tbl_toolbar'
        , defaultToolbar: []
        , cols: [[
            {type: 'numbers', fixed: 'left'}
            , {field: 'id', title: '', sort: true, hide: true}
            , {field: 'yhId', title: 'ID', sort: true}
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
            , {field: 'bmzbMc', title: '部门'}
            , {
                field: 'yxbz', title: '状态', width: 160, templet: '#tbl_col_tpl', unresize: true
            }
            , {title: '操作', width: 160, align: 'center', fixed: 'right', toolbar: '#tbl_col_tool'}
        ]]
        , page: true
        , limit: 10
        , limits: [10, 15, 20]
        , height: 'full-130'//171
        , text: {none: '暂无相关数据'}
    });

    table.on('toolbar(tbl_dsgl)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'refresh':
                table.reload('tbl_dsgl');
                break;
            case 'add':
                cssnj.window("新增导师", contextPath + '/jnkp/dsgl/ds_add', {
                    width: '768px',
                    height: '690px',
                    btn: ['确定', '取消'],
                    yes: function (index, layero) {
                        var iframeWindow = window['layui-layer-iframe' + index]
                            , submitID = 'yhxx_back_submit'
                            , submit = layero.find('iframe').contents().find('#' + submitID);
                        iframeWindow.layui.form.on('submit(' + submitID + ')', function (form_data) {
                            debugger;
                            var checkedData = iframeWindow.layui.table.checkStatus('tbl_yhxx').data;
                            if (checkedData.length == 0) {
                                cssnj.alert("请选择一位需要授权为导师的人员");
                                return;
                            }
                            var tips = "授权\"" + checkedData[0].xm + "\"为导师";
                            cssnj.confirm(tips, {
                                yes: function () {
                                    cssnj.req({
                                        url: contextPath + '/jnkp/dsgl',
                                        data: JSON.stringify({
                                            handle: 'saveDsxx',
                                            data: {yhId: checkedData[0].id}
                                        }),
                                        done: function (res) {
                                            table.reload('tbl_dsgl');
                                            cssnj.close(index);
                                        }
                                    });
                                }
                            });
                        });
                        submit.trigger('click');
                    }
                });
                break;
        }
    });

    table.on('tool(tbl_dsgl)', function (obj) {
        if (obj.event === 'fpxs') {
            cssnj.window("分配学生", contextPath + '/jnkp/dsgl/ds_xs?id=' + obj.data.id, {
                width: '100%',
                height: '100%'
            });
        }
    });

    form.on('submit(dsgl_search)', function (data) {
        table.reload('tbl_dsgl', {
            where: {
                xm: $("input[name='xm']").val(),
                bmzbId: $("input[name='bmzbId']").val()
            }
        });
        return false;
    });

    form.on('switch(yxbz)', function (obj) {
        cssnj.req({
            url: contextPath + '/jnkp/dsgl',
            data: JSON.stringify({
                handle: 'updateDsxx',
                data: {id: this.value, yxbz: obj.elem.checked ? 'Y' : 'N'}
            }),
            success: function (res) {
                table.reload('tbl_dsgl');
            }
        });
    });


    exports('dsgl', {})
});