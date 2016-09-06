package com.test.orissa.msewa.Activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.test.orissa.msewa.R;
import com.test.orissa.msewa.costemview.AutoScrollViewPager;
import com.test.orissa.msewa.costemview.CustomTextView;

import me.relex.circleindicator.CircleIndicator;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private Context appContext;
    public Toolbar mToolbar;
    public ActionBar actionBar;

    ImageView imgLicense;
    CustomTextView tvHome, tvAbout, tvSettings;
    int[] arrayBanner = new int[]{R.mipmap.mobile, R.mipmap.mobile, R.mipmap.mobile};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        appContext = this;
        setuptoolbar();
        initView();

    }

    private RadioGroup radioGroup;
    LinearLayout lay1, lay2, lay3;
    CustomTextView tvnext1, tvnext2, tvSubmit, back2, back3;

    public void initView() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        initBanner();
        initNewsBanner();


        imgLicense = (ImageView) findViewById(R.id.imgLicense);
        imgLicense.setOnClickListener(this);
        tvHome = (CustomTextView) findViewById(R.id.drawerHome);
        tvHome.setOnClickListener(this);

        ImageView  float_icon=(ImageView)findViewById(R.id.float_icon);


        tvAbout = (CustomTextView) findViewById(R.id.drawerAbout);
        tvAbout.setOnClickListener(this);
        tvSettings = (CustomTextView) findViewById(R.id.drawerSettings);
        tvSettings.setOnClickListener(this);







    }


    AutoScrollViewPager pagerView, slider_news;

    CircleIndicator indicator;

    //    public  void initViewPager()
//    {
//        slider_que = (AutoScrollViewPager) findViewById(R.id.slider_que);
//        slider_que.setAdapter(new AwesomePagerAdapter(3));
//        slider_que.stopAutoScroll();
//    }
    public void initBanner() {
        pagerView = (AutoScrollViewPager) findViewById(R.id.slider_details);
        pagerView.setAdapter(new AwesomePagerAdapter(1));
        indicator = (CircleIndicator) findViewById(R.id.indicator);
        pagerView.startAutoScroll();

        indicator.setViewPager(pagerView);

    }

    public void initNewsBanner() {
        slider_news = (AutoScrollViewPager) findViewById(R.id.slider_news);
        slider_news.setAdapter(new AwesomePagerAdapter(2));
        slider_news.startAutoScroll();


    }


    private class AwesomePagerAdapter extends PagerAdapter {

        int bannerType = 0;

        AwesomePagerAdapter(int type) {
            bannerType = type;
        }

        @Override
        public void destroyItem(View collection, int position, Object view) {
            ((ViewPager) collection).removeView((View) view);
        }

        @Override
        public void finishUpdate(View arg0) {
            //setPageTitles(getPageNumber());
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object instantiateItem(View collection, int position) {

            View view = getViewToShow(position, bannerType);
            ((ViewPager) collection).addView(view, 0);
            return view;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((View) object);
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
            // TODO Auto-generated method stub

        }

        @Override
        public Parcelable saveState() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void startUpdate(View arg0) {
            // TODO Auto-generated method stub

        }
    }

    private View getViewToShow(int position, int type) {
        View view = null;
        View layout = null;
        LayoutInflater mInflater = (LayoutInflater)
                appContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            layout = mInflater.inflate(R.layout.reviewlayoutheader, null);
            ImageView imgBanner = (ImageView) layout.findViewById(R.id.img_banner);

                imgBanner.setImageResource(arrayBanner[position]);






        view = layout;

        return view;
    }


    public void setuptoolbar() {
        mToolbar = (Toolbar) findViewById(R.id.tools);
        setSupportActionBar(mToolbar);
//        actionBar = getSupportActionBar();
////        actionBar.setHomeAsUpIndicator(R.mipmap.menu);
//        actionBar.setDisplayShowCustomEnabled(true);
//        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeButtonEnabled(true);

        ((ImageView) findViewById(R.id.img_menu)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLeft();
            }
        });
    }

    public void openLeft() {
        if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            mDrawerLayout.closeDrawer(Gravity.RIGHT);
        }
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            mDrawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            mDrawerLayout.openDrawer(Gravity.LEFT);

        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.imgLicense:

                break;
            case R.id.drawerHome:
                openLeft();
                break;
            case R.id.drawerSettings:
                openLeft();
                break;
            case R.id.drawerAbout:
                openLeft();
                break;

            case R.id.float_icon:

                break;
            default:
                break;

        }
    }


}
