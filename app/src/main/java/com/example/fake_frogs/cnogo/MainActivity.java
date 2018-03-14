package com.example.fake_frogs.cnogo;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectCharacter(View view) {
        Intent intent = new Intent(this, OpponentSelectActivity.class);
        startActivity(intent);
    }

    public void abilitiesDetails(View view) {
        Intent intentAbilities = new Intent(this, DisplayAbilities.class);
        startActivity(intentAbilities);
    }
}