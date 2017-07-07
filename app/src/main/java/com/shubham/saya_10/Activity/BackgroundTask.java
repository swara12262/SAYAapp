package com.shubham.saya_10.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.design.widget.CoordinatorLayout;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.shubham.saya_10.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Inspiron on 02-04-2016.
 */


public class BackgroundTask extends AsyncTask<String, Void, String>//abstart class 
{
    //  AlertDialog alertDialog;
    public String email, password, username,first,last, method,type;
    public String helpusernm_str,helptitle_str,helpcontent_str,oragusernm_str,replyorgnm_str,replyusernm_str,replyagree_str,replydate_str;
    Context ctx;
    public static String orgusernm="",allhelp;
    private CoordinatorLayout coordinatorLayout;
    public static String []allhelp1;
    public static String []allhelp0;
    public static String []help_username;
    public static String []help_title;
    public static String []help_content;
    public static String []help_date;
    public static String blg_title,blg_content,blg_username;
    public static String[] blog_username;
    public static String []blog_title;
    public static String[] blog_content;
    public static String []blog_date;
    public static String []allblogs;
    public static String replylist_user;
    public static String []replytitle;
    public static String []replycontent;
    public static String []replyorgnm;
    public static String []replyagreemsg;
    public static String []replydate;
    public static String []allreplys;
    public static String username_buttoncheck,date_buttoncheck;

