package com.spelcrawler.neckview.parts.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

public interface FretboardBinding {

    void draw(Context context, Canvas canvas, RectF bounds, int fretIndex, boolean leftHanded);

}
