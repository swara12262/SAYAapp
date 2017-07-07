package com.shubham.saya_10.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.shubham.saya_10.R;

import java.util.List;

public class BlogList extends AppCompatActivity implements AdapterView.OnItemClickListener
{

    public static int index_blg;
    public static ListView bloglist_lst;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_list);


        bloglist_lst=(ListView)findViewById(R.id.bloglist_listview);
        bloglist_lst.setOnItemClickListener(this);

        String method="bloglist";
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(method);
    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

        index_blg=position;
        startActivity(new Intent(getApplicationContext(),ReadBlog.class));
    }
}
