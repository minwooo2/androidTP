package com.example.teamProject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class Result3 extends AppCompatActivity {
    LinearLayout Rs3, Rf3, a3, b3, c3;
    ImageButton btn31, btn32, btn33;
    TextView Ra3, Rb3, Rc3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result3);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        int cnt, success, fail;


        Rs3 = (LinearLayout) findViewById(R.id.Rs3);
        Rf3 = (LinearLayout) findViewById(R.id.Rf3);
        a3 = (LinearLayout) findViewById(R.id.a3);
        b3 = (LinearLayout) findViewById(R.id.b3);
        c3 = (LinearLayout) findViewById(R.id.c3);
        Ra3 = (TextView) findViewById(R.id.Ra3);
        Rb3 = (TextView) findViewById(R.id.Rb3);
        Rc3 = (TextView) findViewById(R.id.Rc3);
        btn31 = findViewById(R.id.btn31);
        btn32 = findViewById(R.id.btn32);
        btn33 = findViewById(R.id.btn33);

        Intent intent = getIntent();
        cnt = intent.getIntExtra("cnt", 0);
        success = intent.getIntExtra("success", 0);
        fail = intent.getIntExtra("fail", 0);


        if(success >= 6){
            Rs3.setVisibility(View.VISIBLE);
            Rf3.setVisibility(View.INVISIBLE);
        }
        else{
            Rs3.setVisibility(View.INVISIBLE);
            Rf3.setVisibility(View.VISIBLE);
        }
        Rc3.setText(cnt + "개중 " + success + "개 맞았으며\n" + fail + "개 틀렸습니다.\n 즉, 정답률은" + success*10 + "% 입니다.");



        btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Select.class);
                startActivityForResult(intent, 0);
            }
        });

        btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Game3.class);
                startActivityForResult(intent, 0);
            }
        });

        btn33.setOnClickListener(new View.OnClickListener() {
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
