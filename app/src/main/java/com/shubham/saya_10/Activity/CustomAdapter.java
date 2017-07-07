package com.shubham.saya_10.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.shubham.saya_10.R;

import org.w3c.dom.Text;

import java.util.LinkedList;

/**
 * Created by swara on 5/11/16.
 */
public class CustomAdapter extends ArrayAdapter
{
    private LinkedList <MyBlog> singleitem;
    public CustomAdapter(Context context, LinkedList<MyBlog> list)
    {

        super(context, R.layout.activity_blog_coustem,list);
        singleitem=list;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater list_inflater=LayoutInflater.from(getContext());
        View coustemview = list_inflater.inflate(R.layout.activity_blog_coustem,parent,false);


        TextView blogtitlecstm_txt=(TextView) coustemview.findViewById(R.id.blogtitlecstm_txt);
        TextView blogdatecstm_txt =(TextView) coustemview.findViewById(R.id.blogdatecstm_txt);
        TextView blogauthorcstm_txt=(TextView) coustemview.findViewById(R.id.blogauthercstm_txt);

        blogtitlecstm_txt.setText(singleitem.get(position).getTitle_blg());
        blogauthorcstm_txt.setText("By "+singleitem.get(position).getAuthor_blg());
        blogdatecstm_txt.setText(singleitem.get(position).getDate_blg().substring(0,10));
        return coustemview;


    }
}
