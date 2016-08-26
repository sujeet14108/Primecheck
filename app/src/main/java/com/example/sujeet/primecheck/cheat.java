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


public class cheat extends AppCompatActivity {



    static final private String nmber = "prime";
    static final private String Isprime = "isprime";
    private int prime = 0;




    private int number=1;


    private static final String TAG = "Hint";

    private int r=0;
    //Rotation Handle
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
        setContentView(R.layout.cheat);
        Bundle extras = getIntent().getExtras();
        int   n=extras.getInt(nmber);

        prime= extras.getInt(Isprime);


        number=n;



        if (savedInstanceState != null) {
            // Restore value of members from saved state
            prime = savedInstanceState.getInt(Isprime);
            number=savedInstanceState.getInt(nmber);


        }












    }
    //button listner
    public void onClick(View v) {


        //Log.d(TAG, Integer.toString(y)+"and"+Integer.toString(r));

        switch (v.getId()) {

            case R.id.Showcheat:
                if(prime==1)
                    show_text("Yes, "+number+" is Prime");
                else
                    show_text("No, "+number+" is not Prime");

                r=2;
                break;


        }
    }
    //fn to show toast
    private void show_text(String text) {

        TextView textview = new TextView(cheat.this);
        textview.setText(text);
        textview.setGravity(Gravity.CENTER);
        textview.setTypeface(null, Typeface.BOLD);
        textview.setTextSize(28);
        textview.setBackgroundColor(Color.WHITE);
        textview.setTextColor(Color.RED);
        textview.setPadding(0,0,0,10);
        Toast toast = new Toast(cheat.this);
        toast.setView(textview);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }

    //provding data back on back button press
    @Override
    public void onBackPressed() {


        Log.d(TAG,"Back");


        Intent intent = new Intent();
        /*
        if(r==2&&a==1)
            a=3;
        else if(r==2)
            a=2;
            */


        intent.putExtra("result",Integer.toString(r));

        setResult(RESULT_OK, intent);

        finish();


    }



}
