<%@ page import="com.tywh.kdt.report.pojo.RkDetail" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tywh.kdt.report.pojo.Yzd" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String shum = (String) request.getAttribute("shum");
    String zbh = (String) request.getAttribute("zbh");
    List<Yzd> reslutYzdList = (List<Yzd>) request.getAttribute("reslutYzdList");
%>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/js/jquery-1.11.1-min.js"></script>
    <script type="text/javascript" src="/js/query.js"></script>
    <link href="/js/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <link href="/js/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="/js/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="/js/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/javascript">
    </script>
    <title>预计入库订单信息</title>
</head>
<body>
    <div font-size: small">
        <table>
            <tr style="font-size: medium">
                <td>书    名 : </td>
                <td><%=shum%></td>
            </tr>
            <tr style="font-size: medium">
                <td>物 流 码 : </td>
                <td><%=request.getParameter("sxh")%></td>
            </tr>
            <tr style="font-size: medium">
                <td>自 编 码 : </td>
                <td><%=zbh%></td>
            </tr>
        </table>
    </div>
    <hr>

    <div style="position: relative; height: 100%;">
        <div style="position: relative;top: 20px; font-size: small">
            <table class="table table-hover">
                <thead>
                <tr style="color: blue; font-size: small">
                    <td>序</td>
                    <td>付印单号</td>
                    <td>制单日期</td>
                    <td>预计入库日期</td>
                    <td>印次</td>
                    <td>印刷厂</td>
                    <td>本次印数</td>
                    <td>已收册数</td>
                </tr>
                </thead>
                <tbody id="yzdtbody">
                <%
                    if (reslutYzdList != null) {
                        for (int i=0; i<reslutYzdList.size(); i++) {

                %>
                <tr class="active" style="font-size: small">
                    <td><%=(i+1)%></td>
                    <td><%=reslutYzdList.get(i).getFydh()%></td>
                    <td><%=reslutYzdList.get(i).getTxrq()%></td>
                    <td><%=reslutYzdList.get(i).getYwrq()%></td>
                    <td><%=reslutYzdList.get(i).getYc()%></td>
                    <td><%=reslutYzdList.get(i).getCycjc()%></td>
                    <td><%=reslutYzdList.get(i).getBcys()%></td>
                    <td><%=reslutYzdList.get(i).getYscs()%></td>
                </tr>
                <%
                        }
                    }
                %>

                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
