
    function nowDate() {
        let nowDate = new Date()
        let year = nowDate.getFullYear()
        let month = nowDate.getMonth() + 1
        let day = nowDate.getDate()
        if (month < 10) month = '0' + month
        if (day < 10) day = '0' + day
        return year + '-' + month + '-' +day
    }

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
        window.open ("/search/queryRkDetailList.do?sxh=" + sxh, "newwindow", "height=600, width=800,top=300,left=1000,right=30; toolbar =no, menubar=no, scrollbars=no, resizable=no, location=no, status=no") //写成一行
    }

    function queryDataList(pageNo, pageSize) {
        $.ajax({
            url: "/report/stockage/list.do",
            data: {
                "pageNo" :pageNo,
                "pageSize" : pageSize,
                "shum": $.trim($("#shum").val()),
                "tsfljc": $.trim($("#tsfljc").val()),
                "zbh": $.trim($("#zbh").val()),
                "bmmc": $.trim($("#bmmc").val()),
            },
            type: "post",
            dataType: "json",
            success: function (data) {
                if (data.total == 0) {
                    alert("未查询到数据,请修改查询条件!");
                }
                var tbodyHtml = "";
                $.each(data.stockageList,function (i,n) {
                    tbodyHtml += '<tr class="active" style="font-size: xx-small">';
                    tbodyHtml += '<td>' + (i+1) + '</td>';
                    tbodyHtml += '<td><a style="color: blue; cursor: pointer;" onclick="openwin(' + '\'' + n.sxh + '\'' + ')">' + n.shum + '</a></td>';
                    tbodyHtml += '<td>' + n.tsfljc + '</td>';
                    tbodyHtml += '<td>' + n.yc + '</td>';
                    tbodyHtml += '<td>' + n.bmmc + '</td>';
                    tbodyHtml += '<td>' + n.qmkc + '</td>';
                    tbodyHtml += '<td>' + n.term1 + '</td>';
                    tbodyHtml += '<td>' + n.term2 + '</td>';
                    tbodyHtml += '<td>' + n.term3 + '</td>';
                    tbodyHtml += '<td>' + n.term4 + '</td>';
                    tbodyHtml += '<td>' + n.term5 + '</td>';
                    tbodyHtml += '<td>' + n.term6 + '</td>';
                    tbodyHtml += '<td>' + n.term7 + '</td>';
                    tbodyHtml += '</tr>';
                })
                $("#stockagebody").html(tbodyHtml);

                var totalPages = data.total%pageSize == 0 ? data.total/pageSize : parseInt(data.total/pageSize) + 1;
                $("#activityPage").bs_pagination({
                    currentPage: pageNo, // 页码
                    rowsPerPage: pageSize, // 每页显示的记录条数
                    maxRowsPerPage: 20, // 每页最多显示的记录条数
                    totalPages: totalPages, // 总页数
                    totalRows: data.total, // 总记录条数

                    visiblePageLinks: 5, // 显示几个卡片

                    showGoToPage: true,
                    showRowsPerPage: true,
                    showRowsInfo: true,
                    showRowsDefaultInfo: true,

                    onChangePage : function(event, data){
                        queryDataList(data.currentPage , data.rowsPerPage);
                    }
                });

            }
        })
    }

