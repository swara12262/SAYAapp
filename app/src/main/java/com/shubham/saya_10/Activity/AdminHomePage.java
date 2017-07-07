package com.shubham.saya_10.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.shubham.saya_10.R;

public class AdminHomePage extends AppCompatActivity implements AdapterView.OnItemClickListener
{

    public static int index;
    public static ListView listView;
    public static String orgusernm;
    @Override


    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);

        listView=(ListView)findViewById(R.id.lst);


        listView.setOnItemClickListener(this);
        String method="helpstatus1";
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(method);

    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

        index=position;
        startActivity(new Intent(getApplicationContext(),HelpDetails.class));
        String username_buttoncheck=BackgroundTask.help_username[index];
        String date_buttoncheck=BackgroundTask.help_date[index];
        String method="ButtonCheck";
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(method,username_buttoncheck,date_buttoncheck);
    }
}
