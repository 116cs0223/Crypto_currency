package com.example.hp.listscrollable;

import android.os.AsyncTask;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class getFromInternet extends AsyncTask<Void ,Void, JSONObject>
{


    String internetvalue="";
    String singlerow="";
    String returnvalue="";
    MainActivity activity;
    ArrayList<ListViewItem2> arrayList=new ArrayList<ListViewItem2>();
    static ArrayList<ListViewItem2> restore_arrylist=new ArrayList<ListViewItem2>();

    CustomListViewAdapter adapter;
    static JSONArray array;
    static  URL url;

    public getFromInternet(MainActivity context)
    {
        activity=context;
    }
    @Override
    protected void onPostExecute(JSONObject object)
    {
        super.onPostExecute(object);
        ListView listView = activity.findViewById(R.id.listview);
        try {

            if (arrayList.size() > 0) {
                adapter = new CustomListViewAdapter(activity, arrayList);
            } else {
                adapter = new CustomListViewAdapter(activity, restore_arrylist);
            }

            listView.setAdapter(adapter);
        }
        catch (Exception e)
        {
            listView.setAdapter(null);
        }
    }

    @Override
    protected JSONObject doInBackground(Void... voids)
    {
        try {
            url=new URL("https://api.coinmarketcap.com/v1/ticker/");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            InputStream inputStream=httpsURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while(line!=null)
            {
                line=bufferedReader.readLine();
                internetvalue+=line;

            }

            array = new JSONArray(internetvalue);


            for (int i = 0; i <array.length() ; i++)
            {
                try
                {
                    JSONObject object=array.getJSONObject(i);
                    /*arrayList.add(new ListViewItem2(object.getString("name"),
                                                    Double.parseDouble(object.getString("price_usd")),
                                                    Double.parseDouble(object.getString("percent_change_1h"))
                                                    )
                                );*/
                    arrayList.add(new ListViewItem2(object.getString("name"),
                                    object.getString("price_usd"),
                                    object.getString("percent_change_1h")
                            )
                    );
                    //arrayList.add(new ListViewItem2("12",1.2,3.4));
                    }
                    catch (JSONException e)
                    {

                    }

            }

            if(arrayList.size()!=0)
                restore_arrylist=arrayList;



        }
        catch (IOException ioe)
        {

        }
        catch (JSONException jsone)
        {

        }
        return null;
    }
    public class ListViewItem2
    {
        public String name;
        public String usd_exchange;
        public String percent_change_last_hour;
        public ListViewItem2(String name,String usd_exchange,String percent_change_last_hour)
        {
            this.name=name;
            this.usd_exchange=usd_exchange;
            this.percent_change_last_hour=percent_change_last_hour;
        }

    }
}
