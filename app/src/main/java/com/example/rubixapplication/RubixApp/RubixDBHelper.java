package com.example.rubixapplication.RubixApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

import static java.util.Calendar.DATE;

public class RubixDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDB.db";
    public static final String MOBILE_TABLE_NAME1 = "Apple";
    public static final String MOBILE_TABLE_NAME2 = "Samsung";
    public static final String MOBILE_COLUMN_ID = "id";
    public static final String MOBILE_COLUMN_TITLE = "title";
    public static final String MOBILE_COLUMN_DATE = "dates";
    public static final String MOBILE_COLUMN_QUANTITY = "quantity";
    public static final String MOBILE_COLUMN_RATING = "rating";
    public static final String MOBILE_COLUMN_IMAGE = "image";
    private HashMap hp;

    public RubixDBHelper(Context context) {
        super( context, DATABASE_NAME, null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table " + MOBILE_TABLE_NAME1 +
                        "(id integer primary key, title text,image text,dates DATE , quantity DOUBLE,rating DOUBLE)"
        );

        db.execSQL(
                "create table " + MOBILE_TABLE_NAME2 +
                        "(id integer primary key, title text,image text,dates DATE , quantity DOUBLE,rating DOUBLE)"
//                        "(id integer primary key, title text,image text,dates date, quantity text,rating text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL( "DROP TABLE IF EXISTS mobiles" );
        onCreate( db );
    }

    public boolean insertMobile(String table,int id, String title, String image, String dates, String quantity, String rating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( MOBILE_COLUMN_ID, id );
        contentValues.put( MOBILE_COLUMN_TITLE, title );
        contentValues.put( MOBILE_COLUMN_IMAGE, image );
        contentValues.put( MOBILE_COLUMN_DATE, dates );
        contentValues.put( MOBILE_COLUMN_QUANTITY, quantity );
        contentValues.put( MOBILE_COLUMN_RATING, rating );
        db.insert( table, null, contentValues );
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "select * from mobiles where id=" + id + "", null );
        return res;
    }

    public Cursor getDataDate(String MOBILE_TABLE_NAME1) {
        SQLiteDatabase db = this.getReadableDatabase();
//        SELECT * FROM Customers
//        ORDER BY Country DESC;
        Cursor res = db.rawQuery( "SELECT * FROM " + MOBILE_TABLE_NAME1 + " ORDER BY DATE(" + MOBILE_COLUMN_DATE + ") DESC ;", null );
        return res;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries( db, MOBILE_TABLE_NAME1 );
        return numRows;
    }

    public boolean updateContact(Integer id, String title, String image, String date, String quantity, String rating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( "title", title );
        contentValues.put( "image", image );
        contentValues.put( "dates", date );
        contentValues.put( "quantity", quantity );
        contentValues.put( "rating", rating );
        db.update( "mobiles", contentValues, "id = ? ", new String[]{Integer.toString( id )} );
        return true;
    }

    public Integer deleteContact(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete( "mobiles",
                "id = ? ",
                new String[]{Integer.toString( id )} );
    }

    public ArrayList<Child> getAllMobiles(String mobileCompany) {
        ArrayList<Child> array_list = new ArrayList<Child>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "select * from " + mobileCompany, null );
        res.moveToFirst();


        while (res.isAfterLast() == false) {
            Child child = new Child();
            child.setTitle( res.getString( res.getColumnIndex( MOBILE_COLUMN_TITLE ) ) );
            child.setDate( res.getString( res.getColumnIndex( MOBILE_COLUMN_DATE ) ) );
            child.setQuantity( res.getString( res.getColumnIndex( MOBILE_COLUMN_QUANTITY ) ) );
            child.setRating( res.getString( res.getColumnIndex( MOBILE_COLUMN_RATING ) ) );
            child.setImage( res.getString( res.getColumnIndex( MOBILE_COLUMN_IMAGE ) ) );
            array_list.add( child );
            res.moveToNext();
        }

        return array_list;
    }


    public ArrayList<Child> getAllMobilesDate(String mobileCompany) {
        ArrayList<Child> array_list = new ArrayList<Child>();



        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + mobileCompany + " ORDER BY dates DESC ;", null );
//        Cursor res =  db.rawQuery( "select * from " + mobileCompany, null );
        res.moveToFirst();


        while (res.isAfterLast() == false) {
            Child child = new Child();
            child.setTitle( res.getString( res.getColumnIndex( MOBILE_COLUMN_TITLE ) ) );
            child.setDate( res.getString( res.getColumnIndex( MOBILE_COLUMN_DATE ) ) );
            child.setQuantity( res.getString( res.getColumnIndex( MOBILE_COLUMN_QUANTITY ) ) );
            child.setRating( res.getString( res.getColumnIndex( MOBILE_COLUMN_RATING ) ) );
            child.setImage( res.getString( res.getColumnIndex( MOBILE_COLUMN_IMAGE ) ) );
            array_list.add( child );
            res.moveToNext();
        }

        return array_list;
    }

    public ArrayList<Child> getAllMobilesRating(String mobileCompany) {
        ArrayList<Child> array_list = new ArrayList<Child>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor res = db.rawQuery( "SELECT * FROM " + mobileCompany + " ORDER BY " + MOBILE_COLUMN_RATING + " DESC ;", null );
        Cursor res = db.rawQuery( "select * from "+mobileCompany+" ORDER BY rating DESC", null );
        res.moveToFirst();


        while (res.isAfterLast() == false) {
            Child child = new Child();
            child.setTitle( res.getString( res.getColumnIndex( MOBILE_COLUMN_TITLE ) ) );
            child.setDate( res.getString( res.getColumnIndex( MOBILE_COLUMN_DATE ) ) );
            child.setQuantity( res.getString( res.getColumnIndex( MOBILE_COLUMN_QUANTITY ) ) );
            child.setRating( res.getString( res.getColumnIndex( MOBILE_COLUMN_RATING ) ) );
            child.setImage( res.getString( res.getColumnIndex( MOBILE_COLUMN_IMAGE ) ) );
            array_list.add( child );
            res.moveToNext();
        }

        return array_list;
    }


    public ArrayList<Child> getAllMobilesQuantity(String mobileCompany) {
        ArrayList<Child> array_list = new ArrayList<Child>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor res = db.rawQuery( "SELECT * FROM " + mobileCompany + " ORDER BY " + MOBILE_COLUMN_RATING + " DESC ;", null );
        Cursor res = db.rawQuery( "select * from "+mobileCompany+" ORDER BY quantity DESC", null );
        res.moveToFirst();


        while (res.isAfterLast() == false) {
            Child child = new Child();
            child.setTitle( res.getString( res.getColumnIndex( MOBILE_COLUMN_TITLE ) ) );
            child.setDate( res.getString( res.getColumnIndex( MOBILE_COLUMN_DATE ) ) );
            child.setQuantity( res.getString( res.getColumnIndex( MOBILE_COLUMN_QUANTITY ) ) );
            child.setRating( res.getString( res.getColumnIndex( MOBILE_COLUMN_RATING ) ) );
            child.setImage( res.getString( res.getColumnIndex( MOBILE_COLUMN_IMAGE ) ) );
            array_list.add( child );
            res.moveToNext();
        }

        return array_list;
    }


}