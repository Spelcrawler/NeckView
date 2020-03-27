[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.spelcrawler/neckview/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.spelcrawler/neckview)

# NeckView
Simple guitar neck view

![](static/screenshot.png)

Download
--------

Gradle:

```
dependencies {
  implementation 'com.github.spelcrawler:neckview:0.9.8'
}
```

Usage
-----

You can find sample app [here](https://github.com/Spelcrawler/NeckView/tree/master/app)

Layout file:

```xml
<com.spelcrawler.neckview.NeckView
    android:id="@+id/neckView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

Setup code:

```java
NeckView neckView = findViewById(R.id.neckView);

neckView.setupGuitarStrings(6, 3, R.dimen.stringGauge9, R.dimen.stringGauge48);

neckView.setFretboardNut(new ColorFretboardNut(ContextCompat.getColor(this, R.color.black)));
neckView.setFretboardTop(new DrawableFretboardTop(R.drawable.neck_top));
neckView.setFret(new TexturedFret(ContextCompat.getColor(this, R.color.fretColorGray)));
neckView.setFretboardFinish(new ColorFretboardFinish(ContextCompat.getColor(this, R.color.white)));
neckView.setFretboardBinding(new TriangleColorFretboardBinding(ContextCompat.getColor(this, R.color.white)));
neckView.setFretboardString(new TexturedFretboardString(ContextCompat.getColor(this, R.color.stringColor)));
neckView.setBoundFrets(Arrays.asList(1, 3, 5, 7, 9, 12));

```


