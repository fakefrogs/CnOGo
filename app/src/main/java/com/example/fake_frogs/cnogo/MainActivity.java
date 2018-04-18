package com.example.fake_frogs.cnogo;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private static final int CLYDE = 1;
    private static final int OWEN = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String statsTxt = "stats.txt";

        if (checkFile(this, statsTxt)) {
            //Toast.makeText(this, "File already exists", Toast.LENGTH_SHORT).show();
            Log.i("INFO", "File already exists");
        }
        else {
            addStatsFile(statsTxt);
        }
        Log.i("INFO", String.valueOf(CLYDE));
        Log.i("INFO", String.valueOf(OWEN));
    }

    public void selectCharacter(View view) {
        //Bundle bundle = new Bundle();
        Intent intent = new Intent(this, OpponentSelectActivity.class);
        if (view.getId() == R.id.buttonClyde) {
            intent.putExtra("playerChar", CLYDE);
            String intentPassingValue = String.valueOf(intent.getIntExtra("playerChar", 200));
            Log.i("INFO", intentPassingValue);
            startActivity(intent);
        }
        else if (view.getId() == R.id.buttonOwen) {
            intent.putExtra("playerChar", OWEN);
            startActivity(intent);
        }

    }

    public void abilitiesDetails(View view) {
        Intent intentAbilities = new Intent(this, DisplayAbilities.class);
        if (view.getId() == R.id.buttonDetailsClyde) {
            intentAbilities.putExtra("character", CLYDE);
        }
        else if (view.getId() == R.id.buttonDetailsOwen) {
            intentAbilities.putExtra("character", OWEN);
        }
        startActivity(intentAbilities);
    }

    public void stats(View view) {
        Intent intentStats = new Intent(this, StatsActivity.class);
        startActivity(intentStats);
    }

    public boolean checkFile(Context context, String filename) {
        File file = context.getFileStreamPath(filename);
        if(file == null || !file.exists()) {
            return false;
        }
        return true;
    }

    protected void addStatsFile(String txtFile) {
        String statStrings = "Victories:0:Clyde:0:Owen:0:Super Bread:0:Scientist:0:Grim Reaper:0:The Controller:0:Clyde Clone:0:Carl:0:Cat Person:0";
        String filename = txtFile;
        String fileContents = statStrings;
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
            //Toast.makeText(this,"File was saved",Toast.LENGTH_LONG).show();
            Log.i("INFO", "File was saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}