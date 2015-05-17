package com.bhatworks.materialdatepicker;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;

import java.util.Calendar;

import static com.bhatworks.materialdatepicker.DatePickerUtils.toAbbrMonth;
import static com.bhatworks.materialdatepicker.DatePickerUtils.toDayOfWeek;

public class DatePickerFragment extends DialogFragment implements DialogInterface.OnShowListener {

    public static final String ARG_POSITIVE_BTN = "arg_positive_btn";

    public static final String ARG_NEGATIVE_BTN = "arg_negative_btn";

    public static final String ARG_THEME = "arg_theme";

    public static final String ARG_DATE = "arg_date";

    private final Calendar mDate;

    private TextView mDayOfWeekView;

    private TextView mMonthView;

    private TextView mDayView;

    private TextView mYearView;

    public DatePickerFragment() {
        mDate = Calendar.getInstance();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final int positiveBtn = getArguments().getInt(ARG_POSITIVE_BTN);
        final int negativeBtn = getArguments().getInt(ARG_NEGATIVE_BTN);
        final int theme = getArguments().getInt(ARG_THEME);
        mDate.setTimeInMillis(getArguments().getLong(ARG_DATE));
        final AlertDialog dialog = new AlertDialog.Builder(getActivity(), theme)
                .setView(R.layout.fragment_date_picker)
                .setPositiveButton(positiveBtn, null)
                .setNegativeButton(negativeBtn, null)
                .create();
        dialog.setOnShowListener(this);
        return dialog;
    }

    private void findViews(Dialog dialog) {
        mDayOfWeekView = (TextView) dialog.findViewById(R.id.day_of_week);
        mMonthView = (TextView) dialog.findViewById(R.id.month);
        mDayView = (TextView) dialog.findViewById(R.id.day);
        mYearView = (TextView) dialog.findViewById(R.id.year);
    }

    private void populate() {
        mDayOfWeekView.setText(toDayOfWeek(mDate));
        mMonthView.setText(getText(toAbbrMonth(mDate)).toString().toUpperCase());
        mDayView.setText(String.valueOf(mDate.get(Calendar.DAY_OF_MONTH)));
        final String year = String.valueOf(mDate.get(Calendar.YEAR));
        mYearView.setText(year);
    }

    @Override
    public void onShow(DialogInterface dialog) {
        findViews((Dialog) dialog);
        if (((Dialog) dialog).getOwnerActivity() != null) {
            populate();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getDialog() != null) {
            populate();
        }
    }

    @NonNull
    public static DatePickerFragment of(DatePicker picker) {
        final DatePickerFragment fragment = new DatePickerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        args.putInt(ARG_POSITIVE_BTN, picker.positiveButton());
        args.putInt(ARG_NEGATIVE_BTN, picker.negativeButton());
        args.putInt(ARG_THEME, picker.theme());
        args.putLong(ARG_DATE, picker.date());

        return fragment;
    }
}
