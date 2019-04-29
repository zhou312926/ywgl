layui.extend({
    cssnj: 'common/cssnj'
}).define(['admin', 'form', 'table', 'laydate', 'cssnj'], function (exports) {
    var $ = layui.$
        , admin = layui.admin
        , form = layui.form
        , table = layui.table
        , laydate = layui.laydate
        , cssnj = layui.cssnj;

    var minDate, maxDate, endDate;//, nowTime = new Date();

    var hzrqq = laydate.render({
        elem: '#hzrqq',
        type: 'date',
        // max: nowTime,
        btns: ['clear', 'confirm'],
        done: function (value, date) {
            // if ($.trim(value) == '') {
            //     var curDate = new Date();
            //     date = {'date': curDate.getDate(), 'month': curDate.getMonth() + 1, 'year': curDate.getFullYear()};
            // }
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
        // max: nowTime,
        btns: ['clear', 'confirm'],
        done: function (value, date) {
            // if ($.trim(value) == '') {
            //     var curDate = new Date();
            //     date = {'date': curDate.getDate(), 'month': curDate.getMonth() + 1, 'year': curDate.getFullYear()};
            // }
            // hzrqq.config.max = date;
            // hzrqq.config.max.month = date.month - 1;
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

    form.verify({
        gzlq: function (value, item) {
            if (value != "") {
                if (!/^[0-9]*$/.test(value)) {
                    return '只能填写数字';
                }
            }
        },
        gzlz: function (value, item) {
            if (value != "") {
                if (!/^[0-9]*$/.test(value)) {
                    return '只能填写数字';
                }
            }
        },
        gzlqz: function (value, item) {
            if ($("#gzlq").val() != "" && $("#gzlz").val() != "") {
                if ($("#gzlq").val() > $("#gzlz").val()) {
                    return '工作量起不能大于工作量止';
                }
            }
        }


    });

    form.on('submit(hz_search)', function (data) {
        table.reload('tbl_ywgzlhz', {
            where: {
                hzrqq: $("input[name='hzrqq']").val(),
                hzrqz: $("input[name='hzrqz']").val(),
                gzlq: $("input[name='gzlq']").val(),
                gzlz: $("input[name='gzlz']").val()
            }
        });
        return false;
    });

    table.render({
        elem: '#tbl_ywgzlhz'
        , url: contextPath + '/cxtj/ywgzlhz/loadHzList'
        , method: 'post'
        , request: {
            pageName: 'page'
            , limitName: 'limit'
        }
        , where: {
            hzrqq: $("input[name='hzrqq']").val(),
            hzrqz: $("input[name='hzrqz']").val(),
            gzlq: $("input[name='gzlq']").val(),
            gzlz: $("input[name='gzlz']").val()

        }
        , parseData: function (res) {
            return {
                "code": res.code,
                "msg": res.msg,
                "count": res.data.count,
                "data": res.data.list
            };
        }
        , title: '运维工作量汇总表'
        , toolbar: '#tbl_ywgzlhz_toolbar'
        , defaultToolbar: []
        , cols: [[
            {type: 'numbers', fixed: 'left'}
            , {field: 'id', title: 'ID', hide: true}
            , {field: 'bmzbMc', title: '部门', sort: true}
            , {field: 'xm', title: '姓名'}
            , {field: 'hjs', title: '合计数', sort: true}
            , {field: 'wtl', title: '问题类', sort: true}
            , {field: 'jbl', title: '脚本类', sort: true}
            // , {title: '操作', width: 160, align: 'center', fixed: 'right', toolbar: '#tbl_col_tool'}
        ]]
        , page: true
        , limit: 10
        , limits: [10, 15, 20]
        , height: 'full-130'
        , text: {none: '暂无相关数据'}
    });

    table.on('toolbar(tbl_ywgzlhz)', function (obj) {
        if (obj.event == "refresh") {
            table.reload('tbl_ywgzlhz');
        }
    });

    table.on('tool(tbl_ywgzlhz)', function (obj) {
        if (obj.event === 'mx') {
            cssnj.window("运维问题明细", contextPath + '/cxtj/ywgzlhz/mxlist?hzlx=' + $("select[name='hzlx']").val() + '&hzid=' + obj.data.hzid + '&hzrqq=' + $("input[name='hzrqq']").val() + '&hzrqz=' + $("input[name='hzrqz']").val(), {
                width: '100%',
                height: '100%'
            });
        }
    });

    exports('ywgzlhz', {})
});