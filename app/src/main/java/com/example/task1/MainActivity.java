package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton rBtn;
    EditText exc;
    EditText inc;
    EditText vat;
    EditText price;
    EditText units;
    static final double Vat = 0.20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rBtn = (RadioButton) findViewById(R.id.radioButton);
        exc = (EditText) findViewById(R.id.editTextTextPersonName4);
        vat = (EditText) findViewById(R.id.editTextTextPersonName5);
        inc = (EditText) findViewById(R.id.editTextTextPersonName6);
        price = (EditText) findViewById(R.id.editTextNumber);
        units = (EditText) findViewById(R.id.editTextNumber2);


    }

    public void onClick(View view) {
        String temp1 = price.getText().toString();
        String temp2 = units.getText().toString();
        if (temp1.isEmpty() || temp2.isEmpty()) {
            return;
        }
        double vv, pr = 0, val, val2, tv = 0, tp = 0;
        val = Double.parseDouble(temp1);
        val2 = Double.parseDouble(temp2);
        if (rBtn.isChecked())
            pr = val * val2;
        else {
            tv = (val * Vat) * val2;
            tp = tv + (val * val2);
        }
exc.setText(String.valueOf(pr));
        inc.setText(String.valueOf(tp));
        vat.setText(String.valueOf(tv));
    }

    public void onClear(View view) {
        exc.setText("");
        vat.setText("");
        inc.setText("");
        price.setText("");
        units.setText("");
    }
}