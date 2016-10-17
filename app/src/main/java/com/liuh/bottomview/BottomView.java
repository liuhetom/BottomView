package com.liuh.bottomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liuhe on 2016/10/15.
 */

public class BottomView extends LinearLayout {

    private Context context;
    private AttributeSet attrs;
    private int bv_height = -1;
    private int count;
    private int layout;

    public BottomView(Context context) {
        super(context);
    }

    public BottomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BottomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        this.attrs = attrs;
        getAttr();
        initView();
    }

    private void initView() {
        this.setBackgroundColor(Color.parseColor("#eeeeee"));
        this.setOrientation(HORIZONTAL);
        List<ViewModel> datas = new ArrayList<ViewModel>();
        datas.add(new ViewModel("helo",R.mipmap.ic_launcher,0));
        datas.add(new ViewModel("helo",R.mipmap.ic_launcher,0));
        BottomViewAdapter adapter = new BottomViewAdapter(context, new BottomViewListener() {
            @Override
            public void setView(ViewHelper helper, ViewModel viewModel) {
                helper.setText(R.id.item,viewModel.getName());
            }
        }, datas, layout);
        for (int i = 0; i < adapter.getCount(); i++) {
            int width = UiUtils.getScreenWidth(context);
            int v_width=width/adapter.getCount();
            v_width=width-v_width*i;
            this.addView(adapter.getView(i, null, this), v_width, bv_height);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (bv_height < 0) {
            bv_height = BottomViewFaild.CUSTOM_HEIGHT;
        }
        widthMeasureSpec = UiUtils.getScreenWidth(context);
        heightMeasureSpec = UiUtils.dp2px(context, bv_height);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }


    private void getAttr() {
        TypedArray a = context.obtainStyledAttributes(this.attrs, R.styleable.BottomView);
        bv_height = a.getInt(R.styleable.BottomView_bv_height, -1) == BottomViewFaild.CUSTOM_HEIGHT ? BottomViewFaild.CUSTOM_HEIGHT : BottomViewFaild.GOOGLE_HEIGHT;
        count = a.getInt(R.styleable.BottomView_count, 0);
        layout = a.getResourceId(R.styleable.BottomView_layout_item, -1);
    }


}
