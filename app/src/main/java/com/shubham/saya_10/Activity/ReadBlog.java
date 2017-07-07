package com.shubham.saya_10.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.shubham.saya_10.R;

public class ReadBlog extends AppCompatActivity {

    TextView blg_usernm,blg_title,blg_content,blg_date;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_blog);
        blg_usernm=(TextView)findViewById(R.id.readblg_usernm);
        blg_title=(TextView)findViewById(R.id.readblg_title);
        blg_content=(TextView)findViewById(R.id.readblg_content);
        blg_date=(TextView)findViewById(R.id.readblg_date);

        blg_usernm.setText(blg_usernm.getText().toString()+""+BackgroundTask.blog_username[BlogList.index_blg]);
        blg_date.setText(blg_date.getText().toString()+""+BackgroundTask.blog_date[BlogList.index_blg]);
        blg_title.setText(BackgroundTask.blog_title[BlogList.index_blg]);
        blg_content.setText(BackgroundTask.blog_content[BlogList.index_blg]);
    }
}
