package com.android.microsoft.design;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Microsoft on 10/8/2015.
 */
public class CustomAdapter extends BaseAdapter {

    ArrayList<String> poems = new ArrayList<>();
    Context context;
    public  static LayoutInflater inflater = null;
    public CustomAdapter(Context context){
        this.context = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public CustomAdapter(Context context,ArrayList<String> poems){
        this.context= context;
        this.poems = poems;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return poems.size();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        TextView textView;
        View rowView;
        rowView = inflater.inflate(R.layout.singlepoem, null);
       textView=(TextView) rowView.findViewById(R.id.singleText);
        textView.setText(poems.get(position));
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(context, Main2Activity.class);
                intent.putExtra("PoemTitle",poems.get(position));
                context.startActivity(intent);

                Toast.makeText(context, "You Clicked " + poems.get(position), Toast.LENGTH_LONG).show();
            }
        });
        return rowView;


    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }
}
