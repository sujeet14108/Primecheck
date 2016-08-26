package com.example.sujeet.primecheck;


import android.os.Bundle;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Hint extends AppCompatActivity {


    private String display;
    static final private String nmber = "prime";
    static final private String Isprime = "isprime";
 private int prime = 0;




private int number=1;


    private static final String TAG = "Hint";
   private int a=0;

    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(nmber, number);
        savedInstanceState.putInt(Isprime, prime);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hint);




        if (savedInstanceState != null) {
            // Restore value of members from saved state
            prime = savedInstanceState.getInt(Isprime);
            number=savedInstanceState.getInt(nmber);


        }












    }
    public void onClick(View v) {


        //Log.d(TAG, Integer.toString(y)+"and"+Integer.toString(r));

        switch (v.getId()) {
            case R.id.ShowHint:

                show_text("Count Number Of Factor (Prime number has only 2 factors i.e 1 and itself.)");
                a=1;
                break;



        }
    }
    private void show_text(String text) {

        TextView textview = new TextView(Hint.this);
        textview.setText(text);
        textview.setGravity(Gravity.CENTER);
        textview.setTypeface(null, Typeface.BOLD);
        textview.setTextSize(28);
        textview.setBackgroundColor(Color.WHITE);
        textview.setTextColor(Color.RED);
        textview.setPadding(0,0,0,10);
        Toast toast = new Toast(Hint.this);
        toast.setView(textview);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }
    @Override
    public void onBackPressed() {


        Log.d(TAG,"Back");


        Intent intent = new Intent();


        intent.putExtra("result",Integer.toString(a));

        setResult(RESULT_OK, intent);

        finish();


    }



}
