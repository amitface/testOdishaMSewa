package com.test.orissa.msewa.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

import com.test.orissa.msewa.R;


public class SpleshActivity extends Activity {
    private Thread mThread;
    private boolean isFinish = false;
    private Context appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        appContext=this;
        mThread = new Thread(mRunnable);
        mThread.start();
    }
    private Runnable mRunnable = new Runnable() {

        public void run() {
            SystemClock.sleep(2000);
            mHandler.sendEmptyMessage(0);
        }
    };
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0 && (!isFinish)) {
                stop();
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onDestroy() {
        try {
            mThread.interrupt();
            mThread = null;

        } catch (Exception e) {
        }
        super.onDestroy();
    }




    private void stop()
    {



         isFinish=true;

            startActivity(new Intent(appContext, RegisterActivity.class));

        finish();


    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            stop();
//        }
//        return super.onTouchEvent(event);
//    }
//    private void StartAnimations() {
//        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
//        anim.reset();
////        LinearLayout l=(LinearLayout) findViewById(R.id.lin_lay);
////        l.clearAnimation();
////        l.startAnimation(anim);
//
//        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
//       // anim.reset();
//        anim.setRepeatMode(2);
//        ImageView iv = (ImageView) findViewById(R.id.splash_logo);
//        iv.clearAnimation();
//        iv.startAnimation(anim);
//
//
//    }










}
