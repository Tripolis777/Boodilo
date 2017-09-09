package com.android.tripolis.boodilo.Database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.system.StructPollfd;

/**
 * Created by tripo on 9/8/2017.
 */

public class BoodiloDatabase {


    public static final String DATABASE_NAME = "Boodilo.db";

    private static String getSQLCreateQuery() {
       return "";
    }

    public static void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(getSQLCreateQuery());
    }

    public static void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
