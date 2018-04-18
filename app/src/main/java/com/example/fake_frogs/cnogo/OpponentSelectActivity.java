package com.example.fake_frogs.cnogo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class OpponentSelectActivity extends AppCompatActivity {
    private static final int CLYDE = 1;
    private static final int OWEN = 2;
    private static final int SUPER_BREAD = 3;
    private static final int SCIENTIST = 4;
    private static final int GRIM_REAPER = 5;
    private static final int THE_CONTROLLER = 6;
    private static final int CLYDE_CLONE = 7;
    private static final int CARL = 8;
    private static final int CAT_PERSON = 9;
    private int character = 0;
    private int opponent = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opponent_select);

        //Bundle extras = getIntent().getExtras();
        Log.i("INFO", "value before: " + String.valueOf(character));
        Intent extras = getIntent();
        if (extras != null) {
            character = extras.getIntExtra("playerChar", 100);
            Log.i("INFO", "Value after: " + String.valueOf(character));
        }

        if (character == 1) {
            //Display Clyde as player character
        }
        else if (character == 2) {
            //Display Owen as player character
        }

    }

    //Methods for onClick events of opponent imageButtons
    public void OpponentOne(View view) { opponent = CLYDE; Toast.makeText(this, "Clyde selected", Toast.LENGTH_SHORT).show();}

    public void OpponentTwo(View view) { opponent = OWEN; Toast.makeText(this, "Owen selected", Toast.LENGTH_SHORT).show();}

    public void OpponentThree(View view) { opponent = SUPER_BREAD; Toast.makeText(this, "Super Bread selected", Toast.LENGTH_SHORT).show();}

    public void OpponentFour(View view) { opponent = SCIENTIST; Toast.makeText(this, "Scientist selected", Toast.LENGTH_SHORT).show();}

    public void OpponentFive(View view) { opponent = GRIM_REAPER; Toast.makeText(this, "Grim Reaper selected", Toast.LENGTH_SHORT).show();}

    public void OpponentSix(View view) { opponent = THE_CONTROLLER; Toast.makeText(this, "The Controller selected", Toast.LENGTH_SHORT).show();}

    public void OpponentSeven(View view) { opponent = CLYDE_CLONE; Toast.makeText(this, "Clyde Clone selected", Toast.LENGTH_SHORT).show();}

    public void OpponentEight(View view) { opponent = CARL; Toast.makeText(this, "Carl selected", Toast.LENGTH_SHORT).show();}

    public void OpponentNine(View view) { opponent = CAT_PERSON; Toast.makeText(this, "Cat Person selected", Toast.LENGTH_SHORT).show();}

    public void OpponentTen(View view) {
        Random rand = new Random();
        int randomChar = rand.nextInt(9) + 1;
        Toast.makeText(this, "Random character " + Integer.toString(randomChar) + " selected", Toast.LENGTH_SHORT).show();
        opponent = randomChar;
    }

    //Method for onClick of Play button
    public void playMatch(View view) {
        if(opponent > 0 && opponent < 11) {
            Intent intent = new Intent(this, MatchActivity.class);
            intent.putExtra("playerChar", character);
            intent.putExtra("opponent", opponent);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        else {
            //Display "Choose an opponent" message
            Toast.makeText(this, "Please select an opponent", Toast.LENGTH_LONG).show();
        }
    }
}
