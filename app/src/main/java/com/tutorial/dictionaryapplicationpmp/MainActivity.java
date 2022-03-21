package com.tutorial.dictionaryapplicationpmp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSearch(View view) {

        EditText word = findViewById(R.id.word);
        String theword = word.getText().toString();

        String meaning = findMeaning(theword);
        TextView themean = (TextView) findViewById(R.id.mean);

        if(meaning!=null)
            themean.setText(meaning);
        else
            themean.setText("Word not found");
    }

    private String findMeaning(String theword) {

        InputStream input = getResources().openRawResource(R.raw.myvocabulary);

        Scanner scan = new Scanner(input);

        while (scan.hasNext())
        {
            String line = scan.nextLine();

            String[] pieces = line.split("=");

            if (pieces[0].equalsIgnoreCase(theword.trim())){
                return pieces[1];
            }
        }
        return null;
    }
}