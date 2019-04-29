layui.extend({
    cssnj: 'common/cssnj'
}).define(['admin', 'form', 'table', 'cssnj'], function (exports) {
    var $ = layui.$
        , admin = layui.admin
        , form = layui.form
        , table = layui.table
        , cssnj = layui.cssnj;


    form.on('select(yyxt)', function (data) {
        cssnj.req({
            url: contextPath + '/ywfw/wtcl',
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
        table.reload('tbl_wtcl', {
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
        elem: '#tbl_wtcl'
        , url: contextPath + '/ywfw/wtcl/loadList'
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
        , toolbar: '#tbl_wtcl_toolbar'
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
    });

    table.on('toolbar(tbl_wtcl)', function (obj) {
        if (obj.event == "refresh") {
            table.reload('tbl_wtcl');
        }
    });

    table.on('tool(tbl_wtcl)', function (obj) {
        if (obj.event === 'read') {
            cssnj.window("问题详情", contextPath + '/ywfw/wtcl/wtxx_read?id=' + obj.data.id, {
                width: '1024px',
                height: '98%',
                end: function () {
                    table.reload('tbl_wtcl');
                }
            });
        }
    });


    exports('wtcl', {})
});