package com.doanbvph31058.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        runWhenTurnOnDevice();

    }

    private void runWhenTurnOnDevice(){
        Thread t = new Thread(){
            @Override
            public void run() {
                int count = 0;
               while (true){
                    try {
                        count++;
                        if(count>3){
                            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(intent);
                            break;
                        }
                        Thread.sleep(1000);
                    }catch (InterruptedException e){

                        throw new RuntimeException(e);
                    }
               }
            }
        };
        t.start();
    }
}