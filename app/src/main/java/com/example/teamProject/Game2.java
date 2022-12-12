package com.example.teamProject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Game2 extends AppCompatActivity implements View.OnClickListener {
    ImageButton[] buttons = new ImageButton[20];//이미지 버튼 배열
    ArrayList<Integer> imageList;//출력 이미지 리스트
    ArrayList<CardData> cardList;//카드 리스트

    TextView resultText;//결과 텍스트
    TextView textViewTimer;

    Button btnResult2;
    CountDownTimer countDownTimer;//카운트다운타이머

    int preCardPosition = -1; //전에 선택한 카드 위치

    //누른횟수, 매칭횟수
    int Cnt;
    int mCnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.game2);

        resultText = findViewById(R.id.textResult);
        textViewTimer = findViewById(R.id.textViewTimer);
        btnResult2 = findViewById(R.id.btnResult2);

        init();

        //다시시작 버튼
        ImageButton btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();//카운트다운타이머 삭제
                btnResult2.setVisibility(View.INVISIBLE);//결과창버튼 안보이게
                init();
            }
        });

        //게임선택창 돌아가기 버튼
        ImageButton btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Select.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    //초기화
    public void init() {
        //시도횟수, 매칭횟수 초기화
        Cnt = 0;
        mCnt = 0;

        //카운트다운타이머 생성
        countDownTimer = new CountDownTimer(100000, 1000) {
            public void onTick(long millisUntilFinished) {
                int num = (int) (millisUntilFinished / 1000);
                textViewTimer.setText("남은시간 : " + Integer.toString(num + 1) + "초");
            }
            public void onFinish() {
                Dialog timeout = new Dialog(Game2.this);
                timeout.requestWindowFeature(Window.FEATURE_NO_TITLE);
                timeout.setContentView(R.layout.timeout1);
                timeout.show();
                timeout.findViewById(R.id.timeoutBtn1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), Game2.class);
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

        //리스트에 데이터 등록
        imageList = new ArrayList<>();
        imageList.add(R.drawable.bear);
        imageList.add(R.drawable.cow);
        imageList.add(R.drawable.fox);
        imageList.add(R.drawable.lion);
        imageList.add(R.drawable.rabbit);
        imageList.add(R.drawable.rhino);
        imageList.add(R.drawable.shark);
        imageList.add(R.drawable.tiger);
        imageList.add(R.drawable.snake);
        imageList.add(R.drawable.wolf);
        imageList.add(R.drawable.bear);
        imageList.add(R.drawable.cow);
        imageList.add(R.drawable.fox);
        imageList.add(R.drawable.lion);
        imageList.add(R.drawable.rabbit);
        imageList.add(R.drawable.rhino);
        imageList.add(R.drawable.shark);
        imageList.add(R.drawable.tiger);
        imageList.add(R.drawable.snake);
        imageList.add(R.drawable.wolf);

        //리스트 랜덩므로 섞기
        Collections.shuffle(imageList);

        //카드 초기화
        cardList = new ArrayList<>();

        //버튼 초기화
        for (int i = 0; i < buttons.length; i++) {
            String buttonId = "btnImage" + i;
            int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
            buttons[i] = findViewById(resId);

            //각 버튼에 클럭이벤트
            buttons[i].setOnClickListener(this);

            //리스트에 이미지 담기
            cardList.add(new CardData(imageList.get(i), false, false));

            //뒷면 출력 전 버튼 누를 수 없음
            buttons[i].setEnabled(false);

            //선명도 초기화
            buttons[i].setAlpha(1.0f);
        }

        //각 버튼 이미지 출력
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setImageResource(cardList.get(i).getId());
        }

        //1초 딜레이 후 카드 뒷면으로 변경
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < buttons.length; i++){
                    //각버튼 카드 뒷면으로 변경
                    buttons[i].setImageResource(R.drawable.back);
                    //버튼 누를 수 있게
                    buttons[i].setEnabled(true);
                }
            }
        }, 2000);

        //결과텍스트 초기화
        resultText.setText("");
    }

    public void onClick(View view) {
        Cnt++;   //시도 횟수 증가

        int id = view.getId();
        int position = 0;

        //카드 Id와 같은 Id의 이미지의 좌표 저장
        if (id == R.id.btnImage0) {
            position = 0;
        } else if (id == R.id.btnImage1) {
            position = 1;
        } else if (id == R.id.btnImage2) {
            position = 2;
        } else if (id == R.id.btnImage3) {
            position = 3;
        } else if (id == R.id.btnImage4) {
            position = 4;
        } else if (id == R.id.btnImage5) {
            position = 5;
        } else if (id == R.id.btnImage6) {
            position = 6;
        } else if (id == R.id.btnImage7) {
            position = 7;
        } else if (id == R.id.btnImage8) {
            position = 8;
        } else if (id == R.id.btnImage9) {
            position = 9;
        } else if (id == R.id.btnImage10) {
            position = 10;
        } else if (id == R.id.btnImage11) {
            position = 11;
        } else if (id == R.id.btnImage12) {
            position = 12;
        } else if (id == R.id.btnImage13) {
            position = 13;
        } else if (id == R.id.btnImage14) {
            position = 14;
        } else if (id == R.id.btnImage15) {
            position = 15;
        } else if (id == R.id.btnImage16) {
            position = 16;
        } else if (id == R.id.btnImage17) {
            position = 17;
        } else if (id == R.id.btnImage18) {
            position = 18;
        } else if (id == R.id.btnImage19) {
            position = 19;
        }

        //데이터 변경
        updateData(position);

        //뷰 변경
        updateView(position);
    }

    //데이터 변경
    private void updateData(int position) {
        CardData cardData = cardList.get(position);

        //카드가 앞면일 시 토스트 출력 후 리턴
        if (cardData.getFace()) {
            Toast.makeText(this, "앞면입니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        //전에 뒤집힌 카드 0 또는 2개일 때
        if (preCardPosition == -1) {
            //카드 초기화
            restoreCard();
            //위치 저장
            preCardPosition = position;
        }
        //전에 뒤집히 카드 1개 일 때
        else {
            //카드 비교
            checkMatch(preCardPosition, position);
            preCardPosition = -1;
        }

        //카드의 출력 반대로 변경
        cardList.get(position).setFace(!cardData.getFace());
    }

    // 뷰 변경
    private void updateView(int position) {
        CardData cardData = cardList.get(position);

        // 뒤집었음 랜덤 이미지
        if (cardData.getFace()) {
            buttons[position].setImageResource(cardData.getId());
        }
        //기본 이미지
        else {
            buttons[position].setImageResource(R.drawable.back);
        }
    }

    //매치안된 카드 초기화
    private void restoreCard() {
        for (int i = 0; i < cardList.size(); i++) {
            //매치되지 않은거
            if (!cardList.get(i).getMatch()) {
                //뒷면 출력
                buttons[i].setImageResource(R.drawable.back);
                //데이터 뒷면으로 수정
                cardList.get(i).setFace(false);
            }
        }
    }

    // 카드 이미지 비교
    private void checkMatch(int prePosition, int position) {
        //처음 카드와 두번째 카드 이미지가 같다면
        if (cardList.get(prePosition).getId() == cardList.get(position).getId()) {

            mCnt++;  //매칭 횟수 증가

            resultText.setText("매치");

            cardList.get(prePosition).setMatch(true);
            cardList.get(position).setMatch(true);

            //선명도변경
            buttons[prePosition].setAlpha(0.1f);
            buttons[position].setAlpha(0.1f);
            //선택 불가능
            buttons[prePosition].setEnabled(false);
            buttons[position].setEnabled(false);
            //완료 체크
            checkCompleted();
        } else {
            resultText.setText("매치 실패");
        }
    }

    //완료 체크
    private void checkCompleted() {
        int count = 0;
        for (int i = 0; i < cardList.size(); i++) {
            if (cardList.get(i).getMatch()) {
                count++;
            }
        }
        //매치 갯수와 카드갯수가 같다면 끝
        if (count == cardList.size()) {
            countDownTimer.cancel();
            resultText.setText("게임 끝");
            btnResult2.setVisibility(View.VISIBLE);
            btnResult2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), Result2.class);
                    intent.putExtra("Cnt", Cnt);
                    intent.putExtra("mCnt", mCnt);
                    startActivityForResult(intent, 0);
                }
            });
        }
    }

}