package com.shubham.saya_10.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shubham.saya_10.R;

import org.w3c.dom.Text;

public class CreateAccount extends AppCompatActivity
{

    EditText first_ed,last_ed,user_ed,email_ed,pass_ed,confirmpass_ed;
    String first,last,username,email,password,confirm;
    public static Context context;
    TextView invalid_fsnm,invalid_lsnm,invalid_usernm,invalid_email,invalid_pass,invalid_conf;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        context=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        first_ed= (EditText) findViewById(R.id.first);
        last_ed= (EditText) findViewById(R.id.last);
        user_ed= (EditText) findViewById(R.id.username);
        email_ed= (EditText) findViewById(R.id.email);
        pass_ed= (EditText) findViewById(R.id.password);
        confirmpass_ed= (EditText) findViewById(R.id.confirm_pass);


        invalid_fsnm = (TextView)findViewById (R.id.invalid_fsnm);
        invalid_lsnm = (TextView)findViewById(R.id.invalid_lsnm);
        invalid_usernm=(TextView)findViewById(R.id.invalid_usnm);
        invalid_email=(TextView)findViewById(R.id.invalid_email);
        invalid_pass=(TextView)findViewById(R.id.invalid_pass);
        invalid_conf=(TextView)findViewById(R.id.invalid_confpass);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_account, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void signup(View view)
    {
        int flg=0;

        invalid_fsnm.setText("");
        invalid_lsnm.setText("");
        invalid_email.setText("");
        invalid_pass.setText("");
        invalid_usernm.setText("");
        invalid_conf.setText("");

        first=first_ed.getText().toString();
        last=last_ed.getText().toString();
        username=user_ed.getText().toString();
        email=email_ed.getText().toString();
        password=pass_ed.getText().toString();
        confirm=confirmpass_ed.getText().toString();

        if(first.isEmpty())
            invalid_fsnm.setText("Invalid firstname");
        else if(!first.isEmpty())
        {
            invalid_fsnm.setText("");
            if(last.isEmpty())
                invalid_lsnm.setText("Invalid lastname");
            else if(!last.isEmpty())
            {
                invalid_lsnm.setText("");
                if(username.isEmpty())
                    invalid_usernm.setText("Invalid username");
                else if(!username.isEmpty())
                {
                    invalid_usernm.setText("");
                    if(email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
                        invalid_email.setText("Invalid email");
                    else
                    {
                        invalid_email.setText("");
                        if(password.isEmpty())
                            invalid_pass.setText("Invalid Password");
                        else
                        {
                            invalid_pass.setText("");
                            if(!password.equals(confirm))
                            {
                                Toast.makeText(getApplicationContext(),"Password doesn't match...Please retype",Toast.LENGTH_SHORT).show();
                                pass_ed.setText("");
                                confirmpass_ed.setText("");
                            }
                            else
                            {
                                BackgroundTask backgroundTask = new BackgroundTask(this);
                                String method = "signup";
                                backgroundTask.execute(method, first, last, username, email, password);


                            }
                        }
                    }

                }

            }

        }





    }
}
