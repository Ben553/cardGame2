package com.example.cardgame2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecordsActivity extends AppCompatActivity {

    private ImageView playAgain;
    private TextView playAgainTV;
    private RecordsTable recordsTable;
    SharedPreferences sp;
 //   private String PlayerOneStats , PlayerTwoStats;
    TextView clip_LBL_1,clip_LBL_2,clip_LBL_3,clip_LBL_4,clip_LBL_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("lifeCheck", "RecordsActivityOnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {

            setContentView(R.layout.activity_records);
        }

        playAgain = findViewById(R.id.game_BTN_playAgain);
        playAgain.setOnClickListener(onClickListener);
        playAgainTV = findViewById(R.id.game_TV_playAgain);
        playAgainTV.setOnClickListener(onClickListener);

        sp = getSharedPreferences("Records",Context.MODE_PRIVATE) ;
        SharedPreferences.Editor editor = sp.edit();

        recordsTable = new RecordsTable();


        for(int i = 1; i <= 5; i++){
            recordsTable.setRecordsTable(sp.getString("Player"+i,". Name: ---, Score: 0"),(i-1));
        }

            if(Integer.valueOf(getIntent().getExtras().getInt("KEY")) == 1) {
            recordsTable.addToRecordsTable(getIntent().getStringExtra("PlayerOneName"),getIntent().getExtras().getString("PlayerOneScore"));
            recordsTable.addToRecordsTable(getIntent().getExtras().getString("PlayerTwoName"),getIntent().getExtras().getString("PlayerTwoScore"));

            for(int i = 1; i <= 5; i++){
                editor.putString("Player"+i,recordsTable.toString(i-1));
            }
            editor.apply();

        }




        clip_LBL_1 = findViewById(R.id.clip_LBL_1);
        clip_LBL_2 = findViewById(R.id.clip_LBL_2);
        clip_LBL_3 = findViewById(R.id.clip_LBL_3);
        clip_LBL_4 = findViewById(R.id.clip_LBL_4);
        clip_LBL_5 = findViewById(R.id.clip_LBL_5);


        clip_LBL_1.setText(1+sp.getString("Player1",". Name: ---, Score: 0"));
        clip_LBL_2.setText(2+sp.getString("Player2",". Name: ---, Score: 0"));
        clip_LBL_3.setText(3+sp.getString("Player3",". Name: ---, Score: 0"));
        clip_LBL_4.setText(4+sp.getString("Player4",". Name: ---, Score: 0"));
        clip_LBL_5.setText(5+sp.getString("Player5",". Name: ---, Score: 0"));
    }

    @Override
    protected void onStart() {
        Log.d("lifeCheck", "RecordsActivityOnStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("lifeCheck", "RecordsActivityOnResume");
        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.d("lifeCheck", "RecordsActivityOnStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("lifeCheck", "RecordsActivityOnDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d("lifeCheck", "RecordsActivityOnPause");
        super.onPause();
    }
    private void openActivity(Class activity) {
        Intent myIntent = new Intent(RecordsActivity.this, activity);
        startActivity(myIntent);
        finish();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case(R.id.game_BTN_playAgain):
                case(R.id.game_TV_playAgain):
                    openActivity(MenuActivity.class);
                    break;
            }
        }
    };
    public boolean saveArray(String[] array, String arrayName, Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("preferencename", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(arrayName +"_size", array.length);
        for(int i=0;i<array.length;i++)
            editor.putString(arrayName + "_" + i, array[i]);
        return editor.commit();
    }

    public String[] loadArray(String arrayName, Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("preferencename", 0);
        int size = prefs.getInt(arrayName + "_size", 0);
        String array[] = new String[size];
        for(int i=0;i<size;i++)
            array[i] = prefs.getString(arrayName + "_" + i, null);
        return array;
    }

}