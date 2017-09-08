package com.android.tripolis.boodilo.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

/**
 * Created by tripo on 9/8/2017.
 */

public class BooDBOpenHelper extends SQLiteOpenHelper {

    private static BooDBOpenHelper instance;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Boodilo.db";

    public static BooDBOpenHelper newInstance(Context context, @Nullable SQLiteDatabase.CursorFactory factory) {
        if (instance == null)
            instance = new BooDBOpenHelper(context, factory);
        return instance;
    }

    private BooDBOpenHelper(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        BoodiloDatabase.onUpgrade(sqLiteDatabase, i, i1);
    }
}
