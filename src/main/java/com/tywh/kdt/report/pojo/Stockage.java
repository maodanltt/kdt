package com.tywh.kdt.report.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

@HeadRowHeight(20)
@HeadFontStyle(bold = false)
public class Stockage {

    @ColumnWidth(10)
    @ExcelProperty(value = "书序号",index = 0)
    private String sxh;

    @ColumnWidth(50)
    @ExcelProperty(value = "书名",index = 1)
    private String shum;

    @ColumnWidth(20)
    @ExcelProperty(value = "图书分类简称",index = 2)
    private String tsfljc;

    @ColumnWidth(20)
    @ExcelProperty(value = "编辑部门名称",index = 3)
    private String bmmc;

    @ColumnWidth(7)
    @ExcelProperty(value = "印次",index = 4)
    private String yc;

    @ColumnWidth(17)
    @ExcelProperty(value = "自编号",index = 5)
    private String zbh;

    @ColumnWidth(12)
    @ExcelProperty(value = "当前库存",index = 6)
    private Integer qmkc = 0;

    @ColumnWidth(10)
    @ExcelProperty(value = "0-30天",index = 7)
    private Integer term1 = 0;

    @ColumnWidth(10)
    @ExcelProperty(value = "31-60天",index = 8)
    private Integer term2 = 0;

    @ColumnWidth(12)
    @ExcelProperty(value = "61-180天",index = 9)
    private Integer term3 = 0;

    @ColumnWidth(12)
    @ExcelProperty(value = "181-365天",index = 10)
    private Integer term4 = 0;

    @ColumnWidth(10)
    @ExcelProperty(value = "1-2年",index = 11)
    private Integer term5 = 0;

    @ColumnWidth(10)
    @ExcelProperty(value = "2-3年",index = 12)
    private Integer term6 = 0;

    @ColumnWidth(10)
    @ExcelProperty(value = "3年以上",index = 13)
    private Integer term7 = 0;

    public String getSxh() {
        return sxh;
    }

    public void setSxh(String sxh) {
        this.sxh = sxh;
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

    public String getBmmc() {
        return bmmc;
    }

    public void setBmmc(String bmmc) {
        this.bmmc = bmmc;
    }

    public Integer getQmkc() {
        return qmkc;
    }

    public void setQmkc(Integer qmkc) {
        this.qmkc = qmkc;
    }

    public String getZbh() {
        return zbh;
    }

    public void setZbh(String zbh) {
        this.zbh = zbh;
    }

    public String getYc() {
        return yc;
    }

    public void setYc(String yc) {
        this.yc = yc;
    }

    public Integer getTerm1() {
        return term1;
    }

    public void setTerm1(Integer term1) {
        this.term1 = term1;
    }

    public Integer getTerm2() {
        return term2;
    }

    public void setTerm2(Integer term2) {
        this.term2 = term2;
    }

    public Integer getTerm3() {
        return term3;
    }

    public void setTerm3(Integer term3) {
        this.term3 = term3;
    }

    public Integer getTerm4() {
        return term4;
    }

    public void setTerm4(Integer term4) {
        this.term4 = term4;
    }

    public Integer getTerm5() {
        return term5;
    }

    public void setTerm5(Integer term5) {
        this.term5 = term5;
    }

    public Integer getTerm6() {
        return term6;
    }

    public void setTerm6(Integer term6) {
        this.term6 = term6;
    }

    public Integer getTerm7() {
        return term7;
    }

    public void setTerm7(Integer term7) {
        this.term7 = term7;
    }
}
