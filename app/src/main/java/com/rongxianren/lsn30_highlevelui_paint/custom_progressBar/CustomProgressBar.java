package com.rongxianren.lsn30_highlevelui_paint.custom_progressBar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.rongxianren.lsn30_highlevelui_paint.R;

/**
 * Created by wty on 2017/1/4.
 */

public class CustomProgressBar extends View {

    private float mRoundWidth = 0;
    private int mRoundColor = 0;
    private float mTextSize = 0;
    private float mTextColor = 0;
    private boolean isFill = false;
    private boolean textShow = false;
    private Paint mPaint;
    private Paint mTextPaint;


    private float mMax = 100;
    private float progress = 0;

    public CustomProgressBar(Context context) {
        this(context, null);
    }

    public CustomProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mTextPaint = new Paint();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressBar);
        mRoundWidth = typedArray.getDimension(R.styleable.CustomProgressBar_round_width, 20);
        mRoundColor = typedArray.getColor(R.styleable.CustomProgressBar_round_color, getResources().getColor(R.color.colorAccent));
        mTextSize = typedArray.getDimension(R.styleable.CustomProgressBar_text_size, 5);
        mTextColor = typedArray.getColor(R.styleable.CustomProgressBar_text_color, getResources().getColor(R.color.colorAccent));
        isFill = typedArray.getBoolean(R.styleable.CustomProgressBar_is_fill, false);
        textShow = typedArray.getBoolean(R.styleable.CustomProgressBar_text_show, false);
        typedArray.recycle();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int radius = (int) (this.getWidth() / 2 - mRoundWidth);
        int center = this.getWidth() / 2;
        mPaint.setAntiAlias(true);
        mPaint.setColor(mRoundColor);
        mPaint.setStrokeWidth(mRoundWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(center, center, radius, mPaint);


        float percent = progress / mMax;
        if (textShow && percent != 0) {

            mTextPaint.setAntiAlias(true);

            /**
             * 测量文本宽度 大小记得要在 setTextSize之后  再进行测量
             */
            mTextPaint.setTextSize(mTextSize);

            Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
            System.out.println("---------onDraw---------- = " + mTextPaint.measureText((int) (percent * 100) + "%"));
            float centerX = (this.getWidth() - mTextPaint.measureText((int) (percent * 100) + "%")) / 2f;
            float centerY_1 = this.getWidth() / 2f + ((fontMetrics.bottom - fontMetrics.top) / 2f - fontMetrics.bottom);
            float centerY = getWidth() / 2f - (mTextPaint.descent() + mTextPaint.ascent()) / 2f;

            mTextPaint.setColor(getResources().getColor(R.color.colorAccent));
//            canvas.drawLine(centerX, centerY, centerX + 500, centerY, mTextPaint);
//            canvas.drawLine(centerX, centerY_1, centerX + 500, centerY_1, mTextPaint);
            canvas.drawText((int) (percent * 100) + "%", centerX, centerY_1, mTextPaint);
        }


        mPaint.setColor(getResources().getColor(R.color.colorPrimaryDark));
        RectF rectF = new RectF(center - radius, center - radius, center + radius, center + radius);
        canvas.drawArc(rectF, 90f, 360 * percent, false, mPaint);
    }


    public float getmMax() {
        return mMax;
    }

    public void setmMax(float mMax) {
        this.mMax = mMax;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        postInvalidate();
    }
}
