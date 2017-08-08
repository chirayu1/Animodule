package com.apps.saad.animodule;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Parash on 7/15/17.
 */

public class PaintPotView extends View implements View.OnTouchListener{
    private final int DEFAULT_DOT_SIZE = 25;
    private final int MAX_DOT_SIZE = 100;
    private final int MIN_DOT_SIZE = 10;
    private final int DEFAULT_COLOR = Color.GRAY;
    private int mDotSize;
    private int mPenColor;
    private float mX, mY, mOldX, mOldY;

    private ArrayList<Path> mPaths;
    private ArrayList<Paint> mPaints;
    private Path mPath;
    private Paint mPaint;


    public PaintPotView(Context context) {
        super(context);
        this.init();
    }

    public PaintPotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public PaintPotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {
        mDotSize = DEFAULT_DOT_SIZE;
        mPenColor = DEFAULT_COLOR;
        mPaths = new ArrayList<Path>();
        mPaints = new ArrayList<Paint>();
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setColor(mPenColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mX = mY = mOldX = mOldY = (float)0.0;
        this.addPath(false);
        this.setOnTouchListener(this);
    }

    private void addPath(boolean fill){
        mPath = new Path();
        mPaths.add(mPath);
        mPaint = new Paint();
        mPaints.add(mPaint);
        mPaint.setColor(mPenColor);
        if (!fill)
            mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mDotSize);
    }


    public int getmPenColor() {
        return mPenColor;
    }

    public int getmDotSize() {
        return mDotSize;
    }

    public void setPenColor(int PenColor) {
        this.mPenColor = PenColor;
    }

    public void changeDotSize(int increment) {
        this.mDotSize += increment;
        this.mDotSize = Math.max(mDotSize, MIN_DOT_SIZE);
        this.mDotSize = Math.min(mDotSize, MAX_DOT_SIZE);
    }

    public void reset() {
        this.init();
        this.invalidate();
    }

    public void undo() {
        if (mPaths.size() > 0) {
            mPaths.remove(mPaths.size() - 1);
            mPaints.remove(mPaints.size() - 1);
            mPaths.remove(mPaths.size() - 1);
            mPaints.remove(mPaints.size() - 1);
            mPaths.remove(mPaths.size() - 1);
            mPaints.remove(mPaints.size() - 1);

            this.invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i=0; i<mPaths.size(); ++i)
            canvas.drawPath(mPaths.get(i), mPaints.get(i));
    }

    @Override
    public boolean onTouch(View v, MotionEvent motionEvent) {
        mX = motionEvent.getX();
        mY = motionEvent.getY();
        Log.d("Touched:", " (" + mX + "," + mY + ")");

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.addPath(true);
                this.mPath.addCircle(mX, mY, mDotSize/2, Path.Direction.CW);
                this.addPath(false);
                this.mPath.moveTo(mX, mY);
                break;
            case MotionEvent.ACTION_MOVE:
                this.mPath.lineTo(mX, mY);
                break;
            case MotionEvent.ACTION_UP:
                this.addPath(true);
                if (mOldX == mX && mOldY == mY)
                    this.mPath.addCircle(mX, mY, mDotSize/2, Path.Direction.CW);
                break;

        }
        this.invalidate();
        mOldX = mX;
        mOldY = mY;
        return true;
    }
}
