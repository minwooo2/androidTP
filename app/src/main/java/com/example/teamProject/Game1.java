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
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashSet;
import java.util.Random;

public class Game1 extends AppCompatActivity {
    EditText requestText;
    TextView responseText, resultText, lifeCountText, TimerTextView;
    Button startBtn, result1;
    ImageButton answerBtn, btnReset, btnReturn;
    //랜덤 숫자 들어갈 배열
    int[] com = new int[3];
    //사용자가 입력한 숫자 들어갈 배열
    int[] user = new int[3];
    int strike = 0; //스트라이크 갯수
    int ball = 0; //볼 갯수
    int lifeCount = 10;//기회 횟수
    String result = "";//답변

    CountDownTimer countDownTimer;//카운트다운 타이머

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game1);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //입력된 숫자가 보여지는 텍스트뷰
        requestText = findViewById(R.id.request_text);
        responseText = findViewById(R.id.response_text);
        lifeCountText = findViewById(R.id.life_count_text);
        resultText = findViewById(R.id.result_text);
        answerBtn = findViewById(R.id.answer_btn);
        startBtn = findViewById(R.id.start_btn);
        TimerTextView = findViewById(R.id.textView);

        btnReset = findViewById(R.id.btnReset);
        btnReturn = findViewById(R.id.btnReturn);
        result1 = findViewById(R.id.result1);

        viewMode("end");

        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Select.class);
                startActivityForResult(intent, 0);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(countDownTimer != null)
                    countDownTimer.cancel();//카운트다운타이머 삭제
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });


        startBtn.setOnClickListener(new View.OnClickListener() { //시작버튼 클릭이벤트
            @Override
            public void onClick(View view) {
                countDownTimer = new CountDownTimer(100000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        int num = (int) (millisUntilFinished / 1000);
                        TimerTextView.setText("남은시간 : " + Integer.toString(num + 1) + "초");
                    }

                    public void onFinish() {
                        Dialog timeout = new Dialog(Game1.this);
                        timeout.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        timeout.setContentView(R.layout.timeout1);
                        timeout.show();
                        timeout.findViewById(R.id.timeoutBtn1).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getApplicationContext(), Game1.class);
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


                randomNumber(); //랜덤한 수 생성

                viewMode("start");//게임중

                Toast.makeText(Game1.this, "게임이 시작되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        //정답제출버튼 이벤트
        answerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //비교로직
                numberCheck();
            }
        });

        result1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Result1.class);
                intent.putExtra("lifeCount", lifeCount);

                startActivityForResult(intent, 0);
            }
        });
    } //onCreate

    public void randomNumber() {
        int count = 0;
        Random random = new Random();
        HashSet set = new HashSet();

        while (set.size() < 3) {
            int randomNumber = random.nextInt(9) + 1;// 1~9
            set.add(randomNumber);
        }

        //배열에 숫자 담기
        for (Object number : set) {
            Integer tempNum = (Integer) number;
            com[count] = tempNum;
            count++;
        }
    }

    //숫자 횟수 체크
    public void numberCheck() {
        //입력값
        String inputNumber = requestText.getText().toString();

        if (inputNumber.length() == 3) {//숫자 3개일 때 비교
            if (lifeCount > 0) {
                //기회횟수 감소
                --lifeCount;

                lifeCountText.setText("기회: " + lifeCount + "번");

                //사용자가 입력한 숫자 배열에 넣기
                user[0] = Integer.parseInt(inputNumber.substring(0, 1));
                user[1] = Integer.parseInt(inputNumber.substring(1, 2));
                user[2] = Integer.parseInt(inputNumber.substring(2, 3));

                //비교
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        //랜덤숫자와 입력숫자가 같다면
                        if (com[i] == user[j]) {
                            if (i == j) {//위치까지 맞춘 경우
                                //strike
                                strike++;
                            } else {//숫자만 맞춘 경우
                                //ball
                                ball++;
                            }
                        }
                    }
                }

                if (strike == 3) {
                    Toast.makeText(this, "성공했습니다", Toast.LENGTH_SHORT).show();
                    //답변
                    responseText.setText("정답: " + com[0] + "" + com[1] + "" + com[2]);
                    countDownTimer.cancel();//카운트다운 타이머 초기화
                    result1.setVisibility(View.VISIBLE);

                } else if (lifeCount <= 0) {//기회 횟수 없음
                    Toast.makeText(this, "실패했습니다", Toast.LENGTH_SHORT).show();
                    //답변
                    responseText.setText("정답: " + com[0] + "" + com[1] + "" + com[2]);
                    countDownTimer.cancel();//카운트다운 타이머 초기화
                    result1.setVisibility(View.VISIBLE);
                } else { //계속 진행
                    responseText.setText("strike:" + strike + " ball: " + ball);
                    showResult(inputNumber);
                }
                //초기화
                requestText.setText("");
                result = "";
                strike = 0;
                ball = 0; }
            else {
                Toast.makeText(this, "숫자 3개를 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //화면 구조
    public void viewMode(String mode) {
        if (mode.equals("start")) { //게임중

            startBtn.setEnabled(false);
            answerBtn.setEnabled(true);
            requestText.setEnabled(true);

        } else if (mode.equals("end")) { //쉬는중

            startBtn.setEnabled(true);
            answerBtn.setEnabled(false);
            requestText.setEnabled(false);
        }
    }

//    //초기화
//    public void reset() {
//        TimerTextView.setText("남은시간 : " + Integer.toString(100) + "초");
//        countDownTimer.cancel();//카운트다운 타이머 초기화
//
//        lifeCount = 10;
//        lifeCountText.setText("기회: " + lifeCount + "번");
//        responseText.setText("");//답변 텍스트뷰
//        resultText.setText("");//결과목록 텍스트뷰
//    }

    public void showResult(String inputNumber) {

        result = result + "Strike: " + strike + " Ball: " + ball;
        resultText.append(inputNumber + ": " + result + "\n");
    }
}