package com.innsmap.wyl.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import static com.innsmap.wyl.customview.utils.Tool.getScreenWidth;

/**
 * 作者：Created by wangyl on 2019/1/17 14:48
 * 邮箱：yonglin.wang@innsmap.com
 * http://www.apkbus.com/blog-873057-79397.html 博客页面
 */

public class DynamicLine extends View {
    private float startX, stopX;//的起始X,终止X坐标。
    private Paint paint;
    private RectF rectF = new RectF(startX, 0, stopX, 0);//RectF指的是float精度的矩形


    public DynamicLine(Context context) {
        this(context, null);
    }

    public DynamicLine(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DynamicLine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿
        paint.setStyle(Paint.Style.FILL);//填充
        paint.setStrokeWidth(5);//画笔宽度
        paint.setShader(new LinearGradient(0, 100, getScreenWidth(getContext()), 100, Color.parseColor("#ffc125"), Color.parseColor("#ff4500"), Shader.TileMode.MIRROR));//设置画笔渐变色
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {//自定义DynamicLine的高度
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(20, MeasureSpec.getMode(heightMeasureSpec));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        rectF.set(startX, 0, stopX, 10);
        canvas.drawRoundRect(rectF, 5, 5, paint);//圆角矩形的圆角的曲率
    }


    /**
     * 根据起始、终止坐标更新黄色圆角，进行重新绘制
     * @param startX
     * @param stopX
     */
    public void updateView(float startX, float stopX) {//
        this.startX = startX;
        this.stopX = stopX;
        invalidate();
    }
}