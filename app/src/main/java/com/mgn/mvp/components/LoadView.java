package com.mgn.mvp.components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.mgn.mvp.util.Display;

/**
 * Created by Mi on 3/9/21
 */
public class LoadView extends View {

    private float width;
    private float height;
    private float strokeWdith;
    private float progress;
    private Context context;

    public LoadView(Context context) {
        this(context, null);
    }

    public LoadView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context.getApplicationContext();
        init(context, attrs);
    }

    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthModel = MeasureSpec.getMode(widthMeasureSpec);
        int heightModel = MeasureSpec.getMode(heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        switch (widthModel) {
            case MeasureSpec.AT_MOST:
                width = Display.getWindowWidthPixels(context) / 2;
                break;
            case MeasureSpec.EXACTLY:
                width = widthSize;
                break;
            case MeasureSpec.UNSPECIFIED:
                log("UNSPECIFIED");
                break;
        }

        switch (heightModel) {
            case MeasureSpec.AT_MOST:
                height = Display.getWindowWidthPixels(context) / 2;
                break;
            case MeasureSpec.EXACTLY:
                height = heightSize;
                break;
            case MeasureSpec.UNSPECIFIED:
                log("UNSPECIFIED");
                break;
        }

        setMeasuredDimension((int) width, (int) height);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    @SuppressLint("DrawAllocation")
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(strokeWdith);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(strokeWdith / 2, strokeWdith / 2, width - strokeWdith / 2, height - strokeWdith / 2, -90, progress * 360, false, paint);
    }

    private void log(Object object) {
        Log.i("miguangning", String.valueOf(object));
    }

    private void init(Context context, AttributeSet attrs) {
        //TODO 从布局中获取参数值
        strokeWdith = 50;

        progress = 0;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }
}
