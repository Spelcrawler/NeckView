package com.spelcrawler.neckview_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.spelcrawler.neckview.NeckView;
import com.spelcrawler.neckview.model.GuitarString;
import com.spelcrawler.neckview.parts.CircleColorFretboardBinding;
import com.spelcrawler.neckview.parts.CircleNoteMark;
import com.spelcrawler.neckview.parts.ColorFretboardFinish;
import com.spelcrawler.neckview.parts.ColorFretboardNut;
import com.spelcrawler.neckview.parts.DrawableFretboardTop;
import com.spelcrawler.neckview.parts.TexturedFret;
import com.spelcrawler.neckview.parts.TexturedFretboardString;
import com.spelcrawler.neckview.parts.TrapezeColorFretboardBinding;
import com.spelcrawler.neckview.parts.TriangleColorFretboardBinding;
import com.spelcrawler.neckview.parts.base.NoteMark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NeckView.OnNoteClickListener, View.OnClickListener {

    private NeckView mNeckView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNeckView = findViewById(R.id.neckView);

        findViewById(R.id.button_setup_bass).setOnClickListener(this);
        findViewById(R.id.button_setup_gibson).setOnClickListener(this);
        findViewById(R.id.button_setup_jackson).setOnClickListener(this);

        mNeckView.setNoteMarks(createMarks());
        mNeckView.setOnNoteClickListener(this);

        setupGibson(mNeckView);
    }

    private List<NoteMark> createMarks() {
        List<NoteMark> marks = new ArrayList<>();

        CircleNoteMark eMark = new CircleNoteMark(0, 5);
        eMark.setText("E");
        eMark.setMarkColor(Color.RED);
        marks.add(eMark);


        CircleNoteMark  gBMark = new CircleNoteMark(2, 5);
        gBMark.setText("F#");
        gBMark.setMarkColor(Color.GREEN);
        marks.add(gBMark);

        CircleNoteMark  gMark = new CircleNoteMark(3, 5);
        gMark.setText("G");
        gMark.setMarkColor(Color.GREEN);
        marks.add(gMark);

        CircleNoteMark  aMark = new CircleNoteMark(0, 4);
        aMark.setText("A");
        aMark.setMarkColor(Color.GREEN);
        marks.add(aMark);

        CircleNoteMark  bMark = new CircleNoteMark(2, 4);
        bMark.setText("B");
        bMark.setMarkColor(Color.GREEN);
        marks.add(bMark);

        CircleNoteMark  cMark = new CircleNoteMark(3, 4);
        cMark.setText("C");
        cMark.setMarkColor(Color.GREEN);
        marks.add(cMark);

        CircleNoteMark  dMark = new CircleNoteMark(0, 3);
        dMark.setText("D");
        dMark.setMarkColor(Color.GREEN);
        marks.add(dMark);

        CircleNoteMark  eHighMark = new CircleNoteMark(3, 3);
        eHighMark.setText("E");
        eHighMark.setMarkColor(Color.RED);
        marks.add(eHighMark);

        return marks;
    }

    private void setupJackson(NeckView neckView) {
        neckView.setFretWidth(25f);
        neckView.setNutWidth(150f);
        neckView.setupGuitarStrings(6, 3, 6, 28);
        neckView.setFinishWith(10);
        neckView.setFretCount(15);
        neckView.setNeckRightPadding(30);

        neckView.setFretboardNut(new ColorFretboardNut(Color.BLACK));
        neckView.setFretboardTop(new DrawableFretboardTop(R.drawable.neck_top));
        neckView.setFret(new TexturedFret(Color.LTGRAY));
        neckView.setFretboardFinish(new ColorFretboardFinish(0xFFFFFFF0));
        neckView.setFretboardBinding(new TriangleColorFretboardBinding(0xFFFFFFF0));
        neckView.setFretboardString(new TexturedFretboardString(0xFFB8B8B6));
        neckView.setBoundFrets(Arrays.asList(1, 3, 5, 7, 9, 12));

        neckView.requestLayout();
        neckView.invalidate();
    }

    private void setupGibson(NeckView neckView) {
        neckView.setFretWidth(20f);
        neckView.setNutWidth(50f);
        neckView.setupGuitarStrings(6, 3, 6, 28);
        neckView.setFinishWith(0);
        neckView.setFretCount(15);
        neckView.setNeckRightPadding(30);

        neckView.setFretboardNut(new ColorFretboardNut(0xFFFFFFF0));
        neckView.setFretboardTop(new DrawableFretboardTop(R.drawable.neck_top));
        neckView.setFret(new TexturedFret(0xFFCD7F32));
        neckView.setFretboardBinding(new TrapezeColorFretboardBinding(0xFFFFFFF0, 20f, 65f));
        neckView.setFretboardString(new TexturedFretboardString(0xFFB8B8B6));
        neckView.setBoundFrets(Arrays.asList(3, 5, 7, 9, 12));

        neckView.requestLayout();
        neckView.invalidate();
    }

    private void setupBass(NeckView neckView) {
        neckView.setFretWidth(35f);
        neckView.setNutWidth(50f);
        neckView.setupGuitarStrings(4, 4, 20, 45);
        neckView.setFinishWith(10);
        neckView.setFretCount(15);
        neckView.setNeckRightPadding(30);

        neckView.setFretboardNut(new ColorFretboardNut(0xFFFFFFF0));
        neckView.setFretboardTop(new DrawableFretboardTop(R.drawable.neck_top));
        neckView.setFret(new TexturedFret(0xFFC6C3BF));
        neckView.setFretboardBinding(new CircleColorFretboardBinding(0xFFFFFFF0, 25f));
        neckView.setFretboardString(new TexturedFretboardString(0xFFB8B8B6));
        neckView.setBoundFrets(Arrays.asList(3, 5, 7, 9, 12));

        neckView.requestLayout();
        neckView.invalidate();
    }


    @Override
    public void onNoteClick(int fret, int string) {
        Toast.makeText(this, "Note clicked fret: " + fret + ", string: " + string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_setup_bass:
                setupBass(mNeckView);
                break;
            case R.id.button_setup_gibson:
                setupGibson(mNeckView);
                break;
            case R.id.button_setup_jackson:
                setupJackson(mNeckView);
                break;
        }
    }
}
