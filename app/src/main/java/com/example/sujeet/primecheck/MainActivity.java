package com.example.sujeet.primecheck;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int x;

    private String display;
    static final private String nmber = "prime";
    static final private String Isprime = "isprime";


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(nmber, x);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    private TextView num;
    private static  int getRandomInteger(){
        return ((int) (Math.random()*(1 - 1000))) + 1000;
    }

    private static int prime(int n){
        int i;
        int flag=0;
        for(i=2; i<=n/2; ++i)
        {
            // condition for nonprime number
            if(n%i==0)
            {
                flag=1;
                break;
            }
        }

        if (flag==0)
            return  1;
        else
        return 0;



    }
    private static final String TAG = "PrimeCheck";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num=(TextView) findViewById(R.id.txt);





        if (savedInstanceState != null) {
            // Restore value of members from saved state
            x = savedInstanceState.getInt(nmber);

        } else {
            x = getRandomInteger();
        }
        display="Is "+Integer.toString(x) +" is a Prime Number?";
        num.setText(display);






    }
    private void showt() {
        String text="Correct!";
        TextView textview = new TextView(MainActivity.this);
        textview.setText(text);
        textview.setTextSize(50);
        textview.setBackgroundColor(Color.WHITE);
        textview.setTextColor(Color.GREEN);
        textview.setPadding(0,0,0,10);
        Toast toast = new Toast(MainActivity.this);
        toast.setView(textview);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }
    private void showr() {
        String text="Wrong!";
        TextView textview = new TextView(MainActivity.this);
        textview.setText(text);
        textview.setTextSize(50);
        textview.setBackgroundColor(Color.WHITE);
        textview.setTextColor(Color.RED);
        textview.setPadding(0,0,0,10);
        Toast toast = new Toast(MainActivity.this);
        toast.setView(textview);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }

    public void onClick(View v) {

        int r = prime(x);
        //Log.d(TAG, Integer.toString(y)+"and"+Integer.toString(r));

        switch (v.getId()) {
            case R.id.no:
                if (r == 0)
                    showt();
                   // Toast.makeText(MainActivity.this, "Congo!!", Toast.LENGTH_SHORT).show();

                else
                showr();

                   // Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
              /*
                x = getRandomInteger();
                display="Is "+Integer.toString(x) +" is a Prime Number?";
                num.setText(display);
                */

                break;
            case R.id.yes:
                if (r == 0)
                    showr();
                else
                    showt();
                break;

              /*
                x = getRandomInteger();
                display="Is "+Integer.toString(x) +" is a Prime Number?";
                num.setText(display);*/

            case R.id.Next:


                x = getRandomInteger();
                display="Is "+Integer.toString(x) +" is a Prime Number?";
                num.setText(display);
                break;

            case  R.id.Hint:
                Intent intent = new Intent(com.example.sujeet.primecheck.MainActivity.this,Hint.class);

                /*intent.putExtra(nmber,x);
                intent.putExtra(Isprime,r);*/
                startActivityForResult(intent, 1);
                break;

            case  R.id.cheat:
                Intent intent2 = new Intent(com.example.sujeet.primecheck.MainActivity.this,cheat.class);

                intent2.putExtra(nmber,x);
                intent2.putExtra(Isprime,r);
                startActivityForResult(intent2, 1);
                break;

        }
    }
    //Handling data coming after back
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String st=data.getStringExtra("result");
                int x=Integer.parseInt(st);
                if(x==1)
                    show_text("Hint Taken");
                if(x==2)
                    show_text("Cheated");
                if(x==3)
                    show_text("Cheated as well as Hint taken");
                Log.d(TAG,st);
            }
        }
        Log.d(TAG,"mml");
    }
    //Toast formatting
    private void show_text(String text) {

        TextView textview = new TextView(MainActivity.this);
        textview.setText(text);
        textview.setTextSize(28);
        textview.setGravity(Gravity.CENTER);
        textview.setTypeface(null, Typeface.BOLD);
        textview.setBackgroundColor(Color.WHITE);
        textview.setTextColor(Color.RED);
        textview.setPadding(0,0,0,10);
        Toast toast = new Toast(MainActivity.this);
        toast.setView(textview);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }
    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG," OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG," OnResume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, " OnSTop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "OnDestroy");
    }

}
