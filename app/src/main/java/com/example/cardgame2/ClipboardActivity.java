package com.example.cardgame2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ClipboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("lifeCheck", "ClipboardActivityOnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clipboard);
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
}