package com.codeworm.ganesh.v_dayanimation.utils;

import android.content.Context;

import com.codeworm.ganesh.v_dayanimation.MainActivity;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ganesh on 19/01/18.
 */

public class Helper {
    public static ArrayList<Coordinates> mCoordinates = new ArrayList<>();
    public static Helper instance = new Helper();
    public void prepareForAnimations(Context context) {
        MainActivity activity = ((MainActivity)context) ;

        Random random = new Random();
        int width = activity.mContentView.getWidth() > 0 ? activity.mContentView.getWidth() : 1000;
        int height =  activity.mContentView.getHeight() > 0 ? activity.mContentView.getHeight() : 1500;
        mCoordinates.clear();
        for(int add_counter = 0 ; add_counter < 60; add_counter++ ) {
            mCoordinates.add(new Coordinates(random.nextInt(width - 200) + 100, random.nextInt(height - 250) + 150));
        }
    }

    public class Coordinates {
        private int x;
        private int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
