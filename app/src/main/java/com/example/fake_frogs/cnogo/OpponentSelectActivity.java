package com.example.fake_frogs.cnogo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class OpponentSelectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opponent_select);
    }

    public void playMatch(View view) {
        Intent intent = new Intent(this, MatchActivity.class);
        startActivity(intent);
    }
}
