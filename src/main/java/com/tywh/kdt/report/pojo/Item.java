package com.tywh.kdt.report.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentFontStyle;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

@HeadRowHeight(25)
@HeadFontStyle(bold = false)
public class Item {
    /*
    shum, tsfljc, gjdj, bmmc, xscs, zxscs, qckc, qmkc, xscs / ((qckc + qmkc) / 2)) AS spzzl,
                xscs / zxscs) AS dpdxl
     */


    @ColumnWidth(50)
    @ExcelProperty(value = "书名",index = 0)
    private String shum;

    @ColumnWidth(20)
    @ExcelProperty(value = "图书分类简称",index = 1)
    private String tsfljc;

    @ColumnWidth(7)
    @ExcelProperty(value = "定价",index = 2)
    private double gjdj;

    @ColumnWidth(12)
    @ExcelProperty(value = "期初库存",index = 3)
    private Integer qckc;

    @ColumnWidth(12)
    @ExcelProperty(value = "期末库存",index = 4)
    private Integer qmkc;

    @ColumnWidth(12)
    @ExcelProperty(value = "销售册数",index = 5)
    private Integer xscs;

    @ColumnWidth(13)
    @ExcelProperty(value = "库存周转率",index = 6)
    private String kczzl;

    @ColumnWidth(13)
    @ExcelProperty(value = "库存动销率",index = 7)
    private String kcdxl;

    @ExcelIgnore
    private String kjqj;

    @ExcelIgnore
    private String key;
    public String getKey() {
        return this.shum + "-" + this.gjdj + "-" + this.tsfljc;
    }

    public String getShum() {
        return shum;
    }

    public void setShum(String shum) {
        this.shum = shum;
    }

    public String getTsfljc() {
        return tsfljc;
    }

    public void setTsfljc(String tsfljc) {
        this.tsfljc = tsfljc;
    }

    public double getGjdj() {
        return gjdj;
    }

    public void setGjdj(double gjdj) {
        this.gjdj = gjdj;
    }

    public Integer getQckc() {
        return qckc;
    }

    public void setQckc(Integer qckc) {
        this.qckc = qckc;
    }

    public Integer getQmkc() {
        return qmkc;
    }

    public void setQmkc(Integer qmkc) {
        this.qmkc = qmkc;
    }

    public Integer getXscs() {
        return xscs;
    }

    public void setXscs(Integer xscs) {
        this.xscs = xscs;
    }

    public String getKcdxl() {
        return kcdxl;
    }

    public void setKcdxl(String kcdxl) {
        this.kcdxl = kcdxl;
    }

    public String getKczzl() {
        return kczzl;
    }

    public void setKczzl(String kczzl) {
        this.kczzl = kczzl;
    }

    public String getKjqj() {
        return kjqj;
    }

    public void setKjqj(String kjqj) {
        this.kjqj = kjqj;
    }
}
