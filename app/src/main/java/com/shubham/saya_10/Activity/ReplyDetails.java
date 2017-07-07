package com.shubham.saya_10.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.shubham.saya_10.R;

public class ReplyDetails extends AppCompatActivity {

    TextView replyorgnm,replymsg,replytitle,replycontent,replydate;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_details);
        replyorgnm=(TextView)findViewById(R.id.replyorgnm_txt);
        replymsg=(TextView)findViewById(R.id.replymsg_txt);
        replytitle=(TextView)findViewById(R.id.replytitle_txt);
        replycontent=(TextView)findViewById(R.id.replycontent_txt);
        replydate=(TextView)findViewById(R.id.replydate_txt);

        replyorgnm.setText(replyorgnm.getText().toString()+""+BackgroundTask.replyorgnm[UserReply.reply_index]);
        replymsg.setText(replymsg.getText().toString()+""+BackgroundTask.replyagreemsg[UserReply.reply_index]);
        replytitle.setText(replytitle.getText().toString()+""+BackgroundTask.replytitle[UserReply.reply_index]);
        replycontent.setText(replycontent.getText().toString()+""+BackgroundTask.replycontent[UserReply.reply_index]);
        replydate.setText(replydate.getText().toString()+""+BackgroundTask.replydate[UserReply.reply_index]);


    }
}
