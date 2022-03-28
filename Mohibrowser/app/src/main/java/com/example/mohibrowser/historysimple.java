package com.example.mohibrowser;

public class historysimple {

    private int Id;
    private String historyname;

    public historysimple(int id, String historyname) {
        Id = id;
        this.historyname = historyname;
    }

    public historysimple() {
    }

    @Override
    public String toString() {
        return "historysimple{" +
                "Id=" + Id +
                ", historyname='" + historyname + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getHistoryname() {
        return historyname;
    }

    public void setHistoryname(String historyname) {
        this.historyname = historyname;
    }
}
