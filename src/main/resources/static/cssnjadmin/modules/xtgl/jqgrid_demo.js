layui.extend({
    cssnj: 'common/cssnj'
}).define(['admin', 'form', 'table', 'cssnj'], function (exports) {
    var admin = layui.admin
        , form = layui.form
        , table = layui.table
        , cssnj = layui.cssnj;

    var jqGrid = $("#tbl_bmzbgl");
    jqGrid.jqGrid({
        url: contextPath + '/xtgl/bmzbgl/loadList',
        mtype: 'POST',
        ajaxGridOptions: {contentType: 'application/json; charset=utf-8'},
        postData: {
            handle: 'loadList'
        },
        serializeGridData: function (postData) {
            if (postData.searchField === undefined) postData.searchField = null;
            if (postData.searchString === undefined) postData.searchString = null;
            if (postData.searchOper === undefined) postData.searchOper = null;
            var data = JSON.stringify({
                handle: postData.handle,
                data: {
                    nd: postData.nd,
                    page: postData.page,
                    rows: postData.rows,
                    sidx: postData.sidx,
                    sord: postData.sord
                }
            });
            return data;
        },
        jsonReader:
            {
                root: "data.data",
                page: "data.page",
                total: "data.total",
                records: "data.records"
            },
        datatype: "json",
        colNames: ['名称', '排序', '状态'],
        colModel:
            [
                {name: 'mc', width: 100, index: 'mc'},
                {name: 'xh', width: 300, index: 'xh'},
                {name: 'yxbz', width: 150, index: 'yxbz'}
            ],
        rowNum: 10,
        rowList: [10, 15, 20],
        pager: '#bmzbgl_pager',
        styleUI: 'Bootstrap',
        viewrecords: true,
    });


    exports('bmzbgl', {})
});