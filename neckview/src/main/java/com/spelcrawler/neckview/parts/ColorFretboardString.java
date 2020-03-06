package com.spelcrawler.neckview.parts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;

import androidx.annotation.ColorInt;

import com.spelcrawler.neckview.Drawer;
import com.spelcrawler.neckview.parts.base.FretboardString;

public class ColorFretboardString implements FretboardString {

    @ColorInt
    private int mColor = Color.YELLOW;

    public ColorFretboardString() {}

    public ColorFretboardString(int color) {
        mColor = color;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }

    @Override
    public void draw(Context context, Canvas canvas, RectF bounds, boolean wounded) {
        Drawer.drawColor(canvas, mColor, bounds);
    }

    @Override
    public void draw(Context context, Canvas canvas, RectF bounds) {
        throw new RuntimeException("Use draw(Context, Canvas, RectF, boolean) method instead of this");
    }

}
