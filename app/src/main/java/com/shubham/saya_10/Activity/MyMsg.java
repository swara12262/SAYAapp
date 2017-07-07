package com.shubham.saya_10.Activity;

/**
 * Created by swara on 5/11/16.
 */
public class MyMsg {
    private String nm_org;
    private String date_org;

    public String getDate_org() {
        return date_org;
    }

    public void setDate_org(String date_org) {
        this.date_org = date_org;
    }

    public String getNm_org() {
        return nm_org;
    }

    public void setNm_org(String nm_org) {
        this.nm_org = nm_org;
    }

    public MyMsg(String nm_org, String date_org) {
        this.nm_org = nm_org;
        this.date_org = date_org;
    }
}
