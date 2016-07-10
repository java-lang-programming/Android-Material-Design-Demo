package com.java_lang_programming.android_material_design_demo.ui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import com.java_lang_programming.android_material_design_demo.CalenderInputActivity;

/**
 * カレンダーダイアログ
 */
public class DatePickerDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public static DatePickerDialogFragment newInstance(int year, int month, int dayOfMonth) {
        DatePickerDialogFragment frag = new DatePickerDialogFragment();
        Bundle args = new Bundle();
        args.putInt("year", year);
        args.putInt("month", month);
        args.putInt("dayOfMonth", dayOfMonth);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int year = getArguments().getInt("year");
        int month = getArguments().getInt("month");
        int dayOfMonth = getArguments().getInt("dayOfMonth");

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                getActivity(), this, year, month, dayOfMonth);

        return datePickerDialog;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Activity activity = getActivity();
        if (activity instanceof CalenderInputActivity) {
            ((CalenderInputActivity)activity).setDate(year, month, dayOfMonth);
        }
    }

}
