package com.example.jkhdiplom;

public class DBtable {
    private Integer CodeID;
    private String TbNews;
    private String TbDate;

    public DBtable(Integer CodeID, String TbNews, String TbDate) {
        this.CodeID = CodeID;
        this.TbNews = TbNews;
        this.TbDate = TbDate;

    }
    public DBtable() {
    }

    public Integer getIDCode() {
        return CodeID;
    }

    public Integer getCodeID() {
        return CodeID;
    }

    public void setCodeID(Integer CodeID) {
        this.CodeID = CodeID;
    }

    public String getTbNews() {
        return TbNews;
    }

    public void setTbNews(String TbNews) {
        this.TbNews = TbNews;
    }

    public String getTbDate() {
        return TbDate;
    }

    public void setTbDate(String TbDate) {
        this.TbDate = TbDate;
    }
}
