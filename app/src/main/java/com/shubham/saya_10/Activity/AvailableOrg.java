package com.shubham.saya_10.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.shubham.saya_10.R;

public class AvailableOrg extends AppCompatActivity implements View.OnClickListener{

    public static Context context;
    Button miraj_bt,jaysing_bt,ichal_bt,kop_bt;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_org);
        miraj_bt=(Button)findViewById(R.id.miraj);
        jaysing_bt=(Button)findViewById(R.id.jaysing);
        ichal_bt=(Button)findViewById(R.id.ichal);
        kop_bt=(Button)findViewById(R.id.kop);
        context=this;
        miraj_bt.setOnClickListener(this);
        jaysing_bt.setOnClickListener(this);
        ichal_bt.setOnClickListener(this);
        kop_bt.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {

        if(view.getId()==R.id.miraj)
        {
            Intent i=new Intent(this.getApplicationContext(),Contact.class);
            startActivity(i);
        }
        else if(view.getId()==R.id.jaysing)
        {
            Intent i1=new Intent(this.getApplicationContext(),contact2.class);
            startActivity(i1);
        }
        else if(view.getId()==R.id.ichal)
        {
            Intent i2=new Intent(this.getApplicationContext(),contact3.class);
            startActivity(i2);
        }
        else if(view.getId()==R.id.kop)
        {
            Intent i3=new Intent(this.getApplicationContext(),contact4.class);
            startActivity(i3);
        }
    }
}
