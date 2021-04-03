package com.example.plpl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] questions = {
            "타이타닉의 구명 보트에는 몇 명이 탈수 있을까?",
            "별 중에 가장 슬픈 별은?",
            "진짜 새의 이름은 무엇일까요?",
            "고기 먹을 때마다 따라오는 개는?",
            "왕이 넘어지면 뭐가될까?",
            "차도가 없는 나라는?",
            "오리가 얼면?",
            "물고기의 반대말은?",
            "병아리가 제일 잘 먹는 약은?",
            "발이 두 개 달린 소는?"
    };
    String[] answers = {
            "9명", "이별", "참새", "이쑤시개", "킹콩","인도", "언덕","불고기","삐약","이발소"
    };
    int num_questions = questions.length;
    int index = 0;

   void test(){
       if(num_questions>0){
           index = (int)Math.floor(Math.random()*num_questions);

           TextView tv1 = findViewById(R.id.tv1);
           tv1.setText(questions[index]);
   }
       else {
           Toast.makeText(this,"문제가 다 떨어졌습니다.",
                   Toast.LENGTH_SHORT).show();
           Intent intent = new Intent(getApplicationContext(),Main2Activity.class);

           intent.putExtra("count", count);
           startActivity(intent);
       }
   }
   void di(){

       for (int i =index +1; i<num_questions;i++){
           questions[i - 1]=questions[i];
           answers[i -1]=answers[i];
       }
       num_questions--;
   }
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.bt1);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText et1 = findViewById(R.id.et1);
                TextView count1;
                String text = et1.getText().toString();

                if (text.equals(answers[index])) {
                    Toast.makeText(getApplicationContext(), "정답!", Toast.LENGTH_SHORT).show();
                    et1.setText(null);
                    di();
                    count+=10;
                    count1 = (TextView) findViewById(R.id.count1);
                    count1.setText(String.valueOf(count));
                    test();
                }
                else {
                    Toast.makeText(getApplicationContext(), "오답...", Toast.LENGTH_SHORT).show();
                    et1.setText(null);
                    count-=5;
                    count1 = (TextView) findViewById(R.id.count1);
                    count1.setText(String.valueOf(count));
                }
            }
        });
        test();

    }
}





