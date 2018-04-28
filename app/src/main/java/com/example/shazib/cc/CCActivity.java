package com.example.shazib.cc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CCActivity extends AppCompatActivity {

    /**
     * Defining Variables/
     * /**Pound text Field
     */
    EditText poundText;
    EditText dollarText;
    EditText euroText;
    EditText rupeeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cc);

        poundText = (EditText) findViewById(R.id.poundValue);
        dollarText = (EditText)findViewById(R.id.dollarValue);
        euroText = (EditText)findViewById(R.id.euroValue);
        rupeeText=(EditText)findViewById(R.id.rupeeValue);

        Button clearButton = (Button) findViewById(R.id.clearButton);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poundText.setText("");
                dollarText.setText("");
                euroText.setText("");
                rupeeText.setText("");
            }
        });



    //When Convert Button is Clicked convert pounds to other currencies//
    Button convertButton = (Button) findViewById(R.id.convertButton);
    convertButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            try {
                //Converting pounds to different currencies with two decimal places//
                String poundString = poundText.getText().toString();

                dollarText.setText(String.valueOf(Double.parseDouble(poundString)*1.24));
                euroText.setText(String.valueOf(Double.parseDouble(poundString)*1.16));
                rupeeText.setText(String.valueOf((Double.parseDouble(poundString)*84.0715)));
            }
            catch (Exception exception){
                Toast.makeText(view.getContext(),"Invalid Data TRY AGAIN",Toast.LENGTH_SHORT).show();
            }
        }
    });
    }
}