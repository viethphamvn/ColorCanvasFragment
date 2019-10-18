package edu.temple.colorcanvasfragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {
    Context c;
    int count;
    String[] color;

    public ColorAdapter(Context c, int count, String[] color){
        this.c = c;
        this.count = count;
        this.color = color;
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
        view.setText(color[position]);

        return view;
    }
}
