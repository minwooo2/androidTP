package com.example.teamProject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class Result1 extends AppCompatActivity {
    LinearLayout Rs1, Rf1, a1, b1, c1;
    ImageButton btn11, btn12, btn13;
    TextView Ra1, Rb1, Rc1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result1);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        int lifeCount;


        Rs1 = (LinearLayout) findViewById(R.id.Rs1);
        Rf1 = (LinearLayout) findViewById(R.id.Rf1);
        a1 = (LinearLayout) findViewById(R.id.a1);
        b1 = (LinearLayout) findViewById(R.id.b1);
        c1 = (LinearLayout) findViewById(R.id.c1);
        Ra1 = (TextView) findViewById(R.id.Ra1);
        Rb1 = (TextView) findViewById(R.id.Rb1);
        Rc1 = (TextView) findViewById(R.id.Rc1);
        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);
        btn13 = findViewById(R.id.btn13);

        Intent intent = getIntent();
        lifeCount = intent.getIntExtra("lifeCount", 0);


        if(lifeCount > 0){
            Rs1.setVisibility(View.VISIBLE);
            Rf1.setVisibility(View.INVISIBLE);
            Rc1.setText("10번 기회중 " + (10-lifeCount) + "번 만에 맞추셨습니다. \n" + "정답률은 " + lifeCount*10 + "% 입니다.");
        }
        else{
            Rs1.setVisibility(View.INVISIBLE);
            Rf1.setVisibility(View.VISIBLE);
            Rc1.setText("10번 기회중 한번도 맞추지 \n못하셨습니다.\n" + "정답률은 " + lifeCount*10 + "% 입니다.");
        }

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Select.class);
                startActivityForResult(intent, 0);
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Game1.class);
                startActivityForResult(intent, 0);
            }
        });

        btn13.setOnClickListener(new View.OnClickListener() {
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
