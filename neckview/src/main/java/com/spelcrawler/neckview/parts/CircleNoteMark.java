package com.spelcrawler.neckview.parts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;

import com.spelcrawler.neckview.Drawer;
import com.spelcrawler.neckview.parts.base.NoteMark;
import com.spelcrawler.neckview.parts.base.NoteMarkAnimatable;

public class CircleNoteMark extends NoteMarkAnimatable<CircleNoteMark> {

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
    public void draw(Context context, Canvas canvas, RectF bounds, @Nullable CircleNoteMark fromMark, float animationPercent) {
        if (fromMark == null || fromMark == this) {
            Drawer.drawCircle(canvas, bounds.centerX(), bounds.centerY(), mMarkRadius, getColorWithAlpha(mMarkColor, 1));
            Drawer.drawText(canvas, bounds.centerX(), bounds.centerY(), mTextSize, mText, getColorWithAlpha(mTextColor, 1));
            return;
        }

        int markColor = ColorUtils.blendARGB(fromMark.getMarkColor(), getMarkColor(), animationPercent);
        int textColor = ColorUtils.blendARGB(fromMark.getTextColor(), getTextColor(), animationPercent);

        if (!getText().equals(fromMark.getText())) {
            float textColorAlpha = animationPercent > 0.5f ? (animationPercent - 0.5f) * 2 : 1 - animationPercent * 2;
            textColor = getColorWithAlpha(textColor, textColorAlpha);
        }

        String text = animationPercent > 0.5f ? getText() : fromMark.getText();

        float textSize = fromMark.getTextSize() + (getTextSize() - fromMark.getTextSize()) * animationPercent;
        float markRadius = fromMark.getMarkRadius() + (getMarkRadius() - fromMark.getMarkRadius()) * animationPercent;

        Drawer.drawCircle(canvas, bounds.centerX(), bounds.centerY(), markRadius, markColor);
        Drawer.drawText(canvas, bounds.centerX(), bounds.centerY(), textSize, text, textColor);
    }

    private @ColorInt int getColorWithAlpha(@ColorInt int color, float alpha) {
        return Color.argb((int) (255 * alpha), Color.red(color), Color.green(color), Color.blue(color));
    }



}
