
    function keyupcallback(object,objecttip,data) {

    // $("#shum").keyup(function () {
        if ($(object).val() == '') {
            $(objecttip ).css("display","none");
            return;
        }

        var newData = "{'list':[";
        $.each(data.list,function (i,n) {
            if ((n.name).indexOf($(object).val()) != -1 ){
                if (i < data.list.length -1) {
                    newData += "{'name':'" + n.name +"'},";
                } else {
                    newData += "{'name':'" + n.name +"'}";
                }
            }
        })
        newData += "]}";
        window.eval("var newDataJson = " + newData);
        var html = "";
        $.each(newDataJson.list,function(i, n) {

            html += '<div onmouseover="changeBackColor_over(this)" onmouseout="changeBackColor_out(this)" onclick="clicked(this,object,objecttip)">'
                + n.name + '</div>';
        })
        $(objecttip).html(html);
        $(objecttip).css("display","block")
    }

    function changeBackColor_over(divDomObject) {
        $(divDomObject).css("background-color","#CCCCCC");
    }

    function changeBackColor_out(divDomObject) {
        $(divDomObject).css("background-color","");
    }

    function clicked(divDomObject,object,objecttip) {
        $(object).val(divDomObject.innerHTML);
        $(objecttip).css("display","none");
    }
