package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }
    public void toGame(View view) {
        String player1 = ((EditText)findViewById(R.id.player1_name)).getText().toString();
        String player2 = ((EditText)findViewById(R.id.player2_name)).getText().toString();
        if (player2.isEmpty() || player1.isEmpty()){
            TextView error = findViewById(R.id.error);
            error.setText("* Enter both names for further process");
        }
        else{
            Intent toGameWindow = new Intent(MainActivity.this, GameWindow.class);
            toGameWindow.putExtra("Player1", player1);
            toGameWindow.putExtra("Player2", player2);
            startActivity(toGameWindow);
        }


    }
    public void about(View view) {
        Intent intent = new Intent(MainActivity.this, About.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        finishAffinity();
        System.exit(0);
    }
}