    public BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute()
    {
        //  alertDialog = new AlertDialog.Builder(ctx).create();
        // alertDialog.setTitle("Login Information....");
        //     coordinatorLayout=(CoordinatorLayout) ;


    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://swarasawant.esy.es/swara/register.php";
        String login_url = "http://swarasawant.esy.es/swara/login.php";
        String signout_url = "http://shubhamwlug.esy.es/wlug/signout.php";
        String AgreeReply_url = "http://swarasawant.esy.es/swara/agreeReply.php";
        String writeblogurl="http://swarasawant.esy.es/swara/writeblog.php";
        String helpstatus1url = "http://swarasawant.esy.es/swara/helpstatus1.php";
        String helptableadd_url="http://swarasawant.esy.es/swara/helptable_add.php";
        String readblog_url="http://swarasawant.esy.es/swara/readblog.php";
        String ReplyList_url="http://swarasawant.esy.es/swara/replylist.php";
        String ButtonCheck_url="http://swarasawant.esy.es/swara/buttoncheck.php";

        method = params[0];
        Log.e("In Do in background", "asdasdadasd");
        if (method.equals("signup"))
        {
            first=params[1];
            last=params[2];
            username=params[3];
            email = params[4];
            password = params[5];
            try {

                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);//true for post method
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter((new OutputStreamWriter(OS, "UTF-8")));

                String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                        URLEncoder.encode("firstname", "UTF-8") + "=" + URLEncoder.encode(first, "UTF-8") + "&" +
                        URLEncoder.encode("lastname", "UTF-8") + "=" + URLEncoder.encode(last, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();//
                bufferedWriter.close();
                OS.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "", line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (method.equals("login"))
        {
            username = params[1];
            password = params[2];
            type=params[3];

            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter((new OutputStreamWriter(outputStream, "UTF-8")));

                String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&" +
                        URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(type, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "", line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        if (method.equals("helptable_add"))
        {
            helpusernm_str=params[1];
            helptitle_str=params[2];
            helpcontent_str=params[3];
            oragusernm_str=params[4];
            try {

                URL url = new URL(helptableadd_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter((new OutputStreamWriter(OS, "UTF-8")));

                String data = URLEncoder.encode("helpusernm_str", "UTF-8") + "=" + URLEncoder.encode(helpusernm_str, "UTF-8") + "&" +
                        URLEncoder.encode("helptitle_str", "UTF-8") + "=" + URLEncoder.encode(helptitle_str, "UTF-8") + "&" +
                        URLEncoder.encode("helpcontent_str", "UTF-8") + "=" + URLEncoder.encode(helpcontent_str, "UTF-8") + "&" +
                        URLEncoder.encode("oragusernm_str", "UTF-8") + "=" + URLEncoder.encode(oragusernm_str, "UTF-8");


                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "", line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        if (method.equals("bloglist"))
        {

            try {

                URL url = new URL(readblog_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter((new OutputStreamWriter(OS, "UTF-8")));

               /* String data = URLEncoder.encode("helpusernm_str", "UTF-8") + "=" + URLEncoder.encode(helpusernm_str, "UTF-8") + "&" +
                        URLEncoder.encode("helptitle_str", "UTF-8") + "=" + URLEncoder.encode(helptitle_str, "UTF-8") + "&" +
                        URLEncoder.encode("helpcontent_str", "UTF-8") + "=" + URLEncoder.encode(helpcontent_str, "UTF-8") + "&" +
                        URLEncoder.encode("oragusernm_str", "UTF-8") + "=" + URLEncoder.encode(oragusernm_str, "UTF-8");


                bufferedWriter.write(data);*/
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "", line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if (method.equals("AgreeReply"))
        {
            replyorgnm_str=params[1];
            replyusernm_str=params[2];
            replyagree_str=params[3];
            replydate_str=params[4];

            try {

                URL url = new URL(AgreeReply_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter((new OutputStreamWriter(OS, "UTF-8")));

                String data = URLEncoder.encode("replyorgnm_str", "UTF-8") + "=" + URLEncoder.encode(replyorgnm_str, "UTF-8") + "&" +
                        URLEncoder.encode("replyusernm_str", "UTF-8") + "=" + URLEncoder.encode(replyusernm_str, "UTF-8") + "&" +
                        URLEncoder.encode("replyagree_str", "UTF-8") + "=" + URLEncoder.encode(replyagree_str, "UTF-8") + "&" +
                        URLEncoder.encode("replydate_str", "UTF-8") + "=" + URLEncoder.encode(replydate_str, "UTF-8");


                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "", line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        else if(method.equals("write_blog"))
        {
            blg_username=params[1];
            blg_title=params[2];
            blg_content=params[3];

            try {
                URL url = new URL(writeblogurl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter((new OutputStreamWriter(outputStream, "UTF-8")));

                String data = URLEncoder.encode("blg_username", "UTF-8") + "=" + URLEncoder.encode(blg_username, "UTF-8")+"&"+
                        URLEncoder.encode("blg_title", "UTF-8") + "=" + URLEncoder.encode(blg_title, "UTF-8")+"&"+
                        URLEncoder.encode("blg_content", "UTF-8") + "=" + URLEncoder.encode(blg_content, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "", line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }




        else if (method.equals("helpstatus1"))
        {


            try {
                URL url = new URL(helpstatus1url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter((new OutputStreamWriter(outputStream, "UTF-8")));

                String data = URLEncoder.encode("orgusernm", "UTF-8") + "=" + URLEncoder.encode(orgusernm, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "", line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        else if (method.equals("signout")) {
            email = params[1];
            password = params[2];
            try {
                URL url = new URL(signout_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter((new OutputStreamWriter(outputStream, "UTF-8")));

                String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "", line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (method.equals("ReplyList")) {

            replylist_user = params[1];
            try {
                URL url = new URL(ReplyList_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter((new OutputStreamWriter(outputStream, "UTF-8")));

                String data = URLEncoder.encode("replylist_user","UTF-8")+"="+URLEncoder.encode(replylist_user,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "", line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


        else if (method.equals("ButtonCheck")) {
            username_buttoncheck=params[1];
            date_buttoncheck=params[2];
            try {
                URL url = new URL(ButtonCheck_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter((new OutputStreamWriter(outputStream, "UTF-8")));

                String data = URLEncoder.encode("username_buttoncheck", "UTF-8") + "=" + URLEncoder.encode(username_buttoncheck, "UTF-8") + "&" +
                        URLEncoder.encode("date_buttoncheck", "UTF-8") + "=" + URLEncoder.encode(date_buttoncheck, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "", line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


    @Override
    protected void onPostExecute(String result)
    {
        {

            //Toast.makeText(ctx,result, Toast.LENGTH_SHORT).show();

                if(result.contains("Admin"))//admin login success
                {
                    String []arr=result.split("---");
                    orgusernm=arr[1];
                    SharedPreferences sharedPreferences=ctx.getSharedPreferences("user_data",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();//to create editor
                    Toast.makeText(ctx,username+password+type,Toast.LENGTH_LONG).show();
                    editor.putString("username",username);//put this data in user_data string 
                    editor.putString("password",password);
                    editor.putString("type",type);
                    editor.commit();//commit returns true if the save works

                  //  Toast.makeText(ctx, "Admin logged in ", Toast.LENGTH_SHORT).show();
                    ((Activity) LoginActivity.context).startActivity(new Intent(((Activity) LoginActivity.context), AdminDetails.class));
                    ((Activity) LoginActivity.context).finish();

                }
               else if(result.contains("User"))//user login success
                {
                    SharedPreferences sharedPreferences=ctx.getSharedPreferences("user_data",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    Toast.makeText(ctx,username+password+type,Toast.LENGTH_LONG).show();
                    editor.putString("username",username);
                    editor.putString("password",password);
                    editor.putString("type",type);
                    editor.commit();
                    //Toast.makeText(ctx, "User logged in", Toast.LENGTH_SHORT).show();
                    ((Activity) LoginActivity.context).startActivity(new Intent(((Activity) LoginActivity.context), UserHomePage.class));
                    ((Activity) LoginActivity.context).finish();
                }
            else if(result.contains("Registration"))//registration success
            {
                //Toast.makeText(ctx, "Registration success ", Toast.LENGTH_SHORT).show();
                ((Activity) CreateAccount.context).startActivity(new Intent(((Activity) CreateAccount.context), LoginActivity.class));
                ((Activity) CreateAccount.context).finish();

            }

                else if(result.contains("Reply"))//User reply success
                {
                    Toast.makeText(ctx,"Userdata in back",Toast.LENGTH_SHORT).show();
                    

                }
                else if(result.startsWith("Sorry"))//login failed message
                {
                    Toast.makeText(ctx,"Login failed ",Toast.LENGTH_SHORT).show();
                }
                else if(result.startsWith("newhope"))//helptable data addition success
                {
                    KopOrg.helpcontent_edt.setText(" ");
                    KopOrg.other_cb.setChecked(false);
                    KopOrg.food_cb.setChecked(false);
                    KopOrg.study_cb.setChecked(false);
                    KopOrg.oragnise_cb.setChecked(false);
                    KopOrg.cloth_cb.setChecked(false);
                    KopOrg.volunteer_cb.setChecked(false);
                    ((Activity) KopOrg.ctx).startActivity(new Intent(ctx, HelpOrg.class));
                    ((Activity) KopOrg.ctx).finish();


                }
                else if(result.startsWith("angel"))//helptable data addition success
                {
                    MirajOrg.helpcontent_edt.setText(" ");
                    MirajOrg.other_cb.setChecked(false);
                    MirajOrg.food_cb.setChecked(false);
                    MirajOrg.study_cb.setChecked(false);
                    MirajOrg.oragnise_cb.setChecked(false);
                    MirajOrg.cloth_cb.setChecked(false);
                    MirajOrg.volunteer_cb.setChecked(false);
                    ((Activity) MirajOrg.ctx).startActivity(new Intent(ctx, HelpOrg.class));
                    ((Activity) MirajOrg.ctx).finish();
                    //((Activity) HelpOrg.context).finish();

                }
                else if(result.startsWith("observationhome"))//helptable data addition success
                {
                    JaysingOrg.helpcontent_edt.setText(" ");
                    JaysingOrg.other_cb.setChecked(false);
                    JaysingOrg.food_cb.setChecked(false);
                    JaysingOrg.study_cb.setChecked(false);
                    JaysingOrg.oragnise_cb.setChecked(false);
                    JaysingOrg.cloth_cb.setChecked(false);
                    JaysingOrg.volunteer_cb.setChecked(false);
                    ((Activity) JaysingOrg.ctx).startActivity(new Intent(ctx, HelpOrg.class));
                    ((Activity) JaysingOrg.ctx).finish();
                }
                else if(result.startsWith("rayhouse"))//helptable data addition success
                {
                    IchalOrg.helpcontent_edt.setText(" ");
                    IchalOrg.other_cb.setChecked(false);
                    IchalOrg.food_cb.setChecked(false);
                    IchalOrg.study_cb.setChecked(false);
                    IchalOrg.oragnise_cb.setChecked(false);
                    IchalOrg.cloth_cb.setChecked(false);
                    IchalOrg.volunteer_cb.setChecked(false);
                    ((Activity) IchalOrg.ctx).startActivity(new Intent(ctx, HelpOrg.class));
                    ((Activity) IchalOrg.ctx).finish();
                }
                else if(result.contains("&&&"))  //blogs data retrival success
                {

                    String []allblg=result.split("&&&");
                    String cnt_str=allblg[0];
                    String allblogdata=allblg[1];

                    int cnt=Integer.parseInt(cnt_str);
                    blog_username=new String[cnt];
                    blog_title=new String[cnt];
                    blog_content=new String[cnt];
                    blog_date=new String[cnt];

                    LinkedList <MyBlog>blglist=new LinkedList();

                    allblogs=allblogdata.split("@@@");
                    for(int i=0;i<allblogs.length;i++)
                    {

                        String []tempblog=allblogs[i].split("---");
                        MyBlog blog=new MyBlog(tempblog[1],tempblog[0],tempblog[3]);

                        blglist.add(blog);

                        blog_username[i]=tempblog[0];
                        blog_title[i]=tempblog[1];
                        blog_content[i]=tempblog[2];
                        blog_date[i]=tempblog[3];

                    }
                    //String arr[]={"srs","hasd"};
                    ListAdapter adapter= new CustomAdapter(ctx,blglist);
                    BlogList.bloglist_lst.setAdapter(adapter);


                }

                else if(result.contains("Record"))//if already replied for user message then disable the button
                {
                    //Toast.makeText(ctx,"!!!!!!"+result,Toast.LENGTH_SHORT).show();
                    HelpDetails.agree_bt.setEnabled(false);
                    HelpDetails.disagree_bt.setEnabled(false);
                }
                else if(result.startsWith("Blog"))
                {
                    blog.blog_title_ed.setText(" ");
                    blog.blog_content_ed.setText(" ");
                   /* ((Activity) blog.context).startActivity(new Intent(((Activity) blog.context), UserHomePage.class));
                    ((Activity) blog.context).finish();*/

                }

                else if(result.contains("!!!"))   //User reply success
                {
                    Toast.makeText(ctx,result,Toast.LENGTH_SHORT).show();

                    String []allblg=result.split("!!!");
                    String cnt_str=allblg[0];
                    String allblogdata=allblg[1];

                    int cnt=Integer.parseInt(cnt_str);
                    replydate=new String[cnt];
                    replyorgnm=new String[cnt];
                    replytitle=new String[cnt];
                    replycontent=new String[cnt];
                    replyagreemsg=new String[cnt];

                    LinkedList <MyMsg> replylist=new LinkedList();

                    allreplys=allblogdata.split("@@@");
                    for(int i=0;i<allreplys.length;i++)
                    {

                        String []tempblog=allreplys[i].split("---");
                        MyMsg msg=new MyMsg(tempblog[2],tempblog[4]);
                        replylist.add(msg);

                        replytitle[i]=tempblog[0];
                        replycontent[i]=tempblog[1];
                        replyorgnm[i]=tempblog[2];
                        replyagreemsg[i]=tempblog[3];
                        replydate[i]=tempblog[4];

                    }
                    ListAdapter adapter= new MsgAdapter(ctx,replylist);
                    UserReply.userply_listView.setAdapter(adapter);


                }


            else if(result.contains("###"))   //help details success
                {

                    String []all1= result.split("%%%");
                    String cntstr=all1[0];
                    String helpsplit=all1[1];

                    String []all=helpsplit.split("###");
                    String help1 = all[0];
                    String help0 = all[1];

                    int cnt=Integer.parseInt(cntstr);

                    help_username=new String[cnt];
                    help_title=new String[cnt];
                    help_content=new String[cnt];
                    help_date=new String[cnt];


                    LinkedList <MyAdminMessage>helplist=new LinkedList();


                    allhelp1=help1.split("@@@");
                 //   allhelp0=help0.split("@@@");
                    for(int i=0;i<allhelp1.length;i++)
                    {
                         String []temphelp1=allhelp1[i].split("---");
                       MyAdminMessage msg=new MyAdminMessage(temphelp1[0],temphelp1[3]);
                       helplist.add(msg);
                        help_username[i]=temphelp1[0];
                            help_title[i]=temphelp1[1];
                            help_content[i]=temphelp1[2];
                            help_date[i]=temphelp1[3];
                    }





                    ListAdapter adapter= new AdminMsgAdapter(ctx,helplist);
                    AdminHomePage.listView.setAdapter(adapter);
                    //Toast.makeText(ctx,"Data retreived",Toast.LENGTH_SHORT).show();
                }


                return;

        }
    }
}

