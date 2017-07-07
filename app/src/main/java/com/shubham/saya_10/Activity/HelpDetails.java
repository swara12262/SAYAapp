package com.shubham.saya_10.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.shubham.saya_10.R;

public class HelpDetails extends AppCompatActivity implements View.OnClickListener
{

    public static Object context;
    public static Button agree_bt,disagree_bt;
    TextView usernm_txt,title_txt,content_txt,date_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_details);


        usernm_txt=(TextView)findViewById(R.id.help_username_txt);
        title_txt=(TextView)findViewById(R.id.help_title_txt);
        content_txt=(TextView)findViewById(R.id.help_content_txt);
        date_txt=(TextView)findViewById(R.id.help_date_txt);

        agree_bt=(Button)findViewById(R.id.agree_button);
        disagree_bt=(Button)findViewById(R.id.disagree_button);

        agree_bt.setOnClickListener(this);
        disagree_bt.setOnClickListener(this);

/*
            usernm_txt.setText(usernm_txt.getText().toString()+""+BackgroundTask.help_username[AdminHomePage.index]);
            title_txt.setText(title_txt.getText().toString()+""+BackgroundTask.help_title[AdminHomePage.index]);
            content_txt.setText(content_txt.getText().toString()+""+BackgroundTask.help_content[AdminHomePage.index]);
            date_txt.setText(date_txt.getText().toString()+""+BackgroundTask.help_date[AdminHomePage.index]);
*/
        usernm_txt.setText(BackgroundTask.help_username[AdminHomePage.index].substring(0,1).toUpperCase()+BackgroundTask.help_username[AdminHomePage.index].substring(1));
        title_txt.setText(BackgroundTask.help_title[AdminHomePage.index]);
        content_txt.setText(BackgroundTask.help_content[AdminHomePage.index]);
        date_txt.setText(BackgroundTask.help_date[AdminHomePage.index]);
    }

    @Override
    public void onClick(View view)
    {
        String reply_orgnm=BackgroundTask.orgusernm;
        String reply_usrnm=BackgroundTask.help_username[AdminHomePage.index];
        String reply_date=BackgroundTask.help_date[AdminHomePage.index];

        String method="AgreeReply";
        BackgroundTask backgroundTask=new BackgroundTask(this);
        if(view.getId()==R.id.agree_button)
        {
         //   Toast.makeText(this,reply_date+"*****************",Toast.LENGTH_SHORT).show();
            backgroundTask.execute(method,reply_orgnm,reply_usrnm,"1",reply_date);

        }
        else if(view.getId()==R.id.disagree_button)
        {
           // Toast.makeText(this,reply_date+"*****************",Toast.LENGTH_SHORT).show();

            backgroundTask.execute(method,reply_orgnm,reply_usrnm,"0",reply_date);

        }


    }
}
