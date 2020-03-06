package com.spelcrawler.neckview;

public class FretCalculator {

    private static final float FRET_CONSTANT = 17.817F;

    /**
     *
     * @param fretboardWidth total width for frets
     * @param fretCount count of visible frets
     * @param wrap if true cuts fretboard for visible frets
     * @return fret x positions
     */
    public static float[] calculate(float fretboardWidth, int fretCount, boolean wrap) {
        float[] frets = calculate(fretboardWidth, fretCount);
        if (wrap) {
            float wrapMultiplier = fretboardWidth / frets[frets.length - 1];
            for (int i = 0; i < frets.length; i++) {
                frets[i] *= wrapMultiplier;
            }
        }

        return frets;
    }

    private static float[] calculate(float fretboardWidth, int fretCount) {
        float[] frets = new float[fretCount];

        for (int i = 0; i < fretCount; i++) {
            if (i == 0) {
                frets[i] = 0;
            } else {
                float previousFret = frets[i - 1];
                frets[i] = previousFret + (fretboardWidth - previousFret) / FRET_CONSTANT;
            }
        }

        return frets;
    }



}
