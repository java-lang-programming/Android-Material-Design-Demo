package com.java_lang_programming.android_material_design_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.java_lang_programming.android_material_design_demo.ui.CustomBarActivity;
import com.java_lang_programming.android_material_design_demo.ui.PreferenceDemoActivity;
import com.java_lang_programming.android_material_design_demo.ui.ViewDragHelperDemoActivity;
import com.java_lang_programming.android_material_design_demo.ui.ViewPagerActivity;

public class MainActivity extends AppCompatActivity {

    private Button mMove;
    private Button mCalenderBtn;
    private Button mViewDragHelperDemoBtn;
    private Button mViewPagerDemoBtn;
    private Button customeBarDemoBtn;
    private Button preferenceDemoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMove = (Button) findViewById(R.id.move);
        mCalenderBtn = (Button) findViewById(R.id.calender_btn);
        mViewDragHelperDemoBtn = (Button) findViewById(R.id.view_drag_helper_demo_btn);
        mViewPagerDemoBtn = (Button) findViewById(R.id.view_pager_demo_btn);
        customeBarDemoBtn = (Button) findViewById(R.id.custome_bar_demo_btn);
        preferenceDemoBtn = (Button) findViewById(R.id.preference_demo_btn);

        mMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move();
            }
        });

        mCalenderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveCalender();
            }
        });

        mViewDragHelperDemoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveViewDragHelperDemoActivity();
            }
        });

        mViewPagerDemoBtn.setOnClickListener(view -> {
            moveViewPagerActivity();
        });
        customeBarDemoBtn.setOnClickListener(view -> {
            moveCustomBarActivity();
        });
        preferenceDemoBtn.setOnClickListener(view -> {
            movePreferenceDemoActivity();
        });

    }

    private void move() {
        startActivity(new Intent(this, Main2Activity.class));
    }

    private void moveCalender() {
        startActivity(new Intent(this, CalenderInputActivity.class));
    }

    private void moveViewDragHelperDemoActivity() {
        startActivity(new Intent(this, ViewDragHelperDemoActivity.class));
    }

    private void moveViewPagerActivity() {
        startActivity(new Intent(this, ViewPagerActivity.class));
    }

    private void moveCustomBarActivity() {
        startActivity(new Intent(this, CustomBarActivity.class));
    }

    private void movePreferenceDemoActivity() {
        startActivity(new Intent(this, PreferenceDemoActivity.class));
    }
}
