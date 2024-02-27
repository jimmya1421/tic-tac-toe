
package com.example.prac;
import android.media.Image;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public int[][] winPos = {
            {0,1,2},{3,4,5},{6,7,8},  // khade khade
            {0,3,6},{1,4,7},{2,5,8},   //pade pade
            {0,4,8},{2,4,6}    // weirdos
    };
    public int[] gameState = {
            2,2,2,   // 0 1 2
            2,2,2,  //  3 4 5
            2,2,2};  // 6 7 8
    ImageView[] imageViews = new ImageView[9]; // Or adjust the size as needed
    public int activeUser = 0;
    public int gameActive = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViews[0] = findViewById(R.id.imageView1);
        imageViews[1] = findViewById(R.id.imageView2);
        imageViews[2] = findViewById(R.id.imageView3);
        imageViews[3] = findViewById(R.id.imageView4);
        imageViews[4] = findViewById(R.id.imageView5);
        imageViews[5] = findViewById(R.id.imageView6);
        imageViews[6] = findViewById(R.id.imageView7);
        imageViews[7] = findViewById(R.id.imageView8);
        imageViews[8] = findViewById(R.id.imageView9);



     }
    public void tap(View view){
        ImageView im = (ImageView) view;
        int tag = Integer.parseInt(im.getTag().toString());
        if (gameState[tag-1] == 2){
            if(activeUser == 0){
                gameState[tag-1] = 0;
                activeUser = 1;
                im.setImageResource(R.drawable.o);
            }else{
                gameState[tag-1]= 1;
                im.setImageResource(R.drawable.x);
                activeUser = 0;
            }
        }
      String winn = checkWin();
        if (winn != ""){
        Toast.makeText(this, winn, Toast.LENGTH_SHORT).show();

        }
    }
    public String checkWin(){
        String winner ="";
        for (int[] win:winPos){
            if (gameState[win[0]] == gameState[win[1]] &&
                    gameState[win[1]] == gameState[win[2]] &&
                    gameState[win[0]] !=2){

                if (gameState[win[0]] ==1){
                    winner = "won x" ;

                }else{
                    winner = " y has won ;";
                }
            gameReset();
            }
        }
        return winner;
    }
    public void gameReset(){
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        for (int i =0;i<gameState.length;i++){
            imageViews[i].setImageResource(0);
        }
    }

}