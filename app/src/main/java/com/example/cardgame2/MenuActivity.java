package com.example.cardgame2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {
    private ImageView startGame;
    private ImageView clipBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("lifeCheck", "MenuActivityOnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {

            setContentView(R.layout.activity_main);
        }

        startGame = findViewById(R.id.menu_BTN_startGame);
        clipBoard = findViewById(R.id.menu_BTN_clipBoard);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MenuActivity.this , GameActivity.class);
                startActivity(mIntent);
            }
        });

        clipBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MenuActivity.this ,ClipboardActivity.class);
                startActivity(mIntent);
            }
        });


    }

    @Override
    protected void onStart() {
        Log.d("lifeCheck", "MenuActivityOnStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("lifeCheck", "MenuActivityOnResume");
        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.d("lifeCheck", "MenuActivityOnStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("lifeCheck", "MenuActivityOnDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d("lifeCheck", "MenuActivityOnPause");
        super.onPause();
    }
}