package com.example.geek.mvp.model.entity;

/**
 * Created by geek on 2015/7/29.
 */
public class WeatherInfo {
    private String SD;
    private String isRadar;
    private String time;
    private String WSE;
    private String WS;
    private String WD;
    private String njd;
    private String qy;
    private String Radar;
    private String temp;
    private String cityid;
    private String city;

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "SD='" + SD + '\'' +
                ", isRadar='" + isRadar + '\'' +
                ", time='" + time + '\'' +
                ", WSE='" + WSE + '\'' +
                ", WS='" + WS + '\'' +
                ", WD='" + WD + '\'' +
                ", njd='" + njd + '\'' +
                ", qy='" + qy + '\'' +
                ", Radar='" + Radar + '\'' +
                ", temp='" + temp + '\'' +
                ", cityid='" + cityid + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getSD() {
        return SD;
    }

    public void setSD(String SD) {
        this.SD = SD;
    }

    public String getIsRadar() {
        return isRadar;
    }

    public void setIsRadar(String isRadar) {
        this.isRadar = isRadar;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWSE() {
        return WSE;
    }

    public void setWSE(String WSE) {
        this.WSE = WSE;
    }

    public String getWS() {
        return WS;
    }

    public void setWS(String WS) {
        this.WS = WS;
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

    public String getNjd() {
        return njd;
    }

    public void setNjd(String njd) {
        this.njd = njd;
    }

    public String getQy() {
        return qy;
    }

    public void setQy(String qy) {
        this.qy = qy;
    }

    public String getRadar() {
        return Radar;
    }

    public void setRadar(String radar) {
        Radar = radar;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
