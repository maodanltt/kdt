<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>库存动销率</title>
</head>
<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
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
                url : "/item/queryItemList.do",
                data : {
                    "bjbmmc" : $.trim($("#bjbmmc").val()),
                    "tsfljc" : $.trim($("#tsfljc").val()),
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
                        tbodyHtml += '<tr align="center">';
                        tbodyHtml += '<td width="3%">' + (i + 1) +'</td>';
                        tbodyHtml += '<td width="40%">' + item.shum +'</td>';
                        tbodyHtml += '<td width="5%">' + item.gjdj +'</td>';
                        tbodyHtml += '<td width="15%">' + item.tsfljc +'</td>';
                        tbodyHtml += '<td width="7%">' + item.qckc +'</td>';
                        tbodyHtml += '<td width="7%">' + item.qmkc +'</td>';
                        tbodyHtml += '<td width="7%">' + item.xscs +'</td>';
                        tbodyHtml += '<td width="8%">' + item.kczzl +'</td>';
                        tbodyHtml += '<td width="8%">' + item.kcdxl +'</td>';
                        tbodyHtml += '</tr>';

                    })
                    $("#itemtbody").html(tbodyHtml);
                    var tfootHtml = '<tr align="center">';
                    tfootHtml += '<td width="3%" colspan="4">汇总</td>';
                    tfootHtml += '<td width="7%" >' + data.zqckc +'</td>';
                    tfootHtml += '<td width="7%" >' + data.zqmkc +'</td>';
                    tfootHtml += '<td width="7%" >' + data.zxscs +'</td>';
                    tfootHtml += '<td width="8%" >--</td>';
                    tfootHtml += '<td width="8%" >--</td>';
                    tfootHtml += '</tr>';
                    $("#itemtfoot").html(tfootHtml);
                }
            })
        })
    })

</script>
<body>
<br>
<div>
    编辑部门名称：<input type="text" name="bjbmmc" id="bjbmmc" >&nbsp;&nbsp;&nbsp;
    图书分类简称：<input type="text" name="tsfljc" id="tsfljc" >&nbsp;&nbsp;&nbsp;
    销售部门名称：<input type="text" name="xsbmmc" id="xsbmmc" >&nbsp;&nbsp;&nbsp;
       开始月份：<input type="month" name="startdate" id="startdate" >&nbsp;&nbsp;&nbsp;
       结束月份：<input type="month" name="enddate" id="enddate" > &nbsp;&nbsp;&nbsp;
    <input type="button" value="查询" id="search">
    <hr color="black">
</div>
<div>
    总销售册数：<span id="zxscsspan"></span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 总库存周转率：<span id="zkczzlspan"></span>
    <br><br>
</div>
<table border="1" cellspacing="0" cellpadding="0" width="98%" id="itemTable">
    <thead id="itemthead">
        <tr align="center">
            <td width="3%">序号</td>
            <td width="40%">书名</td>
            <td width="5%">定价</td>
            <td width="15%">图书分类简称</td>
            <td width="7%">期初库存</td>
            <td width="7%">期末库存</td>
            <td width="7%">销售册数</td>
            <td width="8%">库存周转率</td>
            <td width="8%">动销率</td>
        </tr>
    </thead>
    <tbody id="itemtbody">
    </tbody>
    <tfoot id="itemtfoot">
    </tfoot>
</table>
</body>
</html>
