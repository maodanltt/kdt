<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售明细查询</title>
</head>
<body>
        Search <input
        type="text" name="name" class="inputtable"
        id="name" />
        <input type="image" src="images/serchbutton.gif"
       border="0" style="margin-bottom:-4px">
        为了存贮自动补全的文字，我们使用div标签
        设置背景色为白色，绝对布局。并且默认不显示。

        <div id="context1" style="background-color:white; border: 1px solid red;width:128px;position: absolute;top: 133px;left:944px;display:none" >
        </div>
        在百度的补全功能中我们发现，每输入一个字，对应的补全文字就会更新，所以我们要为搜索框设置键盘抬起事件（keyup），然后就是Ajax实现异步交互。
        js代码：
        $(".inputtable").keyup(function(){
        var content=$(this).val();
        //如果当前搜索内容为空，无须进行查询
        if(content==""){
        $("#context1").css("display","none");
        return ;
        }
        //由于浏览器的缓存机制 所以我们每次传入一个时间
        var time=new Date().getTime();
        $.ajax({
        type:"get",
        //新建一个名为findBooksAjaxServlet的servlet
        url:"${pageContext.request.contextPath}/servlet/findBooksAjaxServlet",
        data:{name:content,time:time},
        success:function(data){
        //拼接html
        var res=data.split(",");
        var html="";
        for(var i=0;i<res.length;i++){
        //每一个div还有鼠标移出、移入点击事件
        html+="<div onclick='setSearch_onclick(this)' onmouseout='changeBackColor_out(this)' onmouseover='changeBackColor_over(this)'>"+res[i]+"</div>";
        }
        $("#context1").html(html);
        //显示为块级元素
        $("#context1").css("display","block");
        }
        });
        });
        我们的鼠标在选择到自动补全的内容时，我们会发现内容的那一行会变色，即onmouseover事件，离开时恢复原色onmouseout事件，
        点击时将内容填写到搜索框onclick事件。所以在上面的代码中我们会这样写
        var html="";
        for(var i=0;i<res.length;i++){
        //每一个div还有鼠标移出、移入点击事件
        html+="<div onclick='setSearch_onclick(this)' onmouseout='changeBackColor_out(this)' onmouseover='changeBackColor_over(this)'>"+res[i]+"</div>";
        }
        而其三种事件对应的js代码如下：
        //鼠标移动到内容上
        function changeBackColor_over(div){
        $(div).css("background-color","#CCCCCC");
        }
        //鼠标离开内容
        function changeBackColor_out(div){
        $(div).css("background-color","");
        }
        //将点击的内容放到搜索框
        function setSearch_onclick(div){
        $(".inputtable").val(div.innerText);
        $("#context1").css("display","none");
        }


</body>
</html>
