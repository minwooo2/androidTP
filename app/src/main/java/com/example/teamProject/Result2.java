package com.example.teamProject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class Result2 extends AppCompatActivity {
    LinearLayout Rs2, Rf2, a2, b2, c2;
    ImageButton btn21, btn22, btn23;
    TextView Ra2, Rb2, Rc2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        int Cnt, mCnt;
        float rate;


        Rs2 = (LinearLayout) findViewById(R.id.Rs2);
        Rf2 = (LinearLayout) findViewById(R.id.Rf2);
        a2 = (LinearLayout) findViewById(R.id.a2);
        b2 = (LinearLayout) findViewById(R.id.b2);
        c2 = (LinearLayout) findViewById(R.id.c2);
        Ra2 = (TextView) findViewById(R.id.Ra2);
        Rb2 = (TextView) findViewById(R.id.Rb2);
        Rc2 = (TextView) findViewById(R.id.Rc2);
        btn21 = findViewById(R.id.btn21);
        btn22 = findViewById(R.id.btn22);
        btn23 = findViewById(R.id.btn23);

        Intent intent = getIntent();
        Cnt = intent.getIntExtra("Cnt", 0);
        mCnt = intent.getIntExtra("mCnt", 0);
        rate = (float)mCnt/(Cnt/2) * 100;


        if(rate >= 30){
            Rs2.setVisibility(View.VISIBLE);
            Rf2.setVisibility(View.INVISIBLE);
        }
        else{
            Rs2.setVisibility(View.INVISIBLE);
            Rf2.setVisibility(View.VISIBLE);
        }
        Rc2.setText(Cnt/2 + "번 시도중 " + mCnt + "번 맞았으며\n" + "정답률은 " + String.format("%.2f",rate) + "% 입니다.");

        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Select.class);
                startActivityForResult(intent, 0);
            }
        });

        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Game2.class);
                startActivityForResult(intent, 0);
            }
        });

        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                android.os.Process.killProcess(android.os.Process.myPid());
                moveTaskToBack(true);
                finishAndRemoveTask();
                System.exit(0);
            }
        });
    }

}
