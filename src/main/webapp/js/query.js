
    function keyupcallback(dom1,dom2,data) {
        if ($(dom1).val() == '') {
            $(dom2).css("display", "none");
            return;
        }

        var newData = "{'list':[";
        $.each(data.list, function (i, n) {
            if ((n.name).indexOf($(dom1).val()) != -1) {
                if (i < data.list.length - 1) {
                    newData += "{'name':'" + n.name + "'},";
                } else {
                    newData += "{'name':'" + n.name + "'}";
                }
            }
        })
        //<div onmouseover="changeBackColor_over(this)" onmouseout="changeBackColor_out(this)" onclick="clicked(this,dom1,dom2)">百年方</div>
        newData += "]}";
        window.eval("var newDataJson = " + newData);
        var html = "";
        $.each(newDataJson.list, function (i, n) {

            html += '<div onmouseover="changeBackColor_over(this)" onmouseout="changeBackColor_out(this)" onclick="clicked(this,' + dom1.id + ',' + dom2.id + ')">'
                + n.name + '</div>';
        })
        // alert(html);
        $(dom2).html(html);
        $(dom2).css("display", "block")
    }

    //,' + dom1 + ',' + dom2 + '
    function changeBackColor_over(divDomObject) {
        $(divDomObject).css("background-color","#CCCCCC");
    }

    function changeBackColor_out(divDomObject) {
        $(divDomObject).css("background-color","");
    }

    function clicked(divDomObject,dom1,dom2) {
        $(dom1).val(divDomObject.innerHTML);
        $(dom2).css("display","none");
    }

    function openwin(sxh) {
    alert(123);
        window.open ("/search/queryRkDetailList.do?sxh=" + sxh, "newwindow", "height=600, width=800,top=300,left=1000,right=30; toolbar =no, menubar=no, scrollbars=no, resizable=no, location=no, status=no") //写成一行
    }

