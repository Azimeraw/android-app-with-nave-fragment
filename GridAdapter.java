package com.example.prote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    Context context;
    String[] name;
    int[] image;
    LayoutInflater inflater;
    public GridAdapter(Context context,String[] name,int[] image){
        this.context=context;
        this.name=name;
        this.image=image;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        ImageView imageView;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview=inflater.inflate(R.layout.grid_item,parent,false);
        textView=(TextView)itemview.findViewById(R.id.grid_image1name);
        imageView=(ImageView)itemview.findViewById(R.id.grid_image1);
        textView.setText(name[position]);
        imageView.setImageResource(image[position]);

        return itemview;
    }
}
