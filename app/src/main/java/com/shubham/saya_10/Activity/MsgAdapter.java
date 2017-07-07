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
public class MsgAdapter extends ArrayAdapter {
    private LinkedList<MyMsg> singleitem;

    public MsgAdapter(Context context, LinkedList<MyMsg> msg) {
        super(context,R.layout.single_msg,msg);
        this.singleitem = msg;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater list_inflater=LayoutInflater.from(getContext());
        View coustemview = list_inflater.inflate(R.layout.single_msg,parent,false);


        TextView nmorg_txt=(TextView) coustemview.findViewById(R.id.nmorg_txt);
        TextView dateorg_txt =(TextView) coustemview.findViewById(R.id.dateorg_txt);


        nmorg_txt.setText(singleitem.get(position).getNm_org().toUpperCase()+"Oraganisation");

        dateorg_txt.setText(singleitem.get(position).getDate_org().substring(0,10));
        return coustemview;

    }
}
