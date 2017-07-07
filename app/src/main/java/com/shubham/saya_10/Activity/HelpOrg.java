package com.shubham.saya_10.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shubham.saya_10.R;

public class HelpOrg extends AppCompatActivity implements View.OnClickListener{

    Button miraj_bt,ichal_bt,jaysing_bt,kop_bt;
    public static Context context;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_org);
        miraj_bt=(Button)findViewById(R.id.mirajhelp);
        ichal_bt=(Button)findViewById(R.id.ichalhelp);
        jaysing_bt=(Button)findViewById(R.id.jaysinghelp);
        kop_bt=(Button)findViewById(R.id.kophelp);
context=this;
        miraj_bt.setOnClickListener(this);
        ichal_bt.setOnClickListener(this);
        jaysing_bt.setOnClickListener(this);
        kop_bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId()==R.id.mirajhelp)
        {
            Intent i=new Intent(this.getApplicationContext(),MirajOrg.class);
            startActivity(i);
           finish();
        }
        else if(view.getId()==R.id.ichalhelp)
        {
            Intent i=new Intent(this.getApplicationContext(),IchalOrg.class);
            startActivity(i);
            finish();
        }
        else if(view.getId()==R.id.jaysinghelp)
        {
            Intent i=new Intent(this.getApplicationContext(),JaysingOrg.class);
            startActivity(i);
            finish();
        }
        else if(view.getId()==R.id.kophelp)
        {
            Intent i=new Intent(this.getApplicationContext(),KopOrg.class);
            startActivity(i);
            finish();
        }

    }
}
