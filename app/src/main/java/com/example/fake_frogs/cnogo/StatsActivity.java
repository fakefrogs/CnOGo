package com.example.fake_frogs.cnogo;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class StatsActivity extends AppCompatActivity {
    private int character = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        String statsTxt = "stats.txt";
        String unlocksTxt = "unlocks.txt";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getInt("character") > 0) {
                character = extras.getInt("character");
            }
        }

        if (checkFile(this, statsTxt)) {
            displayStats();
        }
        else {
            Toast.makeText(this,"Stats file not found.", Toast.LENGTH_LONG).show();
        }
        if (checkFile(this, unlocksTxt)) {
            displayUnlocks();
        }
        else {
            Toast.makeText(this,"Unlocks file not found.", Toast.LENGTH_LONG).show();
        }

    }

    public void backToCharactersFromStats(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        if (character > 0) {
            intent.putExtra("character", character);
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP );
        startActivity(intent);
    }

    //Method to check if a file exists
    public boolean checkFile(Context context, String filename) {
        File file = context.getFileStreamPath(filename);
        if(file == null || !file.exists()) {
            return false;
        }
        return true;
    }

    //Display titles and values from stat.txt
    protected void displayStats() {
        String statsTxt = "stats.txt";
        FileInputStream statsInputStream;
        String[] statStrings;

        //Try catch block that checks if file is there then gets stat titles and values from file
        //and adds them to a list/array
        try {
            //Read file contents
            statsInputStream = openFileInput(statsTxt);
            InputStreamReader inputStreamReader = new InputStreamReader(statsInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            line = bufferedReader.readLine();
            bufferedReader.close();
            statStrings = line.split(":");

            //Check if statStrings has 20 strings
            if (statStrings.length == 20) {
                //Check and apply stat titles and values one-by-one
                if (statStrings[0].matches("Victories")) {
                    TextView victoriesTitle = findViewById(R.id.victoriesTitle);
                    TextView victoriesValue = findViewById(R.id.victoriesValue);
                    victoriesTitle.setText(statStrings[0]);
                    victoriesValue.setText(statStrings[1]);
                }

                if (statStrings[2].matches("Clyde")) {
                    TextView clydeTitle = findViewById(R.id.clydeTitle);
                    TextView clydeValue = findViewById(R.id.clydeValue);
                    clydeTitle.setText(statStrings[2]);
                    clydeValue.setText(statStrings[3]);
                }

                if (statStrings[4].matches("Owen")) {
                    TextView owenTitle = findViewById(R.id.owenTitle);
                    TextView owenValue = findViewById(R.id.owenValue);
                    owenTitle.setText(statStrings[4]);
                    owenValue.setText(statStrings[5]);
                }

                if (statStrings[6].matches("Super Bread")) {
                    TextView superBreadTitle = findViewById(R.id.superBreadTitle);
                    TextView superBreadValue = findViewById(R.id.superBreadValue);
                    superBreadTitle.setText(statStrings[6]);
                    superBreadValue.setText(statStrings[7]);
                }

                if (statStrings[8].matches("Scientist")) {
                    TextView scientistTitle = findViewById(R.id.scientistTitle);
                    TextView scientistValue = findViewById(R.id.scientistValue);
                    scientistTitle.setText(statStrings[8]);
                    scientistValue.setText(statStrings[9]);
                }

                if (statStrings[10].matches("Grim Reaper")) {
                    TextView grimReaperTitle = findViewById(R.id.grimReaperTitle);
                    TextView grimReaperValue = findViewById(R.id.grimReaperValue);
                    grimReaperTitle.setText(statStrings[10]);
                    grimReaperValue.setText(statStrings[11]);
                }

                if (statStrings[12].matches("The Controller")) {
                    TextView theControllerTitle = findViewById(R.id.theControllerTitle);
                    TextView theControllerValue = findViewById(R.id.theControllerValue);
                    theControllerTitle.setText(statStrings[12]);
                    theControllerValue.setText(statStrings[13]);
                }

                if (statStrings[14].matches("Clyde Clone")) {
                    TextView clydeCloneTitle = findViewById(R.id.clydeCloneTitle);
                    TextView clydeCloneValue = findViewById(R.id.clydeCloneValue);
                    clydeCloneTitle.setText(statStrings[14]);
                    clydeCloneValue.setText(statStrings[15]);
                }

                if (statStrings[16].matches("Carl")) {
                    TextView charOneTitle = findViewById(R.id.carlTitle);
                    TextView charOneValue = findViewById(R.id.carlValue);
                    charOneTitle.setText(statStrings[16]);
                    charOneValue.setText(statStrings[17]);
                }

                if (statStrings[18].matches("Cat Person")) {
                    TextView charTwoTitle = findViewById(R.id.catPersonTitle);
                    TextView charTwoValue = findViewById(R.id.catPersonValue);
                    charTwoTitle.setText(statStrings[18]);
                    charTwoValue.setText(statStrings[19]);
                }
            }//end if statement
        } catch (Exception e) {
            //Log.e("Error", "There was an exception: " + e);
        }//end try catch block
    }

    //Read unlocks.txt to determine which medals have been awarded
    protected void displayUnlocks() {
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
                if (unlocksStrings[2].matches("Victories")) {
                    ImageView victoriesMedals = findViewById(R.id.victoriesMedalsImageview);
                    if (unlocksStrings[3].matches(String.valueOf(0))) {
                        victoriesMedals.setImageResource(R.drawable.medals_locked);
                    }
                    else if (unlocksStrings[3].matches(String.valueOf(1))) {
                        victoriesMedals.setImageResource(R.drawable.victories_medals_one);
                    }
                    else if (unlocksStrings[3].matches(String.valueOf(2))) {
                        victoriesMedals.setImageResource(R.drawable.victories_medals_one);
                    }
                    else if (unlocksStrings[3].matches(String.valueOf(3))) {
                        victoriesMedals.setImageResource(R.drawable.victories_medals_one);
                    }
                }

                if (unlocksStrings[4].matches("Clyde")) {
                    ImageView clydeMedals = findViewById(R.id.clydeMedalsImageview);
                    if (unlocksStrings[5].matches(String.valueOf(0))) {
                        clydeMedals.setImageResource(R.drawable.medals_locked);
                    }
                    else if (unlocksStrings[5].matches(String.valueOf(1))) {
                        clydeMedals.setImageResource(R.drawable.character_medals_one);
                    }
                    else if (unlocksStrings[5].matches(String.valueOf(2))) {
                        clydeMedals.setImageResource(R.drawable.character_medals_two);
                    }
                    else if (unlocksStrings[5].matches(String.valueOf(3))) {
                        clydeMedals.setImageResource(R.drawable.character_medals_three);
                    }
                }

                if (unlocksStrings[6].matches("Owen")) {
                    ImageView owenMedals = findViewById(R.id.owenMedalsImageview);
                    if (unlocksStrings[7].matches(String.valueOf(0))) {
                        owenMedals.setImageResource(R.drawable.medals_locked);
                    }
                    else if (unlocksStrings[7].matches(String.valueOf(1))) {
                        owenMedals.setImageResource(R.drawable.character_medals_one);
                    }
                    else if (unlocksStrings[7].matches(String.valueOf(2))) {
                        owenMedals.setImageResource(R.drawable.character_medals_two);
                    }
                    else if (unlocksStrings[7].matches(String.valueOf(3))) {
                        owenMedals.setImageResource(R.drawable.character_medals_three);
                    }
                }

                if (unlocksStrings[8].matches("Super Bread")) {
                    ImageView superBreadMedals = findViewById(R.id.superBreadMedalsImageview);
                    if (unlocksStrings[9].matches(String.valueOf(0))) {
                        superBreadMedals.setImageResource(R.drawable.medals_locked);
                    }
                    else if (unlocksStrings[9].matches(String.valueOf(1))) {
                        superBreadMedals.setImageResource(R.drawable.character_medals_one);
                    }
                    else if (unlocksStrings[9].matches(String.valueOf(2))) {
                        superBreadMedals.setImageResource(R.drawable.character_medals_two);
                    }
                    else if (unlocksStrings[9].matches(String.valueOf(3))) {
                        superBreadMedals.setImageResource(R.drawable.character_medals_three);
                    }
                }

                if (unlocksStrings[10].matches("Scientist")) {
                    ImageView scientistMedals = findViewById(R.id.scientistMedalsImageview);
                    if (unlocksStrings[11].matches(String.valueOf(0))) {
                        scientistMedals.setImageResource(R.drawable.medals_locked);
                    }
                    else if (unlocksStrings[11].matches(String.valueOf(1))) {
                        scientistMedals.setImageResource(R.drawable.character_medals_one);
                    }
                    else if (unlocksStrings[11].matches(String.valueOf(2))) {
                        scientistMedals.setImageResource(R.drawable.character_medals_two);
                    }
                    else if (unlocksStrings[11].matches(String.valueOf(3))) {
                        scientistMedals.setImageResource(R.drawable.character_medals_three);
                    }
                }

                if (unlocksStrings[12].matches("Grim Reaper")) {
                    ImageView grimReaperMedals = findViewById(R.id.grimReaperMedalsImageview);
                    if (unlocksStrings[13].matches(String.valueOf(0))) {
                        grimReaperMedals.setImageResource(R.drawable.medals_locked);
                    }
                    else if (unlocksStrings[13].matches(String.valueOf(1))) {
                        grimReaperMedals.setImageResource(R.drawable.character_medals_one);
                    }
                    else if (unlocksStrings[13].matches(String.valueOf(2))) {
                        grimReaperMedals.setImageResource(R.drawable.character_medals_two);
                    }
                    else if (unlocksStrings[13].matches(String.valueOf(3))) {
                        grimReaperMedals.setImageResource(R.drawable.character_medals_three);
                    }
                }

                if (unlocksStrings[14].matches("The Controller")) {
                    ImageView theControllerMedals = findViewById(R.id.theControllerMedalsImageview);
                    if (unlocksStrings[15].matches(String.valueOf(0))) {
                        theControllerMedals.setImageResource(R.drawable.medals_locked);
                    }
                    else if (unlocksStrings[15].matches(String.valueOf(1))) {
                        theControllerMedals.setImageResource(R.drawable.character_medals_one);
                    }
                    else if (unlocksStrings[15].matches(String.valueOf(2))) {
                        theControllerMedals.setImageResource(R.drawable.character_medals_two);
                    }
                    else if (unlocksStrings[15].matches(String.valueOf(3))) {
                        theControllerMedals.setImageResource(R.drawable.character_medals_three);
                    }
                }

                if (unlocksStrings[16].matches("Clyde Clone")) {
                    ImageView clydeCloneMedals = findViewById(R.id.clydeCloneMedalsImageview);
                    if (unlocksStrings[17].matches(String.valueOf(0))) {
                        clydeCloneMedals.setImageResource(R.drawable.medals_locked);
                    }
                    else if (unlocksStrings[17].matches(String.valueOf(1))) {
                        clydeCloneMedals.setImageResource(R.drawable.character_medals_one);
                    }
                    else if (unlocksStrings[17].matches(String.valueOf(2))) {
                        clydeCloneMedals.setImageResource(R.drawable.character_medals_two);
                    }
                    else if (unlocksStrings[17].matches(String.valueOf(3))) {
                        clydeCloneMedals.setImageResource(R.drawable.character_medals_three);
                    }
                }

                if (unlocksStrings[18].matches("Carl")) {
                    ImageView carlMedals = findViewById(R.id.carlMedalsImageview);
                    if (unlocksStrings[19].matches(String.valueOf(0))) {
                        carlMedals.setImageResource(R.drawable.medals_locked);
                    }
                    else if (unlocksStrings[19].matches(String.valueOf(1))) {
                        carlMedals.setImageResource(R.drawable.character_medals_one);
                    }
                    else if (unlocksStrings[19].matches(String.valueOf(2))) {
                        carlMedals.setImageResource(R.drawable.character_medals_two);
                    }
                    else if (unlocksStrings[19].matches(String.valueOf(3))) {
                        carlMedals.setImageResource(R.drawable.character_medals_three);
                    }
                }
                if (unlocksStrings[20].matches("Cat Person")) {
                    ImageView catPersonMedals = findViewById(R.id.catPersonMedalsImageview);
                    if (unlocksStrings[21].matches(String.valueOf(0))) {
                        catPersonMedals.setImageResource(R.drawable.medals_locked);
                    }
                    else if (unlocksStrings[21].matches(String.valueOf(1))) {
                        catPersonMedals.setImageResource(R.drawable.character_medals_one);
                    }
                    else if (unlocksStrings[21].matches(String.valueOf(2))) {
                        catPersonMedals.setImageResource(R.drawable.character_medals_two);
                    }
                    else if (unlocksStrings[21].matches(String.valueOf(3))) {
                        catPersonMedals.setImageResource(R.drawable.character_medals_three);
                    }
                }
            }//end if statement
        } catch (Exception e) {
            //Log.e("Error", "There was an exception: " + e);
        }//end try catch block
    }
}
