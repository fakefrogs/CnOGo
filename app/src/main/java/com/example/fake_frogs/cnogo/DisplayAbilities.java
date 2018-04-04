package com.example.fake_frogs.cnogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DisplayAbilities extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_abilities);
        int character = 0;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            character = extras.getInt("character");
        }

        if (character == 1) {
            //Display Clyde's abilities
        }
        else if (character == 2) {
            //Display Owen's abilities
        }
    }

    public void backToCharacters(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP );//| Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent);
    }
}
