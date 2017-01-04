package com.rongxianren.lsn30_highlevelui_paint.paint_primary_use;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wty on 2016/12/29.
 */

public class CustomPaintView extends View {


    private Paint mPaint;

    public CustomPaintView(Context context) {
        this(context, null);
    }

    public CustomPaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.reset();

        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(30);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setAntiAlias(true);


        Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(500, 100);
        path.lineTo(100, 300);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(path, mPaint);

        path.moveTo(100, 450);
        path.lineTo(200, 550);
        path.lineTo(100, 650);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(path, mPaint);


        path.moveTo(100, 700);
        path.lineTo(500, 700);
        path.lineTo(500, 980);
        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawPath(path, mPaint);

//        mPaint.measureText();
//        mPaint.breakText();
//        mPaint.measureText()

        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();

//        Path path = new Path();
//        path.moveTo(100, 100);
//        path.lineTo(300, 100);
//        path.lineTo(100, 300);
//        mPaint.setStrokeJoin(Paint.Join.MITER);
//        canvas.drawPath(path, mPaint);
//
//        path.moveTo(100, 400);
//        path.lineTo(300, 500);
//        path.lineTo(100, 700);
//        mPaint.setStrokeJoin(Paint.Join.ROUND);
//        canvas.drawPath(path, mPaint);
//
//        path.moveTo(100, 800);
//        path.lineTo(300, 800);
//        path.lineTo(100, 1100);
//        mPaint.setStrokeJoin(Paint.Join.BEVEL);
//        canvas.drawPath(path, mPaint);


    }
}

