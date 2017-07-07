package com.shubham.saya_10.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.shubham.saya_10.R;

import java.util.LinkedList;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {

     EditText user_ed,pass_ed;
    public static  String user_name,password;
    Button sign_up;
    Spinner select_sp;
    String tp;
    public static String orgusernm_str;
    TextView invalid_usnm,invalid_pass;
    public static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        context=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
      /*  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
*/
        user_ed= (EditText) findViewById(R.id.username_log);
        pass_ed= (EditText) findViewById(R.id.password_log);
        sign_up=(Button)findViewById(R.id.signup);
        sign_up.setOnClickListener((View.OnClickListener) this);
        select_sp=(Spinner)findViewById(R.id.select);

        invalid_pass=(TextView)findViewById(R.id.invalid_logpass);
        invalid_usnm=(TextView)findViewById(R.id.invalid_logusnm);

        select_sp.setOnItemSelectedListener(this);

        LinkedList list=new LinkedList();
        list.add("User");
        list.add("Admin");
        ArrayAdapter dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        select_sp.setAdapter(dataAdapter);

    }
    public void onClick(View view) {
        if (view.getId() == R.id.signup)
        {
            Intent i = new Intent(this.getApplicationContext(), CreateAccount.class);
            startActivity(i);
        }
    }
    public void login(View view)
    {
        user_name=user_ed.getText().toString();
        password=pass_ed.getText().toString();

        invalid_usnm.setText("");
        invalid_pass.setText("");

        if(user_name.isEmpty())
            invalid_usnm.setText("Invalid username");
        else if(!user_name.isEmpty())
        {
            invalid_usnm.setText("");
            if (password.isEmpty())
            {
                invalid_pass.setText("Invalid password");
            }
            else
            {
                invalid_pass.setText("");

                BackgroundTask backgroundTask = new BackgroundTask(this);
                String method = "login";
                backgroundTask.execute(method, user_name, password, tp);

            }
        }





    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {


        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.loginaboutus, menu);
        invalidateOptionsMenu();



        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {

            case R.id.aboutuslogin_menu:
            {


                startActivity(new Intent(getApplicationContext(),AboutUs.class));
//                finish();
            }
            break;



        }
        return super.onOptionsItemSelected(menuItem);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
     //   AdapterView parent;
        tp=parent.getItemAtPosition(position).toString();
     /*   Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + tp,
                Toast.LENGTH_SHORT).show();*/

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
