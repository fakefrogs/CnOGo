package com.example.fake_frogs.cnogo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MatchActivity extends AppCompatActivity {
    /**/
    private int stepOne = 0;
    private int stepTwo = 0;
    private int stepThree = 0;

    //Initialize player default variables
    private int player = 0;
    private double playerHealth = 0;
    /*
    private double playerAbilityOne = 0;
    private double playerAbilityTwo = 0;
    private boolean playerAbilityTwoActive = false;
    private boolean playerAbilityThreeActive = false;
    */
    //Initialize opponent default variables
    private int opponent = 0;
    private double opponentHealth = 0;
    /*
    private double opponentAbilityOne = 0;
    private double opponentAbilityTwo = 0;
    private boolean opponentAbilityTwoActive = false;
    private boolean opponentAbilityThreeActive = false;
    */
    //Initialize other variables
    private boolean playerWinner = false;
    private boolean victory = false;
    private boolean playerMove = true;
    private boolean opponentMove = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.combat_stage);

        //Get passed values from intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //if extras contains values, assign them to variables
            player = extras.getInt("playerChar");
            opponent = extras.getInt("opponent");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    //
    //  Temporary methods to end match
    //
    public void buttonOne(View view) {
        stepOne = 1;
        testMatchEnd(stepOne, stepTwo, stepThree);
    }

    public  void buttonTwo(View view) {
        stepTwo = 2;
        testMatchEnd(stepOne, stepTwo, stepThree);
    }

    public void buttonThree(View iew) {
        stepThree = 3;
        testMatchEnd(stepOne, stepTwo, stepThree);
    }

    public void testMatchEnd(int valueOne, int valueTwo, int valueThree) {
        if(valueOne == 1 && valueTwo == 2 && valueThree == 3) {
            playerWinner = true;
            Intent intent = new Intent(this, EndMatch.class);
            intent.putExtra("playerChar", player);
            intent.putExtra("opponent", opponent);
            intent.putExtra("winner", playerWinner);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        else { return; }
    }
    //
    //  End temporary methods to end match
    //

    //
    //  Work in progress methods for gameplay mechanics
    //
    private void PlayerMove() {
        //Processes done during player's move
    }

    private void OpponentMove() {
        //Processes done during opponent's move
    }

    private void PlayerAbilityThree() {
        //Ability three traits
    }

    private void OpponentAbilityThree() {
        //Ability three traits
    }

    private void DecisionStructure() {
        //Choose which ability the opponent uses
    }

    //Method to check player and opponent health
    private void CheckHP() {
        if (playerHealth == 0) {
            victory = true;
            playerWinner = false;
            Victory();
        }
        else if (opponentHealth == 0) {
            victory = true;
            playerWinner = true;
            Victory();
        }
        else {
            victory = false;
            playerWinner = false;
            Victory();
        }
    }

    //Method used to determine victory
    private void Victory() {
        if (victory) { EndMatch(); }
        else { NextMove(); }
    }

    //Method used to begin next move
    private void NextMove() {
        if (playerMove) { PlayerMove(); }
        else { OpponentMove(); }
    }

    //Method used to end the match and start EndMatch activity
    private void EndMatch() {
        Intent intent = new Intent(this, EndMatch.class);
        intent.putExtra("playerChar", player);
        intent.putExtra("opponent", opponent);
        intent.putExtra("winner", playerWinner);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}
