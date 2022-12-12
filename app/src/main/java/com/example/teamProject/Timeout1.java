package com.example.teamProject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class Timeout1 extends AppCompatActivity {
    ImageButton timeoutBtn1, exitBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeout1);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        timeoutBtn1 = findViewById(R.id.timeoutBtn1);
        exitBtn1 = findViewById(R.id.exitBtn1);

        timeoutBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Game1.class);
                startActivityForResult(intent, 0);
            }
        });

        exitBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Select.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}