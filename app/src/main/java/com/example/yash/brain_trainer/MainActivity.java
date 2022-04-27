package com.example.yash.brain_trainer;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button butt1;
    Button butt2;
    Button butt3;
    Button butt4;
    TextView react;
    TextView sum;
    TextView timer;
    TextView score;
    GridLayout grid;
    Button play;
    int loc;
    int numberOfQ = 0;
    int right = 0;
    ArrayList<Integer> answers = new ArrayList<Integer>();

    public void start(View view) {
        button.setVisibility(View.INVISIBLE);
        grid.setVisibility(View.VISIBLE);
        sum.setVisibility(View.VISIBLE);
        timer.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
    }

    public void choose(View view)
    {
       if(Integer.toString(loc).equals(view.getTag().toString()))
       {   react.setVisibility(View.VISIBLE);
           react.setText("Correct");
           right++;
       }
       else{
           react.setVisibility(View.VISIBLE);
           react.setText("Wrong");
       }

       numberOfQ++;
       score.setText(Integer.toString(right) + "/" + Integer.toString(numberOfQ));
       question();
    }
    public void question()
    {
        butt1.setEnabled(true);
        butt2.setEnabled(true);
        butt3.setEnabled(true);
        butt4.setEnabled(true);
        Random random = new Random();
        int a = random.nextInt(21);
        int b = random.nextInt(21);
        int c = a + b;
        sum.setText(Integer.toString(a) + " " + "+" + " " +  Integer.toString(b));

        loc = random.nextInt(4);
        answers.clear();
        for(int i = 0; i <=4; i++)
        {
            if(i == loc)
            {
                answers.add(a + b);
            }
            else
            {
                int d = random.nextInt(41);
                while(d == c)
                {
                    d = random.nextInt(41);
                }
                answers.add(d);
            }
        }
        butt1.setText(Integer.toString(answers.get(0)));
        butt2.setText(Integer.toString(answers.get(1)));
        butt3.setText(Integer.toString(answers.get(2)));
        butt4.setText(Integer.toString(answers.get(3)));

    }
    public void playAgain(View view)
    {
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                timer.setText(String.valueOf(l/1000) + "s");
            }

            @Override
            public void onFinish() {
                react.setText("Done!");
                play.setVisibility(View.VISIBLE);
                butt1.setEnabled(false);
                butt2.setEnabled(false);
                butt3.setEnabled(false);
                butt4.setEnabled(false);
            }
        }.start();

        numberOfQ = 0;
        right = 0;
        score.setText(Integer.toString(right) + "/" + Integer.toString(numberOfQ));
        react.setVisibility(View.INVISIBLE);
        play.setVisibility(View.INVISIBLE);
        question();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.goButton);
        sum = findViewById(R.id.sumExample);
        butt1 = findViewById(R.id.ans1);
        butt2 = findViewById(R.id.ans2);
        butt3 = findViewById(R.id.ans3);
        butt4 = findViewById(R.id.ans4);
        react = findViewById(R.id.reaction);
        grid = findViewById(R.id.gridView);
        timer = findViewById(R.id.timer);
        score = findViewById(R.id.score);
        play = findViewById(R.id.playAgain);
        button.setVisibility(View.VISIBLE);
        grid.setVisibility(View.INVISIBLE);
        react.setVisibility(View.INVISIBLE);
        sum.setVisibility(View.INVISIBLE);
        timer.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);
        play.setVisibility(View.INVISIBLE);
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                timer.setText(String.valueOf(l/1000) + "s");
            }

            @Override
            public void onFinish() {
                react.setText("Done!");
                play.setVisibility(View.VISIBLE);
                butt1.setEnabled(false);
                butt2.setEnabled(false);
                butt3.setEnabled(false);
                butt4.setEnabled(false);
            }
        }.start();

        question();
    }
}
