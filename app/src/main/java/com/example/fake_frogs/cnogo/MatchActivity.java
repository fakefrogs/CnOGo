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
    private double playerAbilityTwo;
    private String playerAbilityTwoString = "";
    private boolean playerAbilityTwoActive = false;
    private String playerAbilityThreeString = "";
    //Initialize opponent default variables
    private int opponent = 0;
    private String opponentName = "";
    private double opponentHealth;
    private double opponentAbilityOne;
    private double opponentAbilityTwo;
    private String opponentAbilityTwoString = "";
    private boolean opponentAbilityTwoActive = false;
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
    //ability three variables
    private String playerAbilityOneString = "";
    private boolean playerAbilityThreeActive = false;
    private String opponentAbilityOneString = "";
    private boolean opponentAbilityThreeActive = false;
    private boolean playerAttackBuffActive = false;
    private boolean playerDefenseBuffActive = false;
    private boolean playerAttackDebuffActive = false;
    private boolean playerDefenseDebuffActive = false;
    private boolean opponentAttackBuffActive = false;
    private boolean opponentDefenseBuffActive = false;
    private boolean opponentAttackDebuffActive = false;
    private boolean opponentDefenseDebuffActive = false;
    private double playerHealthBuff = 0;
    private double opponentHealthBuff = 0;
    private double playerAttackBuff = 0;
    private double playerDefenseBuff = 0;
    private double playerAttackDebuff = 0;
    private double playerDefenseDebuff = 0;
    private double playerActiveDefense;
    private double opponentAttackBuff = 0;
    private double opponentDefenseBuff = 0;
    private double opponentAttackDebuff = 0;
    private double opponentDefenseDebuff = 0;
    private double opponentActiveDefense;
    private int playerCooldown = 0;
    private int opponentCooldown = 0;
    //combat text string variables
    private String used;
    private String period;
    private String dashes;
    private String takes;
    private String damage;
    private String missed;
    private String defensesUp;
    private String playerDisappointmentString;
    private String opponentDisappointmentString;
    //View variables
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
        //Initialize Views
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
        //Initialize text strings for combatTextString use
        used = getString(R.string.used);
        period = getString(R.string.period);
        dashes = getString(R.string.dashes);
        takes = getString(R.string.takes);
        damage = getString(R.string.damage);
        missed = getString(R.string.missed);
        defensesUp = getString(R.string.defenses_up);
        playerDisappointmentString = getString(R.string.player_ability_three_disappointment);
        opponentDisappointmentString = getString(R.string.opponent_ability_three_disappointment);

        //Get passed values from intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //if extras contains values, assign them to variables
            player = extras.getInt("playerChar");
            opponent = extras.getInt("opponent");
        }

        //Check to make sure player and opponent characters were chosen
        //before beginning match
        if (player != 0 || opponent != 0) {
            playerChar = new Character(player);
            opponentChar = new Character(opponent);
            //Set player variables
            playerHealth = playerChar.getCharacterHp();
            playerName = playerChar.getCharacterName();
            playerAbilityOne = playerChar.getAbilityOne();
            playerAbilityTwo = playerChar.getAbilityTwo();
            //Set opponent variables
            opponentHealth = opponentChar.getCharacterHp();
            opponentName = opponentChar.getCharacterName();
            if (opponent == 5) {
                opponentAbilityOne = opponentChar.getAbilityOne() + 10;
            }
            else {
                opponentAbilityOne = opponentChar.getAbilityOne();
            }
            opponentAbilityTwo = opponentChar.getAbilityTwo();
        }
        else {
            //If activity is called and no player or opponent values have been passed,
            //display error message in Toast and return app to MainActivity
            Toast.makeText(this, "No characters available.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP );//| Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent);
        }

        //Set background
        Random rand = new Random();
        int randomBackground = rand.nextInt(3) + 1;
        if (randomBackground == 1) {
            background.setBackgroundResource(R.drawable.cno_background_one);
        }
        else if (randomBackground == 2) {
            background.setBackgroundResource(R.drawable.cno_background_two);
        }
        else if (randomBackground == 3) {
            background.setBackgroundResource(R.drawable.cno_background_three);
        }

        //Set Character images
        SetCharacterResources(player, opponent);

        //Set starting health
        playerHealthTextview.setText(String.valueOf(playerHealth));
        opponentHealthTextview.setText(String.valueOf(opponentHealth));

        //Initialize combat TextView
        combatTextTextview.setText(combatTextString);
    }



    //------  Set Character Resources  ------//



    private void SetCharacterResources(int player, int opponent) {
        //Set player's images
        switch (player) {
            case 1:
                playerIconImg.setImageResource(R.drawable.clyde_player_icon);
                playerImageView.setImageResource(R.drawable.clyde_player);
                abilityOneBtn.setText(R.string.glare);
                abilityTwoBtn.setText(R.string.ignore);
                abilityThreeBtn.setText(R.string.passive_indifference);
                playerAbilityOneString = getString(R.string.glare);
                playerAbilityTwoString = getString(R.string.ignore);
                playerAbilityThreeString = getString(R.string.passive_indifference);
                break;
            case 2:
                playerIconImg.setImageResource(R.drawable.owen_player_icon);
                playerImageView.setImageResource(R.drawable.owen_player);
                abilityOneBtn.setText(R.string.bad_jokes);
                abilityTwoBtn.setText(R.string.friendly_smile);
                abilityThreeBtn.setText(R.string.punishment);
                playerAbilityOneString = getString(R.string.bad_jokes);
                playerAbilityTwoString = getString(R.string.friendly_smile);
                playerAbilityThreeString = getString(R.string.punishment);
                break;
            case 3:
                playerIconImg.setImageResource(R.drawable.super_bread_player_icon);
                playerImageView.setImageResource(R.drawable.super_bread_player);
                abilityOneBtn.setText(R.string.super_strength);
                abilityTwoBtn.setText(R.string.super_flight);
                abilityThreeBtn.setText(R.string.super_yeast);
                playerAbilityOneString = getString(R.string.super_strength);
                playerAbilityTwoString = getString(R.string.super_flight);
                playerAbilityThreeString = getString(R.string.super_yeast);
                break;
            case 4:
                playerIconImg.setImageResource(R.drawable.scientist_player_icon);
                playerImageView.setImageResource(R.drawable.scientist_player);
                abilityOneBtn.setText(R.string.poke_with_a_stick);
                abilityTwoBtn.setText(R.string.hide_behind_clipboard);
                abilityThreeBtn.setText(R.string.scientific_lecture);
                playerAbilityOneString = getString(R.string.poke_with_a_stick);
                playerAbilityTwoString = getString(R.string.hide_behind_clipboard);
                playerAbilityThreeString = getString(R.string.scientific_lecture);
                break;
            case 5:
                playerIconImg.setImageResource(R.drawable.grim_reaper_player_icon);
                playerImageView.setImageResource(R.drawable.grim_reaper_player);
                abilityOneBtn.setText(R.string.scythe);
                abilityTwoBtn.setText(R.string.empty_cloak);
                abilityThreeBtn.setText(R.string.immortality);
                playerAbilityOneString = getString(R.string.scythe);
                playerAbilityTwoString = getString(R.string.empty_cloak);
                playerAbilityThreeString = getString(R.string.immortality);
                break;
            case 6:
                playerIconImg.setImageResource(R.drawable.the_controller_player_icon);
                playerImageView.setImageResource(R.drawable.the_controller_player);
                abilityOneBtn.setText(R.string.the_power);
                abilityTwoBtn.setText(R.string.pause);
                abilityThreeBtn.setText(R.string.rewind);
                playerAbilityOneString = getString(R.string.the_power);
                playerAbilityTwoString = getString(R.string.pause);
                playerAbilityThreeString = getString(R.string.rewind);
                break;
            case 7:
                playerIconImg.setImageResource(R.drawable.clyde_clone_player_icon);
                playerImageView.setImageResource(R.drawable.clyde_clone_player);
                abilityOneBtn.setText(R.string.scheme);
                abilityTwoBtn.setText(R.string.impersonate);
                abilityThreeBtn.setText(R.string.clone_o_max);
                playerAbilityOneString = getString(R.string.scheme);
                playerAbilityTwoString = getString(R.string.impersonate);
                playerAbilityThreeString = getString(R.string.clone_o_max);
                break;
            case 8:
                playerIconImg.setImageResource(R.drawable.carl_player_icon);
                playerImageView.setImageResource(R.drawable.carl_player);
                abilityOneBtn.setText(R.string.awkwardness);
                abilityTwoBtn.setText(R.string.sofa_cushion);
                abilityThreeBtn.setText(R.string.forgotten_about);
                playerAbilityOneString = getString(R.string.awkwardness);
                playerAbilityTwoString = getString(R.string.sofa_cushion);
                playerAbilityThreeString = getString(R.string.forgotten_about);
                break;
            case 9:
                playerIconImg.setImageResource(R.drawable.cat_person_player_icon);
                playerImageView.setImageResource(R.drawable.cat_person_player);
                abilityOneBtn.setText(R.string.hairball);
                abilityTwoBtn.setText(R.string.superiority);
                abilityThreeBtn.setText(R.string.judging_stare);
                playerAbilityOneString = getString(R.string.hairball);
                playerAbilityTwoString = getString(R.string.superiority);
                playerAbilityThreeString = getString(R.string.judging_stare);
                break;
        }
        //set opponent's images
        switch (opponent) {
            case 1:
                opponentIconImg.setImageResource(R.drawable.clyde_opponent_icon);
                opponentImageView.setImageResource(R.drawable.clyde_opponent);
                opponentAbilityOneString = getString(R.string.glare);
                opponentAbilityTwoString = getString(R.string.ignore);
                opponentAbilityThreeString = getString(R.string.passive_indifference);
                break;
            case 2:
                opponentIconImg.setImageResource(R.drawable.owen_opponent_icon);
                opponentImageView.setImageResource(R.drawable.owen_opponent);
                opponentAbilityOneString = getString(R.string.bad_jokes);
                opponentAbilityTwoString = getString(R.string.friendly_smile);
                opponentAbilityThreeString = getString(R.string.punishment);
                break;
            case 3:
                opponentIconImg.setImageResource(R.drawable.super_bread_opponent_icon);
                opponentImageView.setImageResource(R.drawable.super_bread_opponent);
                opponentAbilityOneString = getString(R.string.super_strength);
                opponentAbilityTwoString = getString(R.string.super_flight);
                opponentAbilityThreeString = getString(R.string.super_yeast);
                break;
            case 4:
                opponentIconImg.setImageResource(R.drawable.scientist_opponent_icon);
                opponentImageView.setImageResource(R.drawable.scientist_opponent);
                opponentAbilityOneString = getString(R.string.poke_with_a_stick);
                opponentAbilityTwoString = getString(R.string.hide_behind_clipboard);
                opponentAbilityThreeString = getString(R.string.scientific_lecture);
                break;
            case 5:
                opponentIconImg.setImageResource(R.drawable.grim_reaper_opponent_icon);
                opponentImageView.setImageResource(R.drawable.grim_reaper_opponent);
                opponentAbilityOneString = getString(R.string.scythe);
                opponentAbilityTwoString = getString(R.string.empty_cloak);
                opponentAbilityThreeString = getString(R.string.immortality);
                break;
            case 6:
                opponentIconImg.setImageResource(R.drawable.the_controller_opponent_icon);
                opponentImageView.setImageResource(R.drawable.the_controller_opponent);
                opponentAbilityOneString = getString(R.string.the_power);
                opponentAbilityTwoString = getString(R.string.pause);
                opponentAbilityThreeString = getString(R.string.rewind);
                break;
            case 7:
                opponentIconImg.setImageResource(R.drawable.clyde_clone_opponent_icon);
                opponentImageView.setImageResource(R.drawable.clyde_clone_opponent);
                opponentAbilityOneString = getString(R.string.scheme);
                opponentAbilityTwoString = getString(R.string.impersonate);
                opponentAbilityThreeString = getString(R.string.clone_o_max);
                break;
            case 8:
                opponentIconImg.setImageResource(R.drawable.carl_opponent_icon);
                opponentImageView.setImageResource(R.drawable.carl_opponent);
                opponentAbilityOneString = getString(R.string.awkwardness);
                opponentAbilityTwoString = getString(R.string.sofa_cushion);
                opponentAbilityThreeString = getString(R.string.forgotten_about);
                break;
            case 9:
                opponentIconImg.setImageResource(R.drawable.cat_person_opponent_icon);
                opponentImageView.setImageResource(R.drawable.cat_person_opponent);
                opponentAbilityOneString = getString(R.string.hairball);
                opponentAbilityTwoString = getString(R.string.superiority);
                opponentAbilityThreeString = getString(R.string.judging_stare);
                break;
        }
    }



    //------  Button Click ------//



    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAlilityOne:
                abilityButtonOne = true;
                abilityButtonTwo = false;
                abilityButtonThree = false;
                break;
            case R.id.buttonAbilityTwo:
                abilityButtonOne = false;
                abilityButtonTwo = true;
                abilityButtonThree = false;
                break;
            case R.id.buttonAbilityThree:
                abilityButtonOne = false;
                abilityButtonTwo = false;
                abilityButtonThree = true;
                break;
        }
        disableButtons();
        PlayerMove();
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("playerHealth", playerHealth);
        outState.putDouble("opponentHealth", opponentHealth);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        playerHealth = (Double) savedInstanceState.getDouble("playerHealth");
        opponentHealth = (Double) savedInstanceState.getDouble("opponentHealth");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        playerHealthTextview.setText(String.valueOf(playerHealth));
        opponentHealthTextview.setText(String.valueOf(opponentHealth));
    }

    @Override
    protected void onResume() {
        super.onResume();
        playerHealthTextview.setText(String.valueOf(playerHealth));
        opponentHealthTextview.setText(String.valueOf(opponentHealth));
    }

    //------  Enable and disable buttons  ------//



    private void enableButtons() {
        abilityOneBtn.setEnabled(true);
        abilityTwoBtn.setEnabled(true);
        abilityThreeBtn.setEnabled(true);
        abilityOneBtn.setBackgroundColor(getResources().getColor(R.color.cnoLightGrey));
        abilityTwoBtn.setBackgroundColor(getResources().getColor(R.color.cnoLightGrey));
        abilityThreeBtn.setBackgroundColor(getResources().getColor(R.color.cnoLightGrey));
    }

    private  void disableButtons() {
        abilityOneBtn.setEnabled(false);
        abilityTwoBtn.setEnabled(false);
        abilityThreeBtn.setEnabled(false);
        abilityOneBtn.setBackgroundColor(getResources().getColor(R.color.cnoSteelGrey));
        abilityTwoBtn.setBackgroundColor(getResources().getColor(R.color.cnoSteelGrey));
        abilityThreeBtn.setBackgroundColor(getResources().getColor(R.color.cnoSteelGrey));
    }



    //------  Player Move  ------//



    private void PlayerMove() {
        //Processes done during player's move
        double activeDamageDealt;
        double encounteredDefense;
        combatTextTextview.setText("");

        //Determine which ability button was pressed and do said ability
        if (abilityButtonOne) {
            //get hit chance and apply to active damage
            activeDamageDealt = hitChance(playerAbilityOne);
             //check for player attack buffs
            if (playerAbilityThreeActive) {
                if (playerAttackBuffActive) {
                    double playerAbilOne = activeDamageDealt;
                    playerAbilOne = playerAbilOne + playerAttackBuff;
                    if(playerAttackBuffActive && playerDefenseBuffActive ) {
                        playerAttackBuffActive = false;
                    }
                    else {
                        playerAttackBuffActive = false;
                        playerAbilityThreeActive = false;
                    }
                    //apply player attack buff to active damage;
                    activeDamageDealt = playerAbilOne;
                }
            }

            //Check for opponent attack debuffs
            if (opponentAbilityThreeActive) {
                if (opponentAttackDebuffActive) {
                    double playerAbilOne = activeDamageDealt;
                    if (playerAttackDebuff == 0) {
                        playerAbilOne = playerAttackDebuff;
                    }
                    else {
                        playerAbilOne = playerAbilOne + playerAttackDebuff;
                    }
                    if (opponentAttackDebuffActive && opponentDefenseDebuffActive) {
                        opponentAttackDebuffActive = false;
                    }
                    else {
                        opponentAttackDebuffActive = false;
                        opponentAbilityThreeActive = false;
                    }
                    //apply opponent attack debuff to active damage;
                    activeDamageDealt = playerAbilOne;
                }
            }

            //Check to see if opponent has an active defense up and how strong it will be
            if (opponentAbilityTwoActive) {
                encounteredDefense = defenseChance(opponentActiveDefense);
            }
            else {
                encounteredDefense = 0;
            }
            //Determine opponent's health after attack is made
            if ((activeDamageDealt - encounteredDefense) > 0) {
                opponentHealth = opponentHealth - (activeDamageDealt - encounteredDefense);
                combatTextString = playerName + used + playerAbilityOneString + dashes +
                        opponentName + takes + (activeDamageDealt - encounteredDefense) + damage;
            }
            else {
                combatTextString = playerName + used + playerAbilityOneString + missed;
            }
            combatTextTextview.setText(combatTextString);
        }
        else if (abilityButtonTwo) {
            if (playerAbilityThreeActive) {
                if (playerDefenseBuffActive) {
                    double playerAbilTwo = playerAbilityTwo;
                    playerAbilTwo = playerAbilTwo + playerDefenseBuff;
                    playerDefenseBuffActive = false;
                    playerAbilityThreeActive = false;
                    //Apply player defense buff
                    playerActiveDefense = playerAbilTwo;
                }
            }
            else {
                playerActiveDefense = playerAbilityTwo;
            }

            if (opponentAbilityThreeActive) {
                if (opponentDefenseDebuffActive) {
                    double playerAbilTwo = playerActiveDefense;
                    if (playerDefenseDebuff == 0) {
                        playerAbilTwo = playerDefenseDebuff;
                    }
                    else {
                        playerAbilTwo = playerAbilTwo + playerDefenseDebuff;
                    }
                    opponentDefenseDebuffActive = false;
                    opponentAbilityThreeActive = false;
                    //Apply opponent defense debuff
                    playerActiveDefense = playerAbilTwo;
                }
            }
            playerAbilityTwoActive = true;
            combatTextString = playerName + used + playerAbilityTwoString + dashes + playerName + defensesUp;
            combatTextTextview.setText(combatTextString);
        }
        else if (abilityButtonThree) {
            AbilityThree(player, player);
            //combatTextString = playerName + " used " + playerAbilityThreeString;
            combatTextTextview.setText(combatTextString);
        }
        //Check if there is a cooldown active and increment it down 1
        if(playerCooldown > 0) {
            playerCooldown = playerCooldown - 1;
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
                CheckHP();
            }
        }, 3000);
    }



    //------  Opponent Move  ------//



    private void OpponentMove() {
        //Processes done during opponent's move
        double activeDamageDealt;
        double encounteredDefense;
        combatTextTextview.setText("");
        //Determine which ability the opponent will use
        DecisionStructure();
        if (abilityOne) {
            //get hit chance and apply to active damage
            activeDamageDealt = hitChance(opponentAbilityOne);
            //check for opponent attack buffs
            if (opponentAbilityThreeActive) {
                if (opponentAttackBuffActive) {
                    //double opponentAbilOne = opponentAbilityOne;
                    double opponentAbilOne = activeDamageDealt;
                    opponentAbilOne = opponentAbilOne + opponentAttackBuff;
                    if (opponentAttackBuffActive && opponentDefenseBuffActive) {
                        opponentAttackBuffActive = false;
                    }
                    else {
                        opponentAttackBuffActive = false;
                        opponentAbilityThreeActive = false;
                    }
                    //apply player attack buff to active damage;
                    //activeDamageDealt = activeDamageDealt + opponentAbilOne;
                    activeDamageDealt = opponentAbilOne;
                }
            }

            //Check for player attack debuffs
            if (playerAbilityThreeActive) {
                if (playerAttackDebuffActive) {
                    double opponentAbilOne = activeDamageDealt;
                    if (opponentAttackDebuff == 0) {
                        opponentAbilOne = opponentAttackDebuff;
                    }
                    else {
                        opponentAbilOne = opponentAbilOne + opponentAttackDebuff;
                    }
                    if (playerAttackDebuffActive && playerDefenseDebuffActive) {
                        playerAttackDebuffActive = false;
                    }
                    else {
                        playerAttackDebuffActive = false;
                        playerAbilityThreeActive = false;
                    }
                    //apply opponent attack debuff to active damage;
                    //activeDamageDealt = activeDamageDealt + opponentAbilOne;
                    activeDamageDealt = opponentAbilOne;
                }
            }

            //Check to see if player has an active defense up and how strong it will be
            if (playerAbilityTwoActive) {
                encounteredDefense = defenseChance(playerActiveDefense);
            }
            else {
                encounteredDefense = 0;
            }
            //Determine opponent's health after attack is made
            if ((activeDamageDealt - encounteredDefense) > 0) {
                playerHealth = playerHealth - (activeDamageDealt - encounteredDefense);
                combatTextString = opponentName + used + opponentAbilityOneString + dashes +
                        playerName + takes + (activeDamageDealt - encounteredDefense) + damage;
            }
            else {
                combatTextString = opponentName + used + opponentAbilityOneString + missed;
            }
            combatTextTextview.setText(combatTextString);
        }
        else if (abilityTwo) {
            if (opponentAbilityThreeActive) {
                if (opponentDefenseBuffActive) {
                    double opponentAbilTwo = opponentAbilityTwo;
                    opponentAbilTwo = opponentAbilTwo + opponentDefenseBuff;
                    opponentDefenseBuffActive = false;
                    opponentAbilityThreeActive = false;
                    //Apply player defense buff
                    opponentActiveDefense = opponentAbilTwo;
                }
            }
            else {
                opponentActiveDefense = opponentAbilityTwo;
            }

            if (playerAbilityThreeActive) {
                if (playerDefenseDebuffActive) {
                    double opponentAbilTwo = opponentActiveDefense;
                    if (opponentDefenseDebuff == 0) {
                        opponentAbilTwo = opponentDefenseDebuff;
                    }
                    else {
                        opponentAbilTwo = opponentAbilTwo + opponentDefenseDebuff;
                    }
                    playerDefenseDebuffActive = false;
                    playerAbilityThreeActive = false;
                    //Apply opponent defense debuff
                    opponentActiveDefense = opponentAbilTwo;
                }
            }
            /*else {
                opponentActiveDefense = opponentAbilityTwo;
            }*/

            opponentAbilityTwoActive = true;
            combatTextString = opponentName + used + opponentAbilityTwoString + dashes + opponentName + defensesUp;
            combatTextTextview.setText(combatTextString);
        }
        else if (abilityThree) {
            AbilityThree(opponent, opponent);
            combatTextTextview.setText(combatTextString);
        }
        if(opponentCooldown > 0) {
            opponentCooldown = opponentCooldown - 1;
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
                CheckHP();
            }
        }, 3000);
    }



    //------  Ability Three  ------//



    private void AbilityThree(int character, int callingCharacter) {
        //Ability three traits
        if (callingCharacter == player) {
            switch (character) {
                case 1:
                    //opponentAttackDebuff = -100;
                    opponentAttackDebuff = 0;
                    playerAttackDebuffActive = true;
                    playerAbilityThreeActive = true;
                    combatTextString = playerName + used + playerAbilityThreeString + period;
                    break;
                case 2:
                    opponentAttackDebuff = -2;
                    opponentDefenseDebuff = -2;
                    playerAttackDebuffActive = true;
                    playerDefenseDebuffActive = true;
                    playerAbilityThreeActive = true;
                    combatTextString = playerName + used + playerAbilityThreeString + period;
                    break;
                case 3:
                    playerAttackBuff = 3;
                    playerDefenseBuff = 3;
                    playerAttackBuffActive = true;
                    playerDefenseBuffActive = true;
                    playerAbilityThreeActive = true;
                    combatTextString = playerName + used + playerAbilityThreeString + period;
                    break;
                case 4:
                    if (playerCooldown == 0) {
                        playerCooldown = 4;
                        opponentHealth += -10;
                        opponentHealthTextview.setText(String.valueOf(opponentHealth));
                        combatTextString = playerName + used + playerAbilityThreeString + period;
                    }
                    else {
                        combatTextString = playerName + used + playerAbilityThreeString + period + playerDisappointmentString;
                    }
                    break;
                case 5:
                    if (playerCooldown == 0) {
                        playerCooldown = 20;
                        playerHealth = 99;
                        playerHealthTextview.setText(String.valueOf(playerHealth));
                        combatTextString = playerName + used + playerAbilityThreeString + period;
                    }
                    else {
                        combatTextString = playerName + used + playerAbilityThreeString + period + playerDisappointmentString;
                    }
                    break;
                case 6:
                    if (playerCooldown == 0) {
                        playerCooldown = 4;
                        playerHealth = playerHealth + 10;
                        combatTextString = playerName + used + playerAbilityThreeString + period;
                        if (playerHealth > 100) {
                            playerHealth = 100;
                        }
                    }
                    else {
                        combatTextString = playerName + used + playerAbilityThreeString + period + playerDisappointmentString;
                    }
                    break;
                case 7:
                    if (playerCooldown == 0) {
                        playerCooldown = 5;
                        playerHealthBuff = .5;
                        playerHealth = playerHealth + ((100 - playerHealth) * playerHealthBuff);
                        combatTextString = playerName + used + playerAbilityThreeString + period;
                    }
                    else {
                        combatTextString = playerName + used + playerAbilityThreeString + period + playerDisappointmentString;
                    }
                    break;
                case 8:
                    //opponentDefenseDebuff = -100;
                    //opponentAttackDebuff = -100;
                    opponentDefenseDebuff = 0;
                    opponentAttackDebuff = 0;
                    playerAttackDebuffActive = true;
                    playerDefenseDebuffActive = true;
                    playerAbilityThreeActive = true;
                    combatTextString = playerName + used + playerAbilityThreeString + period;
                    break;
                case 9:
                    opponentDefenseDebuff = -4;
                    playerAttackBuff = 3;
                    playerDefenseDebuffActive = true;
                    playerAttackBuffActive = true;
                    playerAbilityThreeActive = true;
                    combatTextString = playerName + used + playerAbilityThreeString + period;
                    break;
            }
        }
        else if(callingCharacter == opponent) {
            switch (character) {
                case 1:
                    //playerAttackDebuff = -100;
                    playerAttackDebuff = 0;
                    opponentAttackDebuffActive = true;
                    opponentAbilityThreeActive = true;
                    combatTextString = opponentName + used + opponentAbilityThreeString + period;
                    break;
                case 2:
                    playerAttackDebuff = -2;
                    playerDefenseDebuff = -2;
                    opponentAttackDebuffActive = true;
                    opponentDefenseDebuffActive = true;
                    opponentAbilityThreeActive = true;
                    combatTextString = opponentName + used + opponentAbilityThreeString + period;
                    break;
                case 3:
                    opponentAttackBuff = 3;
                    opponentDefenseBuff = 3;
                    opponentAttackBuffActive = true;
                    opponentDefenseBuffActive = true;
                    opponentAbilityThreeActive = true;
                    combatTextString = opponentName + used + opponentAbilityThreeString + period;
                    break;
                case 4:
                    if (opponentCooldown == 0) {
                        opponentCooldown = 4;
                        playerHealth += -10;
                        playerHealthTextview.setText(String.valueOf(playerHealth));
                        combatTextString = opponentName + used + opponentAbilityThreeString + period;
                    }
                    else {
                        combatTextString = opponentName + used + opponentAbilityThreeString + period + opponentDisappointmentString;
                    }
                    break;
                case 5:
                    if (opponentCooldown == 0) {
                        opponentCooldown = 20;
                        opponentHealth = 99;
                        opponentHealthTextview.setText(String.valueOf(opponentHealth));
                        combatTextString = opponentName + used + opponentAbilityThreeString + period;
                    }
                    else {
                        combatTextString = opponentName + used + opponentAbilityThreeString + period + opponentDisappointmentString;
                    }
                    break;
                case 6:
                    if (opponentCooldown == 0) {
                        opponentCooldown = 2;
                        opponentHealth = opponentHealth + 10;
                        combatTextString = opponentName + used + opponentAbilityThreeString + period;
                        if (opponentHealth > 100) {
                            opponentHealth = 100;
                        }
                    }
                    else {
                        combatTextString = opponentName + used + opponentAbilityThreeString + period + opponentDisappointmentString;
                    }
                    break;
                case 7:
                    if (opponentCooldown == 0) {
                        opponentCooldown = 5;
                        opponentHealthBuff = .5;
                        opponentHealth = opponentHealth + ((100 - opponentHealth) * opponentHealthBuff);
                        combatTextString = opponentName + used + opponentAbilityThreeString + period;
                    }
                    else {
                        combatTextString = opponentName + used + opponentAbilityThreeString + period + opponentDisappointmentString;
                    }
                    break;
                case 8:
                    //playerDefenseDebuff = -100;
                    //playerAttackDebuff = -100;
                    playerDefenseDebuff = 0;
                    playerAttackDebuff = 0;
                    opponentAttackDebuffActive = true;
                    opponentDefenseDebuffActive = true;
                    opponentAbilityThreeActive = true;
                    combatTextString = opponentName + used + opponentAbilityThreeString + period;
                    break;
                case 9:
                    playerDefenseDebuff = -4;
                    opponentAttackBuff = 3;
                    opponentDefenseDebuffActive = true;
                    opponentAttackBuffActive = true;
                    opponentAbilityThreeActive = true;
                    combatTextString = opponentName + used + opponentAbilityThreeString + period;
                    break;
            }
        }
    }



    //------  Hit Chance  ------//



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



    //------  Defense Chance  ------//



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



    //------  Opponent Decision Structure  ------//



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



    //------  Check Health Points  ------//



    private void CheckHP() {
        //Log.i("INFO", "CheckHP() called");
        if (playerHealth <= 0) {
            victory = true;
            playerWinner = false;
            Victory();
        }
        else if (opponentHealth <= 0) {
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



    //------  Victory Check  ------//



    private void Victory() {
        if (victory) {
            EndMatch();
        }
        else {
            NextMove();
        }
    }



    //------  Next Move  ------//



    private void NextMove() {
        if (playerMove) {
            enableButtons();
        }
        else {
            OpponentMove();
        }
    }



    //------  End Match  ------//



    private void EndMatch() {
        Intent intent = new Intent(this, EndMatch.class);
        intent.putExtra("playerChar", player);
        intent.putExtra("opponent", opponent);
        intent.putExtra("winner", playerWinner);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
