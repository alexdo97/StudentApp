package be.kuleuven.softdev.alexandrudobrin.studentapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TAG = "DatabaseHelper";
    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "DATE";
    public static final String COL_3 = "LIGHT_VALUE";
    public static final String COL_4 = "SUBJECT";
    public static final String COL_5 = "TIME";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + "DATE TEXT, " +
        "LIGHT_VALUE TEXT, " + "SUBJECT TEXT, " + "TIME TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String date, String light_value, String subject, String time)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, date);
        contentValues.put(COL_3, light_value);
        contentValues.put(COL_4, subject);
        contentValues.put(COL_5, time);

        Log.d(TAG, "addData: Adding " + date + ", "+ light_value + ", "+ subject + ", "+ time + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void deleteItem(int id, String Date, String LightValue, String Subject, String Time)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COL_1 + " = '" + id +
                "'" + " AND " + COL_2  + " = '" + Date +
                "'" + " AND " + COL_3 + " = '" + LightValue +
                "'" + " AND " + COL_4 + " = '" + Subject +
                "'" + " AND " + COL_5 + " = '" + Time + "'";
        Log.d(TAG, "Activity deleted from database");
        db.execSQL(query);


    }
    public void deleteAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,null,null);
        db.close();
    }

}
