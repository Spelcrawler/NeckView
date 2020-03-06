package com.spelcrawler.neckview.parts.base;

public abstract class NoteMark implements FretboardPart {

    private final int mFret;
    private final int mString;

    public NoteMark(int fret, int string) {
        mFret = fret;
        mString = string;
    }

    public int getFret() {
        return mFret;
    }

    public int getString() {
        return mString;
    }

}
