package com.example.kinito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button but_play;
    private Button but_rule;
    private Button but_credit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_princ);

        but_play = (Button)findViewById(R.id.but_play);
        but_rule = (Button)findViewById(R.id.but_rules);
        but_credit = (Button)findViewById(R.id.but_credit);

        but_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_play();
            }
        });

        but_rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_rules();
            }
        });

        but_credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_credit();
            }
        });


    }

    public void openActivity_play() {
        Intent intent_game = new Intent(this, game_dice.class);
        startActivity(intent_game);
    }

    public void openActivity_rules() {
        Intent intent_rules = new Intent(this, rules_game.class);
        startActivity(intent_rules);
    }

    public void openActivity_credit() {
        Intent intent_credit = new Intent(this, credit.class);
        startActivity(intent_credit);
    }


}
