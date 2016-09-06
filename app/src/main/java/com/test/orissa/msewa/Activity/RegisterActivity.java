package com.test.orissa.msewa.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.test.orissa.msewa.R;
import com.test.orissa.msewa.costemview.CustomTextView;

public class RegisterActivity extends AppCompatActivity {
    public Toolbar mToolbar;
    public ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setuptoolbar();
    }

    public void setuptoolbar() {
        mToolbar = (Toolbar) findViewById(R.id.tools);
        setSupportActionBar(mToolbar);
//        actionBar = getSupportActionBar();
////        actionBar.setHomeAsUpIndicator(R.mipmap.back);
//        actionBar.setDisplayShowCustomEnabled(true);
//        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeButtonEnabled(true);
        ((CustomTextView)findViewById(R.id.toolbar_header)).setText("LICENCE");


    }



}
