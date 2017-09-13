package com.android.tripolis.boodilo.Core;

import android.support.annotation.NonNull;

import java.util.Date;

/**
 * Created by v.karyagin on 8/20/17.
 */

public class Alarm {

    private Date startDate;
    private Sound sound;

    public Alarm (@NonNull Date alarmDate) {
        this.startDate = alarmDate;
    }

    public void execute() {

    }

    public void calcel() {

    }

    public Date getStartDate() {
        return startDate;
    }

    public Alarm copy() {
        return this;
    }


    public static abstract class AlarmStatus {
        public static final int STATUS_OFF = 0;
        public static final int STATUS_ON = 1;
        public static final int STATUS_CANCELED = 2;
        public static final int STATUS_REFERRED = 3;
    }
}
