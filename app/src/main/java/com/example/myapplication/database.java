package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {

    public database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
     String table = "Create table user (username text,email text,password)";
     sqLiteDatabase.execSQL(table);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void regisiter(String username,String Email,String password){
        ContentValues cv = new ContentValues();
        cv.put("Username",username);
        cv.put("Email",Email);
        cv.put("Password",password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("user",null,cv);
        db.close();

    }
    public int login(String username , String password){
        int result=0;
        String arr[] = new String[2];
        arr[0]= username;
        arr[1]=password;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("Select * from user where username=? and password=?",arr);
        if(c.moveToFirst()){
             result=1;
        }
        return result;
    }
}
