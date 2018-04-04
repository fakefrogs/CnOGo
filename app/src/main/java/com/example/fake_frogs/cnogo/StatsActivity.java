package com.example.fake_frogs.cnogo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class StatsActivity extends AppCompatActivity {//private Context context = getApplicationContext();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        String statsTxt = "stats.txt";

        if (checkFile(this, statsTxt)) {
            displayStats();
            Toast.makeText(this, "File already exists", Toast.LENGTH_LONG).show();
        }
        else {
            //addStatsFile(statsTxt);
            Toast.makeText(this,"File not found.", Toast.LENGTH_LONG).show();
        }

    }

    public void backToCharacters(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);// | Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent);
    }

    public boolean checkFile(Context context, String filename) {
        File file = context.getFileStreamPath(filename);
        if(file == null || !file.exists()) {
            return false;
        }
        return true;
    }

    protected void displayStats() {
        //Toast.makeText(this,"displayStats() called", Toast.LENGTH_LONG).show();
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
                //Toast.makeText(this,"statStrings contains 20 items", Toast.LENGTH_LONG).show();
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

                if (statStrings[16].matches("CharOne")) {
                    TextView charOneTitle = findViewById(R.id.charOneTitle);
                    TextView charOneValue = findViewById(R.id.charOneValue);
                    charOneTitle.setText(statStrings[16]);
                    charOneValue.setText(statStrings[17]);
                }

                if (statStrings[18].matches("CharTwo")) {
                    TextView charTwoTitle = findViewById(R.id.charTwoTitle);
                    TextView charTwoValue = findViewById(R.id.charTwoValue);
                    charTwoTitle.setText(statStrings[18]);
                    charTwoValue.setText(statStrings[19]);
                }
            }//end if statement
        } catch (Exception e) {
            Log.e("Error", "There was an exception: " + e);
        }//end try catch block
    }
}
