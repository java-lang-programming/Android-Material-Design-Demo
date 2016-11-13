package com.java_lang_programming.android_material_design_demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.java_lang_programming.android_material_design_demo.R;

/**
 * preference activity
 */
public class PreferenceDemoActivity extends AppCompatActivity implements PreferenceDemoFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_demo);
    }
}
