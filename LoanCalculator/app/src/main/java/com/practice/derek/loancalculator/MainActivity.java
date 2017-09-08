package com.practice.derek.loancalculator;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.appindexing.Thing;
//import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {
    EditText loanAmount, term, interest;
    TextView monthPayment, totalPayment, totalInterest, resultSection;
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
        resultSection = (TextView) findViewById(R.id.results);


    }

    public void calculateLoanInfo(View view){
        try {
            double loanAmountDouble = Double.parseDouble(loanAmount.getText().toString());
            int termDouble = Integer.parseInt(term.getText().toString());
            double interestDouble = Double.parseDouble(interest.getText().toString());
            loanCalculator = new LoanCalculator(loanAmountDouble, termDouble, interestDouble);

            DecimalFormat currency = new DecimalFormat("#,###,##0.00");

            monthPayment.setText("" + currency.format(loanCalculator.getMonthlyPayment()));
            totalPayment.setText("" + currency.format(loanCalculator.getTotalCostOfLoan()));
            totalInterest.setText("" + currency.format(loanCalculator.getTotalInterest()));
        } catch(Exception e){
            Log.i(TAG, "calculateLoanInfo: User field(s) not filled in");
            resultSection.setText(R.string.user_warning);

        }

    }

    public void clearFields(View view){
        monthPayment.setText(null);
        totalPayment.setText(null);
        totalInterest.setText(null);

        loanAmount.setText(null);
        term.setText(null);
        interest.setText(null);
    }


}
