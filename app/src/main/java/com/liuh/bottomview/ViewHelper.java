package com.liuh.bottomview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Liuhe on 2016/10/17.
 */

public class ViewHelper {

    private View view;

    public ViewHelper(View view) {
        this.view = view;
    }

    public void setText(int id,String text) {
        TextView tv = (TextView) view.findViewById(id);
        tv.setText(text);
    }

    public void setImage(int id,int img) {
        ImageView iv = (ImageView) view.findViewById(id);
        iv.setImageResource(img);
    }
}
