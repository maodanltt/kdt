package com.tywh.kdt.api.pojo;

public class SenderInfo {

    private String name;

    private String mobile;

    private String province;

    private String city;

    private String detailAddress;

    public SenderInfo() {
    }

    public SenderInfo(String name, String mobile, String province, String city, String detailAddress) {
        this.name = name;
        this.mobile = mobile;
        this.province = province;
        this.city = city;
        this.detailAddress = detailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
}
