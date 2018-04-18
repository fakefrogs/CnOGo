package com.example.fake_frogs.cnogo;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MatchActivity extends AppCompatActivity {
    final Handler handler = new Handler();
    Character playerChar;
    Character opponentChar;
    //Initialize player default variables
    private int player = 0;
    private String playerName = "";
    private double playerHealth;
    private double playerAbilityOne;
    private String playerAbilityOneString = "";
    private double playerAbilityTwo;
    private String playerAbilityTwoString = "";
    private boolean playerAbilityTwoActive = false;
    private boolean playerAbilityThreeActive = false;
    private String playerAbilityThreeString = "";
    //Initialize opponent default variables
    private int opponent = 0;
    private String opponentName = "";
    private double opponentHealth;
    private double opponentAbilityOne;
    private String opponentAbilityOneString = "";
    private double opponentAbilityTwo;
    private String opponentAbilityTwoString = "";
    private boolean opponentAbilityTwoActive = false;
    private boolean opponentAbilityThreeActive = false;
    private String opponentAbilityThreeString = "";
    //Initialize other variables
    private boolean abilityButtonOne = false;
    private boolean abilityButtonTwo = false;
    private boolean abilityButtonThree = false;
    private boolean abilityOne = false;
    private boolean abilityTwo = false;
    private boolean abilityThree = false;
    private boolean playerWinner = false;
    private boolean victory = false;
    private boolean playerMove = true;
    private boolean opponentMove = false;
    private String combatTextString = "";

    ConstraintLayout background;
    ImageView playerIconImg;
    ImageView opponentIconImg;
    ImageView playerImageView;
    ImageView opponentImageView;

    TextView playerHealthTextview;
    TextView opponentHealthTextview;
    TextView combatTextTextview;

    Button abilityOneBtn;
    Button abilityTwoBtn;
    Button abilityThreeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.combat_stage);
        background = (ConstraintLayout) findViewById(R.id.combatLayoutBackground);
        playerIconImg = (ImageView) findViewById(R.id.playerIconImage);
        opponentIconImg = (ImageView) findViewById(R.id.opponentIconImage);
        playerImageView = (ImageView) findViewById(R.id.imagePlayer);
        opponentImageView = (ImageView) findViewById(R.id.imageOpponent);
        playerHealthTextview = (TextView) findViewById(R.id.player_health_textview);
        opponentHealthTextview = (TextView) findViewById(R.id.opponent_health_textview);
        combatTextTextview = (TextView) findViewById(R.id.textCombatInfo);

        abilityOneBtn = (Button) findViewById(R.id.buttonAlilityOne);
        abilityTwoBtn = (Button) findViewById(R.id.buttonAbilityTwo);
        abilityThreeBtn = (Button) findViewById(R.id.buttonAbilityThree);

        //Get passed values from intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //if extras contains values, assign them to variables
            player = extras.getInt("playerChar");
            opponent = extras.getInt("opponent");
        }
        //Check to make sure player and opponent characters were chosen
        //before beginning match
        if (player != 0 && opponent != 0) {
            playerChar = new Character(player);
            opponentChar = new Character(opponent);
            //Set player variables
            playerHealth = playerChar.getCharacterHp();
            playerName = playerChar.getCharacterName();
            playerAbilityOne = playerChar.getAbilityOne();
            playerAbilityOneString = playerChar.getAbilityOneSting();
            playerAbilityTwo = playerChar.getAbilityTwo();
            playerAbilityTwoString = playerChar.getAbilityTwoString();
            //Set opponent variables
            opponentHealth = opponentChar.getCharacterHp();
            opponentName = opponentChar.getCharacterName();
            opponentAbilityOne = opponentChar.getAbilityOne();
            opponentAbilityOneString = opponentChar.getAbilityOneSting();
            opponentAbilityTwo = opponentChar.getAbilityTwo();
            opponentAbilityTwoString = opponentChar.getAbilityTwoString();
        }
        else {
            //If activity is called and no player and opponent values have been passed,
            //display error message in Toast and return app to MainActivity
            Toast.makeText(this, "No characters available.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP );//| Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent);
        }
        Random rand = new Random();
        int randomBackground = rand.nextInt(3) + 1;
        if (randomBackground == 1) {
            background.setBackgroundResource(R.drawable.cno_go_background);
        }
        else if (randomBackground == 2) {
            background.setBackgroundResource(R.drawable.cno_go_background);
        }
        else if (randomBackground == 3) {
            background.setBackgroundResource(R.drawable.cno_go_background);
        }
        SetCharacterIconsAndImages(player, opponent);
        playerHealthTextview.setText(String.valueOf(playerHealth));
        opponentHealthTextview.setText(String.valueOf(opponentHealth));
        combatTextTextview.setText(combatTextString);
    }

    private void SetCharacterIconsAndImages(int playerIcon, int opponentIcon) {
        switch (playerIcon) {
            case 1:
                playerIconImg.setImageResource(R.drawable.player_icon_one);
                playerImageView.setImageResource(R.drawable.clyde_one);
                break;
            case 2:
                playerIconImg.setImageResource(R.drawable.player_icon_one);
                playerImageView.setImageResource(R.drawable.clyde_one);
                break;
            case 3:
                playerIconImg.setImageResource(R.drawable.player_icon_one);
                playerImageView.setImageResource(R.drawable.clyde_one);
                break;
            case 4:
                playerIconImg.setImageResource(R.drawable.player_icon_one);
                playerImageView.setImageResource(R.drawable.clyde_one);
                break;
            case 5:
                playerIconImg.setImageResource(R.drawable.player_icon_one);
                playerImageView.setImageResource(R.drawable.clyde_one);
                break;
            case 6:
                playerIconImg.setImageResource(R.drawable.player_icon_one);
                playerImageView.setImageResource(R.drawable.clyde_one);
                break;
            case 7:
                playerIconImg.setImageResource(R.drawable.player_icon_one);
                playerImageView.setImageResource(R.drawable.clyde_one);
                break;
            case 8:
                playerIconImg.setImageResource(R.drawable.player_icon_one);
                playerImageView.setImageResource(R.drawable.clyde_one);
                break;
            case 9:
                playerIconImg.setImageResource(R.drawable.player_icon_one);
                playerImageView.setImageResource(R.drawable.clyde_one);
                break;
        }

        switch (opponentIcon) {
            case 1:
                opponentIconImg.setImageResource(R.drawable.opponent_icon_one);
                opponentImageView.setImageResource(R.drawable.owen_one);
                break;
            case 2:
                opponentIconImg.setImageResource(R.drawable.opponent_icon_one);
                opponentImageView.setImageResource(R.drawable.owen_one);
                break;
            case 3:
                opponentIconImg.setImageResource(R.drawable.opponent_icon_one);
                opponentImageView.setImageResource(R.drawable.owen_one);
                break;
            case 4:
                opponentIconImg.setImageResource(R.drawable.opponent_icon_one);
                opponentImageView.setImageResource(R.drawable.owen_one);
                break;
            case 5:
                opponentIconImg.setImageResource(R.drawable.opponent_icon_one);
                opponentImageView.setImageResource(R.drawable.owen_one);
                break;
            case 6:
                opponentIconImg.setImageResource(R.drawable.opponent_icon_one);
                opponentImageView.setImageResource(R.drawable.owen_one);
                break;
            case 7:
                opponentIconImg.setImageResource(R.drawable.opponent_icon_one);
                opponentImageView.setImageResource(R.drawable.owen_one);
                break;
            case 8:
                opponentIconImg.setImageResource(R.drawable.opponent_icon_one);
                opponentImageView.setImageResource(R.drawable.owen_one);
                break;
            case 9:
                opponentIconImg.setImageResource(R.drawable.opponent_icon_one);
                opponentImageView.setImageResource(R.drawable.owen_one);
                break;
        }
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAlilityOne:
                /*handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        combatTextString = playerName + " used " + playerAbilityOneString + "...";
                        combatTextTextview.setText(combatTextString);
                    }
                }, 3000);*/
                abilityButtonOne = true;
                abilityButtonTwo = false;
                abilityButtonThree = false;

                //Log.i("INFO", "Ability one selected");
                break;
            case R.id.buttonAbilityTwo:
                /*handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        combatTextString = playerName + " used " + playerAbilityTwoString + "...";
                        combatTextTextview.setText(combatTextString);
                    }
                }, 3000);*/
                abilityButtonOne = false;
                abilityButtonTwo = true;
                abilityButtonThree = false;

                //Log.i("INFO", "Ability two selected");
                break;
            case R.id.buttonAbilityThree:
                /*handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        combatTextString = playerName + " used " + playerAbilityThreeString + "...";
                        combatTextTextview.setText(combatTextString);
                    }
                }, 3000);*/
                abilityButtonOne = false;
                abilityButtonTwo = false;
                abilityButtonThree = true;

                //Log.i("INFO", "Ability three selected");
                break;
        }
        disableButtons();
        Log.i("INFO", "Calling PlayerMove()");
        PlayerMove();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void enableButtons() {
        abilityOneBtn.setEnabled(true);
        abilityTwoBtn.setEnabled(true);
        abilityThreeBtn.setEnabled(true);
    }

    private  void disableButtons() {
        abilityOneBtn.setEnabled(false);
        abilityTwoBtn.setEnabled(false);
        abilityThreeBtn.setEnabled(false);
    }

    private void PlayerMove() {
        //Processes done during player's move
        //Log.i("INFO", "PlayerMove() called");
        double activeDamageDealt;
        double encounteredDefense;
        combatTextTextview.setText("");
        if (abilityButtonOne) {
            /*handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    combatTextString = playerName + " used " + playerAbilityOneString + "...";
                    combatTextTextview.setText(combatTextString);
                }
            }, 3000);*/
            //Check for buffs/debuffs   to be implemented later along with ability three
            //get hit chance and apply to active damage
            activeDamageDealt = hitChance(playerAbilityOne);
            //Check to see if opponent has an active defense up and how strong it will be
            if (opponentAbilityTwoActive) {
                encounteredDefense = defenseChance(opponentAbilityTwo);
            }
            else {
                encounteredDefense = 0;
            }
            //Determine opponent's health after attack is made
            if ((activeDamageDealt - encounteredDefense) > 0) {
                opponentHealth = opponentHealth - (activeDamageDealt - encounteredDefense);
                combatTextString = playerName + " deals: " + (activeDamageDealt - encounteredDefense) + " damage to " + opponentName;
            }
            else {
                combatTextString = playerName + " deals: " + 0.0 + " damage to " + opponentName;
            }
            combatTextTextview.setText(combatTextString);
        }
        else if (abilityButtonTwo) {
            /*handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    combatTextString = playerName + " used " + playerAbilityTwoString + "...";
                    combatTextTextview.setText(combatTextString);
                }
            }, 3000);*/
            //Check for buffs/debuffs
            playerAbilityTwoActive = true;
            combatTextString = playerName + "'s defenses are up.";
            combatTextTextview.setText(combatTextString);
        }
        else if (abilityButtonThree) {
            /*handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    combatTextString = playerName + " used " + playerAbilityThreeString + "...";
                    combatTextTextview.setText(combatTextString);
                }
            }, 3000);*/
            //To be implemented later along with ability three
            combatTextString = "Nothing happened!  What a disappointment.";
            combatTextTextview.setText(combatTextString);
        }
        playerMove = false;
        opponentMove = true;
        opponentAbilityTwoActive = false;
        //Display player and opponent current health points
        playerHealthTextview.setText(String.valueOf(playerHealth));
        opponentHealthTextview.setText(String.valueOf(opponentHealth));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Log.i("INFO", "Calling CheckHP()");
                CheckHP();
            }
        }, 3000);
    }

    private void OpponentMove() {
        //Processes done during opponent's move
        //Log.i("INFO", "OpponentMove() called");
        double activeDamageDealt;
        double encounteredDefense;
        combatTextTextview.setText("");
        DecisionStructure();
        if (abilityOne) {
            /*handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    combatTextString = opponentName + " used " + opponentAbilityOneString + "...";
                    combatTextTextview.setText(combatTextString);
                }
            }, 3000);*/
            //Check for buffs/debuffs   to be implemented later along with ability three
            //get hit chance and apply to active damage
            activeDamageDealt = hitChance(opponentAbilityOne);
            //Check to see if player has an active defense up and how strong it will be
            if (playerAbilityTwoActive) {
                encounteredDefense = defenseChance(playerAbilityTwo);
            }
            else {
                encounteredDefense = 0;
            }
            //Determine opponent's health after attack is made
            if ((activeDamageDealt - encounteredDefense) > 0) {
                playerHealth = playerHealth - (activeDamageDealt - encounteredDefense);
                combatTextString = opponentName + " deals: " + (activeDamageDealt - encounteredDefense) + " damage to " + playerName;
            }
            else {
                combatTextString = opponentName + " deals: " + 0.0 + " damage to " + playerName;
            }

            combatTextTextview.setText(combatTextString);
        }
        else if (abilityTwo) {
            /*handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    combatTextString = opponentName + " used " + opponentAbilityTwoString + "...";
                    combatTextTextview.setText(combatTextString);
                }
            }, 3000);*/
            //Check for buffs/debuffs
            opponentAbilityTwoActive = true;
            combatTextString = opponentName + "'s defenses are up.";
            combatTextTextview.setText(combatTextString);
        }
        else if (abilityThree) {
            /*handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    combatTextString = opponentName + " used " + opponentAbilityThreeString + "...";
                    combatTextTextview.setText(combatTextString);
                }
            }, 3000);*/
            //To be implemented later along with ability three
            combatTextString = "Nothing happened!  What a relief.";
            combatTextTextview.setText(combatTextString);
        }
        playerMove = true;
        opponentMove = false;
        playerAbilityTwoActive = false;
        //Display player and opponent current health points
        playerHealthTextview.setText(String.valueOf(playerHealth));
        opponentHealthTextview.setText(String.valueOf(opponentHealth));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Log.i("INFO", "Calling CheckHP()");
                CheckHP();
            }
        }, 3000);
    }

    /*
    private void PlayerAbilityThree() {
        //Ability three traits
    }

    private void OpponentAbilityThree() {
        //Ability three traits
    }
    /*

     */
    private double hitChance(double abilityUno) {
        Random rand = new Random();
        int chanceOdd = rand.nextInt(100) + 1;
        if (chanceOdd > 0 && chanceOdd < 11) {
            //Hit is a miss
            abilityUno = 0;
        }
        else if (chanceOdd > 10 && chanceOdd < 51) {
            //Hit does 50% damage
            abilityUno = abilityUno / 2;
        }
        else if (chanceOdd > 50 && chanceOdd < 91) {
            //Hit does full damage
            abilityUno = abilityUno * 1;
        }
        else if (chanceOdd > 90 && chanceOdd < 101) {
            //Hit does +5 damage
            //Critical hit
            abilityUno = abilityUno + 5;
        }
        return abilityUno;
    }

    private double defenseChance( double abilityDos) {
        Random rand = new Random();
        int chanceOdd = rand.nextInt(100) + 1;
        if (chanceOdd > 0 && chanceOdd < 11) {
            //Defense fails
            abilityDos = 0;
        }
        else if (chanceOdd > 10 && chanceOdd < 51) {
            //Defense blocks 50% of damage
            abilityDos = abilityDos * 0.5;
        }
        else if (chanceOdd > 50 && chanceOdd < 91) {
            //Defense holds, blocks 75% of damage
            abilityDos = abilityDos * 0.75;
        }
        else if (chanceOdd > 90 && chanceOdd < 101) {
            //Blocks all damage
            abilityDos = abilityDos * 1;
        }
        return abilityDos;
    }

    //Method used by opponent to determine which abillity to use
    //Need to have this customized for each opponent character for unique chances of
    //using each ability.
    private void DecisionStructure() {
        //Choose which ability the opponent uses
        Random rand = new Random();
        int randomChar = rand.nextInt(100) + 1;
        if (randomChar > opponentChar.getDecisions(0) && randomChar < opponentChar.getDecisions(1)) {
            //ability one chosen
            abilityOne = true;
            abilityTwo = false;
            abilityThree = false;
        }
        else if (randomChar > opponentChar.getDecisions(2) && randomChar < opponentChar.getDecisions(3)) {
            //ability two chosen
            abilityOne = false;
            abilityTwo = true;
            abilityThree = false;
        }
        else if (randomChar > opponentChar.getDecisions(4) && randomChar < opponentChar.getDecisions(5)) {
            //ability three chosen
            abilityOne = false;
            abilityTwo = false;
            abilityThree = true;
        }
    }

    //Method to check player and opponent health
    private void CheckHP() {
        //Log.i("INFO", "CheckHP() called");
        if (playerHealth <= 0) {
            victory = true;
            playerWinner = false;
            //Log.i("INFO", "calling Victory()");
            Victory();
        }
        else if (opponentHealth <= 0) {
            victory = true;
            playerWinner = true;
            //Log.i("INFO", "calling Victory()");
            Victory();
        }
        else {
            victory = false;
            playerWinner = false;
            //Log.i("INFO", "calling Victory()");
            Victory();
        }
    }

    //Method used to determine victory
    private void Victory() {
        //Log.i("INFO", "Victory() called");
        if (victory) {
            //Log.i("INFO", "calling EndMatch()");
            EndMatch();
        }
        else {
            //Log.i("INFO", "calling NextMove()");
            NextMove();
        }
    }

    //Method used to begin next move
    private void NextMove() {
        //Log.i("INFO", "NextMove() called");
        if (playerMove) {
            enableButtons();
        }
        else {
            //Log.i("INFO", "calling OpponentMove()");
            OpponentMove();
        }
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
