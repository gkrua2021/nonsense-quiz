package com.example.plpl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int count = getIntent().getIntExtra("count", 0);

        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText(String.valueOf(count) + "점 입니다!");
    }

}
