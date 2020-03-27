package com.spelcrawler.neckview_sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.spelcrawler.neckview.NeckView;
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
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements NeckView.OnNoteClickListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private NeckView mNeckView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNeckView = findViewById(R.id.neckView);
        ((CheckBox) findViewById(R.id.checkbox_left_handed)).setOnCheckedChangeListener(this);

        findViewById(R.id.button_setup_bass).setOnClickListener(this);
        findViewById(R.id.button_setup_gibson).setOnClickListener(this);
        findViewById(R.id.button_setup_jackson).setOnClickListener(this);

        mNeckView.setOnNoteClickListener(this);
        mNeckView.setLeftHanded(false);


        setupGibson(mNeckView);
        mNeckView.setNoteMarks(createMarks(10));
    }

    private List<NoteMark> createMarks(int count) {
        List<NoteMark> marks = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int fret = random.nextInt(14);
            int string = random.nextInt(5);
            CircleNoteMark mark = new CircleNoteMark(fret, string);
            mark.setText(String.valueOf((i % 6) + 1));
            mark.setMarkColor(i % 6 == 0 ? Color.RED : Color.GREEN);

            marks.add(mark);
        }
        Collections.shuffle(marks);

        return marks;
    }

    private void setupJackson(NeckView neckView) {
        neckView.setupGuitarStrings(6, 3, R.dimen.stringGauge9, R.dimen.stringGauge48);

        neckView.setFretboardNut(new ColorFretboardNut(ContextCompat.getColor(this, R.color.black)));
        neckView.setFretboardTop(new DrawableFretboardTop(R.drawable.neck_top));
        neckView.setFret(new TexturedFret(ContextCompat.getColor(this, R.color.fretColorGray)));
        neckView.setFretboardFinish(new ColorFretboardFinish(ContextCompat.getColor(this, R.color.white)));
        neckView.setFretboardBinding(new TriangleColorFretboardBinding(ContextCompat.getColor(this, R.color.white)));
        neckView.setFretboardString(new TexturedFretboardString(ContextCompat.getColor(this, R.color.stringColor)));
        neckView.setBoundFrets(Arrays.asList(1, 3, 5, 7, 9, 12));

        neckView.requestLayout();
        neckView.invalidate();
    }

    private void setupGibson(NeckView neckView) {
        neckView.setupGuitarStrings(6, 3, R.dimen.stringGauge9, R.dimen.stringGauge48);

        neckView.setFretboardNut(new ColorFretboardNut(ContextCompat.getColor(this, R.color.white)));
        neckView.setFretboardTop(new DrawableFretboardTop(R.drawable.neck_top));
        neckView.setFret(new TexturedFret(ContextCompat.getColor(this, R.color.fretColorYellow)));
        neckView.setFretboardBinding(new TrapezeColorFretboardBinding(ContextCompat.getColor(this, R.color.white), 20f, 65f));
        neckView.setFretboardString(new TexturedFretboardString(ContextCompat.getColor(this, R.color.stringColor)));
        neckView.setBoundFrets(Arrays.asList(3, 5, 7, 9, 12));

        neckView.requestLayout();
        neckView.invalidate();
    }

    private void setupBass(NeckView neckView) {
        neckView.setupGuitarStrings(4, 4, R.dimen.stringGauge30, R.dimen.stringGauge105);

        neckView.setFretboardNut(new ColorFretboardNut(ContextCompat.getColor(this, R.color.white)));
        neckView.setFretboardTop(new DrawableFretboardTop(R.drawable.neck_top));
        neckView.setFret(new TexturedFret(ContextCompat.getColor(this, R.color.fretColorGray)));
        neckView.setFretboardBinding(new CircleColorFretboardBinding(ContextCompat.getColor(this, R.color.white), 25f));
        neckView.setFretboardString(new TexturedFretboardString(ContextCompat.getColor(this, R.color.stringColor)));
        neckView.setBoundFrets(Arrays.asList(3, 5, 7, 9, 12));

        neckView.requestLayout();
        neckView.invalidate();
    }


    @Override
    public void onNoteClick(int fret, int string) {
        mNeckView.setNoteMarksWithAnimation(createMarks(10));
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

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mNeckView.setLeftHanded(isChecked);
        mNeckView.invalidate();
    }

}
