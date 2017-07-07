package com.shubham.saya_10.Activity;

/**
 * Created by swara on 5/11/16.
 */
public class MyAdminMessage {
    private String msg_usernm;
    private String msg_date;

    public String getMsg_usernm() {
        return msg_usernm;
    }

    public void setMsg_usernm(String msg_usernm) {
        this.msg_usernm = msg_usernm;
    }

    public String getMsg_date() {
        return msg_date;
    }

    public void setMsg_date(String msg_date) {
        this.msg_date = msg_date;
    }
    MyAdminMessage(String msg_usernm,String msg_date)
    {
        setMsg_usernm(msg_usernm);
        setMsg_date(msg_date);

    }
}
