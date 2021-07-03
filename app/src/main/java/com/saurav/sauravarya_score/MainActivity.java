package com.saurav.sauravarya_score;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

//    initializing variables
    private int currentScoreDD;
    private int currentScoreMI;
    private int changeScoreBy;
    private TextView scoreDD;
    private TextView scoreMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        assigning default value to changeScoreby variable
        changeScoreBy = 1;

//        accessing buttons through their id and setting onClick listners
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
//            setting current score for the teams
            scoreDD. setText(Integer.toString(currentScoreDD));
            scoreMI. setText(Integer.toString(currentScoreMI));
        }
        catch(Exception e){
            Log.e("textViewError",  e.getStackTrace().toString());
        }

//        accessing the radio group through the id
        RadioGroup rdScoreGroup = findViewById(R.id.rdScoreGroup);
        try{
//            setting onCheckedCahange listener to the radio group
            rdScoreGroup.setOnCheckedChangeListener(this);
        }
        catch(Exception e){
            Log.e("RadioGroupError", e.getStackTrace().toString());
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

//        setting different values to the changeScoreBy variable as per the radio button selected
//        through switch statements
        switch(checkedId){
            case R.id.rdScore1:
                changeScoreBy = 1;
                break;
            case R.id.rdScore4:
                changeScoreBy = 4;
                break;
            case R.id.rdScore6:
                changeScoreBy = 6;
                break;
            default:
                Toast.makeText(this, "Select the value to change score by", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void onClick(View view){

//        increasing and decreasing the score as per the button clicked using switch stataements
        switch(view.getId()){
            case R.id.btnIncDD:
//                incrementing team DD score
                currentScoreDD += changeScoreBy;
                try{
//                    setting the score to the current score
                    scoreDD. setText(Integer.toString(currentScoreDD));
                }
                catch(Exception e){
                    Log.e("Error", e.getMessage());
                    Toast.makeText(this, "Button doesn't work", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnIncMI:
//                incrementing team MI score
                currentScoreMI += changeScoreBy;
                try{
//                    setting the score as per the current score
                    scoreMI. setText(Integer.toString(currentScoreMI));
                }
                catch(Exception e){
                    Log.e("Error", e.getMessage());
                    Toast.makeText(this, "Button doesn't work", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnDecDD:
//                decrementing team DD score
                currentScoreDD -= changeScoreBy;
//                if statement to assign 0 to the current score if it gets negative for DD
                if(currentScoreDD < 0){
                    currentScoreDD = 0;
                    Toast.makeText(this, "The score can't be negative", Toast.LENGTH_SHORT).show();
                }
//                try and catch error to get the exception if occured
                try{
//                    setting the score to the current score
                    scoreDD. setText(Integer.toString(currentScoreDD));
                }
                catch(Exception e){
                    Log.e("Error", e.getMessage());
                    Toast.makeText(this, "Button doesn't work", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnDecMI:
//               decrementing team MI score
                currentScoreMI -= changeScoreBy;
//                if statement to assign 0 to the current score if it gets negative for MI
                if(currentScoreMI < 0){
                    currentScoreMI = 0;
                    Toast.makeText(this, "The score can't be negative", Toast.LENGTH_SHORT).show();
                }
//                try and catch error to get the exception if occured
                try{
//                    setting the score to the current score
                    scoreMI. setText(Integer.toString(currentScoreMI));
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