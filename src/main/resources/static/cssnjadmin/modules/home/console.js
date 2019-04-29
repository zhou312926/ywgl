/**

 @Name：layuiAdmin 主页控制台
 @Author：贤心
 @Site：http://www.layui.com/admin/
 @License：GPL-2

 */


layui.define(function (exports) {

    layui.use(['admin', 'echarts'], function () {
        var $ = layui.$
            , admin = layui.admin
            , echarts = layui.echarts;

        admin.req({
            url: contextPath + '/ywfw/wtgl',
            data: JSON.stringify({
                handle: 'countYyxt'
            }),
            type: 'post',
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            done: function (res) {
                if (res.code == '0') {
                    var ywxtFb, options = {
                        title: {
                            text: '运维系统分布',
                            x: 'center',
                            textStyle: {
                                fontSize: 14
                            }
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: "{a} <br/>{b} : {c} ({d}%)"
                        },
                        legend: {
                            orient: 'vertical',
                            x: 'left',
                            data: res.data.legend
                        },
                        series: [{
                            name: '运维系统',
                            type: 'pie',
                            radius: '55%',
                            center: ['50%', '50%'],
                            data: res.data.series
                        }]
                    }, renderDataView = function () {
                        ywxtFb = echarts.init($('#ywxt_fb').get(0), layui.echartsTheme);
                        ywxtFb.setOption(options);
                        admin.resize(function () {
                            ywxtFb.resize();
                        });
                    };
                    renderDataView();
                    layui.admin.on('side', function () {
                        setTimeout(function () {
                            renderDataView();
                        }, 300);
                    });
                }
            }
        });
    });

    layui.use(['admin', 'echarts'], function () {
        var $ = layui.$
            , admin = layui.admin
            , echarts = layui.echarts;

        admin.req({
            url: contextPath + '/ywfw/wtgl',
            data: JSON.stringify({
                handle: 'countWtlx'
            }),
            type: 'post',
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            done: function (res) {
                if (res.code == '0') {
                    var wtlxFb, options = {
                        title: {
                            text: '问题类型分布',
                            x: 'center',
                            textStyle: {
                                fontSize: 14
                            }
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: "{a} <br/>{b} : {c} ({d}%)"
                        },
                        legend: {
                            orient: 'vertical',
                            x: 'left',
                            data: res.data.legend
                        },
                        series: [{
                            name: '问题类型',
                            type: 'pie',
                            radius: '55%',
                            center: ['50%', '50%'],
                            data: res.data.series
                        }]
                    }, renderDataView = function () {
                        wtlxFb = echarts.init($('#wtlx_fb').get(0), layui.echartsTheme);
                        wtlxFb.setOption(options);
                        admin.resize(function () {
                            wtlxFb.resize();
                        });
                    };
                    renderDataView();
                    layui.admin.on('side', function () {
                        setTimeout(function () {
                            renderDataView();
                        }, 300);
                    });
                }
            }
        });

    });

    layui.use(['admin', 'echarts'], function () {
        var $ = layui.$
            , admin = layui.admin
            , echarts = layui.echarts;

        admin.req({
            url: contextPath + '/ywfw/wtgl',
            data: JSON.stringify({
                handle: 'countXzwt'
            }),
            type: 'post',
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            done: function (res) {
                if (res.code == '0') {
                    var wtxxXz, options = {
                        title: {
                            text: '最近一周新增问题量',
                            x: 'center',
                            textStyle: {
                                fontSize: 14
                            }
                        },
                        tooltip: {
                            trigger: 'axis',
                            formatter: "{b}<br>新增问题：{c}"
                        },
                        xAxis: [{
                            type: 'category',
                            data: res.data.xAxis
                        }],
                        yAxis: [{
                            type: 'value'
                        }],
                        series: [{
                            type: 'line',
                            data: res.data.series
                        }]
                    }, renderDataView = function () {
                        wtxxXz = echarts.init($('#wtxx_xz').get(0), layui.echartsTheme);
                        wtxxXz.setOption(options);
                        admin.resize(function () {
                            wtxxXz.resize();
                        });
                    };
                    renderDataView();
                    layui.admin.on('side', function () {
                        setTimeout(function () {
                            renderDataView();
                        }, 300);
                    });
                }
            }
        });
    });

    layui.use(['admin', 'echarts'], function () {
        var $ = layui.$
            , admin = layui.admin
            , echarts = layui.echarts;

        // admin.req({
        //     url: contextPath + '/ywfw/wtgl',
        //     data: JSON.stringify({
        //         handle: 'countYyxt'
        //     }),
        //     type: 'post',
        //     contentType: "application/json;charset=utf-8",
        //     dataType: "json",
        //     done: function (res) {
        //         if (res.code == '0') {
        //             var ywxtFb, options = {
        //                 title: {
        //                     text: '运维系统分布',
        //                     x: 'center',
        //                     textStyle: {
        //                         fontSize: 14
        //                     }
        //                 },
        //                 tooltip: {
        //                     trigger: 'item',
        //                     formatter: "{a} <br/>{b} : {c} ({d}%)"
        //                 },
        //                 legend: {
        //                     orient: 'vertical',
        //                     x: 'left',
        //                     data: res.data.legend
        //                 },
        //                 series: [{
        //                     name: '运维系统',
        //                     type: 'pie',
        //                     radius: '55%',
        //                     center: ['50%', '50%'],
        //                     data: res.data.series
        //                 }]
        //             }, renderDataView = function () {
        //                 ywxtFb = echarts.init($('#ywxt_fb').get(0), layui.echartsTheme);
        //                 ywxtFb.setOption(options);
        //                 admin.resize(function () {
        //                     ywxtFb.resize();
        //                 });
        //             };
        //             renderDataView();
        //             layui.admin.on('side', function () {
        //                 setTimeout(function () {
        //                     renderDataView();
        //                 }, 300);
        //             });
        //         }
        //     }
        // });
        // admin.req({
        //     url: contextPath + '/ywfw/wtgl',
        //     data: JSON.stringify({
        //         handle: 'countWtlx'
        //     }),
        //     type: 'post',
        //     contentType: "application/json;charset=utf-8",
        //     dataType: "json",
        //     done: function (res) {
        //         if (res.code == '0') {
        //             var wtlxFb, options = {
        //                 title: {
        //                     text: '问题类型分布',
        //                     x: 'center',
        //                     textStyle: {
        //                         fontSize: 14
        //                     }
        //                 },
        //                 tooltip: {
        //                     trigger: 'item',
        //                     formatter: "{a} <br/>{b} : {c} ({d}%)"
        //                 },
        //                 legend: {
        //                     orient: 'vertical',
        //                     x: 'left',
        //                     data: res.data.legend
        //                 },
        //                 series: [{
        //                     name: '问题类型',
        //                     type: 'pie',
        //                     radius: '55%',
        //                     center: ['50%', '50%'],
        //                     data: res.data.series
        //                 }]
        //             }, renderDataView = function () {
        //                 wtlxFb = echarts.init($('#wtlx_fb').get(0), layui.echartsTheme);
        //                 wtlxFb.setOption(options);
        //                 admin.resize(function () {
        //                     wtlxFb.resize();
        //                 });
        //             };
        //             renderDataView();
        //             layui.admin.on('side', function () {
        //                 setTimeout(function () {
        //                     renderDataView();
        //                 }, 300);
        //             });
        //         }
        //     }
        // });
        //
        // admin.req({
        //     url: contextPath + '/ywfw/wtgl',
        //     data: JSON.stringify({
        //         handle: 'countXzwt'
        //     }),
        //     type: 'post',
        //     contentType: "application/json;charset=utf-8",
        //     dataType: "json",
        //     done: function (res) {
        //         if (res.code == '0') {
        //             var wtxxXz, options = {
        //                 title: {
        //                     text: '最近一周新增问题量',
        //                     x: 'center',
        //                     textStyle: {
        //                         fontSize: 14
        //                     }
        //                 },
        //                 tooltip: {
        //                     trigger: 'axis',
        //                     formatter: "{b}<br>新增问题：{c}"
        //                 },
        //                 xAxis: [{
        //                     type: 'category',
        //                     data: res.data.xAxis
        //                 }],
        //                 yAxis: [{
        //                     type: 'value'
        //                 }],
        //                 series: [{
        //                     type: 'line',
        //                     data: res.data.series
        //                 }]
        //             }, renderDataView = function () {
        //                 wtxxXz = echarts.init($('#wtxx_xz').get(0), layui.echartsTheme);
        //                 wtxxXz.setOption(options);
        //                 admin.resize(function () {
        //                     wtxxXz.resize();
        //                 });
        //             };
        //             renderDataView();
        //             layui.admin.on('side', function () {
        //                 setTimeout(function () {
        //                     renderDataView();
        //                 }, 300);
        //             });
        //         }
        //     }
        // });

        admin.req({
            url: contextPath + '/ywfw/wtgl',
            data: JSON.stringify({
                handle: 'countWjjwt'
            }),
            type: 'post',
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            done: function (res) {
                if (res.code == '0') {
                    var wtxxWjj, options = {
                        title: {
                            text: '超期（' + res.data.cqts + '天）未解决问题量',
                            x: 'center',
                            textStyle: {
                                fontSize: 14
                            }
                        }, tooltip: {
                            trigger: 'axis',
                            formatter: "{b}<br>未解决问题：{c}"
                        }, calculable: true,
                        xAxis: [
                            {
                                type: 'category',
                                data: res.data.xAxis
                            }
                        ], yAxis: [
                            {
                                type: 'value'
                            }
                        ], series: [
                            {
                                name: '问题量',
                                type: 'bar',
                                barMaxWidth: 30,
                                data: res.data.series
                            }
                        ], noDataLoadingOption: {
                            text: '暂无超期未解决问题',
                            effect: 'bubble',
                            effectOption: {
                                effect: {
                                    n: 0
                                }
                            }
                        }
                    }, renderDataView = function () {
                        wtxxWjj = echarts.init($('#wtxx_wjj').get(0), layui.echartsTheme);
                        wtxxWjj.setOption(options);
                        admin.resize(function () {
                            wtxxWjj.resize();
                        });
                    };
                    renderDataView();
                    layui.admin.on('side', function () {
                        setTimeout(function () {
                            renderDataView();
                        }, 300);
                    });
                }
            }
        });
    });

    exports('console', {})
});

