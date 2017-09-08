package com.example.administrator.huanxin.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.huanxin.R;
import com.example.administrator.huanxin.base.BaseActivity;
import com.hyphenate.chat.EMClient;
import com.hyphenate.util.EasyUtils;

public class MainActivity extends BaseActivity {

    @Override
    protected void initData() {

    }

    @Override
    protected void initId() {
        RelativeLayout rootLayout = (RelativeLayout) findViewById(R.id.splash_root);
        TextView versionText = (TextView) findViewById(R.id.tv_version);
        versionText.setText(getVersion());
        AlphaAnimation animation = new AlphaAnimation(0.3f, 1.0f);
        animation.setDuration(1500);
        rootLayout.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }
    private String getVersion() {
        return EMClient.getInstance().VERSION;
    }
}
