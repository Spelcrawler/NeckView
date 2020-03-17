package com.spelcrawler.neckview.parts.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

import androidx.annotation.Nullable;

public abstract class NoteMarkAnimatable<T extends NoteMarkAnimatable<T>> extends NoteMark {

    private static RectF sBounds = new RectF();

    public NoteMarkAnimatable(int fret, int string) {
        super(fret, string);
    }

    public void draw(Context context, Canvas canvas, RectF fromBounds, RectF toBounds, float animationPercent, T fromMark) {
        sBounds.left = fromBounds.left + (toBounds.left - fromBounds.left) * animationPercent;
        sBounds.top = fromBounds.top + (toBounds.top - fromBounds.top) * animationPercent;
        sBounds.right = fromBounds.right + (toBounds.right - fromBounds.right) * animationPercent;
        sBounds.bottom = fromBounds.bottom + (toBounds.bottom - fromBounds.bottom) * animationPercent;

        draw(context, canvas, sBounds, fromMark, animationPercent);
    }

    @Override
    public void draw(Context context, Canvas canvas, RectF bounds) {
        draw(context, canvas, bounds, null, 1f);
    }

    public abstract void draw(Context context, Canvas canvas, RectF bounds, @Nullable T fromMark, float animationPercent);

}
