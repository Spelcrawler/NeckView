package com.spelcrawler.neckview.parts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;

import androidx.annotation.ColorInt;

import com.spelcrawler.neckview.Drawer;
import com.spelcrawler.neckview.parts.base.FretboardBinding;

public class TrapezeColorFretboardBinding implements FretboardBinding {

    @ColorInt
    private int mColor = Color.WHITE;
    private float mPadding = 25f;
    private float mTrapezeDegree = 65f;

    private final Path mPath = new Path();

    public TrapezeColorFretboardBinding() {}

    public TrapezeColorFretboardBinding(int color, float padding, float trapezeDegree) {
        mColor = color;
        mPadding = padding;
        mTrapezeDegree = trapezeDegree;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }

    public float getPadding() {
        return mPadding;
    }

    public void setPadding(float padding) {
        mPadding = padding;
    }

    public float getTrapezeDegree() {
        return mTrapezeDegree;
    }

    public void setTrapezeDegree(float trapezeDegree) {
        mTrapezeDegree = trapezeDegree;
    }

    @Override
    public void draw(Context context, Canvas canvas, RectF bounds, int fretIndex) {
        bounds.left += mPadding;
        bounds.top += mPadding;
        bounds.right -= mPadding;
        bounds.bottom -= mPadding;

        setupTrapezePath(mPath, bounds, mTrapezeDegree);

        Drawer.drawPath(canvas, mPath, mColor);
    }

    private void setupTrapezePath(Path source, RectF bounds, float degree) {
        //With square triangle formula - b = a * tg(B); B = 90 - A; we know A as degree an b as bounds.width()
        float padding = (float) (bounds.width() * Math.tan(Math.toRadians(90 - degree)));

        source.reset();
        source.moveTo(bounds.left, bounds.bottom);
        source.lineTo(bounds.left, bounds.top);
        source.lineTo(bounds.right, bounds.top + padding);
        source.lineTo(bounds.right, bounds.bottom - padding);
        source.close();
    }

    @Override
    public void draw(Context context, Canvas canvas, RectF bounds) {
        throw new RuntimeException("Use draw(Context, Canvas, RectF, int) method instead of this");
    }

}
