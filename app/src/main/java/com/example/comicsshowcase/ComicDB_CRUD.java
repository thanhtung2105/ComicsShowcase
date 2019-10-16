package com.example.comicsshowcase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ComicDB_CRUD {
    private ComicDB_Helper DB_Helper;
    public static ComicDB_CRUD instance;

    public static ComicDB_CRUD getInstance(Context context) {
        if (instance == null)
            instance = new ComicDB_CRUD(context);
        return instance;
    }

    private ComicDB_CRUD(Context context) {
        this.DB_Helper = new ComicDB_Helper(context);
    }

    //        public void getAll() {
//            SQLiteDatabase database = dbHelper.getWritableDatabase();
//            String query = "SELECT * FROM " + User.TABLE;
//            List<String> users = new ArrayList<>();
//            Cursor cursor = database.rawQuery(query, null);
//        }
//
    public int addUser(ComicDB_User comicDB_user) {
        SQLiteDatabase database = DB_Helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(comicDB_user.USERNAME, comicDB_user.getUsername());
        values.put(comicDB_user.PASSWORD, comicDB_user.getPassword());

        return (int) database.insert(comicDB_user.TABLE, null, values);
    }

    public int addComic(ComicModel comicDB_comic) {
        SQLiteDatabase database = DB_Helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(comicDB_comic.NAME, comicDB_comic.getComic_name());
        values.put(comicDB_comic.IMG_SRC, comicDB_comic.getComic_img());
        values.put(comicDB_comic.CONTENT, comicDB_comic.getComic_introduction());

        return (int) database.insert(comicDB_comic.COMIC, null, values);
    }

    public List<ComicModel> loadComic() {
        SQLiteDatabase database = DB_Helper.getReadableDatabase();
        String query = "SELECT * FROM " + ComicModel.COMIC;
        List<ComicModel> listComic = new ArrayList<>();
        Cursor cursor = database.rawQuery(query, null);
        while (cursor.moveToNext()) {
            ComicModel comic = new ComicModel(cursor.getString(1), cursor.getString(0), cursor.getString(2));
            listComic.add(comic);
        }
        return listComic;
    }

    public boolean checkLogin(String username_check, String password_check) {
        SQLiteDatabase database = DB_Helper.getReadableDatabase();
        String query = "SELECT * FROM " + ComicDB_User.TABLE;
        List<ComicDB_User> listUser = new ArrayList<>();
        Cursor cursor = database.rawQuery(query, null);
        while (cursor.moveToNext()) {
            ComicDB_User user = new ComicDB_User(cursor.getString(1), cursor.getString(2));
            listUser.add(user);
        }
        for (int i = 0; i < listUser.size(); i++) {
            if (username_check.equals(listUser.get(i).getUsername()) && password_check.equals(listUser.get(i).getPassword()))
                return true;
        }
        cursor.close();
        return false;
    }
}
//        public void update(User user) {
//            SQLiteDatabase database = dbHelper.getWritableDatabase();
//            ContentValues values = new ContentValues();
//            values.put(User.USERNAME, user.getUsername());
//            values.put(User.PASSWORD, user.getPassword());
//            database.update(User.TABLE, values, User.ID + "=" + user.getId(), null);
//            database.close();
//        }
//
//        public void delete(int userId) {
//            SQLiteDatabase database = dbHelper.getWritableDatabase();
//            database.delete(User.TABLE, User.ID + "=" + userId, null);
//            database.close();
//        }
//    }