package com.example.mohibrowser;

public class bkmarksimple {

    private int id;
    private String urlname;

    public bkmarksimple(int id, String urlname) {
        this.id = id;
        this.urlname = urlname;
    }

    public bkmarksimple(String urlname) {
        this.urlname = urlname;
    }

    public bkmarksimple() {
    }

    @Override
    public String toString() {
        return "bkmarksimple{" +
                "id=" + id +
                ", urlname='" + urlname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlname() {
        return urlname;
    }

    public void setUrlname(String urlname) {
        this.urlname = urlname;
    }
}
