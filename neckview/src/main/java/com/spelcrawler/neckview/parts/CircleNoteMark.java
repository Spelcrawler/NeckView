package com.spelcrawler.neckview.parts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import com.spelcrawler.neckview.Drawer;
import com.spelcrawler.neckview.parts.base.NoteMark;

public class CircleNoteMark extends NoteMark {

    @ColorInt
    private int mMarkColor = Color.RED;
    @ColorInt
    private int mTextColor = Color.WHITE;
    @NonNull
    private String mText = "";
    private float mMarkRadius = 35f;
    private float mTextSize = 48f;

    public CircleNoteMark(int fret, int string) {
        super(fret, string);
    }

    public int getMarkColor() {
        return mMarkColor;
    }

    public void setMarkColor(int markColor) {
        mMarkColor = markColor;
    }

    public int getTextColor() {
        return mTextColor;
    }

    public void setTextColor(int textColor) {
        mTextColor = textColor;
    }

    public float getMarkRadius() {
        return mMarkRadius;
    }

    public void setMarkRadius(float markRadius) {
        mMarkRadius = markRadius;
    }

    public float getTextSize() {
        return mTextSize;
    }

    public void setTextSize(float textSize) {
        mTextSize = textSize;
    }

    @NonNull
    public String getText() {
        return mText;
    }

    public void setText(@NonNull String text) {
        mText = text;
    }

    @Override
    public void draw(Context context, Canvas canvas, RectF bounds) {
        Drawer.drawCircle(canvas, bounds.centerX(), bounds.centerY(), mMarkRadius, mMarkColor);
        Drawer.drawText(canvas, bounds.centerX(), bounds.centerY(), mTextSize, mText, mTextColor);
    }

}
