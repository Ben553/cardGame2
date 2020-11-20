package com.example.cardgame2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ClipboardActivity extends AppCompatActivity {

    private ImageView playAgain;
    private TextView playAgainTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("lifeCheck", "ClipboardActivityOnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clipboard);

        playAgain = findViewById(R.id.game_BTN_playAgine);
        playAgain.setOnClickListener(onClickListener);
        playAgainTV = findViewById(R.id.game_TV_playAgine);
        playAgainTV.setOnClickListener(onClickListener);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {

            setContentView(R.layout.activity_clipboard);
        }
    }

    @Override
    protected void onStart() {
        Log.d("lifeCheck", "ClipboardActivityOnStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("lifeCheck", "ClipboardActivityOnResume");
        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.d("lifeCheck", "ClipboardActivityOnStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("lifeCheck", "ClipboardActivityOnDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d("lifeCheck", "ClipboardActivityOnPause");
        super.onPause();
    }
    private void openActivity(Class activity) {
        Intent myIntent = new Intent(ClipboardActivity.this, activity);
        startActivity(myIntent);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case(R.id.game_BTN_playAgine):
                case(R.id.game_TV_playAgine):
                    openActivity(MenuActivity.class);
                    break;
            }
        }
    };


}