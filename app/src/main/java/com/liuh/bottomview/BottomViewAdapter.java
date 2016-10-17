package com.liuh.bottomview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Liuhe on 2016/10/16.
 */

public class BottomViewAdapter extends BaseAdapter {

    private Context context;
    private List<ViewModel> data;
    private int layout;
    private BottomViewListener listener;
    private ViewHelper helper;

    public BottomViewAdapter(Context context,BottomViewListener listener , List<ViewModel> data,int layout) {
        this.context = context;
        this.data = data;
        this.layout = layout;
        this.listener=listener;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View inflate = View.inflate(context, layout, null);
        helper = new ViewHelper(inflate);
        listener.setView(helper,data.get(position));
        return inflate;
    }

}
