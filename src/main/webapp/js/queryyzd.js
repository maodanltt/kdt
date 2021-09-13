
    function queryDataList(pageno, pagesize) {
        $.ajax({
            url : "/report/yzd/list.do",
            data: {
                "pageno" : pageno,
                "pagesize" : pagesize,
                "shum" : $.trim($("#query-shum").val()),
                "tsflmc" : $.trim($("#query-tsflmc").val()),
                "fydh" : $.trim($("#query-fydh").val()),
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
                    tbodyHtml += '<td>' + (i + 1) +'</td>';
                    tbodyHtml += '<td>' + item.txrq +'</td>';
                    tbodyHtml += '<td>' + item.ywrq +'</td>';
                    tbodyHtml += '<td>' + item.shum +'</td>';
                    tbodyHtml += '<td>' + item.zbh +'</td>';
                    tbodyHtml += '<td>' + item.cycjc +'</td>';
                    tbodyHtml += '<td>' + item.sxh +'</td>';
                    tbodyHtml += '<td>' + item.fydh +'</td>';
                    tbodyHtml += '<td>' + item.bcys +'</td>';
                    tbodyHtml += '<td>' + item.yscs +'</td>';
                    tbodyHtml += '</tr>';
                })
                $("#yzdtbody").html(tbodyHtml);

                var totalPages = data.total%pagesize == 0 ? data.total/pagesize : parseInt(data.total/pagesize) + 1;
                $("#yzdPage").bs_pagination({
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

