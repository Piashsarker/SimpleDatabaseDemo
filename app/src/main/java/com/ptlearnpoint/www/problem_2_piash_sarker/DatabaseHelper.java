package com.ptlearnpoint.www.problem_2_piash_sarker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PT on 2/3/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String LOG = "DatabaseHelper";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "EmployeDatabase";
    private static final String TABLE_EMPLOYEE = "employee";


    private static final String CREATE_TABLE_INSTRUCTOR = "create table if not exists "
            + TABLE_EMPLOYEE
            + " (id integer primary key autoincrement,"
            + " first_name varchar(30)," + " last_name varchar(30), " + " phone varchar(30)," + "country_name varchar(30) )";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(CREATE_TABLE_INSTRUCTOR);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);


        onCreate(db);

    }

    public void addEmployee(Employee instructor) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("first_name", instructor.getFirstName());
        values.put("last_name", instructor.getLastName());
        values.put("phone", instructor.getPhone());
        values.put("country_name", instructor.getCountry());
        db.insert(TABLE_EMPLOYEE, null, values);
        db.close();
    }


    public List<Employee> getAllEmployee() {
        List<Employee> instructorList = new ArrayList<Employee>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_EMPLOYEE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Employee employee = new Employee();
                employee.setId(cursor.getString(0));
                employee.setFirstName(cursor.getString(1));
                employee.setLastName(cursor.getString(2));
                employee.setPhone(cursor.getString(3));
                employee.setCountry(cursor.getString(4));

                // Adding contact to list
                instructorList.add(employee);
            } while (cursor.moveToNext());
        }

        // return contact list
        return instructorList;
    }

    public int updateEmployee(Employee instructor) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("first_name", instructor.getFirstName());
        values.put("last_name", instructor.getLastName());
        values.put("phone", instructor.getPhone());
        values.put("country_name", instructor.getCountry());

        // updating row
        return db.update(TABLE_EMPLOYEE, values, "id" + " = ?",
                new String[]{String.valueOf(instructor.getId())});
    }

    // Deleting single contact
    public void deleteContact(Employee instructor) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EMPLOYEE, "id" + " = ?",
                new String[]{String.valueOf(instructor.getId())});

        db.close();
    }
}
    // Getting contacts Count
