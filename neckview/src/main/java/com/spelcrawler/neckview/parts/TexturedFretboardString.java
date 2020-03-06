package com.spelcrawler.neckview.parts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;

import androidx.annotation.ColorInt;

import com.spelcrawler.neckview.Drawer;
import com.spelcrawler.neckview.parts.base.FretboardString;

public class TexturedFretboardString implements FretboardString {

    @ColorInt
    private static final int SHADOW_COLOR = 0x50000000;

    @ColorInt
    private int mStringColor;
    private float mWoundWidth = 10f;

    private RectF mShadowBounds = new RectF();



    public TexturedFretboardString(int stringColor) {
        mStringColor = stringColor;
    }

    public int getStringColor() {
        return mStringColor;
    }

    public void setStringColor(int stringColor) {
        mStringColor = stringColor;
    }

    public float getWoundWidth() {
        return mWoundWidth;
    }

    public void setWoundWidth(float woundWidth) {
        mWoundWidth = woundWidth;
    }

    @Override
    public void draw(Context context, Canvas canvas, RectF bounds, boolean wounded) {
        if (wounded) {
            drawWounded(canvas, bounds);
        } else {
            drawSimple(canvas, bounds);
        }
    }

    private void drawWounded(Canvas canvas, RectF bounds) {
        Drawer.drawColor(canvas, mStringColor, bounds);

        float woundWidth = bounds.height() * 0.3f;

        for (float position = bounds.left; position < bounds.right; position += woundWidth) {
            Drawer.drawLine(canvas, position, bounds.top, position, bounds.bottom, SHADOW_COLOR, 2f);
        }

        drawShadows(canvas, bounds);
    }

    private void drawShadows(Canvas canvas, RectF bounds) {
        mShadowBounds.set(bounds);
        mShadowBounds.bottom = bounds.top + bounds.height() / 2.5f;
        Drawer.drawColor(canvas, SHADOW_COLOR, mShadowBounds);
        mShadowBounds.set(bounds);
        mShadowBounds.top = bounds.bottom - bounds.height() / 2.5f;
        Drawer.drawColor(canvas, SHADOW_COLOR, mShadowBounds);

        mShadowBounds.set(bounds);
        mShadowBounds.bottom = bounds.top + bounds.height() / 4;
        Drawer.drawColor(canvas, SHADOW_COLOR, mShadowBounds);
        mShadowBounds.set(bounds);
        mShadowBounds.top = bounds.bottom - bounds.height() / 4;
        Drawer.drawColor(canvas, SHADOW_COLOR, mShadowBounds);
    }

    private void drawSimple(Canvas canvas, RectF bounds) {
        Drawer.drawColor(canvas, mStringColor, bounds);
        drawShadows(canvas, bounds);
    }

    @Override
    public void draw(Context context, Canvas canvas, RectF bounds) {
        throw new RuntimeException("Use draw(Context, Canvas, RectF, boolean) method instead of this");
    }

}
