package com.example.fake_frogs.cnogo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MatchActivity extends AppCompatActivity {
    private int stepOne = 0;
    private int stepTwo = 0;
    private int stepThree = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.combat_stage);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void testMatchEnd(int valueOne, int valueTwo, int valueThree) {
        if(stepOne == 1 && stepTwo == 2 && stepThree == 3) {
            Intent intent = new Intent(this, EndMatch.class);
            startActivity(intent);
        }
        else {
            return;
        }
    }

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
}
