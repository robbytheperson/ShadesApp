package com.example.shadesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        TextView shadeDetailTV = (TextView)findViewById(R.id.shade_detail_TV);
        String shadeDetail = getIntent().getStringExtra("shade_detail");
        shadeDetailTV.setText(shadeDetail);
    }
}