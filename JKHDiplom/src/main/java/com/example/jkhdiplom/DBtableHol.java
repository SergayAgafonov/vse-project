package com.example.jkhdiplom;

public class DBtableHol {
    private Integer HolID;
    private String HolRes;
    private String HolTar;
    private String HolNorm;
    private String HolResP;

    public DBtableHol(Integer HolID, String HolRes, String HolTar, String HolNorm, String HolResP) {
        this.HolID = HolID;
        this.HolRes = HolRes;
        this.HolTar = HolTar;
        this.HolNorm = HolNorm;
        this.HolResP = HolResP;
    }
    public DBtableHol() {

    }

    public Integer getHolID() {
        return HolID;
    }

    public void setHolID(Integer HolID) {
        this.HolID = HolID;
    }

    public String getHolRes() {
        return HolRes;
    }

    public void setHolRes(String HolRes) {
        this.HolRes = HolRes;
    }

    public String getHolTar() {
        return HolTar;
    }

    public void setHolTar(String HolTar) {
        this.HolTar = HolTar;
    }

    public String getHolNorm() {
        return HolNorm;
    }

    public void setHolNorm(String HolNorm) {
        this.HolNorm = HolNorm;
    }

    public String getHolResP() {
        return HolResP;
    }

    public void setHolResP(String HolResP) {
        this.HolResP = HolResP;
    }
}
