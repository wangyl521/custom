package com.innsmap.wyl.customviewproject;

import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DrawableActivity extends Activity {
    private Button bt;
    private boolean flag;
    private TransitionDrawable drawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawable_layout);
        bt = findViewById(R.id.bt);
         drawable = (TransitionDrawable) bt.getBackground();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag){
                    drawable.startTransition(2000);
                    flag = !flag;
                }else{
                    flag = !flag;
                    drawable.reverseTransition(2000);
                }
            }
        });
    }
}
