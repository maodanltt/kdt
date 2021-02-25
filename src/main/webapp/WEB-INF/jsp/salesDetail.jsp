
<html>
<head>
    <title>销售明细查询</title>
</head>
<script type="text/javascript">

    function search() {

    }

    function check() {
        return true;
    }

    function init() {
    }
</script>
<body onload="init()">
<br>
<form id="itemForm" action="/item/queryItemList.action" method="post">
    编辑部门名称：<input type="text" name="bjbmmc" id="bjbmmc" value="<%=bjbmmc == null ? "" : bjbmmc %>">&nbsp;&nbsp;&nbsp;
    图书分类简称：<input type="text" name="tsfljc" id="tsfljc" value="<%=tsfljc == null ? "" : tsfljc %>">&nbsp;&nbsp;&nbsp;
    销售部门名称：<input type="text" name="xsbmmc" id="xsbmmc" value="<%=xsbmmc == null ? "" : xsbmmc %>">&nbsp;&nbsp;&nbsp;
       开始月份：<input type="month" name="startdate" id="startdate" value="<%=startdate == null ? "" : startdate %>">&nbsp;&nbsp;&nbsp;
       结束月份：<input type="month" name="enddate" id="enddate" value="<%=enddate == null ? "" : enddate %>"> &nbsp;&nbsp;&nbsp;
    <input type="button" value="查询" onclick="search()">
</form>
<hr color="black">
    <div>
        总销售册数：<span id="zxscsspan"></span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 总库存周转率：<span id="zkczzlspan"></span>
        <br><br>
    </div>
<table border="1" cellspacing="0" cellpadding="0" width="98%">
    <tr align="center">
        <td width="3%">发货单编号</td>
        <td width="40%">发货状态</td>
        <td width="5%">客户名称</td>
        <td width="15%">销售部门名称</td>
        <td width="7%">单据类型</td>
        <td width="7%">制单日期</td>
        <td width="7%">书序号</td>
        <td width="8%">书名</td>
        <td width="8%">编辑部门名称</td>
        <td width="5%">图书分类简称</td>
        <td width="15%">自编码</td>
        <td width="7%">定价</td>
        <td width="7%">册数</td>
        <td width="7%">码洋</td>
        <td width="8%">折扣</td>
        <td width="8%">实洋</td>
        <td width="8%">大区经理</td>
        <td width="8%">地区</td>
    </tr>

    <tr align="center">
        <td width="3%"></td>
        <td width="40%"></td>
        <td width="5%"></td>
        <td width="15%"></td>
        <td width="7%"></td>
        <td width="7%"></td>
        <td width="7%"></td>
        <td width="8%"></td>
        <td width="8%"></td>
    </tr>

    <tr align="center">
        <td width="3%" colspan="4">汇总</td>
        <td width="7%"></td>
        <td width="7%"></td>
        <td width="7%"></td>
        <td width="8%">--</td>
        <td width="8%">--</td>
    </tr>

</table>
</body>
</html>
