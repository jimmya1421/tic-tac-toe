
package com.example.prac;
import android.media.Image;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private LinearLayout textContainer;
    ImageView[] imageViews = new ImageView[9]; // Or adjust the size as needed
    public boolean isO = false;

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

        int i=0;
        for ( i = 0; i < imageViews.length; i++) {

            ImageView myImageView = imageViews[i];
            imageViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Handle click events here
                    if (isO != true){
                    myImageView.setImageResource(R.drawable.o);
                    isO = true;
                    myImageView.setContentDescription("o");
                    }else {myImageView.setImageResource(R.drawable.x);isO = false;
                    myImageView.setContentDescription("x");
                    }
                  String ans =   checkWinner();
                    if (ans =="WE have a winner")
                    {
                       
                    }
                }
            });
        }

     }
    public String checkWinner(){
        String[] gp = new String[9];
        for (int i =0;i<gp.length;i++)
        {

            gp[i] = (String) imageViews[i].getContentDescription();
        }
        boolean resetGame = false;
        if (gp[0] == gp[1] &&gp[1]==gp[2] && gp[0] ==gp[2] ){
            resetGame = true;

        } else if (gp[3] == gp[4] && gp[4]==gp[5] && gp[3] == gp[5]) {
            resetGame = true;

        }else if(gp[6] == gp[7] &&gp[7]==gp[8] && gp[8] ==gp[6]){
            resetGame = true;

        }
        if (gp[0] == gp[8] && gp[0] == gp[4]){
            resetGame = true;

        }

        if (gp[2] == gp[6] && gp[0] ==gp[4]){
            resetGame = true;

        }
        if (resetGame){
             for ( int j = 0;j < imageViews.length;j++) {
                            ImageView myImageView = imageViews[j];
                            myImageView.setImageResource(R.drawable.ic_launcher_background);
                            myImageView.setContentDescription("i + " + j);
             }
             return "WE have a winner";

        }

        return "keep playing";
    }

}