package com.example.administrator.huanxin.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.example.administrator.huanxin.R;
import com.example.administrator.huanxin.base.BaseActivity;
import com.example.administrator.huanxin.base.FragmentBuilder;
import com.example.administrator.huanxin.fragent.HuiFragment;
import com.example.administrator.huanxin.fragent.SheFragment;
import com.example.administrator.huanxin.fragent.XunFragment;

public class ShaoyeActivity extends BaseActivity {


    private RadioButton homo;
    private RadioButton ding;
    private RadioButton my;
    @Override
    protected void initData() {

    }

    @Override
    protected void initId() {
        initView();
        homo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentBuilder.getFragmentBuilder().containerId(R.id.fram_home).satrt(HuiFragment.class).build();
            }
        });
        ding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentBuilder.getFragmentBuilder().containerId(R.id.fram_home).satrt(SheFragment.class).build();
            }
        });
        my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentBuilder.getFragmentBuilder().containerId(R.id.fram_home).satrt(XunFragment.class).build();

            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_shaoye;
    }

    private void initView() {
        homo = (RadioButton) findViewById(R.id.homo);
        ding = (RadioButton) findViewById(R.id.ding);
        my = (RadioButton) findViewById(R.id.my);
    }
}
