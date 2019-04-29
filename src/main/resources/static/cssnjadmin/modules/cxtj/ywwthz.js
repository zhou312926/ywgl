layui.extend({
    cssnj: 'common/cssnj'
}).define(['admin', 'form', 'table', 'laydate', 'cssnj'], function (exports) {
    var $ = layui.$
        , admin = layui.admin
        , form = layui.form
        , table = layui.table
        , laydate = layui.laydate
        , cssnj = layui.cssnj;

    var minDate, maxDate, endDate;
    var hzrqq = laydate.render({
        elem: '#hzrqq',
        type: 'date',
        btns: ['clear', 'confirm'],
        done: function (value, date) {
            hzrqz.config.min = {
                year: date.year,
                month: date.month - 1,
                date: date.date
            };
            hzrqz.config.max = {
                year: date.year,
                month: date.month,
                date: date.date
            };
            if ($("#hzrqz").val() != "") {
                minDate = new Date(Date.parse(hzrqz.config.min.year + "-" + (hzrqz.config.min.month + 1) + "-" + hzrqz.config.min.date));
                maxDate = new Date(Date.parse(hzrqz.config.max.year + "-" + (hzrqz.config.max.month + 1) + "-" + hzrqz.config.max.date));
                endDate = new Date(Date.parse(hzrqz.config.dateTime.year + "-" + (hzrqz.config.dateTime.month + 1) + "-" + hzrqz.config.dateTime.date));
                if (minDate > endDate) {
                    $("#hzrqz").val(cssnj.dateFormat(minDate, "yyyy-MM-dd"));
                } else if (maxDate < endDate) {
                    $("#hzrqz").val(cssnj.dateFormat(maxDate, "yyyy-MM-dd"));
                }
            }
        }
    });
    var hzrqz = laydate.render({
        elem: '#hzrqz',
        type: 'date',
        btns: ['clear', 'confirm'],
        done: function (value, date) {
            hzrqq.config.max = {
                year: date.year,
                month: date.month - 1,
                date: date.date
            };
            hzrqq.config.min = {
                year: date.year,
                month: date.month - 2,
                date: date.date
            };
            if ($("#hzrqq").val() != "") {
                minDate = new Date(Date.parse(hzrqq.config.min.year + "-" + (hzrqq.config.min.month + 1) + "-" + hzrqq.config.min.date));
                maxDate = new Date(Date.parse(hzrqq.config.max.year + "-" + (hzrqq.config.max.month + 1) + "-" + hzrqq.config.max.date));
                endDate = new Date(Date.parse(hzrqq.config.dateTime.year + "-" + (hzrqq.config.dateTime.month + 1) + "-" + hzrqq.config.dateTime.date));
                if (maxDate < endDate) {
                    $("#hzrqq").val(cssnj.dateFormat(maxDate, "yyyy-MM-dd"));
                } else if (minDate > endDate) {
                    $("#hzrqq").val(cssnj.dateFormat(minDate, "yyyy-MM-dd"));
                }
            }
        }
    });

    $("#hz_reset").bind('click', function () {
        minDate = {'date': 1, 'month': 1, 'year': 1900};
        maxDate = {'date': 31, 'month': 12, 'year': 2099};
        hzrqq.config.min = minDate;
        hzrqq.config.max = maxDate;
        hzrqz.config.min = minDate;
        hzrqz.config.max = maxDate;
    });

    form.on('submit(hz_search)', function (data) {
        table.reload('tbl_ywwthz', {
            where: {
                hzlx: $("select[name='hzlx']").val(),
                hzrqq: $("input[name='hzrqq']").val(),
                hzrqz: $("input[name='hzrqz']").val()
            }
        });
        return false;
    });

    table.render({
        elem: '#tbl_ywwthz'
        , url: contextPath + '/cxtj/ywwthz/loadHzList'
        , method: 'post'
        , request: {
            pageName: 'page'
            , limitName: 'limit'
        }
        , where: {
            hzlx: $("select[name='hzlx']").val(),
            hzrqq: $("input[name='hzrqq']").val(),
            hzrqz: $("input[name='hzrqz']").val()

        }
        , parseData: function (res) {
            return {
                "code": res.code,
                "msg": res.msg,
                "count": res.data.count,
                "data": res.data.list
            };
        }
        , title: '运维问题汇总表'
        , toolbar: '#tbl_ywwthz_toolbar'
        , defaultToolbar: []
        , cols: [[
            {type: 'numbers', fixed: 'left'}
            , {field: 'hzid', title: '汇总ID', hide: true}
            , {field: 'hzmc', title: '名称', sort: true}
            , {field: 'wthjs', title: '合计数', sort: true}
            , {field: 'wtyjjs', title: '已解决数', sort: true}
            , {field: 'wtwjjs', title: '未解决数', sort: true}
            , {title: '操作', width: 160, align: 'center', fixed: 'right', toolbar: '#tbl_col_tool'}
        ]]
        , page: true
        , limit: 10
        , limits: [10, 15, 20]
        , height: 'full-130'
        , text: {none: '暂无相关数据'}
    });

    table.on('toolbar(tbl_ywwthz)', function (obj) {
        if (obj.event == "refresh") {
            table.reload('tbl_ywwthz');
        }
    });

    table.on('tool(tbl_ywwthz)', function (obj) {
        if (obj.event === 'mx') {
            cssnj.window("运维问题明细", contextPath + '/cxtj/ywwthz/mxlist?hzlx=' + $("select[name='hzlx']").val() + '&hzid=' + obj.data.hzid + '&hzrqq=' + $("input[name='hzrqq']").val() + '&hzrqz=' + $("input[name='hzrqz']").val(), {
                width: '100%',
                height: '100%'
            });
        }
    });

    exports('ywwthz', {})
});