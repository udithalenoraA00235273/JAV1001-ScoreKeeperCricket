package com.example.cricketscoreboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
// Creating variables for scores
    int teamOneScore = 0;
    int teamOneExtras = 0;
    int teamOneWickets = 0;
    int teamTwoScore = 0;
    int teamTwoExtras = 0;
    int teamTwoWickets = 0;

// Creating a function for buttons
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

// Team One Scoring Methods
    public void teamOneOneRun(View view){
        teamOneScore = teamOneScore + 1;
        displayForTeamOneTotal(teamOneScore);
    }

    public void teamOneTwoRuns(View view){
        teamOneScore = teamOneScore + 2;
        displayForTeamOneTotal(teamOneScore);
    }

    public void teamOneThreeRuns(View view){
        teamOneScore = teamOneScore + 3;
        displayForTeamOneTotal(teamOneScore);
    }

    public void teamOneFourRuns(View view){
        teamOneScore = teamOneScore + 4;
        displayForTeamOneTotal(teamOneScore);
    }

    public void teamOneSixRuns(View view){
        teamOneScore = teamOneScore + 6;
        displayForTeamOneTotal(teamOneScore);
    }

// Team One Wickets falling method
    public void teamOneWicket(View view){
        teamOneScore = teamOneScore - 5;
        displayForTeamOneTotal(teamOneScore);
        teamOneWickets = teamOneWickets + 1;
        displayForTeamOneWickets(teamOneWickets);

    // If statement to check weather team got all out and displaying the user about the required runs to win
        if (teamOneWickets > 9){
            teamOneWickets = 9;
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("All out.." + "\n" + "Team Two need" + " " + (teamOneScore + 1) + " " + "runs to win");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    Toast.makeText(MainActivity.this, "Welcome to the Second Innings...", Toast.LENGTH_SHORT).show();
                }
            });
            alert.create().show();

        // Disabling every button when wickets count get to 10 (All out)
            button = findViewById(R.id.team_one_one_run);
            button.setEnabled(false);
            button = findViewById(R.id.team_one_two_runs);
            button.setEnabled(false);
            button = findViewById(R.id.team_one_three_runs);
            button.setEnabled(false);
            button = findViewById(R.id.team_one_four_runs);
            button.setEnabled(false);
            button = findViewById(R.id.team_one_six_runs);
            button.setEnabled(false);
            button = findViewById(R.id.team_one_wicket_count);
            button.setEnabled(false);
            button = findViewById(R.id.team_one_wide);
            button.setEnabled(false);
            button = findViewById(R.id.team_one_no);
            button.setEnabled(false);
            button = findViewById(R.id.team_one_extras_multi);
            button.setEnabled(false);
            button = findViewById(R.id.team_one_extras_five);
            button.setEnabled(false);
        }
    }

// Team One Extra Runs Method
    public void teamOneExtrasMulti(View view){
        teamOneExtras = teamOneExtras + 1;
        teamOneScore = teamOneScore + 1;
        displayForTeamOneTotal(teamOneScore);
        displayForTeamOneExtras(teamOneExtras);
    }

    public void teamOneExtrasFive(View view){
        teamOneExtras = teamOneExtras + 5;
        teamOneScore = teamOneScore + 5;
        displayForTeamOneTotal(teamOneScore);
        displayForTeamOneExtras(teamOneExtras);
    }

