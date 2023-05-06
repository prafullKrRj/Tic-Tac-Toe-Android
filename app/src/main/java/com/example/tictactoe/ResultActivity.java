package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.GnssAutomaticGainControl;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String str = getIntent().getStringExtra("Winner");
        TextView winner = findViewById(R.id.textView3);
        winner.setText(str);
    }

    @Override
    public void onBackPressed() {

    }

    public void about(View view) {
        Intent intent = new Intent(ResultActivity.this, About.class);
        startActivity(intent);

    }

    public void restart(View view) {
        Intent intent = new Intent(ResultActivity.this, GameWindow.class);
        intent.putExtra("Player1", getIntent().getStringExtra("Player1"));
        intent.putExtra("Player2", getIntent().getStringExtra("Player2"));
        startActivity(intent);
    }

    public void userChange(View view) {
        Intent i = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void exit(View view) {
        finishAffinity();
        System.exit(0);
    }
}