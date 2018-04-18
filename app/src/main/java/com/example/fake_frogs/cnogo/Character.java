package com.example.fake_frogs.cnogo;

import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Array;

/**
 * Created by fake_frogs on 4/12/18.
 */

public class Character extends AppCompatActivity {
    //Constants for initializing character health and name
    private static double CHARACTER_HP = 100.0;
    private static String CLYDE = "Clyde";
    private static String OWEN = "Owen";
    private static String SUPER_BREAD = "Super Bread";
    private static String SCIENTIST = "Scientist";
    private static String GRIM_REAPER = "Grim Reaper";
    private static String THE_CONTROLLER = "The Controller";
    private static String CLYDE_CLONE = "Clyde Clone";
    private static String CARL = "Carl";
    private static String CAT_PERSON = "Cat Person";

    //Variables for character
    private String characterName;
    private double abilityOne;
    private String abilityOneSting;
    private double abilityTwo;
    private String abilityTwoString;
    //Ability three might be a variable
    //private double abilityThree;
    private String abilityThreeString;
    private int[] decisions = new int[6];

    //Constructor
    Character(int character) {
        switch (character) {
            case 1:  //create or return character 1
                characterName = CLYDE;
                abilityOne = 9;
                abilityOneSting = "Glare";//getApplicationContext().getString(R.string.ability_1);
                abilityTwo = 8;
                abilityTwoString = "Ignore";//getApplicationContext().getString(R.string.ability_2);
                abilityThreeString = "Passive Indifference";//getApplicationContext().getString(R.string.ability_3);
                decisions[0] = 0;
                decisions[1] = 45;
                decisions[2] = 44;
                decisions[3] = 78;
                decisions[4] = 77;
                decisions[5] = 100;
                break;
            case 2:  //create or return character 2
                characterName = OWEN;
                abilityOne = 10;
                abilityOneSting = "Bad Jokes";//getApplicationContext().getString(R.string.ability_1);
                abilityTwo = 7;
                abilityTwoString = "Friendly Smile";//getApplicationContext().getString(R.string.ability_2);
                abilityThreeString = "PUNishment";//getApplicationContext().getString(R.string.ability_3);
                decisions[0] = 0;
                decisions[1] = 34;
                decisions[2] = 33;
                decisions[3] = 67;
                decisions[4] = 66;
                decisions[5] = 100;
                break;
            case 3:  //create or return character 3
                characterName = SUPER_BREAD;
                abilityOne = 9;
                abilityOneSting = "Super Strength";//getApplicationContext().getString(R.string.ability_1);
                abilityTwo = 9;
                abilityTwoString = "Super Flight";//getApplicationContext().getString(R.string.ability_2);
                abilityThreeString = "Super Yeast";//getApplicationContext().getString(R.string.ability_3);
                decisions[0] = 0;
                decisions[1] = 44;
                decisions[2] = 43;
                decisions[3] = 86;
                decisions[4] = 85;
                decisions[5] = 100;
                break;
            case 4:  //create or return character 4
                characterName = SCIENTIST;
                abilityOne = 2;
                abilityOneSting = "Poke with a Stick";//getApplicationContext().getString(R.string.ability_1);
                abilityTwo = 6;
                abilityTwoString = "Hide Behind Clipboard";//getApplicationContext().getString(R.string.ability_2);
                abilityThreeString = "Theorize";//getApplicationContext().getString(R.string.ability_3);
                decisions[0] = 0;
                decisions[1] = 51;
                decisions[2] = 50;
                decisions[3] = 76;
                decisions[4] = 75;
                decisions[5] = 100;
                break;
            case 5:  //create or return character 5
                characterName = GRIM_REAPER;
                abilityOne = 20;
                abilityOneSting = "Scythe";//getApplicationContext().getString(R.string.ability_1);
                abilityTwo = 10;
                abilityTwoString = "Empty Cloak";//getApplicationContext().getString(R.string.ability_2);
                abilityThreeString = "Immortality";//getApplicationContext().getString(R.string.ability_3);
                decisions[0] = 0;
                decisions[1] = 10;
                decisions[2] = 9;
                decisions[3] = 99;
                decisions[4] = 98;
                decisions[5] = 100;
                break;
            case 6:  //create or return character 6
                characterName = THE_CONTROLLER;
                abilityOne = 7;
                abilityOneSting = "The Power!";//getApplicationContext().getString(R.string.ability_1);
                abilityTwo = 5;
                abilityTwoString = "Pause";//getApplicationContext().getString(R.string.ability_2);
                abilityThreeString = "Fast Forward";//getApplicationContext().getString(R.string.ability_3);
                decisions[0] = 0;
                decisions[1] = 36;
                decisions[2] = 35;
                decisions[3] = 81;
                decisions[4] = 80;
                decisions[5] = 100;
                break;
            case 7:  //create or return character 7
                characterName = CLYDE_CLONE;
                abilityOne = 8;
                abilityOneSting = "Scheme";//getApplicationContext().getString(R.string.ability_1);
                abilityTwo = 9;
                abilityTwoString = "Impersonate";//getApplicationContext().getString(R.string.ability_2);
                abilityThreeString = "Clone-O-Max 5000";//getApplicationContext().getString(R.string.ability_3);
                decisions[0] = 0;
                decisions[1] = 45;
                decisions[2] = 44;
                decisions[3] = 91;
                decisions[4] = 90;
                decisions[5] = 100;
                break;
            case 8:  //create or return character 8
                characterName = CARL;
                abilityOne = 8;
                abilityOneSting = "Awkwardness";//getApplicationContext().getString(R.string.ability_1);
                abilityTwo = 8;
                abilityTwoString = "Sofa Cushion";//getApplicationContext().getString(R.string.ability_2);
                abilityThreeString = "Forgotten About";//getApplicationContext().getString(R.string.ability_3);
                decisions[0] = 0;
                decisions[1] = 41;
                decisions[2] = 40;
                decisions[3] = 61;
                decisions[4] = 60;
                decisions[5] = 100;
                break;
            case 9:  //create or return character 9
                characterName = CAT_PERSON;
                abilityOne = 8;
                abilityOneSting = "Hairball";//getApplicationContext().getString(R.string.ability_1);
                abilityTwo = 10;
                abilityTwoString = "Superiority";//getApplicationContext().getString(R.string.ability_2);
                abilityThreeString = "Judging Stare";//getApplicationContext().getString(R.string.ability_3);
                decisions[0] = 0;
                decisions[1] = 46;
                decisions[2] = 45;
                decisions[3] = 76;
                decisions[4] = 75;
                decisions[5] = 100;
                break;
        }
    }

    public String getCharacterName() {
        return characterName;
    }

    public double getCharacterHp() {
        return CHARACTER_HP;
    }

    public double getAbilityOne() {
        return abilityOne;
    }

    public String getAbilityOneSting() {
        return abilityOneSting;
    }

    public double getAbilityTwo() {
        return abilityTwo;
    }

    public String getAbilityTwoString() {
        return abilityTwoString;
    }

    public String getAbilityThreeString() {
        return abilityThreeString;
    }

    public int getDecisions(int i) {
        return decisions[i];
    }
}
