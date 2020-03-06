package com.spelcrawler.neckview.parts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;

import androidx.annotation.ColorInt;

import com.spelcrawler.neckview.Drawer;
import com.spelcrawler.neckview.parts.base.Fret;

public class ColorFret implements Fret {

    @ColorInt
    private int mColor = Color.YELLOW;


    public ColorFret() {}

    public ColorFret(int color) {
        mColor = color;
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
    }

}
