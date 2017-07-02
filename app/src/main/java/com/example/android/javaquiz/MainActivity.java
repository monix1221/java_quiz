package com.example.android.javaquiz;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android.javaquiz.databinding.ActivityMainBinding;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private static int USER_SCORE =0;

    private HashMap<Integer, Boolean> questionViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        questionViews = new HashMap<Integer, Boolean>();
        fillMapOfAnswers(questionViews);

        setOnClickListenersForButtons();
    }


    public void setOnClickListenersForButtons(){
        binding.submitScoreButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                USER_SCORE=0;
                submitScore(questionViews);
                displayScoreMessage();
            }
        });

        binding.resetScoreButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                USER_SCORE=0;
                hideScoreMessage();
                clearHighlightBackgroundForAnswers();
                clearAllAnswers();
            }
        });

        binding.highlightAnswersButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                setHighlightBackgroundForAnswers();
            }
        });
    }

    public void setHighlightBackgroundForAnswers(){

        fillMapOfAnswers(questionViews);

        if (questionViews.get(1) == true){
            binding.q1Radiogroup.setBackgroundResource(R.color.colorForRightAnswer);
        }else{
           binding.q1Radiogroup.setBackgroundResource(R.color.colorForWrongAnswer);
        }

        if (questionViews.get(2) == true){
            binding.q2EditText.setBackgroundResource(R.color.colorForRightAnswer);
        }else{
            binding.q2EditText.setBackgroundResource(R.color.colorForWrongAnswer);
        }

        if (questionViews.get(3) == true){
            binding.q3EditText.setBackgroundResource(R.color.colorForRightAnswer);
        }else{
            binding.q3EditText.setBackgroundResource(R.color.colorForWrongAnswer);
        }

        if (questionViews.get(4) == true){
            binding.q4Radiogroup.setBackgroundResource(R.color.colorForRightAnswer);
        }else{
            binding.q4Radiogroup.setBackgroundResource(R.color.colorForWrongAnswer);
        }

        if (questionViews.get(5) == true){
            binding.q5Radiogroup.setBackgroundResource(R.color.colorForRightAnswer);
        }else{
            binding.q5Radiogroup.setBackgroundResource(R.color.colorForWrongAnswer);
        }

        if (questionViews.get(6) == true){
            binding.q6EditText.setBackgroundResource(R.color.colorForRightAnswer);
        }else{
            binding.q6EditText.setBackgroundResource(R.color.colorForWrongAnswer);
        }

        if (questionViews.get(7) == true){
            binding.q7EditText.setBackgroundResource(R.color.colorForRightAnswer);
        }else{
            binding.q7EditText.setBackgroundResource(R.color.colorForWrongAnswer);
        }

        if (questionViews.get(8) == true){
            binding.q8EditText.setBackgroundResource(R.color.colorForRightAnswer);
        }else{
            binding.q8EditText.setBackgroundResource(R.color.colorForWrongAnswer);
        }

        if (questionViews.get(9) == true){
            binding.q9Checkboxgroup.setBackgroundResource(R.color.colorForRightAnswer);
        }else{
            binding.q9Checkboxgroup.setBackgroundResource(R.color.colorForWrongAnswer);
        }

    }

    public void clearHighlightBackgroundForAnswers(){
        binding.q1Radiogroup.setBackgroundResource(R.color.colorDefaultBackground);
        binding.q2EditText.setBackgroundResource(R.color.colorDefaultBackground);
        binding.q3EditText.setBackgroundResource(R.color.colorDefaultBackground);
        binding.q4Radiogroup.setBackgroundResource(R.color.colorDefaultBackground);
        binding.q5Radiogroup.setBackgroundResource(R.color.colorDefaultBackground);
        binding.q6EditText.setBackgroundResource(R.color.colorDefaultBackground);
        binding.q7EditText.setBackgroundResource(R.color.colorDefaultBackground);
        binding.q8EditText.setBackgroundResource(R.color.colorDefaultBackground);
        binding.q9Checkboxgroup.setBackgroundResource(R.color.colorDefaultBackground);
    }

    public void clearAllAnswers(){
        binding.q1WrongAnsButton.setChecked(false);
        binding.q1CorrectAnsButton.setChecked(false);
        binding.q2EditText.setText("");
        binding.q3EditText.setText("");
        binding.q4CorrectAnswerRadioButton.setChecked(false);
        binding.q4Wrong1RadioButton.setChecked(false);
        binding.q4Wrong2RadioButton.setChecked(false);
        binding.q4Wrong3RadioButton.setChecked(false);
        binding.q4Wrong4RadioButton.setChecked(false);
        binding.q5CorrectAnsRadioButton.setChecked(false);
        binding.q5WrongAnsRadioButton.setChecked(false);
        binding.q6EditText.setText("");
        binding.q7EditText.setText("");
        binding.q8EditText.setText("");
        binding.q9WrongAnswerCheckbox.setChecked(false);
        binding.q9Count1Checkbox.setChecked(false);
        binding.q9Count2Checkbox.setChecked(false);
        binding.q9Count3Checkbox.setChecked(false);

    }

    public void displayScoreMessage(){
        binding.displayScoreTextView.setVisibility(View.VISIBLE);
        binding.displayScoreTextView.setText(getString(R.string.you_got_text) + USER_SCORE+"/9 !");
        Toast.makeText(this, getString(R.string.you_got_text)+USER_SCORE + getString(R.string.points_text), Toast.LENGTH_SHORT).show();
    }

    public void hideScoreMessage(){
        binding.displayScoreTextView.setVisibility(View.GONE);
    }

    public HashMap<Integer, Boolean> fillMapOfAnswers(HashMap map){
        map.put(1, isAnswerCorrectForQ1());
        map.put(2, isAnswerCorrectForQ2());
        map.put(3, isAnswerCorrectForQ3());
        map.put(4, isAnswerCorrectForQ4());
        map.put(5, isAnswerCorrectForQ5());
        map.put(6, isAnswerCorrectForQ6());
        map.put(7, isAnswerCorrectForQ7());
        map.put(8, isAnswerCorrectForQ8());
        map.put(9, isAnswerCorrectForQ9());
        return map;
    }

    public int submitScore(HashMap<Integer, Boolean> scoreMap){

        fillMapOfAnswers(scoreMap);
       for(int i=1; i<=scoreMap.size(); i++){
           if (scoreMap.get(i)==true){
               USER_SCORE++;
           }
       }
        return USER_SCORE;
    }

    public boolean isAnswerCorrectForQ1(){
        if(binding.q1CorrectAnsButton.isChecked())return true;
        return false;
    }

    //question gets edit text - correct answer is synchronized
    public boolean isAnswerCorrectForQ2(){
        String answerForQ2 = binding.q2EditText.getText().toString().toLowerCase();
        String correctAnswer = getString(R.string.synchronized_answer);
        if(answerForQ2.equals(correctAnswer)) return true;
        return false;
    }

    /**
     * could think of a better way to check if the field contains ONLY two correct answers;
     * @return
     */
    public boolean isAnswerCorrectForQ3(){
        String answerForQ3;
        answerForQ3 = binding.q3EditText.getText().toString().toLowerCase();

        String checkHowManyWords = answerForQ3;
        String trimmingStr = checkHowManyWords.trim();              // trim() returns a String with any leading and trailing whitespace removed
        trimmingStr=trimmingStr.replace(",","");

        if(trimmingStr.split("\\s+").length>3) return false;        // "\s" matches the space; here space is the regex; public String[] split(String regex) --> we get an array of splitted Strings

        String[] splittedAnswer = trimmingStr.split("\\s");

        //Correct answers:
        String correctAnswer1 = "error";
        String correctAnswer2 = "exception";

        int val=0;
        for(int i=0; i<splittedAnswer.length; i++){
            if(splittedAnswer[i]!=null){
            if (splittedAnswer[i].equals(correctAnswer1)){
                val++;
                break;
            }}}
        for(int i=0; i<splittedAnswer.length; i++){
            if(splittedAnswer[i]!=null){
            if(splittedAnswer[i].equals(correctAnswer2)){
                val++;
                break;
            }
        }}

        //if(answerForQ3.contains(correctAnswer1) & answerForQ3.contains(correctAnswer2)) return true;
        if(val==2)return true;

        return false;
    }

    public boolean isAnswerCorrectForQ4(){
        if(binding.q4CorrectAnswerRadioButton.isChecked()) return true;
        return false;
    }

    public boolean isAnswerCorrectForQ5(){
        if(binding.q5CorrectAnsRadioButton.isChecked()) return true;
        return false;
    }

    public boolean isAnswerCorrectForQ6(){
        String answerForQ6 = binding.q6EditText.getText().toString().toLowerCase();

        //Correct answer:
        String correctAnswer1 = "static";

        if(answerForQ6.equals(correctAnswer1)) return true;
        return false;
    }

    public boolean isAnswerCorrectForQ7(){
        String answerForQ7 = binding.q7EditText.getText().toString().toLowerCase();

        //Correct answer:
        String correctAnswer1 = "one";
        String correctAnswer2 = "1";

        if(answerForQ7.equals(correctAnswer1) || answerForQ7.equals(correctAnswer2)) return true;
        return false;
    }

    public boolean isAnswerCorrectForQ8(){
        String answerForQ8 = binding.q8EditText.getText().toString().toLowerCase();

        //Correct answer:
        String correctAnswer1 = "two";
        String correctAnswer2 = "2";

        if(answerForQ8.equals(correctAnswer1) || answerForQ8.equals(correctAnswer2)) return true;
        return false;
    }

    public boolean isAnswerCorrectForQ9(){
        if(binding.q9Count1Checkbox.isChecked() & binding.q9Count2Checkbox.isChecked() & binding.q9Count3Checkbox.isChecked() & !binding.q9WrongAnswerCheckbox.isChecked()) return true;
        return false;
    }
}