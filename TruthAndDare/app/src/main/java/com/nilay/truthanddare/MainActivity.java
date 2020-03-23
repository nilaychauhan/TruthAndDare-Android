package com.nilay.truthanddare;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView bottle;
    Button btn;
    Random r;
    int first=0, last,count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottle = findViewById(R.id.bottle);
        btn = findViewById(R.id.spin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spin();
                count++;
                if(count>0){
                    first=last;
                }
            }
        });

    }

    private void spin(){
        int pivotX = bottle.getHeight()/3;
        int pivotY = bottle.getHeight()/3;
        r = new Random();
        int a = r.nextInt(5000);
        last = a;
        Animation rotate = new RotateAnimation(first,last,pivotX,pivotY);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);

        bottle.startAnimation(rotate);
    }
}
