package com.example.kinito;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class game_dice extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    public static final Random RandKini = new Random();
    private ImageView DiceLeft, DiceRight;


    public int NbRoll = 0;
    public TextView DiceLog;
    public TextView TextClient;
    public TextView TextNbRoll;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_dice);

        TextClient = findViewById(R.id.TextClient);
        Button rollDices = findViewById(R.id.rollDices);

        DiceLeft = findViewById(R.id.DiceLeft);
        DiceRight = findViewById(R.id.DiceRight);

        DiceLog = findViewById(R.id.DiceLog);
        TextNbRoll = findViewById(R.id.NbRolls);


        final MediaPlayer Mson_kinito_theo = MediaPlayer.create(this,R.raw.son_kinito_theo);
        final MediaPlayer Mson_kinito_mael = MediaPlayer.create(this,R.raw.son_kinito_mael);

        rollDices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextClient.setText("");
                //DiceLog.setText();

                NbRoll++;
                String SNbRoll = String.valueOf(NbRoll);
                TextNbRoll.setText(SNbRoll);


                int value1 = randomDiceValue();
                int value2 = randomDiceValue();

                int res1 = getResources().getIdentifier("dice_" + value1, "drawable", "com.example.kinito");
                int res2 = getResources().getIdentifier("dice_" + value2, "drawable", "com.example.kinito");

                DiceLeft.setImageResource(res1);
                DiceRight.setImageResource(res2);

                if(value1 == 1 && value2 == 2 || value1 == 2 && value2 == 1 || value1 == 5 && value2 == 6 || value1 == 6 && value2 == 5){
                        TextClient.setText("KINITO!");

                    switch (randomForSoundKinito()){

                        case 1 :
                            Mson_kinito_theo.start();

                        case 2 :
                            Mson_kinito_mael.start();

                        default:
                            break;
                    }


                }

                if(value1 == value2){
                    TextClient.setText("Bien joué, Double!");
                }



            }
        });

    }

    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;
    }

    public int randomForSoundKinito(){
        return RandKini.nextInt(2) +1;
    }
}
