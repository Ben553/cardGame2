package com.example.cardgame2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {
    private ImageView winnerLeft;
    private ImageView winnerRight;
    private ImageView draw;
    private TextView leftScore;
    private TextView rightScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {

            setContentView(R.layout.activity_main);
        }

        winnerLeft = findViewById(R.id.winner_IMG_winnerLeft);
        winnerRight = findViewById(R.id.winner_IMG_winnerRight);
        rightScore = findViewById(R.id.winner_LBL_scoreRight);
        leftScore = findViewById(R.id.winner_LBL_scoreLeft);
        draw = findViewById(R.id.winner_IMG_draw);
        winnerRight.setVisibility(View.INVISIBLE);
        winnerLeft.setVisibility(View.INVISIBLE);
        draw.setVisibility(View.INVISIBLE);

        String left_score = getIntent().getStringExtra("LEFT_SCORE");
        String right_score = getIntent().getStringExtra("RIGHT_SCORE");
        rightScore.setText("" + right_score);
        leftScore.setText("" + left_score);
        if (Integer.valueOf(right_score) > Integer.valueOf(left_score))
            winnerRight.setVisibility(View.VISIBLE);
        else if (Integer.valueOf(right_score) < Integer.valueOf(left_score))
            winnerLeft.setVisibility(View.VISIBLE);
        else
            draw.setVisibility(View.VISIBLE);


    }

    @Override
    protected void onStart() {
        Log.d("lifeCheck", "WinnerActivityOnStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("lifeCheck", "WinnerActivityOnResume");
        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.d("lifeCheck", "WinnerActivityOnStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("lifeCheck", "WinnerActivityOnDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d("lifeCheck", "WinnerActivityOnPause");
        super.onPause();
    }
}