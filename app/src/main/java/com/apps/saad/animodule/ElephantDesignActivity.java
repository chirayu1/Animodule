package com.apps.saad.animodule;

import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.content.ClipData;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import static android.os.Build.VERSION_CODES.O;

//Create by Saad Anwar 7/1/2017
public class ElephantDesignActivity extends AppCompatActivity implements OnTouchListener, View.OnClickListener{
    Button main, next,designs,background,color, bred,bmagenta,bblue,bgreen,byellow,bgray,head,ears,
            frontlegs,torso,backlegs,done,bclear;
    ImageButton and, henna,mandala;
    ImageView backarrow, henna2,henna3,henna4,mandala2,mandala3,mandala4,
            and3,and5,and7,elephantearcutout,elephantheadcutout,
            elephantfrontlegscutout,elephantbacklegscutout,elephanttorsocutout;
    HorizontalScrollView tags, ands,hennas,mandalas,backgrounds;
    LinearLayout paintlayout;
    RelativeLayout designedEar,designedHead,designedFrontLegs,designedBackLegs,designedTorso;

    private android.widget.RelativeLayout.LayoutParams layoutParams;
    String msg;
    float dX, dY;

    /*Paint code */
    private PaintPotView v_drawingPad, v2_drawingPad, v3_drawingPad, v4_drawingPad, v5_drawingPad;
    private Button b_red, b_blue, b_green, b_yellow, b_pink, b_gray, b_black, b_white;
    private Button b_undo, b_reset, b_dotSizePlus, b_dotSizeMinus;
    private TextView tv_dotSize;
    private static final int DOT_SIZE_INCREMENT = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_elephant);

        next();         //to go to a different activity
        getItems();     //initializing buttons/images and layouts
        imageLoad();    //loading images using the ids
        partsVisibility();  //making elephant parts visible when clicked on the relative buttons
        designcolorbackground();    //listener for design button/background button and color button
        backgroundmethod();         //setting the background colors
        tabs();                     //flipping between tabs
        listeners();

        /*Paint code */
        this.init();
        this.init2();
        this.init3();
        this.init4();
        this.init5();
    }

    /*Paint code*/
    private void init() {
        b_red = (Button)findViewById(R.id.red_b);
        b_blue = (Button)findViewById(R.id.blue_b);
        b_green = (Button)findViewById(R.id.green_b);
        b_yellow = (Button)findViewById(R.id.yellow_b);
        b_pink = (Button)findViewById(R.id.pink_b);
        b_gray = (Button)findViewById(R.id.gray_b);
        b_black = (Button)findViewById(R.id.black_b);
        b_white = (Button)findViewById(R.id.white_b);
        b_undo = (Button)findViewById(R.id.undo_b);
        b_reset = (Button)findViewById(R.id.reset_b);
        b_dotSizePlus = (Button)findViewById(R.id.dotSizePlus_b);
        b_dotSizeMinus = (Button)findViewById(R.id.dotSizeMinus_b);

        b_red.setOnClickListener(this);
        b_blue.setOnClickListener(this);
        b_green.setOnClickListener(this);
        b_yellow.setOnClickListener(this);
        b_pink.setOnClickListener(this);
        b_gray.setOnClickListener(this);
        b_black.setOnClickListener(this);
        b_white.setOnClickListener(this);
        b_reset.setOnClickListener(this);
        b_undo.setOnClickListener(this);
        b_dotSizePlus.setOnClickListener(this);
        b_dotSizeMinus.setOnClickListener(this);

        v_drawingPad = (PaintPotView) findViewById(R.id.drawingPad_v);

        tv_dotSize = (TextView)findViewById(R.id.dotSize_tv);
        tv_dotSize.setText("Brush Size = " + v_drawingPad.getmDotSize());

    }

    private void init2(){
        b_red.setOnClickListener(this);
        b_blue.setOnClickListener(this);
        b_green.setOnClickListener(this);
        b_yellow.setOnClickListener(this);
        b_pink.setOnClickListener(this);
        b_gray.setOnClickListener(this);
        b_black.setOnClickListener(this);
        b_white.setOnClickListener(this);
        b_reset.setOnClickListener(this);
        b_undo.setOnClickListener(this);
        b_dotSizePlus.setOnClickListener(this);
        b_dotSizeMinus.setOnClickListener(this);

        v2_drawingPad = (PaintPotView) findViewById(R.id.drawingPad_v2);

        tv_dotSize = (TextView)findViewById(R.id.dotSize_tv);
        tv_dotSize.setText("Brush Size = " + v2_drawingPad.getmDotSize());
    }

    private void init3(){
        b_red.setOnClickListener(this);
        b_blue.setOnClickListener(this);
        b_green.setOnClickListener(this);
        b_yellow.setOnClickListener(this);
        b_pink.setOnClickListener(this);
        b_gray.setOnClickListener(this);
        b_black.setOnClickListener(this);
        b_white.setOnClickListener(this);
        b_reset.setOnClickListener(this);
        b_undo.setOnClickListener(this);
        b_dotSizePlus.setOnClickListener(this);
        b_dotSizeMinus.setOnClickListener(this);

        v3_drawingPad = (PaintPotView) findViewById(R.id.drawingPad_v3);

        tv_dotSize = (TextView)findViewById(R.id.dotSize_tv);
        tv_dotSize.setText("Brush Size = " + v3_drawingPad.getmDotSize());
    }

    private void init4(){
        b_red.setOnClickListener(this);
        b_blue.setOnClickListener(this);
        b_green.setOnClickListener(this);
        b_yellow.setOnClickListener(this);
        b_pink.setOnClickListener(this);
        b_gray.setOnClickListener(this);
        b_black.setOnClickListener(this);
        b_white.setOnClickListener(this);
        b_reset.setOnClickListener(this);
        b_undo.setOnClickListener(this);
        b_dotSizePlus.setOnClickListener(this);
        b_dotSizeMinus.setOnClickListener(this);

        v4_drawingPad = (PaintPotView) findViewById(R.id.drawingPad_v4);

        tv_dotSize = (TextView)findViewById(R.id.dotSize_tv);
        tv_dotSize.setText("Brush Size = " + v4_drawingPad.getmDotSize());
    }

    private void init5(){
        b_red.setOnClickListener(this);
        b_blue.setOnClickListener(this);
        b_green.setOnClickListener(this);
        b_yellow.setOnClickListener(this);
        b_pink.setOnClickListener(this);
        b_gray.setOnClickListener(this);
        b_black.setOnClickListener(this);
        b_white.setOnClickListener(this);
        b_reset.setOnClickListener(this);
        b_undo.setOnClickListener(this);
        b_dotSizePlus.setOnClickListener(this);
        b_dotSizeMinus.setOnClickListener(this);

        v5_drawingPad = (PaintPotView) findViewById(R.id.drawingPad_v5);

        tv_dotSize = (TextView)findViewById(R.id.dotSize_tv);
        tv_dotSize.setText("Brush Size = " + v5_drawingPad.getmDotSize());
    }

    /*Paint code*/
    @Override
    public void onClick(View view) {

        Button _b = (Button) findViewById(view.getId());

        switch (view.getId()) {
            case R.id.red_b:
                v_drawingPad.setPenColor(Color.RED);
                v2_drawingPad.setPenColor(Color.RED);
                v3_drawingPad.setPenColor(Color.RED);
                v4_drawingPad.setPenColor(Color.RED);
                v5_drawingPad.setPenColor(Color.RED);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.blue_b:
                v_drawingPad.setPenColor(Color.BLUE);
                v2_drawingPad.setPenColor(Color.BLUE);
                v3_drawingPad.setPenColor(Color.BLUE);
                v4_drawingPad.setPenColor(Color.BLUE);
                v5_drawingPad.setPenColor(Color.BLUE);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.green_b:
                v_drawingPad.setPenColor(Color.GREEN);
                v2_drawingPad.setPenColor(Color.GREEN);
                v3_drawingPad.setPenColor(Color.GREEN);
                v4_drawingPad.setPenColor(Color.GREEN);
                v5_drawingPad.setPenColor(Color.GREEN);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.yellow_b:
                v_drawingPad.setPenColor(Color.YELLOW);
                v2_drawingPad.setPenColor(Color.YELLOW);
                v3_drawingPad.setPenColor(Color.YELLOW);
                v4_drawingPad.setPenColor(Color.YELLOW);
                v5_drawingPad.setPenColor(Color.YELLOW);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.pink_b:
                v_drawingPad.setPenColor(Color.MAGENTA);
                v2_drawingPad.setPenColor(Color.MAGENTA);
                v3_drawingPad.setPenColor(Color.MAGENTA);
                v4_drawingPad.setPenColor(Color.MAGENTA);
                v5_drawingPad.setPenColor(Color.MAGENTA);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.gray_b:
                v_drawingPad.setPenColor(Color.GRAY);
                v2_drawingPad.setPenColor(Color.GRAY);
                v3_drawingPad.setPenColor(Color.GRAY);
                v4_drawingPad.setPenColor(Color.GRAY);
                v5_drawingPad.setPenColor(Color.GRAY);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.black_b:
                v_drawingPad.setPenColor(Color.BLACK);
                v2_drawingPad.setPenColor(Color.BLACK);
                v3_drawingPad.setPenColor(Color.BLACK);
                v4_drawingPad.setPenColor(Color.BLACK);
                v5_drawingPad.setPenColor(Color.BLACK);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.white_b:
                v_drawingPad.setPenColor(Color.WHITE);
                v2_drawingPad.setPenColor(Color.WHITE);
                v3_drawingPad.setPenColor(Color.WHITE);
                v4_drawingPad.setPenColor(Color.WHITE);
                v5_drawingPad.setPenColor(Color.WHITE);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.reset_b:
                v_drawingPad.reset();
                v2_drawingPad.reset();
                v3_drawingPad.reset();
                v4_drawingPad.reset();
                v5_drawingPad.reset();
                tv_dotSize.setText("Brush Size = " + v_drawingPad.getmDotSize());
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.undo_b:
                v_drawingPad.undo();
                v2_drawingPad.undo();
                v3_drawingPad.undo();
                v4_drawingPad.undo();
                v5_drawingPad.undo();
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.dotSizePlus_b:
                v_drawingPad.changeDotSize(+DOT_SIZE_INCREMENT);
                v2_drawingPad.changeDotSize(+DOT_SIZE_INCREMENT);
                v3_drawingPad.changeDotSize(+DOT_SIZE_INCREMENT);
                v4_drawingPad.changeDotSize(+DOT_SIZE_INCREMENT);
                v5_drawingPad.changeDotSize(+DOT_SIZE_INCREMENT);
                tv_dotSize.setText("Brush Size = " + v_drawingPad.getmDotSize());
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.dotSizeMinus_b:
                v_drawingPad.changeDotSize(-DOT_SIZE_INCREMENT);
                v2_drawingPad.changeDotSize(-DOT_SIZE_INCREMENT);
                v3_drawingPad.changeDotSize(-DOT_SIZE_INCREMENT);
                v4_drawingPad.changeDotSize(-DOT_SIZE_INCREMENT);
                v5_drawingPad.changeDotSize(-DOT_SIZE_INCREMENT);
                tv_dotSize.setText("Brush Size = " + v_drawingPad.getmDotSize());
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
        }
    }

    private void next() {
        main = (Button) findViewById(R.id.main);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ElephantDesignActivity.this, SubMainActivity.class);
                startActivity(myIntent);
            }
        });
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ElephantDesignActivity.this, ColorMenuActivity.class);
                startActivity(myIntent);
            }
        });
    }

    private void getItems() {

        designs = (Button) findViewById(R.id.designs);
        background = (Button) findViewById(R.id.background);
        color = (Button) findViewById(R.id.color);
        //done = (Button) findViewById(R.id.done);

        paintlayout = (LinearLayout) findViewById(R.id.paintlayout);

        and = (ImageButton) findViewById(R.id.and1);
        henna = (ImageButton) findViewById(R.id.henna1);
        mandala = (ImageButton) findViewById(R.id.mandala1);
        backarrow= (ImageView) findViewById(R.id.backarrow);

        tags = (HorizontalScrollView) findViewById(R.id.tags);
        backgrounds = (HorizontalScrollView) findViewById(R.id.backgrounds);
        ands = (HorizontalScrollView) findViewById(R.id.ands);
        hennas = (HorizontalScrollView) findViewById(R.id.hennas);
        mandalas = (HorizontalScrollView) findViewById(R.id.mandalas);
    }

    private void imageLoad(){
        and3= (ImageView) findViewById(R.id.and3);
        and5= (ImageView) findViewById(R.id.and5);
        and7= (ImageView) findViewById(R.id.and7);
        henna2= (ImageView) findViewById(R.id.henna2);
        henna3= (ImageView) findViewById(R.id.henna3);
        henna4= (ImageView) findViewById(R.id.henna4);
        mandala2= (ImageView) findViewById(R.id.mandala2);
        mandala3= (ImageView) findViewById(R.id.mandala3);
        mandala4= (ImageView) findViewById(R.id.mandala4);

        Glide.with(this)
                .load(R.drawable.henna2)
                .into(henna2);
        Glide.with(this)
                .load(R.drawable.henna3)
                .into(henna3);
        Glide.with(this)
                .load(R.drawable.henna4)
                .into(henna4);
        Glide.with(this)
                .load(R.drawable.mandala2)
                .into(mandala2);
        Glide.with(this)
                .load(R.drawable.mandala3)
                .into(mandala3);
        Glide.with(this)
                .load(R.drawable.mandala4)
                .into(mandala4);
        Glide.with(this)
                .load(R.drawable.and5)
                .into(and3);
        Glide.with(this)
                .load(R.drawable.and7)
                .into(and5);
        Glide.with(this)
                .load(R.drawable.and117)
                .into(and7);
        /*
        Glide.with(this)
                .load(R.drawable.elephantheadcutout)
                .into(elephantheadcutout);
        Glide.with(this)
                .load(R.drawable.elephantearcutout)
                .into(elephantearcutout);
        Glide.with(this)
                .load(R.drawable.elephantfrontlegscutout)
                .into(elephantfrontlegscutout);
        Glide.with(this)
                .load(R.drawable.elephanttorsocutout)
                .into(elephanttorsocutout);
        Glide.with(this)
                .load(R.drawable.elephantbacklegscutout)
                .into(elephantbacklegscutout);
*/
        //elephantheadcutout.setImageResource(R.drawable.elephantheadcutout);
        //elephantearcutout.setImageResource(R.drawable.elephantearcutout);
        //elephantfrontlegscutout.setImageResource(R.drawable.elephantfrontlegscutout);
        //elephantheadcutout.setImageResource(R.drawable.elephantheadcutout);
        //elephantheadcutout.setImageResource(R.drawable.elephantheadcutout);
    }

    private void partsVisibility(){
        designedEar = (RelativeLayout) findViewById(R.id.designedEar);
        designedHead = (RelativeLayout) findViewById(R.id.designedHead);
        designedFrontLegs = (RelativeLayout) findViewById(R.id.designedFrontLegs);
        designedBackLegs = (RelativeLayout) findViewById(R.id.designedBackLegs);
        designedTorso = (RelativeLayout) findViewById(R.id.designedTorso);
        head = (Button) findViewById(R.id.elephanthead);
        ears = (Button) findViewById(R.id.elephantears);
        frontlegs = (Button) findViewById(R.id.elephantfrontlegs);
        backlegs = (Button) findViewById(R.id.elephantbacklegs);
        torso = (Button) findViewById(R.id.elephanttorso);

        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                head.setBackgroundResource(R.drawable.clicked_parts_button_shape);
                ears.setBackgroundResource(R.drawable.parts_button_shape);
                frontlegs.setBackgroundResource(R.drawable.parts_button_shape);
                backlegs.setBackgroundResource(R.drawable.parts_button_shape);
                torso.setBackgroundResource(R.drawable.parts_button_shape);
                designedHead.setVisibility(View.VISIBLE);
                designedEar.setVisibility(View.GONE);
                designedFrontLegs.setVisibility(View.GONE);
                designedBackLegs.setVisibility(View.GONE);
                designedTorso.setVisibility(View.GONE);

            }
        });

        ears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ears.setBackgroundResource(R.drawable.clicked_parts_button_shape);
                head.setBackgroundResource(R.drawable.parts_button_shape);
                frontlegs.setBackgroundResource(R.drawable.parts_button_shape);
                backlegs.setBackgroundResource(R.drawable.parts_button_shape);
                torso.setBackgroundResource(R.drawable.parts_button_shape);
                designedEar.setVisibility(View.VISIBLE);
                designedHead.setVisibility(View.GONE);
                designedFrontLegs.setVisibility(View.GONE);
                designedBackLegs.setVisibility(View.GONE);
                designedTorso.setVisibility(View.GONE);
            }
        });
        frontlegs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frontlegs.setBackgroundResource(R.drawable.clicked_parts_button_shape);
                head.setBackgroundResource(R.drawable.parts_button_shape);
                ears.setBackgroundResource(R.drawable.parts_button_shape);
                backlegs.setBackgroundResource(R.drawable.parts_button_shape);
                torso.setBackgroundResource(R.drawable.parts_button_shape);
                designedEar.setVisibility(View.GONE);
                designedHead.setVisibility(View.GONE);
                designedFrontLegs.setVisibility(View.VISIBLE);
                designedBackLegs.setVisibility(View.GONE);
                designedTorso.setVisibility(View.GONE);
            }
        });
        backlegs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backlegs.setBackgroundResource(R.drawable.clicked_parts_button_shape);
                ears.setBackgroundResource(R.drawable.parts_button_shape);
                head.setBackgroundResource(R.drawable.parts_button_shape);
                frontlegs.setBackgroundResource(R.drawable.parts_button_shape);
                torso.setBackgroundResource(R.drawable.parts_button_shape);
                designedEar.setVisibility(View.GONE);
                designedHead.setVisibility(View.GONE);
                designedFrontLegs.setVisibility(View.GONE);
                designedBackLegs.setVisibility(View.VISIBLE);
                designedTorso.setVisibility(View.GONE);
            }
        });
        torso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                torso.setBackgroundResource(R.drawable.clicked_parts_button_shape);
                head.setBackgroundResource(R.drawable.parts_button_shape);
                frontlegs.setBackgroundResource(R.drawable.parts_button_shape);
                backlegs.setBackgroundResource(R.drawable.parts_button_shape);
                ears.setBackgroundResource(R.drawable.parts_button_shape);
                designedEar.setVisibility(View.GONE);
                designedHead.setVisibility(View.GONE);
                designedFrontLegs.setVisibility(View.GONE);
                designedBackLegs.setVisibility(View.GONE);
                designedTorso.setVisibility(View.VISIBLE);
            }
        });
    }

    private void designcolorbackground(){
        designs.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                designs.setBackgroundResource(R.drawable.clicked_design_button_shape);
                background.setBackgroundResource(R.drawable.background_button_shape);
                color.setBackgroundResource(R.drawable.color_button_shape);
                tags.setVisibility(View.VISIBLE);
                ands.setVisibility(View.GONE);
                hennas.setVisibility(View.GONE);
                mandalas.setVisibility(View.GONE);
                backgrounds.setVisibility(View.GONE);
                paintlayout.setVisibility(View.GONE);
            }
        });
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                designs.setBackgroundResource(R.drawable.design_button_shape);
                color.setBackgroundResource(R.drawable.color_button_shape);
                background.setBackgroundResource(R.drawable.clicked_background_button_shape);

                tags.setVisibility(View.GONE);
                ands.setVisibility(View.GONE);
                hennas.setVisibility(View.GONE);
                mandalas.setVisibility(View.GONE);
                backgrounds.setVisibility(View.VISIBLE);
                backarrow.setVisibility(View.GONE);
                paintlayout.setVisibility(View.GONE);
            }
        });
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                color.setBackgroundResource(R.drawable.clicked_color_button_shape);
                designs.setBackgroundResource(R.drawable.design_button_shape);
                background.setBackgroundResource(R.drawable.background_button_shape);
                paintlayout.setVisibility(View.VISIBLE);
                tags.setVisibility(View.GONE);
                ands.setVisibility(View.GONE);
                hennas.setVisibility(View.GONE);
                mandalas.setVisibility(View.GONE);
                backgrounds.setVisibility(View.GONE);
                backarrow.setVisibility(View.GONE);
            }
        });
    }
