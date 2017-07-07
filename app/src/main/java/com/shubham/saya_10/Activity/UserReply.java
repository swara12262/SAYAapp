package com.shubham.saya_10.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.shubham.saya_10.R;

public class UserReply extends AppCompatActivity implements AdapterView.OnItemClickListener

{
    public static ListView userply_listView;//Listview to represent user messages
    public static int reply_index;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_reply);
        userply_listView=(ListView)findViewById(R.id.usereply_listview);

        userply_listView.setOnItemClickListener(this);

        String method="ReplyList";
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(method,LoginActivity.user_name);

    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

        reply_index=position;
        startActivity(new Intent(getApplicationContext(),ReplyDetails.class));
    }
}
