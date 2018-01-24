package com.codeworm.ganesh.v_dayanimation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.codeworm.ganesh.v_dayanimation.utils.Helper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ViewGroup mContentView;
    private ArrayList<HeartImage> heartImages = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContentView = findViewById(R.id.activity_main);

        mContentView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(MotionEvent.ACTION_DOWN == motionEvent.getActionMasked()) {
                    Helper.instance.prepareForAnimations(MainActivity.this);
                    for(int heartIndex = 0; heartIndex < Helper.mCoordinates.size();heartIndex ++) {
                        heartImages.add(heartIndex, new HeartImage(MainActivity.this, Color.argb(255,255,0,0)));
                        heartImages.get(heartIndex).setX(Helper.mCoordinates.get(heartIndex).getX());
                        heartImages.get(heartIndex).setY(Helper.mCoordinates.get(heartIndex).getY());
                        mContentView.addView(heartImages.get(heartIndex));
                        heartImages.get(heartIndex).startAnim();

                    }
                }
                return false;
            }
        });
    }

}
