package com.deepak15341.tappingspeed;


import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CountDownTimer countDownTimer;
    private long totaltime =60000;
    private int remaining = 0,timeinterval =1000;
    int count=0;
    int cu=0,cd=400,fcd=400;
    AppCompatButton appCompatButtonreset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView result =findViewById(R.id.result);
        TextView timer = findViewById(R.id.timer);
        ImageView image = findViewById(R.id.imageView);
        TextView CountUp = findViewById(R.id.countup);
        TextView CountDown = findViewById(R.id.CountDown);
        AppCompatButton appCompatButton =findViewById(R.id.appCompatButton);
        appCompatButtonreset = findViewById(R.id.appCompatButtonReset);
        image.setImageDrawable(getDrawable(R.drawable.startimg));
        CountDown.setText(cd+"");
        CountUp.setText(cu+"");
        timer.setText(0+"");

        appCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appCompatButton.setBackgroundColor(getResources().getColor(R.color.orange));

                if (count==0){
                    count=count+1;

                    countDownTimer.start();

                }
                if(cu==fcd){
                    image.setImageDrawable(getDrawable(R.drawable.you_won));
                    result.setText("Great");
                    appCompatButton.setClickable(false);
                    appCompatButton.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else {
                    if (cu < fcd) {
                        cu++;
                        CountUp.setText(cu + "");
                    }
                    if (cd > 0) {
                        cd--;
                        CountDown.setText(cd + "");
                    }
                }
            }
        });



        appCompatButtonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                timer.setText(0+"");
                image.setImageDrawable(getDrawable(R.drawable.startimg));
                count=0;
                cu=0;
                cd=fcd;
                appCompatButton.setClickable(true);
                CountDown.setText(cd+"");
                CountUp.setText(cu+"");
                countDownTimer.cancel();


            }
        });

        countDownTimer= new CountDownTimer(totaltime,timeinterval) {
            @Override

            public void onTick(long l) {
                remaining = (int)l/1000;
                timer.setText(remaining +"");
                result.setText("Go On,You can achieve!");


            }

            @Override
            public void onFinish(){
                if(cu==fcd) {
                    image.setImageDrawable(getDrawable(R.drawable.you_won));
                    result.setText("Great");
                    timer.setText(0 + "");
                    appCompatButton.setClickable(false);
                    appCompatButton.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else {

                    timer.setText(0 + "");
                    result.setText("Better Luck Next Time");
                    image.setImageDrawable(getDrawable(R.drawable.game_over));
                    appCompatButton.setClickable(false);
                    appCompatButton.setBackgroundColor(getResources().getColor(R.color.grey));
                }

            }
        };

    }
}