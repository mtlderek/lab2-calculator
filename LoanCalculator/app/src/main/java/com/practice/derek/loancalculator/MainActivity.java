package com.practice.derek.loancalculator;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.appindexing.Thing;
//import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {
    EditText loanAmount, term, interest;
    TextView monthPayment, totalPayment, totalInterest;
    LoanCalculator loanCalculator;
    private static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loanAmount = (EditText) findViewById(R.id.loan_amount);
        term = (EditText) findViewById(R.id.term_loan);
        interest = (EditText) findViewById(R.id.yearly_int_rate);
        monthPayment = (TextView) findViewById(R.id.monthly_payment_result);
        totalPayment = (TextView) findViewById(R.id.total_payment_result);
        totalInterest = (TextView) findViewById(R.id.total_interest_result);

    }

    public void calculateLoanInfo(View view){

        double loanAmountDouble = Double.parseDouble(loanAmount.getText().toString());
        int termDouble = Integer.parseInt(term.getText().toString());
        double interestDouble = Double.parseDouble(interest.getText().toString());
        loanCalculator = new LoanCalculator(loanAmountDouble, termDouble, interestDouble);



        monthPayment.setText("" + loanCalculator.getMonthlyPayment());
        totalPayment.setText("" + loanCalculator.getTotalCostOfLoan());
        totalInterest.setText("" + loanCalculator.getTotalInterest());

    }

    public void clearFields(View view){
        // TODO: 9/7/2017 clearFields Method
    }


}
