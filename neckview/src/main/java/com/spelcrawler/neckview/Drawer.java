package com.spelcrawler.neckview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;

public class Drawer {

    private static final Paint sPaint = new Paint();

    public static void drawColor(Canvas canvas, @ColorInt int color, RectF bounds) {
        sPaint.setColor(color);
        sPaint.setStyle(Paint.Style.FILL);

        canvas.drawRect(bounds, sPaint);
    }

    public static void drawDrawable(Context context, Canvas canvas, @DrawableRes int drawableRes, RectF bounds) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableRes);
        if (drawable == null) {
            throw new IllegalArgumentException("Can't find drawable with id: " + drawableRes);
        }
        drawable.setBounds((int) bounds.left, (int) bounds.top, (int) bounds.right, (int) bounds.bottom);
        drawable.draw(canvas);
    }

    public static void drawCircle(Canvas canvas, float centerX, float centerY, float radius, @ColorInt int color) {
        sPaint.setColor(color);
        sPaint.setStyle(Paint.Style.FILL);
        sPaint.setAntiAlias(true);

        canvas.drawCircle(centerX, centerY, radius, sPaint);
    }

    public static void drawText(Canvas canvas, float centerX, float centerY, float textSize, String text, @ColorInt int textColor) {
        sPaint.setTextSize(textSize);
        sPaint.setTextAlign(Paint.Align.CENTER);
        sPaint.setColor(textColor);
        sPaint.setAntiAlias(true);

        centerY -= (sPaint.descent() + sPaint.ascent()) / 2;

        canvas.drawText(text, centerX, centerY, sPaint);
    }

    public static void drawLine(Canvas canvas, float startX, float startY, float endX, float endY, @ColorInt int color, float width) {
        sPaint.setColor(color);
        sPaint.setStyle(Paint.Style.STROKE);
        sPaint.setStrokeWidth(width);
        sPaint.setAntiAlias(true);

        canvas.drawLine(startX, startY, endX, endY, sPaint);
    }

    public static void drawPath(Canvas canvas, Path path, @ColorInt int color) {
        sPaint.setColor(color);
        sPaint.setStyle(Paint.Style.FILL);
        sPaint.setAntiAlias(true);

        canvas.drawPath(path, sPaint);
    }


}
