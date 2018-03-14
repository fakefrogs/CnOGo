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
    }

    public void backToCharacters(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
