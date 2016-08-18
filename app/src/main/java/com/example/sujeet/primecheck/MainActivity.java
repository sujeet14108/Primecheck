package com.example.sujeet.primecheck;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int x;
    int y;
    static final String nmber = "prime";
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(nmber, x);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    private TextView num;
    public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

    public static int prime(int n){
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
    private static final String TAG = "QuizActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num=(TextView) findViewById(R.id.txt);



        if (savedInstanceState != null) {
            // Restore value of members from saved state
            x = savedInstanceState.getInt(nmber);

        } else {
            x = getRandomInteger(1, 1000);
        }
        num.setText("Is "+Integer.toString(x) +" is a Prime Number?");






    }
    public void showt(String text) {
        TextView textview = new TextView(MainActivity.this);
        textview.setText(text);
        textview.setTextSize(50);
        textview.setBackgroundColor(Color.WHITE);
        textview.setTextColor(Color.GREEN);
        textview.setPadding(30,30,30,30);
        Toast toast = new Toast(MainActivity.this);
        toast.setView(textview);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }
    public void showr(String text) {
        TextView textview = new TextView(MainActivity.this);
        textview.setText(text);
        textview.setTextSize(50);
        textview.setBackgroundColor(Color.WHITE);
        textview.setTextColor(Color.RED);
        textview.setPadding(30,30,30,30);
        Toast toast = new Toast(MainActivity.this);
        toast.setView(textview);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }

    public void onClick(View v) {

        int r = prime(x);
        Log.d(TAG, Integer.toString(y)+"ccc"+Integer.toString(r));

        switch (v.getId()) {
            case R.id.no:
                if (r == 0)
                    showt("Congo!");
                   // Toast.makeText(MainActivity.this, "Congo!!", Toast.LENGTH_SHORT).show();

                else
                showr("Wrong!");
                   // Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();

                x = getRandomInteger(1, 1000);
                num.setText("Is "+Integer.toString(x) +" is a Prime Number?");

                break;
            case R.id.yes:
                if (r == 0)
                    showr("Wrong!");
                else
                    showt("Congo!");


                x = getRandomInteger(1, 1000);
                num.setText("Is "+Integer.toString(x) +" is a Prime Number?");
                break;
            case R.id.Next:


                x = getRandomInteger(1, 1000);
                num.setText("Is "+Integer.toString(x) +" is a Prime Number?");
                break;
        }
    }



    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnResume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }

}
