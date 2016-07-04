package com.java_lang_programming.android_material_design_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMove = (Button) findViewById(R.id.move);

        mMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move();
            }
        });

    }

    private void move() {
        startActivity(new Intent(this, Main2Activity.class));
    }

}
