package com.example.fake_frogs.cnogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DisplayAbilities extends AppCompatActivity {
    TextView abilityOneTextview;
    TextView abilityTwoTextview;
    TextView abilityThreeTextview;
    int character = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_abilities);
        abilityOneTextview = findViewById(R.id.textAbilityOne);
        abilityTwoTextview = findViewById(R.id.textAbilityTwo);
        abilityThreeTextview = findViewById(R.id.textAbilityThree);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getInt("character") > 0) {
                character = extras.getInt("character");
            }
        }

        //Check if a character is available
        if (character > 0 ) {
            //Determine which character abilities to display
            switch(character) {
                case 1:
                    abilityOneTextview.setText(R.string.glare);
                    abilityTwoTextview.setText(R.string.ignore);
                    abilityThreeTextview.setText(R.string.passive_indifference);
                    break;
                case 2:
                    abilityOneTextview.setText(R.string.bad_jokes);
                    abilityTwoTextview.setText(R.string.friendly_smile);
                    abilityThreeTextview.setText(R.string.punishment);
                    break;
                case 3:
                    abilityOneTextview.setText(R.string.super_strength);
                    abilityTwoTextview.setText(R.string.super_flight);
                    abilityThreeTextview.setText(R.string.super_yeast);
                    break;
                case 4:
                    abilityOneTextview.setText(R.string.poke_with_a_stick);
                    abilityTwoTextview.setText(R.string.hide_behind_clipboard);
                    abilityThreeTextview.setText(R.string.scientific_lecture);
                    break;
                case 5:
                    abilityOneTextview.setText(R.string.scythe);
                    abilityTwoTextview.setText(R.string.empty_cloak);
                    abilityThreeTextview.setText(R.string.immortality);
                    break;
                case 6:
                    abilityOneTextview.setText(R.string.the_power);
                    abilityTwoTextview.setText(R.string.pause);
                    abilityThreeTextview.setText(R.string.rewind);
                    break;
                case 7:
                    abilityOneTextview.setText(R.string.scheme);
                    abilityTwoTextview.setText(R.string.impersonate);
                    abilityThreeTextview.setText(R.string.clone_o_max);
                    break;
                case 8:
                    abilityOneTextview.setText(R.string.awkwardness);
                    abilityTwoTextview.setText(R.string.sofa_cushion);
                    abilityThreeTextview.setText(R.string.forgotten_about);
                    break;
                case 9:
                    abilityOneTextview.setText(R.string.hairball);
                    abilityTwoTextview.setText(R.string.superiority);
                    abilityThreeTextview.setText(R.string.judging_stare);
                    break;
            }
        }
    }

    //Create and call Intent to return to character selection
    public void backToCharactersFromAbilities(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        if (character > 0) {
            intent.putExtra("character", character);
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP );
        startActivity(intent);
    }
}
