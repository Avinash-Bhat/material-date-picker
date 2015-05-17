package com.bhatworks.materialdatepicker;

import android.support.annotation.StringRes;

import java.util.Calendar;

import static java.util.Calendar.APRIL;
import static java.util.Calendar.AUGUST;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.DECEMBER;
import static java.util.Calendar.FEBRUARY;
import static java.util.Calendar.FRIDAY;
import static java.util.Calendar.JANUARY;
import static java.util.Calendar.JULY;
import static java.util.Calendar.JUNE;
import static java.util.Calendar.MARCH;
import static java.util.Calendar.MAY;
import static java.util.Calendar.MONDAY;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.NOVEMBER;
import static java.util.Calendar.OCTOBER;
import static java.util.Calendar.SATURDAY;
import static java.util.Calendar.SEPTEMBER;
import static java.util.Calendar.SUNDAY;
import static java.util.Calendar.THURSDAY;
import static java.util.Calendar.TUESDAY;
import static java.util.Calendar.WEDNESDAY;

public class DatePickerUtils {

    @StringRes
    static int toAbbrMonth(Calendar date) {
        final int month = date.get(MONTH);
        switch (month) {
            case JANUARY:
                return R.string.january_abbr;
            case FEBRUARY:
                return R.string.february_abbr;
            case MARCH:
                return R.string.march_abbr;
            case APRIL:
                return R.string.april_abbr;
            case MAY:
                return R.string.may_abbr;
            case JUNE:
                return R.string.june_abbr;
            case JULY:
                return R.string.july_abbr;
            case AUGUST:
                return R.string.august_abbr;
            case SEPTEMBER:
                return R.string.september_abbr;
            case OCTOBER:
                return R.string.october_abbr;
            case NOVEMBER:
                return R.string.november_abbr;
            case DECEMBER:
                return R.string.december_abbr;
        }
        throw new IllegalStateException("Invalid code for month: " + month);
    }

    @StringRes
    static int toMonth(Calendar date) {
        final int month = date.get(MONTH);
        switch (month) {
            case JANUARY:
                return R.string.january;
            case FEBRUARY:
                return R.string.february;
            case MARCH:
                return R.string.march;
            case APRIL:
                return R.string.april;
            case MAY:
                return R.string.may;
            case JUNE:
                return R.string.june;
            case JULY:
                return R.string.july;
            case AUGUST:
                return R.string.august;
            case SEPTEMBER:
                return R.string.september;
            case OCTOBER:
                return R.string.october;
            case NOVEMBER:
                return R.string.november;
            case DECEMBER:
                return R.string.december;
        }
        throw new IllegalStateException("Invalid code for month: " + month);
    }

    @StringRes
    static int toDayOfWeek(Calendar date) {
        final int dow = date.get(DAY_OF_WEEK);
        switch (dow) {
            case SUNDAY:
                return R.string.sunday;
            case MONDAY:
                return R.string.monday;
            case TUESDAY:
                return R.string.tuesday;
            case WEDNESDAY:
                return R.string.wednesday;
            case THURSDAY:
                return R.string.thursday;
            case FRIDAY:
                return R.string.friday;
            case SATURDAY:
                return R.string.saturday;
        }
        throw new IllegalStateException("Invalid code for day of week: " + dow);
    }
}
