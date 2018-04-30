package com.example.fake_frogs.cnogo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class EndMatch extends AppCompatActivity {
    //Constants
    private static  final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    //variables
    private int player = 0;
    private int opponent = 0;
    private boolean winner = false;
    private String[] statStrings;
    //View variables
    ImageView winnerImage;
    TextView titleTextview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_match);
        String statsTxt = "stats.txt";
        winnerImage = (ImageView) findViewById(R.id.imageWinner);
        titleTextview = (TextView) findViewById(R.id.textEndGameTitle);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            player = extras.getInt("playerChar");
            opponent = extras.getInt("opponent");
            winner = extras.getBoolean("winner");
        }

        if (winner) {
            if (checkFile(this, statsTxt)) {
                UpdateStats();
                updateUnlocks();
                titleTextview.setText(R.string.victory);
                SetWinnerImage(player);
            }
            else {
            }
        }
        else {
            titleTextview.setText(R.string.defeat);
            SetWinnerImage(opponent);
        }
    }

    private void SetWinnerImage(int character) {
        //Set winner image
        switch (character) {
            case 1:
                winnerImage.setImageResource(R.drawable.clyde_player);
                break;
            case 2:
                winnerImage.setImageResource(R.drawable.owen_player);
                break;
            case 3:
                winnerImage.setImageResource(R.drawable.super_bread_player);
                break;
            case 4:
                winnerImage.setImageResource(R.drawable.scientist_player);
                break;
            case 5:
                winnerImage.setImageResource(R.drawable.grim_reaper_player);
                break;
            case 6:
                winnerImage.setImageResource(R.drawable.the_controller_player);
                break;
            case 7:
                winnerImage.setImageResource(R.drawable.clyde_clone_player);
                break;
            case 8:
                winnerImage.setImageResource(R.drawable.carl_player);
                break;
            case 9:
                winnerImage.setImageResource(R.drawable.cat_person_player);
                break;
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
        String statsTxt = "stats.txt";
        FileInputStream statsInputStream;
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
                if (statStrings[0].matches("Victories")) {
                    //Get the val of the second string in String[] -->  # of Victories
                    int victoryValue = Integer.parseInt(statStrings[1]);
                    //increase the val by 1
                    victoryValue += 1;
                    //return the val to the String[] in same location
                    statStrings[1] = Integer.toString(victoryValue);
                }//end if statement

                for (int i = 0; i < statStrings.length; i = i + 2) {
                    if (statStrings[i].matches(statString)) {
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
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }//end if statement
        } catch (Exception e) {
            //Log.e("Error", "There was an exception: " + e);
        }//end try catch block
    }

    protected void updateUnlocks() {
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
                if (unlocksStrings[2].matches("Victories")) {
                    if (statStrings[1].matches(String.valueOf(50))) {
                        unlocksStrings[3] = ONE;
                    }
                    else if (statStrings[1].matches(String.valueOf(100))) {
                        unlocksStrings[3] = TWO;
                    }
                    else if (statStrings[1].matches(String.valueOf(200))) {
                        unlocksStrings[3] = THREE;
                    }
                }
                if (unlocksStrings[4].matches("Clyde")) {
                    if (statStrings[3].matches(String.valueOf(10))) {
                        unlocksStrings[5] = ONE;
                        //unlocksStrings[1] = ONE;
                    }
                    else if (statStrings[3].matches(String.valueOf(25))) {
                        unlocksStrings[5] = TWO;
                    }
                    else if (statStrings[3].matches(String.valueOf(50))) {
                        unlocksStrings[5] = THREE;
                    }
                }
                if (unlocksStrings[6].matches("Owen")) {
                    if (statStrings[5].matches(String.valueOf(10))) {
                        unlocksStrings[7] = ONE;
                        //unlocksStrings[1] = ONE;
                    }
                    else if (statStrings[5].matches(String.valueOf(25))) {
                        unlocksStrings[7] = TWO;
                    }
                    else if (statStrings[5].matches(String.valueOf(50))) {
                        unlocksStrings[7] = THREE;
                    }
                }
                if (unlocksStrings[8].matches("Super Bread")) {
                    if (statStrings[7].matches(String.valueOf(10))) {
                        unlocksStrings[9] = ONE;
                        unlocksStrings[1] = ONE;
                    }
                    else if (statStrings[7].matches(String.valueOf(25))) {
                        unlocksStrings[9] = TWO;
                    }
                    else if (statStrings[7].matches(String.valueOf(50))) {
                        unlocksStrings[9] = THREE;
                    }
                }
                if (unlocksStrings[10].matches("Scientist")) {
                    if (statStrings[9].matches(String.valueOf(10))) {
                        unlocksStrings[11] = ONE;
                        unlocksStrings[1] = ONE;
                    }
                    else if (statStrings[9].matches(String.valueOf(25))) {
                        unlocksStrings[11] = TWO;
                    }
                    else if (statStrings[9].matches(String.valueOf(50))) {
                        unlocksStrings[11] = THREE;
                    }
                }
                if (unlocksStrings[12].matches("Grim Reaper")) {
                    if (statStrings[11].matches(String.valueOf(10))) {
                        unlocksStrings[13] = ONE;
                        unlocksStrings[1] = ONE;
                    }
                    else if (statStrings[11].matches(String.valueOf(25))) {
                        unlocksStrings[13] = TWO;
                    }
                    else if (statStrings[11].matches(String.valueOf(50))) {
                        unlocksStrings[13] = THREE;
                    }
                }
                if (unlocksStrings[14].matches("The Controller")) {
                    if (statStrings[13].matches(String.valueOf(10))) {
                        unlocksStrings[15] = ONE;
                        unlocksStrings[1] = ONE;
                    }
                    else if (statStrings[13].matches(String.valueOf(25))) {
                        unlocksStrings[15] = TWO;
                    }
                    else if (statStrings[13].matches(String.valueOf(50))) {
                        unlocksStrings[15] = THREE;
                    }
                }
                if (unlocksStrings[16].matches("Clyde Clone")) {
                    if (statStrings[15].matches(String.valueOf(10))) {
                        unlocksStrings[17] = ONE;
                        unlocksStrings[1] = ONE;
                    }
                    else if (statStrings[15].matches(String.valueOf(25))) {
                        unlocksStrings[17] = TWO;
                    }
                    else if (statStrings[15].matches(String.valueOf(50))) {
                        unlocksStrings[17] = THREE;
                    }
                }
                if (unlocksStrings[18].matches("Carl")) {
                    if (statStrings[17].matches(String.valueOf(10))) {
                        unlocksStrings[19] = ONE;
                        unlocksStrings[1] = ONE;
                    }
                    else if (statStrings[17].matches(String.valueOf(25))) {
                        unlocksStrings[19] = TWO;
                    }
                    else if (statStrings[17].matches(String.valueOf(50))) {
                        unlocksStrings[19] = THREE;
                    }
                }
                if (unlocksStrings[20].matches("Cat Person")) {
                    if (statStrings[19].matches(String.valueOf(10))) {
                        unlocksStrings[21] = ONE;
                        unlocksStrings[1] = ONE;
                    }
                    else if (statStrings[19].matches(String.valueOf(25))) {
                        unlocksStrings[21] = TWO;
                    }
                    else if (statStrings[19].matches(String.valueOf(50))) {
                        unlocksStrings[21] = THREE;
                    }
                }

                line = unlocksStrings[0]+":"+unlocksStrings[1]+":"+unlocksStrings[2]+":"+unlocksStrings[3]+":"+unlocksStrings[4]+":"+
                        unlocksStrings[5]+":"+unlocksStrings[6]+":"+unlocksStrings[7]+":"+unlocksStrings[8]+":"+unlocksStrings[9]+":"+
                        unlocksStrings[10]+":"+unlocksStrings[11]+":"+unlocksStrings[12]+":"+unlocksStrings[13]+":"+unlocksStrings[14]+":"+
                        unlocksStrings[15]+":"+unlocksStrings[16]+":"+unlocksStrings[17]+":"+unlocksStrings[18]+":"+unlocksStrings[19]+":"+
                        unlocksStrings[20]+":"+unlocksStrings[21];

                FileOutputStream outputStream;

                try {
                    outputStream = openFileOutput(unlocksTxt, Context.MODE_PRIVATE);
                    outputStream.write(line.getBytes());
                    outputStream.close();
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }//end if statement
        } catch (Exception e) {
            //Log.e("Error", "There was an exception: " + e);
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
