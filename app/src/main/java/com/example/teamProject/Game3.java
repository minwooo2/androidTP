package com.example.teamProject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Game3 extends AppCompatActivity {

    Dialog timeout;
    EditText textEqual;
    Button  btnResult3;
    ImageButton btnGo, btnStart, btnReset, btnReturn;
    ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9, image10,
            image11, image12, image13, image14, image15, image16, image17, image18, image19, image20,
            image21, image22;
    TextView textImageNum, text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11,
            text12, text13, text14, text15, text16, text17, text18, text19, text20, text21, text22,
            textView3;
    LinearLayout L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16,
            L17, L18, L19, L20, L21, L22;

    int imageNum = 0;//이미지 번호 출력변수

    int index = 0;
    int cnt = 0, success, fail;
    Random random = new Random();

    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game3);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        textImageNum = findViewById(R.id.textImageNum);

        textView3 = findViewById(R.id.textView3);
        textEqual = (EditText) findViewById(R.id.textEqual);
        btnStart = findViewById(R.id.btnStart);
        btnGo = findViewById(R.id.btnGo);
        btnResult3 = (Button) findViewById(R.id.btnResult3);
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        image5 = (ImageView) findViewById(R.id.image5);
        image6 = (ImageView) findViewById(R.id.image6);
        image7 = (ImageView) findViewById(R.id.image7);
        image8 = (ImageView) findViewById(R.id.image8);
        image9 = (ImageView) findViewById(R.id.image9);
        image10 = (ImageView) findViewById(R.id.image10);
        image11 = (ImageView) findViewById(R.id.image11);
        image12 = (ImageView) findViewById(R.id.image12);
        image13 = (ImageView) findViewById(R.id.image13);
        image14 = (ImageView) findViewById(R.id.image14);
        image15 = (ImageView) findViewById(R.id.image15);
        image16 = (ImageView) findViewById(R.id.image16);
        image17 = (ImageView) findViewById(R.id.image17);
        image18 = (ImageView) findViewById(R.id.image18);
        image19 = (ImageView) findViewById(R.id.image19);
        image20 = (ImageView) findViewById(R.id.image20);
        image21 = (ImageView) findViewById(R.id.image21);
        image22 = (ImageView) findViewById(R.id.image22);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        text5 = (TextView) findViewById(R.id.text5);
        text6 = (TextView) findViewById(R.id.text6);
        text7 = (TextView) findViewById(R.id.text7);
        text8 = (TextView) findViewById(R.id.text8);
        text9 = (TextView) findViewById(R.id.text9);
        text10 = (TextView) findViewById(R.id.text10);
        text11 = (TextView) findViewById(R.id.text11);
        text12 = (TextView) findViewById(R.id.text12);
        text13 = (TextView) findViewById(R.id.text13);
        text14 = (TextView) findViewById(R.id.text14);
        text15 = (TextView) findViewById(R.id.text15);
        text16 = (TextView) findViewById(R.id.text16);
        text17 = (TextView) findViewById(R.id.text17);
        text18 = (TextView) findViewById(R.id.text18);
        text19 = (TextView) findViewById(R.id.text19);
        text20 = (TextView) findViewById(R.id.text20);
        text21 = (TextView) findViewById(R.id.text21);
        text22 = (TextView) findViewById(R.id.text22);
        L1 = (LinearLayout) findViewById(R.id.L1);
        L2 = (LinearLayout) findViewById(R.id.L2);
        L3 = (LinearLayout) findViewById(R.id.L3);
        L4 = (LinearLayout) findViewById(R.id.L4);
        L5 = (LinearLayout) findViewById(R.id.L5);
        L6 = (LinearLayout) findViewById(R.id.L6);
        L7 = (LinearLayout) findViewById(R.id.L7);
        L8 = (LinearLayout) findViewById(R.id.L8);
        L9 = (LinearLayout) findViewById(R.id.L9);
        L10 = (LinearLayout) findViewById(R.id.L10);
        L11 = (LinearLayout) findViewById(R.id.L11);
        L12 = (LinearLayout) findViewById(R.id.L12);
        L13 = (LinearLayout) findViewById(R.id.L13);
        L14 = (LinearLayout) findViewById(R.id.L14);
        L15 = (LinearLayout) findViewById(R.id.L15);
        L16 = (LinearLayout) findViewById(R.id.L16);
        L17 = (LinearLayout) findViewById(R.id.L17);
        L18 = (LinearLayout) findViewById(R.id.L18);
        L19 = (LinearLayout) findViewById(R.id.L19);
        L20 = (LinearLayout) findViewById(R.id.L20);
        L21 = (LinearLayout) findViewById(R.id.L21);
        L22 = (LinearLayout) findViewById(R.id.L22);

        btnReset =  findViewById(R.id.btnReset);
        btnReturn = findViewById(R.id.btnReturn);

        printImage();//이미지 출력

        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Select.class);
                startActivityForResult(intent, 0);
            }
        });

        countDownTimer = new CountDownTimer(100000, 1000) {
            public void onTick(long millisUntilFinished) {
                int num = (int) (millisUntilFinished / 1000);
                textView3.setText("남은시간 : " + Integer.toString(num + 1) + "초");
            }
            public void onFinish() {
                timeout = new Dialog(Game3.this);
                timeout.requestWindowFeature(Window.FEATURE_NO_TITLE);
                timeout.setContentView(R.layout.timeout1);
                timeout.show();
                timeout.findViewById(R.id.timeoutBtn1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), Game3.class);
                        startActivityForResult(intent, 0);
                    }
                });
                timeout.findViewById(R.id.exitBtn1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), Select.class);
                        startActivityForResult(intent, 0);
                    }
                });
            }
        }.start();

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();//카운트다운타이머 삭제
                imageNum = 0;//이미지번호 초기화
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printImage();
            }
        });
    }

    //이미지 출력
    public void printImage() {
        imageNum++;//이미지번호 증가
        textImageNum.setText("" + imageNum);//이미지번호 출력

        textEqual.setVisibility(View.VISIBLE);
        btnGo.setVisibility(View.VISIBLE);
        btnResult3.setEnabled(false);
        if (cnt > 9) {
            btnResult3.setEnabled(true);
            btnStart.setEnabled(false);
            btnStart.setVisibility(View.GONE);
            btnGo.setEnabled(false);
            btnResult3.setVisibility(View.VISIBLE);
            countDownTimer.cancel();
        }

        index = random.nextInt(22);
        switch (index) {
            case 0:
                L1.setVisibility(View.VISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text1.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 1:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.VISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text2.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 2:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.VISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text3.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 3:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.VISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text4.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 4:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.VISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text5.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 5:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.VISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text6.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 6:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.VISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text7.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 7:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.VISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text8.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 8:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.VISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text9.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 9:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.VISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text10.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 10:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.VISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text11.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 11:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.VISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text12.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 12:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.VISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text13.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 13:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.VISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text14.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 14:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.VISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text15.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 15:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.VISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text16.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 16:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.VISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text17.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 17:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.VISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text18.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 18:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.VISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text19.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 19:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.VISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text20.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 20:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.VISIBLE);
                L22.setVisibility(View.INVISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text21.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
            case 21:
                L1.setVisibility(View.INVISIBLE);
                L2.setVisibility(View.INVISIBLE);
                L3.setVisibility(View.INVISIBLE);
                L4.setVisibility(View.INVISIBLE);
                L5.setVisibility(View.INVISIBLE);
                L6.setVisibility(View.INVISIBLE);
                L7.setVisibility(View.INVISIBLE);
                L8.setVisibility(View.INVISIBLE);
                L9.setVisibility(View.INVISIBLE);
                L10.setVisibility(View.INVISIBLE);
                L11.setVisibility(View.INVISIBLE);
                L12.setVisibility(View.INVISIBLE);
                L13.setVisibility(View.INVISIBLE);
                L14.setVisibility(View.INVISIBLE);
                L15.setVisibility(View.INVISIBLE);
                L16.setVisibility(View.INVISIBLE);
                L17.setVisibility(View.INVISIBLE);
                L18.setVisibility(View.INVISIBLE);
                L19.setVisibility(View.INVISIBLE);
                L20.setVisibility(View.INVISIBLE);
                L21.setVisibility(View.INVISIBLE);
                L22.setVisibility(View.VISIBLE);
                btnGo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text22.getText().toString().equals(textEqual.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "정답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            success++;
                        } else {
                            Toast.makeText(getApplicationContext(), "오답!",
                                    Toast.LENGTH_SHORT).show();
                            textEqual.setText(null);
                            fail++;
                        }
                        cnt++;
                    }
                });
                break;
        }

        btnResult3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Result3.class);
                intent.putExtra("cnt", cnt);
                intent.putExtra("success", success);
                intent.putExtra("fail", fail);
//                        Toast.makeText(getApplicationContext(), "cnt, success, fail : "+ cnt + "," + success + "," + fail + "개", Toast.LENGTH_SHORT).show();
                startActivityForResult(intent, 0);
            }
        });
    }
}