package com.example.jkhdiplom;

public class DBtableUsl {
    private Integer UsID;
    private String Usluga;
    private String Price;

    public DBtableUsl(Integer UsID, String Usluga, String Price) {
        this.UsID = UsID;
        this.Usluga = Usluga;
        this.Price = Price;

    }
    public DBtableUsl() {

    }
    public Integer getIDUs() {
        return UsID;
    }

    public Integer getUsID() {
        return UsID;
    }

    public void setUsID(Integer UsID) {
        this.UsID = UsID;
    }

    public String getUsluga() {
        return Usluga;
    }

    public void setUsluga(String Usluga) {
        this.Usluga = Usluga;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {this.Price = Price;}
}
