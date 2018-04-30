package com.example.fake_frogs.cnogo;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private static final int CLYDE = 1;
    private static final int OWEN = 2;
    private boolean unlocks = false;
    private int character = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String statsTxt = "stats.txt";
        String unlocksTxt = "unlocks.txt";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getInt("character") > 0) {
                character = extras.getInt("character");
            }
        }

        if (checkFile(this, statsTxt)) {
            //Toast.makeText(this, "File already exists", Toast.LENGTH_SHORT).show();
            //Log.i("INFO", "File already exists");
        }
        else {
            addStatsFile(statsTxt);
        }
        if (checkFile(this, unlocksTxt)) {
            //Toast.makeText(this, "File already exists", Toast.LENGTH_SHORT).show();
            //Log.i("INFO", "File already exists");
        }
        else {
            addUnlocksFile(unlocksTxt);
            setContentView(R.layout.activity_main);
        }
        determineUnlocks();
        if (unlocks) {
            if (character > 0) {
                Intent intent = new Intent(this, PlayerSelect.class);
                intent.putExtra("character", character);
                startActivity(intent);
            }
            else {
                Intent intent = new Intent(this, PlayerSelect.class);
                startActivity(intent);
            }
        }
        else {
            setContentView(R.layout.activity_main);
        }
    }

    public void selectCharacter(View view) {
        Intent intent = new Intent(this, OpponentSelectActivity.class);
        if (view.getId() == R.id.buttonClyde) {
            intent.putExtra("playerChar", CLYDE);
            startActivity(intent);
        }
        else if (view.getId() == R.id.buttonOwen) {
            intent.putExtra("playerChar", OWEN);
            startActivity(intent);
        }
    }

    public void abilitiesDetails(View view) {
        Intent intentAbilities = new Intent(this, DisplayAbilities.class);
        if (view.getId() == R.id.buttonDetailsClyde) {
            intentAbilities.putExtra("character", CLYDE);
        }
        else if (view.getId() == R.id.buttonDetailsOwen) {
            intentAbilities.putExtra("character", OWEN);
        }
        startActivity(intentAbilities);
    }

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

    public boolean checkFile(Context context, String filename) {
        File file = context.getFileStreamPath(filename);
        if(file == null || !file.exists()) {
            return false;
        }
        return true;
    }

    protected void addStatsFile(String txtFile) {
        String statStrings = "Victories:0:Clyde:0:Owen:0:Super Bread:0:Scientist:0:Grim Reaper:0:The Controller:0:Clyde Clone:0:Carl:0:Cat Person:0";
        String filename = txtFile;
        String fileContents = statStrings;
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    protected void addUnlocksFile(String txtFile) {
        String unlocksStrings = "Unlocks:0:Victories:0:Clyde:0:Owen:0:Super Bread:0:Scientist:0:Grim Reaper:0:The Controller:0:Clyde Clone:0:Carl:0:Cat Person:0";
        String filename = txtFile;
        String fileContents = unlocksStrings;
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    protected void determineUnlocks() {
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

            //Check if unlocksStrings has 22 strings
            if (unlocksStrings.length == 22) {
                //Check to see if unlocks have been awarded
                if (unlocksStrings[0].matches("Unlocks")) {
                    if (unlocksStrings[1].matches(String.valueOf(1))) {
                        unlocks = true;
                    }
                    else {
                        unlocks = false;
                    }
                }
            }//end if statement
        } catch (Exception e) {
            //Log.e("Error", "There was an exception: " + e);
        }//end try catch block
    }
}