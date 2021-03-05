
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

    function openwin(sxh,shum,zbh) {
        window.open ("/search/queryRkDetailList.do?sxh=" + sxh + "&shum=" + shum + "&zbh=" + zbh, "newwindow", "height=600, width=800,top=300,left=1000,right=30; toolbar =no, menubar=no, scrollbars=no, resizable=no, location=no, status=no") //写成一行
    }

    function queryDataList(pageNo, pageSize) {
        $.ajax({
            url: "/report/querySalesDetailList.do",
            data: {
                "pageNo" :pageNo,
                "pageSize" : pageSize,
                "khmc": $.trim($("#khmc").val()),
                "shum": $.trim($("#shum").val()),
                "tsfljc": $.trim($("#tsfljc").val()),
                "zbh": $.trim($("#zbh").val()),
                "bmmc": $.trim($("#bmmc").val()),
                "djlx": $.trim($("#djlx").val()),
                "dqjl": $.trim($("#dqjl").val()),
                "dq": $.trim($("#dq").val()),
                "startdate": $.trim($("#startdate").val()),
                "enddate": $.trim($("#enddate").val()),
            },
            type: "post",
            dataType: "json",
            success: function (data) {
                if (data.total == 0) {
                    alert("未查询到数据,请修改查询条件!");
                }
                var tbodyHtml = "";
                $.each(data.salesDetailList,function (i,n) {
                    tbodyHtml += '<tr class="active" style="font-size: xx-small">';
                    tbodyHtml += '<td>' + (i+1) + '</td>';
                    tbodyHtml += '<td>' + n.fhdbh + '</td>';
                    tbodyHtml += '<td>' + n.khmc + '</td>';
                    tbodyHtml += '<td>' + n.txrq + '</td>';
                    tbodyHtml += '<td><a style="color: blue; cursor: pointer;" onclick="openwin(' + '\'' + n.sxh + '\'' + ',' + '\'' + n.shum + '\'' + ',' + '\'' + n.zbh + '\'' + ')">' + n.shum + '</a></td>';
                    tbodyHtml += '<td>' + n.yc + '</td>';
                    tbodyHtml += '<td>' + n.dj + '</td>';
                    tbodyHtml += '<td>' + n.cs + '</td>';
                    tbodyHtml += '<td>' + n.my + '</td>';
                    tbodyHtml += '<td>' + n.zk + '</td>';
                    tbodyHtml += '<td>' + n.sy + '</td>';
                    tbodyHtml += '<td>' + n.dqjl + '</td>';
                    tbodyHtml += '<td>' + n.dq + '</td>';
                    tbodyHtml += '</tr>';
                })
                $("#itemtbody").html(tbodyHtml);
                var tfootHtml = '<tr class="active" style="font-size: small">';
                tfootHtml += '<td colspan="6" align="center" style="color: blue">汇总</td>';
                tfootHtml += '<td></td>';
                tfootHtml += '<td>' + data.zcs + '</td>';
                tfootHtml += '<td>' + data.zmy + '</td>';
                tfootHtml += '<td></td>';
                tfootHtml += '<td>' + data.zsy + '</td>';
                tfootHtml += '<td></td>';
                tfootHtml += '<td></td>';
                tfootHtml += '</tr>';
                $("#itemtfoot").html(tfootHtml);
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

