package com.example.fake_frogs.cnogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by fake_frogs on 4/23/18.
 */

public class PlayerSelect extends AppCompatActivity {
    //Constants
    private static final int CLYDE = 1;
    private static final int OWEN = 2;
    private static final int SUPER_BREAD = 3;
    private static final int SCIENTIST = 4;
    private static final int GRIM_REAPER = 5;
    private static final int THE_CONTROLLER = 6;
    private static final int CLYDE_CLONE = 7;
    private static final int CARL = 8;
    private static final int CAT_PERSON = 9;
    //Character variable
    private int character = 0;
    //ImageButton variables
    ImageButton playerSuperBreadBtn;
    ImageButton playerScientistBtn;
    ImageButton playerGrimReaperBtn;
    ImageButton playerTheControllerBtn;
    ImageButton playerClydeCloneBtn;
    ImageButton playerCarlBtn;
    ImageButton playerCatPersonBtn;
    ImageButton playerRandomBtn;
    ImageView playerCharacterImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_select);
        //Retrieve ImageButtons and assign to ImageButton variables
        playerSuperBreadBtn = findViewById(R.id.playerThreeImgBtn);
        playerScientistBtn = findViewById(R.id.playerFourImgBtn);
        playerGrimReaperBtn = findViewById(R.id.playerFiveImgBtn);
        playerTheControllerBtn = findViewById(R.id.playerSixImgBtn);
        playerClydeCloneBtn = findViewById(R.id.playerSevenImgBtn);
        playerCarlBtn = findViewById(R.id.playerEightImgBtn);
        playerCatPersonBtn = findViewById(R.id.playerNineImgBtn);
        playerRandomBtn = findViewById(R.id.playerTenImgBtn);
        playerCharacterImageView = findViewById(R.id.playerSelectedCharacterImg);
        //Disable ImageButtons
        playerSuperBreadBtn.setEnabled(false);
        playerScientistBtn.setEnabled(false);
        playerGrimReaperBtn.setEnabled(false);
        playerTheControllerBtn.setEnabled(false);
        playerClydeCloneBtn.setEnabled(false);
        playerCarlBtn.setEnabled(false);
        playerCatPersonBtn.setEnabled(false);
        playerRandomBtn.setEnabled(false);
        playerRandomBtn.setVisibility(View.INVISIBLE);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getInt("character") > 0) {
                character = extras.getInt("character");
            }
        }
        if (character > 0 && character < 10) {
            setCharacterImage(character);
        }

        //Call unlockCharacters() to check for unlocked characters
        unlockCharacters();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(character > 0) {
            setCharacterImage(character);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(character > 0) {
            setCharacterImage(character);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("playerChar", character);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        character = (int) savedInstanceState.getInt("playerChar");
    }

    //Set the selected character image
    protected void setCharacterImage(int character) {
        switch (character) {
            case 1: playerCharacterImageView.setImageResource(R.drawable.clyde_player); break;
            case 2: playerCharacterImageView.setImageResource(R.drawable.owen_player); break;
            case 3: playerCharacterImageView.setImageResource(R.drawable.super_bread_player); break;
            case 4: playerCharacterImageView.setImageResource(R.drawable.scientist_player); break;
            case 5: playerCharacterImageView.setImageResource(R.drawable.grim_reaper_player); break;
            case 6: playerCharacterImageView.setImageResource(R.drawable.the_controller_player); break;
            case 7: playerCharacterImageView.setImageResource(R.drawable.clyde_clone_player); break;
            case 8: playerCharacterImageView.setImageResource(R.drawable.carl_player); break;
            case 9: playerCharacterImageView.setImageResource(R.drawable.cat_person_player); break;
        }
    }

    //Select a character value
    public void viewCharacter(View view) {
        if (view.getId() == R.id.playerOneImgBtn) {
            playerCharacterImageView.setImageResource(R.drawable.clyde_player);
            character = CLYDE;
        }
        else if (view.getId() == R.id.playerTwoImgBtn) {
            playerCharacterImageView.setImageResource(R.drawable.owen_player);
            character= OWEN;
        }
        else if (view.getId() == R.id.playerThreeImgBtn) {
            playerCharacterImageView.setImageResource(R.drawable.super_bread_player);
            character= SUPER_BREAD;
        }
        else if (view.getId() == R.id.playerFourImgBtn) {
            playerCharacterImageView.setImageResource(R.drawable.scientist_player);
            character= SCIENTIST;
        }
        else if (view.getId() == R.id.playerFiveImgBtn) {
            playerCharacterImageView.setImageResource(R.drawable.grim_reaper_player);
            character= GRIM_REAPER;
        }
        else if (view.getId() == R.id.playerSixImgBtn) {
            playerCharacterImageView.setImageResource(R.drawable.the_controller_player);
            character= THE_CONTROLLER;
        }
        else if (view.getId() == R.id.playerSevenImgBtn) {
            playerCharacterImageView.setImageResource(R.drawable.clyde_clone_player);
            character= CLYDE_CLONE;
        }
        else if (view.getId() == R.id.playerEightImgBtn) {
            playerCharacterImageView.setImageResource(R.drawable.carl_player);
            character= CARL;
        }
        else if (view.getId() == R.id.playerNineImgBtn) {
            playerCharacterImageView.setImageResource(R.drawable.cat_person_player);
            character= CAT_PERSON;
        }
        //else if (view.getId() == R.id.playerTenImgBtn) {
            //playerCharacterImageView.setImageResource(R.drawable.random_player);
        //}
    }

    //Create and call Intent to display character abilities Activity
    public void abilitiesDetails(View view) {
        if (character > 0) {
            Intent intentAbilities = new Intent(this, DisplayAbilities.class);
            intentAbilities.putExtra("character", character);
            startActivity(intentAbilities);
        }
        else {
            Toast.makeText(this,"Please select a character to view.", Toast.LENGTH_LONG).show();
        }
    }

    //create and call Intent to display opponent select Activity
    public void selectCharacter(View view) {
        if (character > 0) {
            Intent intent = new Intent(this, OpponentSelectActivity.class);
            intent.putExtra("playerChar", character);
            startActivity(intent);
        }
        else {
            Toast.makeText(this,"Please select a character.", Toast.LENGTH_LONG).show();
        }
    }

    //Create and call Intent to display stats Activity
    public void stats(View view) {
        Intent intent = new Intent(this, StatsActivity.class);
        if (character > 0) {
            intent.putExtra("character", character);
            startActivity(intent);
        }
        else {
            startActivity(intent);
        }
    }

    //Check unlocks.txt to find out which characters have been unlocked for player to use
    protected void unlockCharacters() {
        String unlocksTxt = "unlocks.txt";
        FileInputStream unlocksInputStream;
        String[] unlocksStrings;

        //Try catch block that checks if file is there then gets unlocks values from file
        //and adds them to a list/array
        try {
            //Read file contents
            unlocksInputStream = openFileInput(unlocksTxt);
            InputStreamReader inputStreamReader = new InputStreamReader(unlocksInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            line = bufferedReader.readLine();
            bufferedReader.close();
            unlocksStrings = line.split(":");

            //Check if unlocksStrings has 20 strings
            if (unlocksStrings.length == 22) {
                //Check and apply unlocks medals one-by-one

                if (unlocksStrings[8].matches("Super Bread")) {
                    if (unlocksStrings[9].matches(String.valueOf(1))) {
                        playerSuperBreadBtn.setEnabled(true);
                        playerSuperBreadBtn.setImageResource(R.drawable.super_bread_player_icon);
                    }
                }

                if (unlocksStrings[10].matches("Scientist")) {
                    if (unlocksStrings[11].matches(String.valueOf(1))) {
                        playerScientistBtn.setEnabled(true);
                        playerScientistBtn.setBackgroundResource(R.drawable.scientist_player_icon);
                    }
                }

                if (unlocksStrings[12].matches("Grim Reaper")) {
                    if (unlocksStrings[13].matches(String.valueOf(1))) {
                        playerGrimReaperBtn.setEnabled(true);
                        playerGrimReaperBtn.setBackgroundResource(R.drawable.grim_reaper_player_icon);
                    }
                }

                if (unlocksStrings[14].matches("The Controller")) {
                    if (unlocksStrings[15].matches(String.valueOf(1))) {
                        playerTheControllerBtn.setEnabled(true);
                        playerTheControllerBtn.setBackgroundResource(R.drawable.the_controller_player_icon);
                    }
                }

                if (unlocksStrings[16].matches("Clyde Clone")) {
                    if (unlocksStrings[17].matches(String.valueOf(1))) {
                        playerClydeCloneBtn.setEnabled(true);
                        playerClydeCloneBtn.setBackgroundResource(R.drawable.clyde_clone_player_icon);
                    }
                }

                if (unlocksStrings[18].matches("Carl")) {
                    if (unlocksStrings[19].matches(String.valueOf(1))) {
                        playerCarlBtn.setEnabled(true);
                        playerCarlBtn.setBackgroundResource(R.drawable.carl_player_icon);
                    }
                }
                if (unlocksStrings[20].matches("Cat Person")) {
                    if (unlocksStrings[21].matches(String.valueOf(1))) {
                        playerCatPersonBtn.setEnabled(true);
                        playerCatPersonBtn.setBackgroundResource(R.drawable.cat_person_player_icon);
                    }
                }
            }//end if statement
        } catch (Exception e) {
            //Log.e("Error", "There was an exception: " + e);
        }//end try catch block
    }
}
