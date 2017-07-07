package com.shubham.saya_10.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shubham.saya_10.R;

public class blog extends AppCompatActivity implements OnClickListener
{

    public static Object context;
    String blog_title,blog_content;
    protected static EditText blog_title_ed,blog_content_ed;
    Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        blog_title_ed=(EditText) findViewById(R.id.blog_title_txt);
        blog_content_ed=(EditText) findViewById(R.id.blog_txt);
        done=(Button)findViewById(R.id.done_button);
        done.setOnClickListener((OnClickListener)this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.done_button)
        {
            blog_title=blog_title_ed.getText().toString();
            blog_content=blog_content_ed.getText().toString();
            if(blog_title.isEmpty())
                Toast.makeText(blog.this, "Please enter Title...", Toast.LENGTH_SHORT).show();
            else if(!blog_title.isEmpty())
            {
               // blog_title_ed.setText("");
                if(blog_content.isEmpty())
                    Toast.makeText(blog.this,"Please write content...",Toast.LENGTH_SHORT).show();
                else
                {
                 //   blog_content_ed.setText("");
                    BackgroundTask backgroundTask = new BackgroundTask(this);
                    String method = "write_blog";
                    backgroundTask.execute(method,LoginActivity.user_name,blog_title,blog_content);
                }

            }


        }
    }
}