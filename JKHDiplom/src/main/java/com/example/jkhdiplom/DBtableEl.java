package com.example.jkhdiplom;

public class DBtableEl {
    private Integer ElectID;
    private String ElectRes;
    private String ElectTar;
    private String ElectNorm;
    private String ElectResP;

    public DBtableEl(Integer ElectID, String ElectRes, String ElectTar, String ElectNorm, String ElectResP) {
        this.ElectID = ElectID;
        this.ElectRes = ElectRes;
        this.ElectTar = ElectTar;
        this.ElectNorm = ElectNorm;
        this.ElectResP = ElectResP;
    }
    public DBtableEl() {

    }

    public Integer getElectID() {
        return ElectID;
    }

    public void setElectID(Integer ElectID) {
        this.ElectID = ElectID;
    }

    public String getElectRes() {
        return ElectRes;
    }

    public void setElectRes(String ElectRes) {
        this.ElectRes = ElectRes;
    }

    public String getElectTar() {
        return ElectTar;
    }

    public void setElectTar(String ElectTar) {
        this.ElectTar = ElectTar;
    }

    public String getElectNorm() {
        return ElectNorm;
    }

    public void setElectNorm(String ElectNorm) {
        this.ElectNorm = ElectNorm;
    }

    public String getElectResP() {
        return ElectResP;
    }

    public void setElectResPP(String ElectResP) {
        this.ElectResP = ElectResP;
    }
}
