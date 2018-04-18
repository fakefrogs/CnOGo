package com.example.fake_frogs.cnogo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class EndMatch extends AppCompatActivity {
    private int player = 0;
    private int opponent = 0;
    private boolean winner = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_match);
        String statsTxt = "stats.txt";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            player = extras.getInt("playerChar");
            opponent = extras.getInt("opponent");
            winner = extras.getBoolean("winner");
        }

        if (winner) {
            if (checkFile(this, statsTxt)) {
                //Toast.makeText(this,"File found.", Toast.LENGTH_LONG).show();
                Log.i("INFO", "File found");
                UpdateStats();
            }
            else {
                //Toast.makeText(this, "File not found.", Toast.LENGTH_LONG).show();
                Log.i("ERROR", "File not found");
            }
        }
    }

    public boolean checkFile(Context context, String filename) {
        File file = context.getFileStreamPath(filename);
        if(file == null || !file.exists()) {
            return false;
        }
        return true;
    }

    protected  void UpdateStats() {
        //Toast.makeText(this,"displayStats() called", Toast.LENGTH_LONG).show();
        String statsTxt = "stats.txt";
        FileInputStream statsInputStream;
        String[] statStrings;
        String statString = "";
        int statValue;

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

            switch (opponent) {
                case 1:
                    statString = "Clyde";
                    break;
                case 2:
                    statString = "Owen";
                    break;
                case 3:
                    statString = "Super Bread";
                    break;
                case 4:
                    statString = "Scientist";
                    break;
                case 5:
                    statString = "Grim Reaper";
                    break;
                case 6:
                    statString = "The Controller";
                    break;
                case 7:
                    statString = "Clyde Clone";
                    break;
                case 8:
                    statString = "Carl";
                    break;
                case 9:
                    statString = "Cat Person";
                    break;
            }//end Switch statement

            //Check if statStrings has 20 strings
            if (statStrings.length == 20) {
                //Toast.makeText(this,"statStrings contains 20 items", Toast.LENGTH_LONG).show();
                if (statStrings[0].matches("Victories")) {
                    //Get the val of the second string in String[] -->  # of Victories
                    int victoryValue = Integer.parseInt(statStrings[1]);
                    //increase the val by 1
                    victoryValue += 1;
                    //return the val to the String[] in same location
                    statStrings[1] = Integer.toString(victoryValue);
                    //Toast.makeText(this, "statStrings[1] updated to: " + statStrings[1], Toast.LENGTH_LONG).show();
                }//end if statement

                for (int i = 0; i < statStrings.length; i = i + 2) {
                    if (statStrings[i].matches(statString)) {
                        //Toast.makeText(this, "Match found", Toast.LENGTH_LONG).show();
                        //assign value of the next string in the String[] as an int val
                        statValue = Integer.parseInt(statStrings[i + 1]);
                        //increase int value by one
                        statValue += 1;
                        //assign updated int val back to String[] at same location
                        statStrings[i + 1] = Integer.toString(statValue);
                    }//end if statement
                }//end for loop

                line = statStrings[0]+":"+statStrings[1]+":"+statStrings[2]+":"+statStrings[3]+":"+statStrings[4]+":"+
                        statStrings[5]+":"+statStrings[6]+":"+statStrings[7]+":"+statStrings[8]+":"+statStrings[9]+":"+
                        statStrings[10]+":"+statStrings[11]+":"+statStrings[12]+":"+statStrings[13]+":"+statStrings[14]+":"+
                        statStrings[15]+":"+statStrings[16]+":"+statStrings[17]+":"+statStrings[18]+":"+statStrings[19];

                FileOutputStream outputStream;

                try {
                    outputStream = openFileOutput(statsTxt, Context.MODE_PRIVATE);
                    outputStream.write(line.getBytes());
                    outputStream.close();
                    //Toast.makeText(this,"File was saved",Toast.LENGTH_LONG).show();
                    Log.i("INFO", "File was saved");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }//end if statement
        } catch (Exception e) {
            Log.e("Error", "There was an exception: " + e);
        }//end try catch block
    }

    //method for onClick event of Restart Match button
    public void restartMatch(View view) {
        Intent intent = new Intent(this, MatchActivity.class);
        intent.putExtra("playerChar", player);
        intent.putExtra("opponent", opponent);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    //method for onClick event of Character Select button
    public void characterSelect(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    //method for onClick event of Opponent Select button
    public void opponentSelect(View view) {
        Intent intent = new Intent(this, OpponentSelectActivity.class);
        intent.putExtra("playerChar", player);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
