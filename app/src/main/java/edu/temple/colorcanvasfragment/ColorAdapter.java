package edu.temple.colorcanvasfragment;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {
    Context c;
    int count;
    String[] color, color_display;

    public ColorAdapter(Context c, int count, String[] color, String[] color_display){
        this.c = c;
        this.count = count;
        this.color = color;
        this.color_display = color_display;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        return color[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view;
        if (convertView instanceof View){
            view = (TextView)convertView;
        } else {
            view = new TextView(c);
        }
        view.setTextSize(40);
        view.setText(color_display[position]);
        return view;
    }


    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView textView;

        if (convertView instanceof View){
            textView = (TextView) convertView;
        } else {
            textView = new TextView(c);
        }
        textView.setBackgroundColor(Color.WHITE);
        textView.setTextSize(40);
        textView.setText(color_display[position]);
        try {
            textView.setBackgroundColor(Color.parseColor(color[position]));
        } catch(Exception e){}
        return textView;
    }
}
