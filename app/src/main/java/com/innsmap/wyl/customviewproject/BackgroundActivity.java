package com.innsmap.wyl.customviewproject;

import android.app.Activity;
import android.os.Bundle;

import com.noober.background.BackgroundLibrary;

public class BackgroundActivity extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BackgroundLibrary.inject(this);
        setContentView(R.layout.background_layout);

    }
}
