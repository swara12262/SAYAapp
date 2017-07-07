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
import android.widget.TextView;

import com.shubham.saya_10.R;

public class AdminDetails extends AppCompatActivity implements View.OnClickListener
{
    Button admindetails;
    TextView admindetalorg_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_details);
        admindetalorg_txt=(TextView)findViewById(R.id.admindetalorg_txt);
        admindetalorg_txt.setText(LoginActivity.user_name+"!!!");


        admindetails=(Button)findViewById(R.id.admindetails_bt);
        admindetails.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {


        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.admindetail_menu, menu);
        invalidateOptionsMenu();



        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {

            case R.id.signout_admin://onclick of sinout menu following action get performed 
            {


                SharedPreferences sharedPreferences=getSharedPreferences("user_data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                editor.putString("username","N/A");
                editor.putString("password","N/A");
                editor.putString("type","N/A");
                editor.commit();

                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();
            }

            break;
            case R.id.aboutusadmin_menu:
            {


                startActivity(new Intent(getApplicationContext(),AboutUs.class));
                //finish();
            }
            break;



        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onClick(View view)
    {

        if(view.getId()==R.id.admindetails_bt)
        {
            Intent i =new Intent(getApplicationContext(),AdminHomePage.class);
            startActivity(i);
        }
    }
   /* public void signout(View view)
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
