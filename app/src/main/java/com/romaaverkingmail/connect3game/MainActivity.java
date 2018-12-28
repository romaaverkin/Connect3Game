package com.romaaverkingmail.connect3game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // 0: blue, 1: red, 2: empty

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPosition = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    int activePlayer = 0;

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        Log.i("Tag", counter.getTag().toString());

        int tapedCounter = Integer.parseInt(counter.getTag().toString());
        gameState[tapedCounter] = activePlayer;

        counter.setTranslationY(-1500);

        if (activePlayer == 0) {
            counter.setImageResource(R.drawable.blue);
            activePlayer = 1;
        } else {
            counter.setImageResource(R.drawable.red);
            activePlayer = 0;
        }

        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
