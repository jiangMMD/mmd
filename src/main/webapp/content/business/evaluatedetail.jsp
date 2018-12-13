<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>评价详细</title>
    <link rel="stylesheet" href="/mmd/assets/css/ui.jqgrid.css"/>
    <link rel="stylesheet" href="assets/css/select2.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-duallistbox.css" />
    <link rel="stylesheet" href="assets/css/bootstrap-multiselect.css" />
</head>
<body>
<div class="page-header">
    <h5>
        <div class="row">
            <button class="btn btn-default btn-sm" onclick="history.back()">
                <i class="ace-icon fa fa-arrow-left"></i>
                返回
            </button>
        </div>
    </h5>
</div>
<div class="row">
    <div class="col-xs-12">

        <div class="space-12"></div>
        <div class="fc-button-group" style="margin-left: 5px;">
            <a id="custom_del" data-rel="tooltip" title="" data-original-title="删除" href="javascript:void(0)"
               style="padding: 2px;"><i class="ace-icon fa fa-trash-o red bigger-125"></i></a>
        </div>
        <table id="grid-table"></table>
        <div id="grid-pager"></div>
    </div>
</div>


<script type="text/javascript">
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    var scripts = [null, "assets/js/date-time/bootstrap-datepicker.js",
        "assets/js/jqGrid/jquery.jqGrid.custom.js",
        "assets/js/chosen.jquery.js",
        "assets/js/jquery.raty.js",
        "assets/js/jqGrid/i18n/grid.locale-cn.js",
        "assets/js/select2.js", null];

    $('.page-content-area').ace_ajax('loadScripts', scripts, function () {
        $(function () {
            var parent_column = $(grid_selector).closest('[class*="col-"]');
            $(window).on('resize.jqGrid', function () {
                $(grid_selector).jqGrid('setGridWidth', parent_column.width());
                $(grid_selector).jqGrid('setGridHeight', $(window).height() - 360);
            });
            $(document).one('ajaxloadstart.page', function (e) {
                $.jgrid.gridDestroy(grid_selector);
                $('.ui-jqdialog').remove();
            });


            //删除数据
            $("#custom_del").on("click", function () {
                var ids = $(grid_selector).jqGrid('getGridParam', 'selarrrow');
                if (!ids || ids.length === 0) {
                    showWarnInfo("请至少选择一条记录!");
                } else {
                    bootbox.confirm("确认删除选中的客户信息? ", function (result) {
                        if (result) {
                            myAjax("/business/delWord", {ids: ids.join(",")}, function (result) {
                                if (result.code === 1) {
                                    showSuccInfo("操作成功！");
                                    queryData();
                                } else {
                                    showErrorInfo(result.message);
                                }
                            })
                        }
                    });
                }
            });

            $(grid_selector).jqGrid({
                url: projectUrl + "/business/getWord?pid=" + '${id}', //获取所用用户信息
                datatype: "json",
                mtype: 'POST',
                height: $(window).height() - 360,
                colNames: ['ID', '用户名', '评论词', '评论时间', '星级'],
                colModel: [
                    {name: 'id', key: true, width: 60, hidden: true},
                    {name: 'unick', width: 150},
                    {name: 'word', width: 450},
                    {name: 'evdate', width: 150},
                    {name: 'starlevel', width: 150, formatter: pcikStarLevel}
                ],
                sortname: 'evdate',
                sortorder: 'desc',
                ondblClickRow: queryDetail,
                viewrecords: true,
                rowNum: 10,
                rowList: [10, 20, 30],
                pager: pager_selector,
                autowidth: true,
                autoScroll: false,
                shrinkToFit: false,
                multiselect: true,
                multiboxonly: true,
                loadError: function (xhr, status, error) {
                    showErrorInfo("服务异常;" + error);
                },

                loadComplete: function() {
                    $('.rating').each(function(){
                        $(this).raty({
                            number: $(this).attr("data-val"),
                            starType : 'i',
                            readOnly: true,
                        });
                        $(this).find('.star-off-png').addClass("star-on-png").removeClass("star-off-png");
                    })
                }
            });
            //星级
            function pcikStarLevel(val) {
                return '<div class="rating inline" data-val="'+val+'"></div>';
            }



            //查看详细信息
            function queryDetail(id) {
                toCustomUrl('server/business/toProdEvaluateDetail?id=' + id);
            }

        })

    })


</script>

</body>

</html>
