package com.example.comicsshowcase;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ComicDB_Helper extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String DB_NAME = "Database.db";

    public ComicDB_Helper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    public ComicDB_Helper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_USER = "CREATE TABLE " + ComicDB_User.TABLE + "("
                + ComicDB_User.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ComicDB_User.USERNAME + " TEXT,"
                + ComicDB_User.PASSWORD + " TEXT)";
        db.execSQL(CREATE_TABLE_USER);

        String CREATE_TABLE_COMIC = "CREATE TABLE " + ComicModel.COMIC + "("
                + ComicModel.NAME + " TEXT,"
                + ComicModel.IMG_SRC + " TEXT,"
                + ComicModel.CONTENT + " TEXT)";
        db.execSQL(CREATE_TABLE_COMIC);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ComicDB_User.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ComicModel.COMIC);
        onCreate(db);
    }
}
