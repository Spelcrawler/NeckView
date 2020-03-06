package com.spelcrawler.neckview.model;

public class GuitarString {

    private float mWidth;
    private boolean mWounded;

    public GuitarString() {}

    public GuitarString(float width, boolean wounded) {
        mWidth = width;
        mWounded = wounded;
    }

    public float getWidth() {
        return mWidth;
    }

    public void setWidth(float width) {
        mWidth = width;
    }

    public boolean isWounded() {
        return mWounded;
    }

    public void setWounded(boolean wounded) {
        mWounded = wounded;
    }



}
