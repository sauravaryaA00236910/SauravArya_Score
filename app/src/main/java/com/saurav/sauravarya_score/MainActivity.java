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

    private int currentScore; 
    private int changeScoreBy;
    private TextView scoreDD;
    private TextView scoreMI;
    private RadioGroup rdScoreGroup;

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

        rdScoreGroup = findViewById(R.id.rdScoreGroup);
        try{
            rdScoreGroup.setOnCheckedChangeListener(this);
        }
        catch(Exception e){
            Log.e("RadioGroupError", e.getStackTrace().toString());
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
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
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void onClick(View view){

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