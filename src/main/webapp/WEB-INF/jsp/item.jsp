<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/js/jquery-1.11.1-min.js"></script>
    <link href="/js/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <link href="/js/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="/js/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="/js/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>
    <link rel="stylesheet" type="text/css" href="/js/bs_pagination/jquery.bs_pagination.min.css">
    <script type="text/javascript" src="/js/bs_pagination/jquery.bs_pagination.min.js"></script>
    <script type="text/javascript" src="/js/bs_pagination/en.js"></script>


    <script type="text/javascript">
        $(function () {
            $("#search").click(function () {
                if ($.trim($("#startdate").val()) == '') {
                    alert("开始月份必须输入");
                    $("#startdate").focus();
                    return false;
                }
                if ($.trim($("#enddate").val()) == '') {
                    alert("结束月份必须输入");
                    $("#enddate").focus();
                    return false;
                }
                $.ajax({
                    url : "/report/item/list.do",
                    data : {
                        "bjbmmc" : $.trim($("#bjbmmc").val()),
                        "xsbmmc" : $.trim($("#xsbmmc").val()),
                        "startdate" : $.trim($("#startdate").val()),
                        "enddate" : $.trim($("#enddate").val()),
                    },
                    type : "post",
                    dataType : "json",
                    success : function(data) {
                        $("#zxscsspan").html(data.zxscs);
                        $("#zkczzlspan").html(data.zkczzl);
                        var tbodyHtml = "";
                        $.each(data.itemList,function(i,item) {
                            tbodyHtml += '<tr class="active" style="font-size: xx-small">';
                            tbodyHtml += '<td>' + (i + 1) +'</td>';
                            tbodyHtml += '<td>' + item.shum +'</td>';
                            tbodyHtml += '<td>' + item.gjdj +'</td>';
                            tbodyHtml += '<td>' + item.tsfljc +'</td>';
                            tbodyHtml += '<td>' + item.qckc +'</td>';
                            tbodyHtml += '<td>' + item.qmkc +'</td>';
                            tbodyHtml += '<td>' + item.xscs +'</td>';
                            tbodyHtml += '<td>' + item.kczzl +'</td>';
                            tbodyHtml += '<td>' + item.kcdxl +'</td>';
                            tbodyHtml += '</tr>';

                        })
                        $("#itemtbody").html(tbodyHtml);
                        var tfootHtml = '<tr class="active" style="font-size: small">';
                        tfootHtml += '<td colspan="4" align="center" style="color: blue">汇总</td>';
                        tfootHtml += '<td>' + data.zqckc +'</td>';
                        tfootHtml += '<td>' + data.zqmkc +'</td>';
                        tfootHtml += '<td>' + data.zxscs +'</td>';
                        tfootHtml += '<td>--</td>';
                        tfootHtml += '<td>--</td>';
                        tfootHtml += '</tr>';
                        $("#itemtfoot").html(tfootHtml);
                    }
                })

            })
        })

    </script>
</head>
<body>

<div style="position: relative; height: 100%;">

    <div class="btn-toolbar" role="toolbar" style="height: 80px; padding: 0 20px">
        <form role="form" action="/report/item/export.do" method="post" style="position: relative; top: 8%; left: 5px;font-size: small" id="queryForm" target="iframe">
            <div class="row">
                <div class="form-group col-xs-3">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">
                            编辑部门
                        </div>
                        <input class="form-control" type="text" name="bjbmmc" id="bjbmmc">
                    </div>
                </div>

                <div class="form-group col-xs-3">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">销售部门</div>
                        <input class="form-control" type="text" name="xsbmmc" id="xsbmmc">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-xs-3 col-md-3">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">开始月份</div>
                        <input class="form-control" type="month" name="startdate" id="startdate">
                    </div>
                </div>
                <div class="form-group col-xs-3 col-md-3">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">结束月份</div>
                        <input class="form-control" type="month" name="enddate" id="enddate">
                    </div>
                </div>
                <div class="form-group col-xs-2">
                    <button type="button" class="btn btn-default" style="color: blue" id="search"> 查 询</button>
                </div>

                <div class="form-group col-xs-2">
                    <button type="submit" class="btn btn-default" style="color: blue" id="export"> 导出Excel</button>
                </div>
            </div>
        </form>
        <iframe id="iframe" name="iframe" style="display:none;"></iframe>
    </div>
    <hr>
    <div>
        总销售册数：<span id="zxscsspan"></span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 总库存周转率：<span id="zkczzlspan"></span>
    </div>

    <div style="position: relative;top: 20px; font-size: small">
        <table class="table table-hover">
            <thead>
            <tr style="color: blue; font-size: xx-small">
                <td>序号</td>
                <td>书名</td>
                <td>定价</td>
                <td>图书分类简称</td>
                <td>期初库存</td>
                <td>期末库存</td>
                <td>销售册数</td>
                <td>库存周转率</td>
                <td>动销率</td>
            </tr>
            </thead>
            <tbody id="itemtbody"></tbody>
            <tfoot id="itemtfoot">
            </tfoot>
        </table>
    </div>

</div>


</body>
</html>
