package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class GameWindow extends AppCompatActivity {
    /*
     *   0 1 2
     *   3 4 5
     *   6 7 8
     * */
    TextView turnIndicator;
    TextView player1, player2;
    String o = "O", x = "X";

    boolean winned = false;
    int [] tapped = {2,2,2,2,2,2,2,2,2};
    int [][] winPos = { {0,1,2},
                        {3,4,5},
                        {6,7,8},
                        {0,3,6},
                        {1,4,7},
                        {2,5,8},
                        {0,4,8},
                        {2,4,6}};
    int activePlayer = 0;
    int count=0;
    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game_window);
        player1 = findViewById(R.id.player1Game);
        player2 = findViewById(R.id.player2Game);
        String p1 = getIntent().getStringExtra("Player1");
        String p2 = getIntent().getStringExtra("Player2");
        player1.setText(p1);
        player2.setText(p2);
    }
    @Override
    public void onBackPressed() {

    }
    public void about(View view) {
        Intent intent = new Intent(GameWindow.this, About.class);
        startActivity(intent);
    }

    public void clicked(View view) {
        if (!winned){
            ImageView img = (ImageView) view;
            int tag = Integer.parseInt(img.getTag().toString());

            if (tapped[tag-1]==2){
                if (activePlayer==0){
                    img.setImageResource(R.drawable.xi);
                    tapped[tag-1]=activePlayer;
                    activePlayer=1;
                    count++;
                }else {
                    img.setImageResource(R.drawable.oi);
                    tapped[tag-1]=activePlayer;
                    count++;
                    activePlayer=0;
                }
            }a=count;
            for (int [] winPos: winPos){
                if (tapped[winPos[0]]==tapped[winPos[1]] && tapped[winPos[1]]==tapped[winPos[2]] && tapped[winPos[0]]!=2){
                    winned=true;
                    Intent i = new Intent(GameWindow.this, ResultActivity.class);
                    if (tapped[winPos[0]]==0){
                        i.putExtra("Winner", "Congratulations "+getIntent().getStringExtra("Player1")+" for your win!!!");

                    }else {
                        i.putExtra("Winner", "Congratulations "+getIntent().getStringExtra("Player2")+" for your win!!!");
                    }
                    i.putExtra("Player1", getIntent().getStringExtra("Player1"));
                    i.putExtra("Player2", getIntent().getStringExtra("Player2"));
                    startActivity(i);
                }else if (!winned && count()){
                    Intent i = new Intent(GameWindow.this, ResultActivity.class);
                    i.putExtra("Player1", getIntent().getStringExtra("Player1"));
                    i.putExtra("Player2", getIntent().getStringExtra("Player2"));
                    i.putExtra("Winner", "It's a Draw!!");
                    startActivity(i);
                }
            }
        }


    }
    public boolean count(){
        for (int i=0; i<9; i++){
            if (tapped[i]==2){
                return false;
            }
        }
        return true;
    }
}