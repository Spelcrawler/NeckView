package com.spelcrawler.neckview.parts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

import androidx.annotation.DrawableRes;

import com.spelcrawler.neckview.Drawer;
import com.spelcrawler.neckview.parts.base.FretboardTop;

public class DrawableFretboardTop implements FretboardTop {

    @DrawableRes
    private final int mDrawableRes;

    public DrawableFretboardTop(int drawableRes) {
        mDrawableRes = drawableRes;
    }

    @Override
    public void draw(Context context, Canvas canvas, RectF bounds) {
        Drawer.drawDrawable(context, canvas, mDrawableRes, bounds);
    }

}
