package com.codeworm.ganesh.v_dayanimation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Ganesh on 19/01/18.
 */

public class HeartImage extends ImageView {
    private Context context;

    public HeartImage(Context context, int filter) {
        super(context);
        this.context = context;
        this.setImageResource(R.drawable.ic_heart);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(40,40);
        this.setLayoutParams(params);
        this.setColorFilter(filter);
    }

    public void startAnim() {
        Animation animationScaleUp = AnimationUtils.loadAnimation(context, R.anim.anim_1);
        this.startAnimation(animationScaleUp);
        animationScaleUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                HeartImage.this.setVisibility(GONE);
                HeartImage.this.destroyDrawingCache();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
