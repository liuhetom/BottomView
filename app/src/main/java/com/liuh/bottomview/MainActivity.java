package com.liuh.bottomview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pacific.adapter.Adapter;
import com.pacific.adapter.AdapterHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomView bottomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<ViewModel> data = new ArrayList<>();
        data.add(new ViewModel("11",-1,-1));
        bottomView = (BottomView) findViewById(R.id.bv);
        Adapter<ViewModel> adapter = new Adapter<ViewModel>(this, data, R.layout.bottomitem) {
            @Override
            protected void convert(AdapterHelper helper, ViewModel item) {
                helper.setText(R.id.item, item.getName());
            }
        };
        bottomView.setAdapter(adapter);
    }
}
