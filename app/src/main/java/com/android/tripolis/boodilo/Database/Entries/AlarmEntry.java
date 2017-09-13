package com.android.tripolis.boodilo.Database.Entries;

import android.provider.BaseColumns;
import android.text.format.DateFormat;

import com.android.tripolis.boodilo.Core.Alarm;
import com.android.tripolis.boodilo.Database.Table.SQLiteTableManager;

import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by tripo on 9/9/2017.
 */

public class AlarmEntry implements DatabaseEntry {

    public static abstract class AlarmSchema implements BaseColumns {
        public static final String TABLE_NAME = "alarm";
        public static final String COLUMN_NAME_TIME = "time";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_STATUS = "status";
        public static final String COLUMN_NAME_SOUND = "sound";
    }

    private String time;
    private int type;
    private int status;
    private int sound;
    //private Sound soundObj;

    public AlarmEntry() {}
    public AlarmEntry(Alarm alarm) {}


    public void setTime (String time) {
        this.time = time;
    }

    public void setType (int type) {
        this.type = type;
    }

    public void setStatus (int status) {
        this.status = status;
    }

    public void setSound (int sound) {
        this.sound = sound;
    }

    /*
    public void setSound (Sound sound) { ... }
    */

    public String getTime () {
        return this.time;
    }

    public int getType () {
        return this.type;
    }

    public int getStatus () {
        return this.status;
    }

    public int getSound () {
        return this.sound;
    }

    /*
    public Sound getSound () { ... }
     */

    // TODO: Непонятно как поведёт себя парсер. Нужно научиться ставаить дату в пределах текущих 24 часов
    public Alarm getAlarm () {
        SimpleDateFormat formater = new SimpleDateFormat("HH:mm");

        Date dateStart = null;
        try {
            dateStart = formater.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Alarm(dateStart);
    }
}
