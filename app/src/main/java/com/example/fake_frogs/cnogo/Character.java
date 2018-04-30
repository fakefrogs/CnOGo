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
    private double abilityTwo;
    private int[] decisions = new int[6];

    //Constructor
    Character(int character) {
        switch (character) {
            case 1:
                characterName = CLYDE;
                abilityOne = 9;
                abilityTwo = 8;
                decisions[0] = 0;
                decisions[1] = 45;
                decisions[2] = 44;
                decisions[3] = 78;
                decisions[4] = 77;
                decisions[5] = 100;
                break;
            case 2:
                characterName = OWEN;
                abilityOne = 10;
                abilityTwo = 7;
                decisions[0] = 0;
                decisions[1] = 34;
                decisions[2] = 33;
                decisions[3] = 67;
                decisions[4] = 66;
                decisions[5] = 100;
                break;
            case 3:
                characterName = SUPER_BREAD;
                abilityOne = 9;
                abilityTwo = 9;
                decisions[0] = 0;
                decisions[1] = 44;
                decisions[2] = 43;
                decisions[3] = 86;
                decisions[4] = 85;
                decisions[5] = 100;
                break;
            case 4:
                characterName = SCIENTIST;
                abilityOne = 2;
                abilityTwo = 6;
                decisions[0] = 0;
                decisions[1] = 51;
                decisions[2] = 50;
                decisions[3] = 76;
                decisions[4] = 75;
                decisions[5] = 100;
                break;
            case 5:
                characterName = GRIM_REAPER;
                abilityOne = 10;
                abilityTwo = 10;
                decisions[0] = 0;
                decisions[1] = 16;
                decisions[2] = 15;
                decisions[3] = 93;
                decisions[4] = 92;
                decisions[5] = 100;
                break;
            case 6:
                characterName = THE_CONTROLLER;
                abilityOne = 7;
                abilityTwo = 9;
                decisions[0] = 0;
                decisions[1] = 41;
                decisions[2] = 40;
                decisions[3] = 71;
                decisions[4] = 70;
                decisions[5] = 100;
                break;
            case 7:
                characterName = CLYDE_CLONE;
                abilityOne = 8;
                abilityTwo = 9;
                decisions[0] = 0;
                decisions[1] = 45;
                decisions[2] = 44;
                decisions[3] = 91;
                decisions[4] = 90;
                decisions[5] = 100;
                break;
            case 8:
                characterName = CARL;
                abilityOne = 8;
                abilityTwo = 8;
                decisions[0] = 0;
                decisions[1] = 41;
                decisions[2] = 40;
                decisions[3] = 61;
                decisions[4] = 60;
                decisions[5] = 100;
                break;
            case 9:
                characterName = CAT_PERSON;
                abilityOne = 8;
                abilityTwo = 10;
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

    public double getAbilityTwo() {
        return abilityTwo;
    }

    public int getDecisions(int i) {
        return decisions[i];
    }
}
