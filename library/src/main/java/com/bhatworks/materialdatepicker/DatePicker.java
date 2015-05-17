package com.bhatworks.materialdatepicker;

import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.Calendar;
import java.util.Date;

import auto.parcel.AutoParcel;

@AutoParcel
public abstract class DatePicker {

    public static final String PICKER_TAG = DatePickerFragment.class.getName();

    abstract FragmentManager fragmentManager();

    abstract String tag();

    @StringRes
    abstract int positiveButton();

    @StringRes
    abstract int negativeButton();

    @StyleRes
    abstract int theme();

    abstract long date();

    @AutoParcel.Builder
    public interface Builder {

        Builder fragmentManager(FragmentManager fragmentManager);

        Builder tag(String tag);

        Builder positiveButton(@StringRes int positiveRes);

        Builder negativeButton(@StringRes int negativeRes);

        Builder theme(@StyleRes int themeRes);

        Builder date(long date);

        DatePicker build();
    }

    public static Builder builder() {
        return new AutoParcel_DatePicker.Builder()
                .tag(PICKER_TAG)
                .positiveButton(android.R.string.ok)
                .negativeButton(android.R.string.cancel)
                .date(new Date().getTime())
                .theme(R.style.Theme_AppCompat_Light);
    }

    public void show() {
        final FragmentTransaction transaction = fragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        DatePickerFragment fragment = DatePickerFragment.of(this);
        final Fragment f = fragmentManager().findFragmentByTag(tag());
        if (f != null) {
            ((DatePickerFragment) f).dismiss();
        }
        fragment.show(transaction, tag());
    }
}
