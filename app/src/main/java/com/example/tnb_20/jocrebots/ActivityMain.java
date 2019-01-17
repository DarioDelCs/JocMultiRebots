package com.example.tnb_20.jocrebots;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class ActivityMain extends AppCompatActivity {

    static Pelota[] pelotas;

    static int statusBar, width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout layout = findViewById(R.id.layout);

        // Mida de l'statusBar per calcular l'alçada de l'aplicació
        statusBar = getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));

        // Obtenim les dimensions de la pantalla
        DisplayMetrics display = this.getBaseContext().getResources().getDisplayMetrics();
        width = display.widthPixels;
        height = display.heightPixels;

        float[] posX = {height/10*2, height/10*4, height/10*6, height/10*8};
        float[] posY = {width/10*2, width/10*4, width/10*6, width/10*8};
        float[] vel = {4, -4};

        pelotas = new Pelota[4];
        // La bola
        for (int i = 0; i<4 ; i++) {
            pelotas[i]=new Pelota(vel[new Random().nextInt(2)], vel[new Random().nextInt(2)], i);
            pelotas[i].iv = new ImageView(getApplicationContext());
            layout.addView(pelotas[i].iv);

            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) pelotas[i].iv.getLayoutParams();
            params.width = 120;
            params.height = 120;
            pelotas[i].iv.setLayoutParams(params);

            pelotas[i].iv.setImageResource(R.drawable.bola);

            pelotas[i].iv.setX(posY[new Random().nextInt(4)]);
            pelotas[i].iv.setY(posX[i]);
        }
        //img = (ImageView) findViewById(R.id.imageView);



        //img.setX(0f);
        //img.setY(0f);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                for(int i =0; i<4; i++) {
                    pelotas[i].moveBall(2, 2);
                }
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 1000,30);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
