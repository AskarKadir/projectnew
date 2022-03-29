package com.example.advance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    /*Manually Adding Code*/
    Context mContext;
    LayoutInflater inflater;
    private ArrayList<ClassNama> arraylist;

    public ListViewAdapter(Context context){
        mContext = context;

        inflater = LayoutInflater.from(mContext);

        this.arraylist = new ArrayList<ClassNama>();

        this.arraylist.addAll(HomeActivity.classNamaArrayList);
    }

    public class ViewHolder{
        TextView name;
    }

    /*Auto Genrate from Base Adapter*/
    @Override
    public int getCount() {
        return HomeActivity.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return HomeActivity.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;

        if(view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_listview,null);
            holder.name = (TextView) view.findViewById(R.id.tempatnama);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText(HomeActivity.classNamaArrayList.get(i).getName());

        return view;
    }
}
