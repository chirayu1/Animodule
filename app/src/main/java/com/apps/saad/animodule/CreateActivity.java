package com.apps.saad.animodule;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;

import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;


public class CreateActivity extends AppCompatActivity {
        int windowwidth;
        int windowheight;
        ImageView ima1,ima2;
        ImageView tv1,tv2;

        private android.widget.RelativeLayout.LayoutParams layoutParams ;
        // private android.widget.RelativeLayout.LayoutParams layoutParams ;
        //private android.widget.RelativeLayout.LayoutParams layoutParams ;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_create);

            windowwidth = getWindowManager().getDefaultDisplay().getWidth();
            windowheight = getWindowManager().getDefaultDisplay().getHeight();


            tv1 = (ImageView) findViewById(R.id.image);
            tv1.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) tv1.getLayoutParams();
                    switch(event.getActionMasked())
                    {
                        case MotionEvent.ACTION_DOWN:
                            break;
                        case MotionEvent.ACTION_MOVE:
                            int x_cord = (int) event.getRawX();
                            int y_cord = (int) event.getRawY();
                            if (x_cord > windowwidth) {
                                x_cord = windowwidth;
                            }
                            if (y_cord > windowheight) {
                                y_cord = windowheight;
                            }
                            layoutParams1.leftMargin = x_cord - 25;
                            layoutParams1.topMargin = y_cord - 75;
                            tv1.setLayoutParams(layoutParams1);
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
            tv2 = (ImageView)findViewById(R.id.image1);
            tv2.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) tv2.getLayoutParams();
                    switch(event.getActionMasked())
                    {
                        case MotionEvent.ACTION_DOWN:
                            break;
                        case MotionEvent.ACTION_MOVE:
                            int x_cord = (int) event.getRawX();
                            int y_cord = (int) event.getRawY();
                            if (x_cord > windowwidth) {
                                x_cord = windowwidth;
                            }
                            if (y_cord > windowheight) {
                                y_cord = windowheight;
                            }
                            layoutParams2.leftMargin = x_cord - 25;
                            layoutParams2.topMargin = y_cord - 75;
                            tv2.setLayoutParams(layoutParams2);
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
        }
    }