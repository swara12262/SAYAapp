package com.shubham.saya_10.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shubham.saya_10.R;

public class KopOrg extends AppCompatActivity implements View.OnClickListener{

    Button send_bt;
    public  static Context ctx;
    public static CheckBox cloth_cb,food_cb,study_cb,volunteer_cb,oragnise_cb,other_cb;
    String helptitle_str,helpcontent_str;
    String username_str;
    public static EditText helpcontent_edt;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kop_org);
        cloth_cb=(CheckBox)findViewById(R.id.k_cloth);
        food_cb= (CheckBox) findViewById(R.id.k_food);
        study_cb= (CheckBox) findViewById(R.id.k_studymaterial);
        volunteer_cb= (CheckBox) findViewById(R.id.k_volunteer);
        oragnise_cb= (CheckBox) findViewById(R.id.k_orgnise);
        other_cb= (CheckBox) findViewById(R.id.k_other);
        helpcontent_edt=(EditText)findViewById(R.id.k_helpcontent_edtxt);
        cloth_cb.setOnClickListener(this);
        food_cb.setOnClickListener(this);
        study_cb.setOnClickListener(this);
        volunteer_cb.setOnClickListener(this);
        oragnise_cb.setOnClickListener(this);
        other_cb.setOnClickListener(this);
        ctx=this;
        send_bt=(Button)findViewById(R.id.k_sendmessage_button);
        send_bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.k_sendmessage_button)
        {
            helptitle_str="";
            if(cloth_cb.isChecked())
            {
                helptitle_str+="Cloth , ";

            }
            if(food_cb.isChecked())
            {
                helptitle_str+="Food , ";
            }
            if (study_cb.isChecked())
            {
                helptitle_str+="Study Material , ";
            }
            if(volunteer_cb.isChecked())
            {
                helptitle_str+="Volunteer in their event , ";
            }
            if(oragnise_cb.isChecked())
            {
                helptitle_str+="Oraganise an event , ";
            }

            if(other_cb.isChecked())
            {
                helptitle_str+="Other ";
            }
            helpcontent_str="";
//            Toast.makeText(this.getApplicationContext(),helptitle_str,Toast.LENGTH_SHORT).show();
            helpcontent_str= helpcontent_edt.getText().toString();
          //  Toast.makeText(this.getApplicationContext(),helpcontent_str,Toast.LENGTH_SHORT).show();
            username_str=LoginActivity.user_name;
            //Toast.makeText(this.getApplicationContext(),username_str,Toast.LENGTH_SHORT).show();

            BackgroundTask backgroundTask=new BackgroundTask(this);
            String method="helptable_add";
            backgroundTask.execute(method,username_str,helptitle_str,helpcontent_str,"newhope");

        }
    }
}
