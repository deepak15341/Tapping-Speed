package com.deepak15341.tappingspeed;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView timer = findViewById(R.id.timer);
        ImageView image = findViewById(R.id.imageView);
        TextView CountUp = findViewById(R.id.countup);
        TextView CountDown = findViewById(R.id.CountDown);
        AppCompatButton appCompatButton =findViewById(R.id.appCompatButton);
        appCompatButton.setOnClickListener(new View.OnClickListener() {
            int cu=0,cd=1000;
            @Override
            public void onClick(View view) {

                if (cu<=1000) {
                    cu=cu+1;
                    CountUp.setText(cu+"");
                }
                if (cd>=0) {
                    cd=cd-1;
                    CountDown.setText(cd+"");
                }

                CountDownTimer countDownTimer= new CountDownTimer(60000,1000) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {

                    }
                };
            }
        });
    }
}