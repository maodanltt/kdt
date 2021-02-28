<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售明细查询</title>
</head>
<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $(function () {
        $("#shum").keyup(function () {
            if ($("#shum").val() == '') {
                $("#shumtip").css("display","none");
                return;
            }
            $.ajax({
                url : "/search/queryBookList.do",
                data : {"shum" : $.trim($("#shum").val())},
                type : "get",
                dataType : "json",
                success : function (data) {
                    var html = "";
                    $.each(data.shumList,function(i, shum) {
                        html += '<div onmouseover="changeBackColor_over(this)" onmouseout="changeBackColor_out(this)" onclick="clicked(this)">'
                            + shum + '</div>';
                    })
                    $("#shumtip").html(html);
                    $("#shumtip").css("display","block")
                }
            })
        })
    })

    function changeBackColor_over(divDomObject) {
        $(divDomObject).css("background-color","#CCCCCC");
    }

    function changeBackColor_out(divDomObject) {
        $(divDomObject).css("background-color","");
    }

    function clicked(divDomObject) {
        $("#shum").val(divDomObject.innerHTML);
        $("#shumtip").css("display","none");
    }
</script>
<body>
    <div style="font-size: small">
        客户名称：<input style="width:150px;" type="text" name="shum" id="khmc">&nbsp;&nbsp;&nbsp;
        销售部门：<input style="width:150px;" type="text" name="shum" id="xsbmmc">&nbsp;&nbsp;&nbsp;
        编辑部门：<input style="width:150px;" type="text" name="shum" id="bmmc">&nbsp;&nbsp;&nbsp;
        图书分类：<input style="width:100px;" type="text" name="shum" id="tsfljc">&nbsp;&nbsp;&nbsp;
        自编码：<input style="width:100px;" type="text" name="shum" id="zbh"><br><br>
        书&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input style="width:500px;" type="text" name="shum" id="shum">&nbsp;&nbsp;&nbsp;
        分类名称：<input style="width:100px;" type="text" name="shum" id="flmc">&nbsp;&nbsp;&nbsp;
        开始月份：<input type="date" name="startdate" id="startdate" >&nbsp;&nbsp;&nbsp;
        结束月份：<input type="date" name="enddate" id="enddate" > &nbsp;&nbsp;&nbsp;
        <input type="button" value="查询" id="search">
        <hr>
        <div id="shumtip" style="background-color:white; border: 1px solid cadetblue;width:500px;position: center;top: 133px;left:944px;display:none" ></div>


    </div>

</body>
</html>
