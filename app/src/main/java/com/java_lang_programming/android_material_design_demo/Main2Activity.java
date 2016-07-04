package com.java_lang_programming.android_material_design_demo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextInputLayout mUserNameLayout;
    private EditText mUserNameView;

    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mUserNameLayout = (TextInputLayout) findViewById(R.id.sample_form_text_input_layout);
        mUserNameView = (EditText) findViewById(R.id.user_name);

        mUserNameView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_SEND) {
                    String user_name = textView.getText().toString();
                    if (TextUtils.isEmpty(user_name)) {
                        mUserNameLayout.setError("This field is required.");
                    } else if (user_name.length() > 10) {
                        mUserNameLayout.setError("This field is less than 10.");
                    } else {
                        mUserNameLayout.setError(null);
                    }
                    return true;
                }
                return false;
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

}
