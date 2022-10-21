package com.example.games;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.NativeActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeCookieActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_play_demo, btn_play_web, btn_rules, btn_go_main;
    AlertDialog ad_web, ad_rules;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_cookie);

        btn_play_demo = findViewById(R.id.btn_play_demo);
        btn_play_web = findViewById(R.id.btn_play_web);
        btn_rules = findViewById(R.id.btn_rules);
        btn_go_main = findViewById(R.id.btn_go_main);

        btn_go_main.setOnClickListener(this);
        btn_play_demo.setOnClickListener(this);
        btn_play_web.setOnClickListener(this);
        btn_rules.setOnClickListener(this);
    }

    public void start_web() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("play on web");
        builder.setMessage("are you sure?");
        builder.setCancelable(true);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://orteil.dashnet.org/cookieclicker/")));
            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(HomeCookieActivity.this, "ok", Toast.LENGTH_SHORT).show();


            }
        });
        ad_web = builder.create();
        ad_web.show();
    }

    public void start_rules() {
        String str_rules = "1. Have fun\n2. Press the cookie\n3. taps= The amount of points you get per click ";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("rules");
        builder.setMessage(str_rules);
        builder.setCancelable(true);
        builder.setPositiveButton("ok", null);

        ad_rules = builder.create();
        ad_rules.show();
    }


    @Override
    public void onClick(View view) {
        if (view == btn_go_main) {
            startActivity(new Intent(this, MainActivity.class));
        }
        if (view == btn_play_demo) {
            startActivity(new Intent(this, CookieGameActivity.class));

        }
        if (view == btn_play_web) {
            start_web();
        }
        if (view == btn_rules) {
            start_rules();
        }
    }
}