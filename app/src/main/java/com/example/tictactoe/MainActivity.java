package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
    Player Representation
    0 - O
    1 - X
    */
    int activePlayer = 0;

    /*
    Game State
    0 - X
    1 - O
    2 - Blank
    */
    int [] gameState = {2,2,2,2,2,2,2,2,2};

    // winning positions
    int [] [] winPos = {{0,1,2}, {3,4,5}, {6,7,8}, // Horizontal
                        {0,3,6}, {1,4,7}, {2,5,8}, // Vertical
                        {0,4,8}, {6,4,2}}; // Diagonal

    // Creating object of status bar


    // setting win variable
    boolean win = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void tapTap(View view){
        TextView stat = (TextView) findViewById(R.id.status) ;

        // creating object of image
        ImageView img = (ImageView) view;
        int tappedImageTag =  Integer.parseInt(view.getTag().toString());
        if (gameState[tappedImageTag] == 2 && !win){



            // changing of backend or changing position in array
            gameState[tappedImageTag] = activePlayer;

            // changing gui
            // making image move 1000f upward
            img.setTranslationY(-1000f);

            if (activePlayer == 0){
                img.setImageResource(R.drawable.o);
                activePlayer = 1;
                stat.setText(R.string.xturn);
            }
            else {
                img.setImageResource(R.drawable.x);
                activePlayer = 0;
                stat.setText(R.string.oturn);
            }
            img.animate().translationYBy(1000f).setDuration(300); // duration in milli seconds

        }
        checkWin();
        if (!win) {
            checkDraw();
        }
    }
    public void checkWin(){
        TextView stat = (TextView) findViewById(R.id.status) ;
        for(int[] i : winPos){
            if (gameState[i[0]] !=2 && gameState[i[0]] == gameState[i[1]] && gameState[i[1]]== gameState[i[2]]){
                if (gameState[i[0]] == 0){
                    stat.setText(R.string.owon);
                }
                else {
                    stat.setText(R.string.xwin);
                }
                win = true;
            }
        }
    }
    public void checkDraw(){
        TextView stat = (TextView) findViewById(R.id.status) ;

        // Checking if board still empty
        for (int i: gameState){
            if (i == 2){
                return;
            }
        }
        stat.setText(R.string.draw);
    }
    public void resetGame(View view){

        // Resetting Variables
        activePlayer = 0;
        win = false;
        // changing gamestate to blank
        for (int i = 0; i<9; i++){
            gameState[i] = 2;
        }
//        changing all image view
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
    }
}