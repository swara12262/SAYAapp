package com.shubham.saya_10.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.shubham.saya_10.R;

public class UserHomePage extends AppCompatActivity implements View.OnClickListener{

    Button search_bt,help_bt,reply_bt,write_blg,read_blg;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);

        search_bt=(Button)findViewById(R.id.search);
        help_bt=(Button)findViewById(R.id.help);
        reply_bt=(Button)findViewById(R.id.replymsg_bt);
        read_blg=(Button)findViewById(R.id.blg_read);

        search_bt.setOnClickListener(this);
        help_bt.setOnClickListener(this);
        reply_bt.setOnClickListener(this);
        write_blg=(Button)findViewById(R.id.blg_write);
        write_blg.setOnClickListener(this);
        read_blg.setOnClickListener(this);


    }

    @Override
    public void onClick(View view)
    {
        if(view.getId()==R.id.search)
        {
            Intent i=new Intent(this.getApplicationContext(),AvailableOrg.class);
            startActivity(i);

        }
        else if(view.getId()==R.id.help)
        {
            Intent i=new Intent(this.getApplicationContext(),HelpOrg.class);
            startActivity(i);
         //   finish();
        }
        else if(view.getId()==R.id.replymsg_bt)
        {
            Intent i=new Intent(this.getApplicationContext(),UserReply.class);
            startActivity(i);

        }
        else if(view.getId()==R.id.blg_write)
        {
            Intent i=new Intent(this.getApplicationContext(),blog.class);
            startActivity(i);
        }
        else if(view.getId()==R.id.blg_read)
        {
            Intent i=new Intent(this.getApplicationContext(),BlogList.class);
            startActivity(i);
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.userhome_menu, menu);
        invalidateOptionsMenu();

       // Intent i =new Intent(getApplicationContext(),LoginActivity.class);
        //startActivity(i);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {

            case R.id.action_signout:
            {


                SharedPreferences sharedPreferences=getSharedPreferences("user_data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                //Toast.makeText(ctx,username+password+type,Toast.LENGTH_LONG).show();
                editor.putString("username","N/A");
                editor.putString("password","N/A");
                editor.putString("type","N/A");
                editor.commit();

                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();
            }
            break;

            case R.id.aboutususer_menu:
            {


                startActivity(new Intent(getApplicationContext(),AboutUs.class));
               // finish();
            }
            break;



        }
        return super.onOptionsItemSelected(menuItem);
    }
  /*  public void signout(View view)
    {

        SharedPreferences sharedPreferences=getSharedPreferences("user_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
    //    Toast.makeText(ctx,username+password+type,Toast.LENGTH_LONG).show();
        editor.putString("username","N/A");
        editor.putString("password","N/A");
        editor.putString("type","N/A");
        editor.commit();
    }*/
}
