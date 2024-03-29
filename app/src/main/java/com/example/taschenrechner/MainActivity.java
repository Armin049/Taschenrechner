package com.example.taschenrechner;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    public static final String MYKEY = "MYKEY";
    public static final String MYKEY2 = "MYKEY2";

    //saves the values from the Calculation and the Result window to the savedInstances
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        TextView view =findViewById(R.id.textViewCalculation);
        TextView view2 =findViewById(R.id.textViewResult);
        outState.putString(MYKEY, view.getText().toString());
        outState.putString(MYKEY2, view2.getText().toString());
        super.onSaveInstanceState(outState);
    }

    //gets the values from the savedInstances
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        TextView calculation =findViewById(R.id.textViewCalculation);
        TextView result =findViewById(R.id.textViewResult);
        calculation.setText(savedInstanceState.getString(MYKEY));
        result.setText(savedInstanceState.getString(MYKEY2));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
    }
//creates the settings buttons
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Configuration config = getResources().getConfiguration();
        switch (config.screenLayout&Configuration.SCREENLAYOUT_SIZE_MASK){
            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                return true;
            default:{
                getMenuInflater().inflate(R.menu.menu_new, menu);
                return true;
            }
        }
    }
//sets the values for the settings buttons (sin,tan,cos,sqrt)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        switch (item.getItemId()) {
            case R.id.cos:
                calculation.setText(calculation.getText()+"cos");
                Calculate();
                return true;
            case R.id.sin:
                calculation.setText(calculation.getText()+"sin");
                Calculate();
                return true;
            case R.id.tan:
                calculation.setText(calculation.getText()+"tan");
                Calculate();
                return true;
            case R.id.wurzel:
                calculation.setText(calculation.getText()+"√");
                Calculate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //calculates after every change inthe field Calculation
    public void Calculate(){
        TextView res =findViewById(R.id.textViewResult);
        TextView calculation =findViewById(R.id.textViewCalculation);
        String calc=calculation.getText().toString().replace("√","sqrt");
        Expression e = new ExpressionBuilder(calc)
                .build();
        try {
            double result = e.evaluate();
            res.setText(Double.toString(result));
        } catch (Exception exception) {
            exception.printStackTrace();
            res.setText("error");
        }
    }


    //the following buttons write the number from their name in to the field Calculation
    public void onClick1(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"1");
        Calculate();
    }
    public void onClick2(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"2");
        Calculate();
    }
    public void onClick3(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"3");
        Calculate();
    }
    public void onClick4(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"4");
        Calculate();
    }
    public void onClick5(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"5");
        Calculate();
    }
    public void onClick6(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"6");
        Calculate();
    }
    public void onClick7(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"7");
        Calculate();
    }
    public void onClick8(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"8");
        Calculate();
    }
    public void onClick9(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"9");
        Calculate();
    }
    public void onClick0(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"0");
        Calculate();
    }

    public void onClickMultiply(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"*");
    }
    public void onClickDivide(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"/");
    }
    public void onClickMinus(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"-");
    }
    public void onClickPlus(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"+");
    }
    public void onClickDot(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+".");
        Calculate();
    }
    public void onClickAC(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText("");
    }
    public void onClickDel(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        CharSequence str =calculation.getText();
            if (str != null && str.length() > 0) {
                str = str.toString().substring(0, str.length() - 1);
            }
        calculation.setText(str);
            if (str.length()>0){
                Calculate();
            }
    }
    public void onClickEquals(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        TextView res =findViewById(R.id.textViewResult);
        if (res.getText()!="error") {
            calculation.setText(res.getText());
            res.setText("");
        }
    }
    public void onClickSin(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"sin");
        Calculate();
    }
    public void onClickCos(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"cos");
        Calculate();
    }
    public void onClickTan(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"tan");
        Calculate();
    }
    public void onClickSqrt(View view) {
        TextView calculation =findViewById(R.id.textViewCalculation);
        calculation.setText(calculation.getText()+"√");
        Calculate();
    }
}

