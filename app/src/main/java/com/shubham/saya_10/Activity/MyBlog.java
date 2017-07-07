package com.shubham.saya_10.Activity;

/**
 * Created by swara on 5/11/16.
 */
public class MyBlog {
    private String title_blg;
    private String author_blg;
    private String date_blg;
    public String getTitle_blg() {
        return title_blg;
    }

    public void setTitle_blg(String title_blg) {
        this.title_blg = title_blg;
    }

    public String getAuthor_blg() {
        return author_blg;
    }

    public void setAuthor_blg(String author_blg) {
        this.author_blg = author_blg;
    }

    public String getDate_blg() {
        return date_blg;
    }

    public void setDate_blg(String date_blg) {
        this.date_blg = date_blg;
    }
    MyBlog(String title_blg,String author_blg,String date_blg)
    {
        setAuthor_blg(author_blg);
        setDate_blg(date_blg);
        setTitle_blg(title_blg);

    }



}
