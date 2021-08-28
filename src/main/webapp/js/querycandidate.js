
    function queryDataList(pageno, pagesize) {
        $.ajax({
            url : "/hr/candidate/list.do",
            data: {
                "pageno" : pageno,
                "pagesize" : pagesize,
                "username" : $.trim($("#query-username").val()),
                "candidate" : $.trim($("#query-candidate").val()),
                "jobtitle" : $.trim($("#query-jobtitle").val()),
                "startdate" : $.trim($("#query-startdate").val()),
                "enddate" : $.trim($("#query-enddate").val()),
            },
            type: "post",
            dataType: "json",
            success: function (data) {
                if (data.total == 0) {
                    alert("未查询到数据,请修改查询条件!");
                }
                var tbodyHtml = "";
                $.each(data.list,function(i,item) {
                    tbodyHtml += '<tr style="font-size: xx-small">';
                    tbodyHtml += '<td><input type="checkbox" name="xz" value="' + (item.id) + '"></td>';
                    tbodyHtml += '<td>' + (i + 1) +'</td>';
                    tbodyHtml += '<td>' + item.createdate +'</td>';
                    tbodyHtml += '<td>' + item.username +'</td>';
                    tbodyHtml += '<td>' + item.sitename +'</td>';
                    tbodyHtml += '<td>' + item.candidate +'</td>';
                    tbodyHtml += '<td>' + item.jobtitle +'</td>';
                    tbodyHtml += '<td>' + item.mobile +'</td>';
                    tbodyHtml += '<td>' + item.appointdate +'</td>';
                    tbodyHtml += '<td>' + item.appointtime +'</td>';
                    tbodyHtml += '<td>' + item.communication +'</td>';
                    tbodyHtml += '<td>' + item.onepattern +'</td>';
                    tbodyHtml += '<td>' + item.onepass +'</td>';
                    tbodyHtml += '<td>' + item.oneremark +'</td>';
                    tbodyHtml += '<td>' + item.secondpattern +'</td>';
                    tbodyHtml += '<td>' + item.secondpass +'</td>';
                    tbodyHtml += '<td>' + item.secondremark +'</td>';
                    tbodyHtml += '<td>' + item.offered +'</td>';
                    tbodyHtml += '<td>' + item.entry +'</td>';
                    tbodyHtml += '<td>' + item.remark +'</td>';
                    tbodyHtml += '</tr>';
                })
                $("#candidatetbody").html(tbodyHtml);

                var totalPages = data.total%pagesize == 0 ? data.total/pagesize : parseInt(data.total/pagesize) + 1;
                $("#candidatePage").bs_pagination({
                    currentPage: pageno, // 页码
                    rowsPerPage: pagesize, // 每页显示的记录条数
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

