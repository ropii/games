package com.example.games;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button xo_btn,cookieClicker_btn,wordle_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xo_btn= findViewById(R.id.xo_btn);
        xo_btn.setOnClickListener(this);
        cookieClicker_btn= findViewById(R.id.cookieClicker_btn);
        cookieClicker_btn.setOnClickListener(this);
        wordle_btn= findViewById(R.id.wordle_btn);
        wordle_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==xo_btn){
            startActivity(new Intent(this, TictactoeActivity.class));
        }

        if (view==cookieClicker_btn){
            startActivity(new Intent(this, HomeCookieActivity.class));
        }
        if (view==wordle_btn){
            startActivity(new Intent(this, HomeWordleActivity.class));
        }
    }
}