package com.shubham.saya_10.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.shubham.saya_10.R;

import java.util.LinkedList;

/**
 * Created by swara on 5/11/16.
 */
public class AdminMsgAdapter extends ArrayAdapter {
    private LinkedList<MyAdminMessage> singleitem;
    public AdminMsgAdapter(Context context, LinkedList<MyAdminMessage>list)
    {

        super(context, R.layout.activity_admin_message_custom,list);
        singleitem=list;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater list_inflater=LayoutInflater.from(getContext());
        View coustemview = list_inflater.inflate(R.layout.activity_admin_message_custom,parent,false);


        TextView admincustomusernm_txt=(TextView) coustemview.findViewById(R.id.admincustomusernm_txt);
        TextView admincustomdate_txt =(TextView) coustemview.findViewById(R.id.admincustomdate_txt);


        admincustomusernm_txt.setText("Helper Name : "+singleitem.get(position).getMsg_usernm().toUpperCase());

        admincustomdate_txt.setText(singleitem.get(position).getMsg_date().substring(0,10));
        return coustemview;

    }
}
