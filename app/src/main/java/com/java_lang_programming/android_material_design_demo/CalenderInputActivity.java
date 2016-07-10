package com.java_lang_programming.android_material_design_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.java_lang_programming.android_material_design_demo.ui.DatePickerDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A login screen that offers login via email/password.
 */
public class CalenderInputActivity extends AppCompatActivity {

    private TextView mDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_input);
        // Set up the login form.
        mDate = (TextView) findViewById(R.id.date);
        mDate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = mDate.getText().toString();

                int year = 0;
                int month = 0;
                int dayOfMonth = 0;
                if (TextUtils.isEmpty(date)) {
                    Calendar calendar = Calendar.getInstance();
                    year = calendar.get(Calendar.YEAR);
                    month = calendar.get(Calendar.MONTH);
                    dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                } else {
                    year = Integer.valueOf(date.substring(0, 4));
                    month = Integer.valueOf(date.substring(5, 7));
                    month = month - 1;
                    dayOfMonth = Integer.valueOf(date.substring(8, 10));
                }
                showDatePickerDialog(year, month, dayOfMonth);
            }
        });

    }

    public void showDatePickerDialog(int year, int month, int dayOfMonth) {
        DatePickerDialogFragment dialog = DatePickerDialogFragment.newInstance(year, month, dayOfMonth);
        dialog.show(getSupportFragmentManager(), "datePicker");
    }

    public void setDate(int year, int month, int dayOfMonth) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, dayOfMonth);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mDate.setText(sdf.format(cal.getTime()));
    }
}

