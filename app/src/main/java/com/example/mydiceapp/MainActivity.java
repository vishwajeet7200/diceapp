package com.example.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRoll=  findViewById(R.id.btnRollTheDice);
        final ImageView diceImage1= findViewById(R.id.diceImage1);
        final ImageView diceImage2= findViewById(R.id.diceImage2);

        final int[] diceImages= {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.dice_sound);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("mydice","hello its done");
                mp.start();
                Random rndObj =new Random();
                int myRandomNumber = rndObj.nextInt(6);
                int myRandomNumber1 = rndObj.nextInt(6);

                diceImage1.setImageResource(diceImages[myRandomNumber]);
                diceImage2.setImageResource(diceImages[myRandomNumber1]);


                YoYo.with(Techniques.RollIn)
                        .duration(700)
                        .repeat(0)
                        .playOn(diceImage1);
                YoYo.with(Techniques.RollIn)
                        .duration(700)
                        .repeat(0)
                        .playOn(diceImage2);


                Log.i("mydice",myRandomNumber+"");

            }
        });


    }
}