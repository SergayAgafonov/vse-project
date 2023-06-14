package com.example.jkhdiplom;

public class DBtableGor {
    private Integer GorID;
    private String GorRes;
    private String GorTar;
    private String GorNorm;
    private String GorResP;

    public DBtableGor(Integer GorID, String GorRes, String GorTar, String GorNorm, String GorResP) {
        this.GorID = GorID;
        this.GorRes = GorRes;
        this.GorTar = GorTar;
        this.GorNorm = GorNorm;
        this.GorResP = GorResP;
    }
    public DBtableGor() {

    }

    public Integer getGorID() {
        return GorID;
    }

    public void setGorID(Integer GorID) {
        this.GorID = GorID;
    }

    public String getGorRes() {
        return GorRes;
    }

    public void setGorRes(String GorRes) {
        this.GorRes = GorRes;
    }

    public String getGorTar() {
        return GorTar;
    }

    public void setGorTar(String GorTar) {
        this.GorTar = GorTar;
    }

    public String getGorNorm() {
        return GorNorm;
    }

    public void setGorNorm(String GorNorm) {
        this.GorNorm = GorNorm;
    }

    public String getGorResP() {
        return GorResP;
    }

    public void setGorResP(String GorResP) {
        this.GorResP = GorResP;
    }
}