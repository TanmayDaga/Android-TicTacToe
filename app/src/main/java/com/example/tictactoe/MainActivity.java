package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void tapTap(View view){

        // creating object of image
        ImageView img = (ImageView) view;
        int tappedImageTag =  Integer.parseInt(view.getTag().toString());
        if (gameState[tappedImageTag] == 2){

            // changing of backend or changing position in array
            gameState[tappedImageTag] = activePlayer;

            // changing gui
            // making image move 1000f upward
            img.setTranslationY(-1000f);

            if (activePlayer == 0){
                img.setImageResource(R.drawable.o);
                activePlayer = 1;
            }
            else {
                img.setImageResource(R.drawable.x);
                activePlayer = 0;
            }
            img.animate().translationYBy(1000f).setDuration(300); // duration in milli seconds


        }

    }
}