package com.appgue.sendwa;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {
    CountryCodePicker ccp;
    Button btnSend;
    EditText phoneNumber, textPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ccp = (CountryCodePicker) findViewById(R.id.ccp);
        btnSend = (Button) findViewById(R.id.btnSend);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        textPesan = (EditText) findViewById(R.id.textPesan);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newString = phoneNumber.getText().toString();
                String pesan = textPesan.getText().toString();

                ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
                    @Override
                    public void onCountrySelected() {
                        String newString = phoneNumber.getText().toString();
                        String pesan = textPesan.getText().toString();
                    }
                });

                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse(
                                "https://api.whatsapp.com/send?phone="+ccp.getSelectedCountryCode()+newString+"&text="+pesan
                        )));
            }
        });



    }
}
