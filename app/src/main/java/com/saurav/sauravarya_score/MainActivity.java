package com.saurav.sauravarya_score;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener{

    private int currentScore;
    private int changeScoreBy;
    private TextView scoreDD;
    private TextView scoreMI;
    private TextView rdScoreGroup;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        changeScoreBy = 1;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIncDD = findViewById(R.id.btnIncDD);
        btnIncDD.setOnClickListener(this);

        Button btnDecDD = findViewById(R.id.btnDecDD);
        btnDecDD.setOnClickListener(this);

        Button btnIncMI = findViewById(R.id.btnIncMI);
        btnIncMI.setOnClickListener(this);

        Button btnDecMI = findViewById(R.id.btnDecMI);
        btnDecMI.setOnClickListener(this);

        scoreDD = findViewById(R.id.scoreDD);
        scoreMI = findViewById(R.id.scoreMI);

        try{
            scoreDD.setOnClickListener(this);
            scoreMI.setOnClickListener(this);
            scoreDD. setText(Integer.toString(currentScore));
            scoreMI. setText(Integer.toString(currentScore));
        }
        catch(Exception e){
            Log.e("textViewError",  e.getStackTrace().toString());
        }

//        RadioButton rdScore1 = findViewById(R.id.rdScore1);
//        rdScore1.setOnClickListener(this);
//
//        RadioButton rdScore4 = findViewById(R.id.rdScore4);
//        rdScore4.setOnClickListener(this);
//
//        RadioButton rdScore6 = findViewById(R.id.rdScore6);
//        rdScore6.setOnClickListener(this);


//        couldn't set the setOnClickChangedListeners due to some unknown error

//        rdScoreGroup = findViewById(R.id.rdScoreGroup);
//        try{
//            rdScoreGroup.setOnCheckedChangeListener(this);
//        }
//        catch(Exception e){
//            Log.e("RadioGroupError", e.getStackTrace().toString());
//        }
    }
    public void onClick(View view){
//        switch(view.getId()){
//            case R.id.rdScore1:
//                try {
//                    changeScoreBy = 1;
//                }
//                catch(Exception e){
//                    Log.e("Error", e.getMessage());
//                    Toast.makeText(this, "Button doesn't work", Toast.LENGTH_SHORT).show();
//                }
//                break;
//            case R.id.rdScore4:
//                try {
//                    changeScoreBy = 4;
//                }
//                catch(Exception e){
//                    Log.e("Error", e.getMessage());
//                    Toast.makeText(this, "Button doesn't work", Toast.LENGTH_SHORT).show();
//                }
//                break;
//            case R.id.rdScore6:
//                try {
//                    changeScoreBy = 6;
//                }
//                catch(Exception e){
//                    Log.e("Error", e.getMessage());
//                    Toast.makeText(this, "Button doesn't work", Toast.LENGTH_SHORT).show();
//                }
//                break;
//            default:
//                Toast.makeText(this, "View not Implemented", Toast.LENGTH_SHORT).show();
//                break;
//        }

//        switch statement to select the clicked button


        switch(view.getId()){
            case R.id.btnIncDD:

//                incrementing team DD score
                currentScore += changeScoreBy;
                try{
                    scoreDD. setText(Integer.toString(currentScore));
                }
                catch(Exception e){
                    Log.e("Error", e.getMessage());
                    Toast.makeText(this, "Button doesn't work", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnIncMI:
//                incrementing team MI score
                currentScore += changeScoreBy;
                try{
                    scoreMI. setText(Integer.toString(currentScore));
                }
                catch(Exception e){
                    Log.e("Error", e.getMessage());
                    Toast.makeText(this, "Button doesn't work", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnDecDD:
//                decrementing team DD score
                currentScore -= changeScoreBy;
                if(currentScore < 0){
                    currentScore = 0;
                }
                //                try and catch error to get the exception if occured
                try{
                    scoreDD. setText(Integer.toString(currentScore));
                }
                catch(Exception e){
                    Log.e("Error", e.getMessage());
                    Toast.makeText(this, "Button doesn't work", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnDecMI:
//               decrementing team MI score
                currentScore -= changeScoreBy;
                if(currentScore < 0){
                    currentScore = 0;
                }

//                try and catch error to get the exception if occured
                try{
                    scoreMI. setText(Integer.toString(currentScore));
                }
                catch(Exception e){
                    Log.e("Error", e.getMessage());
                    Toast.makeText(this, "Button doesn't work", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Toast.makeText(this, "View not Implemented", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}