package com.example.actionbardemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;

import com.example.actionbardemo.adapter.SimpleListAdapter;
import com.example.actionbardemo.model.SimpleListModal;

public class HomeActivity extends Activity {

    private Drawable mActionBarBackgroundDrawable;
    private ListView list;
    List<SimpleListModal> listitem = new ArrayList<SimpleListModal>();
    SimpleListAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mActionBarBackgroundDrawable.setCallback(mDrawableCallback);
        }

//        mActionBarBackgroundDrawable = getResources().getDrawable(R.drawable.penguins);

        mActionBarBackgroundDrawable = new ColorDrawable(Color.parseColor("#4bb848"));
        mActionBarBackgroundDrawable.setAlpha((int) 0.6);
        getActionBar().setBackgroundDrawable(mActionBarBackgroundDrawable);

        ((NotifyingScrollView) findViewById(R.id.scroll_view)).setOnScrollChangedListener(mOnScrollChangedListener);
        
        list = (ListView)findViewById(R.id.list);
        
        //set data to list.
        listitem.add(new SimpleListModal("one", ""));
        listitem.add(new SimpleListModal("two", ""));
        listitem.add(new SimpleListModal("three", ""));
        listitem.add(new SimpleListModal("four", ""));
        listitem.add(new SimpleListModal("five", ""));
        listitem.add(new SimpleListModal("six", ""));
        listitem.add(new SimpleListModal("seven", ""));
        listitem.add(new SimpleListModal("eight", ""));
        listitem.add(new SimpleListModal("nine", ""));
        listitem.add(new SimpleListModal("ten", ""));
        listitem.add(new SimpleListModal("eleven", ""));
        
        adapter = new SimpleListAdapter(listitem, HomeActivity.this);
        list.setAdapter(adapter);
    }

    private NotifyingScrollView.OnScrollChangedListener mOnScrollChangedListener = new NotifyingScrollView.OnScrollChangedListener() {
        public void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt) {
            final int headerHeight = findViewById(R.id.image_header).getHeight() - getActionBar().getHeight();
            final float ratio = (float) Math.min(Math.max(t, 0), headerHeight) / headerHeight;
            final int newAlpha = (int) (ratio * 255);
            mActionBarBackgroundDrawable.setAlpha(newAlpha);
        }
    };
    
    private Drawable.Callback mDrawableCallback = new Drawable.Callback() {
        @Override
        public void invalidateDrawable(Drawable who) {
            getActionBar().setBackgroundDrawable(who);
        }

        @Override
        public void scheduleDrawable(Drawable who, Runnable what, long when) {
        }

        @Override
        public void unscheduleDrawable(Drawable who, Runnable what) {
        }
    };
}