package com.spelcrawler.neckview.parts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;

import androidx.annotation.ColorInt;

import com.spelcrawler.neckview.Drawer;
import com.spelcrawler.neckview.parts.base.Fret;

public class TexturedFret implements Fret {

    @ColorInt
    private static final int SHADOW_COLOR = 0x50000000;

    private RectF mShadowBounds = new RectF();
    @ColorInt
    private int mColor = Color.YELLOW;

    public TexturedFret() {}

    public TexturedFret(int color) {
        mColor = color;
    }

    public RectF getShadowBounds() {
        return mShadowBounds;
    }

    public void setShadowBounds(RectF shadowBounds) {
        mShadowBounds = shadowBounds;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }

    @Override
    public void draw(Context context, Canvas canvas, RectF bounds) {
        Drawer.drawColor(canvas, mColor, bounds);
        drawShadows(canvas, bounds);
    }

    private void drawShadows(Canvas canvas, RectF bounds) {
        mShadowBounds.set(bounds);
        mShadowBounds.right = bounds.left + bounds.width() / 4.5f;
        Drawer.drawColor(canvas, SHADOW_COLOR, mShadowBounds);
        mShadowBounds.set(bounds);
        mShadowBounds.left = bounds.right - bounds.width() / 4.5f;
        Drawer.drawColor(canvas, SHADOW_COLOR, mShadowBounds);

        mShadowBounds.set(bounds);
        mShadowBounds.right = bounds.left + bounds.width() / 7f;
        Drawer.drawColor(canvas, SHADOW_COLOR, mShadowBounds);
        mShadowBounds.set(bounds);
        mShadowBounds.left = bounds.right - bounds.width() / 7f;
        Drawer.drawColor(canvas, SHADOW_COLOR, mShadowBounds);
    }

}