//To change colors of the background of the animal parts
    private void backgroundmethod(){
        bred= (Button) findViewById(R.id.bred);
        bmagenta= (Button) findViewById(R.id.bmagenta);
        bblue= (Button) findViewById(R.id.bblue);
        byellow= (Button) findViewById(R.id.byellow);
        bgreen= (Button) findViewById(R.id.bgreen);
        bgray= (Button) findViewById(R.id.bgray);
        bclear= (Button) findViewById(R.id.bclear);

        elephantearcutout= (ImageView) findViewById(R.id.elephantearcutout);
        elephantheadcutout= (ImageView) findViewById(R.id.elephantheadcutout);
        elephantfrontlegscutout= (ImageView) findViewById(R.id.elephantfrontlegscutout);
        elephantbacklegscutout= (ImageView) findViewById(R.id.elephantbacklegscutout);
        elephanttorsocutout= (ImageView) findViewById(R.id.elephanttorsocutout);
        bred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (designedEar.getVisibility()==View.VISIBLE)
                    elephantearcutout.setColorFilter(Color.RED);
                if(designedHead.getVisibility()==View.VISIBLE)
                    elephantheadcutout.setColorFilter(Color.RED);
                if(designedFrontLegs.getVisibility()==View.VISIBLE)
                    elephantfrontlegscutout.setColorFilter(Color.RED);
                if(designedBackLegs.getVisibility()==View.VISIBLE)
                    elephantbacklegscutout.setColorFilter(Color.RED);
                if(designedTorso.getVisibility()==View.VISIBLE)
                    elephanttorsocutout.setColorFilter(Color.RED);

            }
        });
        bmagenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (designedEar.getVisibility()==View.VISIBLE)
                    elephantearcutout.setColorFilter(Color.MAGENTA);
                if(designedHead.getVisibility()==View.VISIBLE)
                    elephantheadcutout.setColorFilter(Color.MAGENTA);
                if(designedFrontLegs.getVisibility()==View.VISIBLE)
                    elephantfrontlegscutout.setColorFilter(Color.MAGENTA);
                if(designedBackLegs.getVisibility()==View.VISIBLE)
                    elephantbacklegscutout.setColorFilter(Color.MAGENTA);
                if(designedTorso.getVisibility()==View.VISIBLE)
                    elephanttorsocutout.setColorFilter(Color.MAGENTA);
            }
        });
        bblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (designedEar.getVisibility()==View.VISIBLE)
                    elephantearcutout.setColorFilter(Color.BLUE);
                if(designedHead.getVisibility()==View.VISIBLE)
                    elephantheadcutout.setColorFilter(Color.BLUE);
                if(designedFrontLegs.getVisibility()==View.VISIBLE)
                    elephantfrontlegscutout.setColorFilter(Color.BLUE);
                if(designedBackLegs.getVisibility()==View.VISIBLE)
                    elephantbacklegscutout.setColorFilter(Color.BLUE);
                if(designedTorso.getVisibility()==View.VISIBLE)
                    elephanttorsocutout.setColorFilter(Color.BLUE);
            }
        });
        byellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (designedEar.getVisibility()==View.VISIBLE)
                    elephantearcutout.setColorFilter(Color.YELLOW);
                if(designedHead.getVisibility()==View.VISIBLE)
                    elephantheadcutout.setColorFilter(Color.YELLOW);
                if(designedFrontLegs.getVisibility()==View.VISIBLE)
                    elephantfrontlegscutout.setColorFilter(Color.YELLOW);
                if(designedBackLegs.getVisibility()==View.VISIBLE)
                    elephantbacklegscutout.setColorFilter(Color.YELLOW);
                if(designedTorso.getVisibility()==View.VISIBLE)
                    elephanttorsocutout.setColorFilter(Color.YELLOW);
            }
        });
        bgray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (designedEar.getVisibility()==View.VISIBLE)
                    elephantearcutout.setColorFilter(Color.GRAY);
                if(designedHead.getVisibility()==View.VISIBLE)
                    elephantheadcutout.setColorFilter(Color.GRAY);
                if(designedFrontLegs.getVisibility()==View.VISIBLE)
                    elephantfrontlegscutout.setColorFilter(Color.GRAY);
                if(designedBackLegs.getVisibility()==View.VISIBLE)
                    elephantbacklegscutout.setColorFilter(Color.GRAY);
                if(designedTorso.getVisibility()==View.VISIBLE)
                    elephanttorsocutout.setColorFilter(Color.GRAY);
            }
        });
        bgreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (designedEar.getVisibility()==View.VISIBLE)
                    elephantearcutout.setColorFilter(Color.GREEN);
                if(designedHead.getVisibility()==View.VISIBLE)
                    elephantheadcutout.setColorFilter(Color.GREEN);
                if(designedFrontLegs.getVisibility()==View.VISIBLE)
                    elephantfrontlegscutout.setColorFilter(Color.GREEN);
                if(designedBackLegs.getVisibility()==View.VISIBLE)
                    elephantbacklegscutout.setColorFilter(Color.GREEN);
                if(designedTorso.getVisibility()==View.VISIBLE)
                    elephanttorsocutout.setColorFilter(Color.GREEN);
            }
        });
        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (designedEar.getVisibility()==View.VISIBLE)
                    elephantearcutout.clearColorFilter();
                if(designedHead.getVisibility()==View.VISIBLE)
                    elephantheadcutout.clearColorFilter();
                if(designedFrontLegs.getVisibility()==View.VISIBLE)
                    elephantfrontlegscutout.clearColorFilter();
                if(designedBackLegs.getVisibility()==View.VISIBLE)
                    elephantbacklegscutout.clearColorFilter();
                if(designedTorso.getVisibility()==View.VISIBLE)
                    elephanttorsocutout.clearColorFilter();
            }
        });
    }

    private void tabs() {
        and.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ands.setVisibility(View.VISIBLE);
                tags.setVisibility(View.GONE);
                hennas.setVisibility(View.GONE);
                mandalas.setVisibility(View.GONE);
                backgrounds.setVisibility(View.GONE);
                backarrow.setVisibility(View.VISIBLE);
                paintlayout.setVisibility(View.GONE);
            }
        });
        henna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hennas.setVisibility(View.VISIBLE);
                ands.setVisibility(View.GONE);
                tags.setVisibility(View.GONE);
                mandalas.setVisibility(View.GONE);
                backgrounds.setVisibility(View.GONE);
                backarrow.setVisibility(View.VISIBLE);
                paintlayout.setVisibility(View.GONE);
            }
        });
        mandala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mandalas.setVisibility(View.VISIBLE);
                hennas.setVisibility(View.GONE);
                ands.setVisibility(View.GONE);
                tags.setVisibility(View.GONE);
                backgrounds.setVisibility(View.GONE);
                backarrow.setVisibility(View.VISIBLE);
                paintlayout.setVisibility(View.GONE);

            }
        });


        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tags.setVisibility(View.VISIBLE);
                ands.setVisibility(View.GONE);
                hennas.setVisibility(View.GONE);
                mandalas.setVisibility(View.GONE);
                backgrounds.setVisibility(View.GONE);
                paintlayout.setVisibility(View.GONE);
                backarrow.setVisibility(View.GONE);
            }
        });

    }

    private void listeners() {


        findViewById(R.id.henna2).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.henna3).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.henna4).setOnTouchListener(new MyTouchListener());


        findViewById(R.id.mandala2).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.mandala3).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.mandala4).setOnTouchListener(new MyTouchListener());

        findViewById(R.id.and3).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.and5).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.and7).setOnTouchListener(new MyTouchListener());

        designedEar.setOnDragListener(new MyDragListener());
        designedHead.setOnDragListener(new MyDragListener());
        designedFrontLegs.setOnDragListener(new MyDragListener());
        designedTorso.setOnDragListener(new MyDragListener());
        designedBackLegs.setOnDragListener(new MyDragListener());
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {



        return true;
    }

    private final class MyTouchListener implements OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

                view.startDrag(data, shadowBuilder, view, 0);

                return true;
            } else {
                return false;
            }
        }
    }
