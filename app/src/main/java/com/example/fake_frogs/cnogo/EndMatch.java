package com.example.fake_frogs.cnogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class EndMatch extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_match);
    }

    public void restartMatch(View view) {
        Intent intent = new Intent(this, MatchActivity.class);
        startActivity(intent);
    }

    public void characterSelect(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void opponentSelect(View view) {
        Intent intent = new Intent(this, OpponentSelectActivity.class);
        startActivity(intent);
    }
}