// Method to display the output in each text views
    public void displayForTeamOneTotal(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_one_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamOneWickets(int wickets) {
        TextView wicketView = (TextView) findViewById(R.id.team_one_wickets);
        wicketView.setText(String.valueOf(wickets));
    }

    public void displayForTeamOneExtras(int extras) {
        TextView extrasView = (TextView) findViewById(R.id.team_one_extras);
        extrasView.setText(String.valueOf(extras));
    }

// Team Two Scoring Methods
    public void teamTwoOneRun(View view){
        teamTwoScore = teamTwoScore + 1;
        displayForTeamTwoTotal(teamTwoScore);
        calculateWin(view);
    }

    public void teamTwoTwoRuns(View view){
        teamTwoScore = teamTwoScore + 2;
        displayForTeamTwoTotal(teamTwoScore);
        calculateWin(view);
    }

    public void teamTwoThreeRuns(View view){
        teamTwoScore = teamTwoScore + 3;
        displayForTeamTwoTotal(teamTwoScore);
        calculateWin(view);
    }

    public void teamTwoFourRuns(View view){
        teamTwoScore = teamTwoScore + 4;
        displayForTeamTwoTotal(teamTwoScore);
        calculateWin(view);
    }

    public void teamTwoSixRuns(View view){
        teamTwoScore = teamTwoScore + 6;
        displayForTeamTwoTotal(teamTwoScore);
        calculateWin(view);
    }

// Team Two Wickets falling method
    public void teamTwoWicket(View view) {
        teamTwoScore = teamTwoScore - 5;
        displayForTeamTwoTotal(teamTwoScore);
        teamTwoWickets = teamTwoWickets + 1;
        displayForTeamTwoWickets(teamTwoWickets);
        calculateWin(view);
    }

    // method to decide the winning team
    public void calculateWin(View view){
    // If statement to check which team has won the match and displaying the results to the user
        if ((teamOneScore > teamTwoScore) && teamTwoWickets > 9) {
            teamTwoWickets = 9;
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Team One has won the match...!!!");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    Toast.makeText(MainActivity.this, "Congrats to the winning team...!!!", Toast.LENGTH_SHORT).show();
                }
            });
            alert.create().show();

            // Disabling every button when wickets count get to 10 (All Out)
            button = findViewById(R.id.team_two_one_run);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_two_runs);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_three_runs);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_four_runs);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_six_runs);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_wicket_count);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_wide);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_no);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_extras_multi);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_extras_five);
            button.setEnabled(false);
        }
        else if (teamOneScore < teamTwoScore) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Team Two has won the match...!!!");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    Toast.makeText(MainActivity.this, "Congrats to the winning team...!!!", Toast.LENGTH_SHORT).show();
                }
            });
            alert.create().show();
            // Disabling every button when wickets count get to 10 (All Out)
            button = findViewById(R.id.team_two_one_run);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_two_runs);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_three_runs);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_four_runs);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_six_runs);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_wicket_count);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_wide);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_no);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_extras_multi);
            button.setEnabled(false);
            button = findViewById(R.id.team_two_extras_five);
            button.setEnabled(false);
        }
    }
// Team One Extra Runs Method
    public void teamTwoExtrasMulti(View view){
        teamTwoExtras = teamTwoExtras + 1;
        teamTwoScore = teamTwoScore + 1;
        displayForTeamTwoTotal(teamTwoScore);
        displayForTeamTwoExtras(teamTwoExtras);
    }

    public void teamTwoExtrasFive(View view){
        teamTwoExtras = teamTwoExtras + 5;
        teamTwoScore = teamTwoScore + 5;
        displayForTeamTwoTotal(teamTwoScore);
        displayForTeamTwoExtras(teamTwoExtras);
    }

// Method to display the output in each text views
    public void displayForTeamTwoTotal(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_two_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamTwoWickets(int wickets) {
        TextView wicketView = (TextView) findViewById(R.id.team_two_wickets);
        wicketView.setText(String.valueOf(wickets));
    }

    public void displayForTeamTwoExtras(int extras) {
        TextView extrasView = (TextView) findViewById(R.id.team_two_extras);
        extrasView.setText(String.valueOf(extras));
    }

// Reset Button Method //
    public void resetScores(View view){
        teamOneScore = 0;
        teamOneExtras = 0;
        teamOneWickets = 0;
        teamTwoScore = 0;
        teamTwoExtras = 0;
        teamTwoWickets = 0;

    // Assigning 0 values to scores
        displayForTeamOneTotal(0);
        displayForTeamTwoTotal(0);
        displayForTeamOneWickets(0);
        displayForTeamTwoWickets(0);
        displayForTeamOneExtras(0);
        displayForTeamTwoExtras(0);

    // Enabling buttons after click the reset score
        button = findViewById(R.id.team_one_one_run);
        button.setEnabled(true);
        button = findViewById(R.id.team_one_two_runs);
        button.setEnabled(true);
        button = findViewById(R.id.team_one_three_runs);
        button.setEnabled(true);
        button = findViewById(R.id.team_one_four_runs);
        button.setEnabled(true);
        button = findViewById(R.id.team_one_six_runs);
        button.setEnabled(true);
        button = findViewById(R.id.team_one_wicket_count);
        button.setEnabled(true);
        button = findViewById(R.id.team_one_wide);
        button.setEnabled(true);
        button = findViewById(R.id.team_one_no);
        button.setEnabled(true);
        button = findViewById(R.id.team_one_extras_multi);
        button.setEnabled(true);
        button = findViewById(R.id.team_one_extras_five);
        button.setEnabled(true);
        button = findViewById(R.id.team_two_one_run);
        button.setEnabled(true);
        button = findViewById(R.id.team_two_two_runs);
        button.setEnabled(true);
        button = findViewById(R.id.team_two_three_runs);
        button.setEnabled(true);
        button = findViewById(R.id.team_two_four_runs);
        button.setEnabled(true);
        button = findViewById(R.id.team_two_six_runs);
        button.setEnabled(true);
        button = findViewById(R.id.team_two_wicket_count);
        button.setEnabled(true);
        button = findViewById(R.id.team_two_wide);
        button.setEnabled(true);
        button = findViewById(R.id.team_two_no);
        button.setEnabled(true);
        button = findViewById(R.id.team_two_extras_multi);
        button.setEnabled(true);
        button = findViewById(R.id.team_two_extras_five);
        button.setEnabled(true);
    }
}