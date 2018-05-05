package com.example.hp.listscrollable;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewAdapter extends BaseAdapter
{
    Context c;
    ArrayList<getFromInternet.ListViewItem2> items;
    LayoutInflater inflater;
    public  CustomListViewAdapter(Activity context, ArrayList<getFromInternet.ListViewItem2> items)
    {
        super();

        this.items=items;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        c=context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view1, ViewGroup viewGroup)
    {
        //MainActivity.ListViewItem item=items.get(position);
        getFromInternet.ListViewItem2 item=items.get(position);
        View vi=view1;
        if(view1==null)
        {
            //vi=inflater.inflate(R.layout.item_row,null);
            vi=LayoutInflater.from(c).inflate(R.layout.item_row,viewGroup,false);
        }

        TextView name=vi.findViewById(R.id.textView2);
        TextView usd_exchange=vi.findViewById(R.id.textView3);
        TextView percent_change_1st_hour=vi.findViewById(R.id.textView4);


        name.setText(item.name);
        usd_exchange.setText(item.usd_exchange);
        percent_change_1st_hour.setText(item.percent_change_last_hour);




        return  vi;
    }
}
