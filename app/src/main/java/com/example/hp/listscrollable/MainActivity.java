package com.example.hp.listscrollable;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity
{
    ListView listView;
    static getFromInternet getfun=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void click_For_Refresh(View view)
    {

        try
        {
            getfun=new getFromInternet(this);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        getfun.execute();


        //listView=(ListView)findViewById(R.id.listview);

        //ArrayList<ListViewItem> items=new ArrayList<MainActivity.ListViewItem>();

        /*items.add(new ListViewItem("ananya",1.2,3.5));
        items.add(new ListViewItem("pp",1.1,2.5));
        items.add(new ListViewItem("ananya",1.2,3.5));
        items.add(new ListViewItem("pp",1.1,2.5));
        items.add(new ListViewItem("ananya",1.2,3.5));
        items.add(new ListViewItem("pp",1.1,2.5));
        items.add(new ListViewItem("ananya",1.2,3.5));
        items.add(new ListViewItem("pp",1.1,2.5));
        items.add(new ListViewItem("ananya",1.2,3.5));
        items.add(new ListViewItem("pp",1.1,2.5));
        items.add(new ListViewItem("ananya",1.2,3.5));
        items.add(new ListViewItem("pp",1.1,2.5));
        items.add(new ListViewItem("ananya",1.2,3.5));
        items.add(new ListViewItem("pp",1.1,2.5));
        items.add(new ListViewItem("ananya",1.2,3.5));
        items.add(new ListViewItem("pp",1.1,2.5));
        items.add(new ListViewItem("ananya",1.2,3.5));
        items.add(new ListViewItem("pp",1.1,2.5));
        items.add(new ListViewItem("ananya",1.2,3.5));
        items.add(new ListViewItem("pp",1.1,2.5));
        items.add(new ListViewItem("ananya",1.2,3.5));
        items.add(new ListViewItem("pp",1.1,2.5));
        items.add(new ListViewItem("ananya",1.2,3.5));
        items.add(new ListViewItem("pp",1.1,2.5));
        items.add(new ListViewItem("ananya",1.2,3.5));
        items.add(new ListViewItem("pp",1.1,2.5));
        items.add(new ListViewItem("ananya",1.2,3.5));
        items.add(new ListViewItem("pp",1.1,2.5));
        items.add(new ListViewItem("ananya",1.2,3.5));
        items.add(new ListViewItem("pp",1.1,2.5));
        items.add(new ListViewItem("ananya",1.2,3.5));
        items.add(new ListViewItem("pp",1.1,2.5));
        items.add(new ListViewItem("ananya",1.2,3.5));
        items.add(new ListViewItem("pp",1.1,2.5));*/


        //CustomListViewAdapter adapter=new CustomListViewAdapter(this,items);
        //listView.setAdapter(adapter);


    }

    /*public class  ListViewItem
    {
        public String name;
        public Double usd_exchange;
        public Double percent_change_last_hour;
        public ListViewItem(String name,Double usd_exchange,Double percent_change_last_hour)
        {
            this.name=name;
            this.usd_exchange=usd_exchange;
            this.percent_change_last_hour=percent_change_last_hour;
        }
    }*/
}

