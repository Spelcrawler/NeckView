package com.spelcrawler.neckview.parts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;

import androidx.annotation.ColorInt;

import com.spelcrawler.neckview.Drawer;
import com.spelcrawler.neckview.parts.base.FretboardBinding;

public class TriangleColorFretboardBinding implements FretboardBinding {

    @ColorInt
    private int mColor = Color.WHITE;

    private final Path mPath = new Path();

    public TriangleColorFretboardBinding() {}

    public TriangleColorFretboardBinding(int color) {
        mColor = color;
    }

    @Override
    public void draw(Context context, Canvas canvas, RectF bounds, int fretIndex) {
        mPath.reset();
        mPath.moveTo(bounds.left, bounds.bottom);
        mPath.lineTo(bounds.left, bounds.top);
        mPath.lineTo(bounds.right, bounds.bottom);
        mPath.close();

        Drawer.drawPath(canvas, mPath, mColor);
    }

    @Override
    public void draw(Context context, Canvas canvas, RectF bounds) {
        throw new RuntimeException("Use draw(Context, Canvas, RectF, int) method instead of this");
    }

}