/*
    @Override
    public boolean onLongClick(View v) {
        ClipData.Item item = new ClipData.Item((CharSequence)v.getTag());
        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

        ClipData dragData = new ClipData(v.getTag().toString(),mimeTypes, item);
        View.DragShadowBuilder myShadow = new View.DragShadowBuilder(v);

        v.startDrag(dragData,myShadow,null,0);
        return true;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        switch(event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                layoutParams = (RelativeLayout.LayoutParams)v.getLayoutParams();
                Log.d(msg, "Action is DragEvent.ACTION_DRAG_STARTED");

                // Do nothing
                break;

            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
                int x_cord = (int) event.getX();
                int y_cord = (int) event.getY();
                break;

            case DragEvent.ACTION_DRAG_EXITED :
                Log.d(msg, "Action is DragEvent.ACTION_DRAG_EXITED");
                x_cord = (int) event.getX();
                y_cord = (int) event.getY();
                layoutParams.leftMargin = x_cord;
                layoutParams.topMargin = y_cord;
                v.setLayoutParams(layoutParams);
                break;

            case DragEvent.ACTION_DRAG_LOCATION  :
                Log.d(msg, "Action is DragEvent.ACTION_DRAG_LOCATION");
                x_cord = (int) event.getX();
                y_cord = (int) event.getY();
                break;

            case DragEvent.ACTION_DRAG_ENDED   :
                Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENDED");

                // Do nothing
                break;

            case DragEvent.ACTION_DROP:
                Log.d(msg, "ACTION_DROP event");

                // Do nothing
                break;
            default: break;
        }
        return true;
    }
    */


    private class MyDragListener implements OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();

            if(designedHead.getVisibility()==View.VISIBLE) {
                RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) designedHead.getLayoutParams();
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // do nothing
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DRAG_LOCATION:

                        break;
                    case DragEvent.ACTION_DROP:
                        // Dropped, reassign View to ViewGroup
                        final PhotoView target = (PhotoView) findViewById(R.id.blank1);
                        View view = (View) event.getLocalState();

                        ImageView oldView = (ImageView) view;
                        ImageView newView = new ImageView(getApplicationContext());
                        newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());

                        final ImageView dragged = newView;

                        Drawable target_draw = target.getDrawable();
                        Drawable dragged_draw = dragged.getDrawable();

                        dragged.setImageDrawable(target_draw);
                        target.setImageDrawable(dragged_draw);
                        /*
                        ViewGroup from = (ViewGroup) view.getParent();
                        from.removeView(view);
                        LinearLayout to = (LinearLayout) v;
                        to.addView(view);
                        */
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            dragged.setBackground(null);
                            target.setBackground(null);
                        }

                        target.setOnTouchListener(new View.OnTouchListener() {

                            @Override
                            public boolean onTouch(View view, MotionEvent event) {
                                switch(event.getAction() & MotionEvent.ACTION_MASK)
                                {
                                    case MotionEvent.ACTION_DOWN:
                                        dX = view.getX() - event.getRawX();
                                        dY = view.getY() - event.getRawY();
                                        break;
                                    case MotionEvent.ACTION_MOVE:
                                        view.animate()
                                                .x(event.getRawX() + dX)
                                                .y(event.getRawY() + dY)
                                                .setDuration(0)
                                                .start();
                                        break;
                                    default:
                                        break;
                                }
                                return true;
                            }
                        });
                        /*
                        done.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                target.buildDrawingCache();
                                Bitmap bmap = target.getDrawingCache();
                            }
                        });
*/
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                    default:
                        break;

                }
            }
            else if(designedEar.getVisibility()==View.VISIBLE) {
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // do nothing
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DROP:
                        // Dropped, reassign View to ViewGroup
                        PhotoView target = (PhotoView) findViewById(R.id.blank2);
                        View view = (View) event.getLocalState();

                        ImageView oldView = (ImageView) view;
                        ImageView newView = new ImageView(getApplicationContext());
                        newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());

                        ImageView dragged = newView;

                        Drawable target_draw = target.getDrawable();
                        Drawable dragged_draw = dragged.getDrawable();

                        dragged.setImageDrawable(target_draw);
                        target.setImageDrawable(dragged_draw);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            dragged.setBackground(null);
                        }
                        target.setOnTouchListener(new View.OnTouchListener() {

                            @Override
                            public boolean onTouch(View view, MotionEvent event) {
                                switch(event.getAction() & MotionEvent.ACTION_MASK)
                                {
                                    case MotionEvent.ACTION_DOWN:
                                        dX = view.getX() - event.getRawX();
                                        dY = view.getY() - event.getRawY();
                                        break;
                                    case MotionEvent.ACTION_MOVE:
                                        view.animate()
                                                .x(event.getRawX() + dX)
                                                .y(event.getRawY() + dY)
                                                .setDuration(0)
                                                .start();
                                        break;
                                    default:
                                        break;
                                }
                                return true;
                            }
                        });
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                    default:
                        break;
                }
            }
            else if(designedFrontLegs.getVisibility()==View.VISIBLE) {
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // do nothing
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DROP:
                        // Dropped, reassign View to ViewGroup
                        PhotoView target = (PhotoView) findViewById(R.id.blank3);
                        View view = (View) event.getLocalState();

                        ImageView oldView = (ImageView) view;
                        ImageView newView = new ImageView(getApplicationContext());
                        newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());

                        ImageView dragged = newView;

                        Drawable target_draw = target.getDrawable();
                        Drawable dragged_draw = dragged.getDrawable();

                        dragged.setImageDrawable(target_draw);
                        target.setImageDrawable(dragged_draw);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            dragged.setBackground(null);
                        }
                        target.setOnTouchListener(new View.OnTouchListener() {

                            @Override
                            public boolean onTouch(View view, MotionEvent event) {
                                switch(event.getAction() & MotionEvent.ACTION_MASK)
                                {
                                    case MotionEvent.ACTION_DOWN:
                                        dX = view.getX() - event.getRawX();
                                        dY = view.getY() - event.getRawY();
                                        break;
                                    case MotionEvent.ACTION_MOVE:
                                        view.animate()
                                                .x(event.getRawX() + dX)
                                                .y(event.getRawY() + dY)
                                                .setDuration(0)
                                                .start();
                                        break;
                                    default:
                                        break;
                                }
                                return true;
                            }
                        });
                        break;

                    case DragEvent.ACTION_DRAG_ENDED:
                    default:
                        break;
                }
            }
            else if(designedTorso.getVisibility()==View.VISIBLE) {
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // do nothing
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DROP:
                        // Dropped, reassign View to ViewGroup
                        PhotoView target = (PhotoView) findViewById(R.id.blank4);
                        View view = (View) event.getLocalState();

                        ImageView oldView = (ImageView) view;
                        ImageView newView = new ImageView(getApplicationContext());
                        newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());

                        ImageView dragged = newView;

                        Drawable target_draw = target.getDrawable();
                        Drawable dragged_draw = dragged.getDrawable();

                        dragged.setImageDrawable(target_draw);
                        target.setImageDrawable(dragged_draw);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            dragged.setBackground(null);
                        }
                        target.setOnTouchListener(new View.OnTouchListener() {

                            @Override
                            public boolean onTouch(View view, MotionEvent event) {
                                switch(event.getAction() & MotionEvent.ACTION_MASK)
                                {
                                    case MotionEvent.ACTION_DOWN:
                                        dX = view.getX() - event.getRawX();
                                        dY = view.getY() - event.getRawY();
                                        break;
                                    case MotionEvent.ACTION_MOVE:
                                        view.animate()
                                                .x(event.getRawX() + dX)
                                                .y(event.getRawY() + dY)
                                                .setDuration(0)
                                                .start();
                                        break;
                                    default:
                                        break;
                                }
                                return true;
                            }
                        });
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                    default:
                        break;
                }
            }
            else if(designedBackLegs.getVisibility()==View.VISIBLE) {
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // do nothing
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DROP:
                        // Dropped, reassign View to ViewGroup
                        PhotoView target = (PhotoView) findViewById(R.id.blank5);
                        View view = (View) event.getLocalState();

                        ImageView oldView = (ImageView) view;
                        ImageView newView = new ImageView(getApplicationContext());
                        newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());

                        ImageView dragged = newView;

                        Drawable target_draw = target.getDrawable();
                        Drawable dragged_draw = dragged.getDrawable();

                        dragged.setImageDrawable(target_draw);
                        target.setImageDrawable(dragged_draw);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            dragged.setBackground(null);
                        }
                        target.setOnTouchListener(new View.OnTouchListener() {

                            @Override
                            public boolean onTouch(View view, MotionEvent event) {
                                switch(event.getAction() & MotionEvent.ACTION_MASK)
                                {
                                    case MotionEvent.ACTION_DOWN:
                                        dX = view.getX() - event.getRawX();
                                        dY = view.getY() - event.getRawY();
                                        break;
                                    case MotionEvent.ACTION_MOVE:
                                        view.animate()
                                                .x(event.getRawX() + dX)
                                                .y(event.getRawY() + dY)
                                                .setDuration(0)
                                                .start();
                                        break;
                                    default:
                                        break;
                                }
                                return true;
                            }
                        });
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                    default:
                        break;
                }
            }
            return true;
        }
    }


}

