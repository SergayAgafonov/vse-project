package com.example.jkhdiplom;

public class DBtableOtop {
    private Integer OtopID;
    private String OtopRes;
    private String OtopTar;
    private String OtopNorm;
    private String OtopResP;

    public DBtableOtop(Integer OtopID, String OtopRes, String OtopTar, String OtopNorm, String OtopResP) {
        this.OtopID = OtopID;
        this.OtopRes = OtopRes;
        this.OtopTar = OtopTar;
        this.OtopNorm = OtopNorm;
        this.OtopResP = OtopResP;
    }
    public DBtableOtop() {

    }

    public Integer getOtopID() {
        return OtopID;
    }

    public void setOtopID(Integer OtopID) {
        this.OtopID = OtopID;
    }

    public String getOtopRes() {
        return OtopRes;
    }

    public void setOtopRes(String OtopRes) {
        this.OtopRes = OtopRes;
    }

    public String getOtopTar() {
        return OtopTar;
    }

    public void setOtopTar(String OtopTar) {
        this.OtopTar = OtopTar;
    }

    public String getOtopNorm() {
        return OtopNorm;
    }

    public void setOtopNorm(String OtopNorm) {
        this.OtopNorm = OtopNorm;
    }

    public String getOtopResP() {
        return OtopResP;
    }

    public void setOtopResP(String OtopResP) {
        this.OtopResP = OtopResP;
    }
}
