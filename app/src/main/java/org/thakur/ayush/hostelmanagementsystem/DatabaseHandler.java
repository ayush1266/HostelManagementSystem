package org.thakur.ayush.hostelmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by win on 17-10-2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "hostelMEss";
    private Cursor cursor;

    //TABLES OF DATABASE


    private static final String TABLE_STUDENT = "Student";
    private static final String KEY_STUDENT_ID = "s_id";
    private static final String KEY_STUDENT_NAME = "s_name";
    private static final String KEY_STUDENT_PHONE_NUMBER = "s_phone";
    private static final String KEY_STUDENT_BALANCE = "balance";
    private static final String KEY_STUDENT_PASSWORD = "password";
    private static final String KEY_STUDENT_MESS_NUMBER = "messNumber";
    private static final String KEY_STUDENT_JOIN_DATE ="joinDate";
    private static final String KEY_STUDENT_RECHARGE_DATE="rechargeDate";

    private static final String TABLE_ADMIN = "Admin";
    private static final String KEY_ADMIN_ID = "a_id";
    private static final String KEY_ADMIN_NAME = "a_name";
    private static final String KEY_ADMIN_PASSWORD = "password";
    private static final String KEY_ADMIN_EMAIL= "email";
    private static final String KEY_ADMIN_MANAGES = "manages";

    private static final String TABLE_MESS = "Mess";
    private static final String KEY_MESS_NO = "mess_number";
    private static final String KEY_MESS_TIMETABLE = "timetable";


    private static final String TABLE_HOSTEL = "Hostel";
    private static final String KEY_HOSTEL_NO = "h_number";
    private static final String KEY_HOSTEL_NAME = "h_name";
    private static final String KEY_HOSTEL_CAPACITY = "h_capacity";




    private static final String TABLE_LEAVE = "Leave";
    private static final String KEY_LEAVE_STUDENT_ID = "l_id";
    private static final String KEY_LEAVE_START = "l_start";
    private static final String KEY_LEAVE_END = "l_end";
    private static final String KEY_LEAVE_REMARK = "l_remark";


    private static final String TABLE_TIMETABLE= "TimeTable";
    private static final String KEY_TT_NUMBER="ttNumber";
    private static final String KEY_TT_DAY = "dTimeTableday";
    private static final String KEY_TT_BREAKFAST="breakfast";
    private static final String KEY_TT_LUNCH = "lunch";
    private static final String KEY_TT_DINNER = "dinner";



    //CREATE TABLE QUERIES
    private String CREATE_TABLE_STUDENT = "CREATE TABLE "+TABLE_STUDENT + "("
            + KEY_STUDENT_ID + " varchar(15) NOT NULL, " + KEY_STUDENT_NAME +
            " varchar(50) NOT NULL, "+ KEY_STUDENT_PHONE_NUMBER + " varchar(10), " +
            KEY_STUDENT_BALANCE + " int DEFAULT 30000, " + KEY_STUDENT_PASSWORD +" varchar(25) NOT NULL, "
            +KEY_STUDENT_MESS_NUMBER+" int NOT NULL, "+KEY_STUDENT_JOIN_DATE + " varchar(10), " +
            KEY_STUDENT_RECHARGE_DATE+" varchar(10), "
            + "PRIMARY KEY(" + KEY_STUDENT_ID +"))";


    private String CREATE_TABLE_ADMIN = "CREATE TABLE "+TABLE_ADMIN + "("
            + KEY_ADMIN_ID + " varchar(15) NOT NULL, " + KEY_ADMIN_NAME+
            " varchar(50) NOT NULL, "+ KEY_ADMIN_PASSWORD + " varchar(20), " +
            KEY_ADMIN_EMAIL + " varchar(30), " + KEY_ADMIN_MANAGES + " int NOT NULL , PRIMARY KEY (" + KEY_ADMIN_ID +"))";



    private String CREATE_TABLE_MESS = "CREATE TABLE "+TABLE_MESS + "("
            + KEY_MESS_NO + " int NOT NULL, " + KEY_MESS_TIMETABLE + " int NOT NULL, "
            + "PRIMARY KEY(" + KEY_MESS_NO +"))";


    private String CREATE_TABLE_HOSTEL = "CREATE TABLE "+TABLE_HOSTEL + "("
            + KEY_HOSTEL_NO + " INT NOT NULL, " + KEY_HOSTEL_NAME +
            " varchar(50) NOT NULL, "+ KEY_HOSTEL_CAPACITY + " int, " + KEY_MESS_NO
            +" int, "
            + "PRIMARY KEY(" + KEY_HOSTEL_NO +"))";



    private String CREATE_TABLE_LEAVE = "CREATE TABLE "+TABLE_LEAVE + "("
            + KEY_LEAVE_STUDENT_ID+ " varchar(15) NOT NULL, " + KEY_LEAVE_START  +
            " varchar(10) NOT NULL, "+ KEY_LEAVE_END + " varchar(10) NOT NULL, "  + KEY_LEAVE_REMARK
            +" varchar(200), "
            + "PRIMARY KEY (" + KEY_LEAVE_STUDENT_ID +"))";


    private String CREATE_TABLE_TIMETABLE = "CREATE TABLE "+TABLE_TIMETABLE +" ("
            +KEY_TT_NUMBER +" int , " + KEY_TT_DAY + " int NOT NULL ," + KEY_TT_BREAKFAST +" varchar(200) NOT NULL, "
            + KEY_TT_LUNCH +" varchar(200) NOT NULL, " +  KEY_TT_DINNER +" varchar(200) NOT NULL)";


    //CONSTRUCTOR
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String TAG = "DatabaseHandler";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ADMIN);
        db.execSQL(CREATE_TABLE_HOSTEL);
        Log.d(TAG, "onCreate: " + CREATE_TABLE_TIMETABLE);
        db.execSQL(CREATE_TABLE_TIMETABLE);
        db.execSQL(CREATE_TABLE_LEAVE);
        db.execSQL(CREATE_TABLE_MESS);
        db.execSQL(CREATE_TABLE_STUDENT);


        for(int i=1;i<=9;i++) {

            for(int j=1;j<=7;j++) {
                ContentValues values = new ContentValues();

                values.put(KEY_TT_NUMBER, i);
                values.put(KEY_TT_DAY, j);
                values.put(KEY_TT_BREAKFAST, "POHA + NAMKEEN + NEEBU + SAUCE + MILK");
                values.put(KEY_TT_LUNCH, "RAJMA  + CHAAAWAL");
                values.put(KEY_TT_DINNER, "AALOO BHINDI PYAJ + ROTI + DAAL");
                db.insert(TABLE_TIMETABLE, null, values);
            }


        }

        cursor = db.rawQuery("SELECT * FROM "+TABLE_TIMETABLE,null);

        int cursorCount = cursor.getCount();

        Log.d(TAG, "onCreate: total counts in tt " + cursorCount);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    //FUNCTION FOR STUDENT TABLES

    //ADD NEW STUDENT


    public void addStudent(String id, String name, String phone_number, String password, int messNumber, String passedDate,String rechargeDate)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_STUDENT_ID,id);
        values.put(KEY_STUDENT_NAME,name);
        values.put(KEY_STUDENT_PHONE_NUMBER,phone_number);
        values.put(KEY_STUDENT_PASSWORD,password);
        values.put(KEY_STUDENT_MESS_NUMBER,messNumber);
        values.put(KEY_STUDENT_JOIN_DATE,passedDate);
        values.put(KEY_STUDENT_RECHARGE_DATE,rechargeDate);
        //inserting rows
        db.insert(TABLE_STUDENT,null,values);
        db.close();
    }

    //CHEACK A STUDENT , IF HE EXIST DURING LOGIN
    public boolean checkStudent(String id,String password)
    {
        SQLiteDatabase db  = this.getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_STUDENT +" WHERE " + KEY_STUDENT_ID + " =? " + "AND " + KEY_STUDENT_PASSWORD
                +" =? ";

        cursor = db.rawQuery(query,new String[]{id,password});
        int cursonCount = cursor.getCount();
        db.close();

        if(cursonCount>0)
            return true;
        else
            return false;

    }

    //if student exist
    public boolean existStudent(String id)
    {
        SQLiteDatabase db  = this.getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_STUDENT +" WHERE " + KEY_STUDENT_ID+ "=?";

        cursor = db.rawQuery(query,new String[]{id});
        int cursonCount = cursor.getCount();
        db.close();

        if(cursonCount>0)
            return true;
        else
            return false;

    }

    //getAllStudent List

    public List<Student> getAllStudents()
    {
        SQLiteDatabase db  = this.getWritableDatabase();
        List<Student> studentList = new ArrayList<Student>();
        //SELECT ALL QUERY

        String query = "SELECT * FROM "+ TABLE_STUDENT;

        cursor = db.rawQuery(query,null);
        int i=0;
        if(cursor.moveToFirst())
        {

            do {
                Student student = new Student();
                student.setId(cursor.getString(0));
                student.setName(cursor.getString(1));
                student.setPhone_number(cursor.getString(2));
                student.setBalance(Integer.parseInt(cursor.getString(3)));
                student.setPassword(cursor.getString(4));
                student.setMessNumber(cursor.getInt(5));
                student.setJoinDate(cursor.getString(6));
                student.setRechargeDate(cursor.getString(7));
                //adding student details
                studentList.add(student);
                i++;
            }while(cursor.moveToNext());
        }
        Log.d(TAG, "getAllStudents: number = "+ i);
        return studentList;
    }


    //get particular students detail

    public Student getStudent(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_STUDENT + " WHERE " + KEY_STUDENT_ID + " =? ";
        cursor = db.rawQuery(query,new String[]{id});
        if(cursor!=null)
            cursor.moveToFirst();
        Student student = new Student();
        student.setId(cursor.getString(0));
        student.setName(cursor.getString(1));
        student.setPhone_number(cursor.getString(2));
        student.setBalance(Integer.parseInt(cursor.getString(3)));
        student.setPassword(cursor.getString(4));
        student.setMessNumber(cursor.getInt(5));
        student.setJoinDate(cursor.getString(6));
        student.setRechargeDate(cursor.getString(7));
        return student;
    }

    //get student count
    public int getStudentCount()
    {
        SQLiteDatabase db  = this.getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_STUDENT;

        cursor = db.rawQuery(query,null);
        int cursorCount = cursor.getCount();
        db.close();

        return cursorCount;
    }


    //ADD ADMIN
    public void addAdmin(String id, String name, String password,String email,Integer manage)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ADMIN_ID,id);
        values.put(KEY_ADMIN_NAME,name);
        values.put(KEY_ADMIN_PASSWORD,password);
        values.put(KEY_ADMIN_EMAIL,email);
        values.put(KEY_ADMIN_MANAGES,manage);

        //inserting rows
        db.insert(TABLE_ADMIN,null,values);
        db.close();
    }
    //CHEACK AN ADMIN , IF HE EXIST DURING LOGIN
    public boolean checkAdmin(String id,String password)
    {
        SQLiteDatabase db  = this.getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_ADMIN +" WHERE " + KEY_ADMIN_ID+ " =? " + "AND " + KEY_ADMIN_PASSWORD
                +" =? ";

        cursor = db.rawQuery(query,new String[]{id,password});
        int cursonCount = cursor.getCount();
        db.close();

        if(cursonCount>0)
            return true;
        else
            return false;

    }
    //getAllAdmin List

    public List<Admin> getAllAdmins()
    {
        List<Admin> adminList = new ArrayList<Admin>();
        //SELECT ALL QUERY
        String selectAllQuery = "SELECT * FROM " + TABLE_ADMIN;

        SQLiteDatabase db = this.getReadableDatabase();
        cursor = db.rawQuery(selectAllQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                Admin admin = new Admin();
                admin.setAdmin_id(cursor.getString(0));
                admin.setAdmin_name(cursor.getString(1));
                admin.setAdmin_password(cursor.getString(2));
                admin.setAdmin_email((cursor.getString(3)));
                admin.setAdmin_manages(Integer.parseInt(cursor.getString(4)));
                //adding student details
                adminList.add(admin);
            }while(cursor.moveToNext());
        }
        return adminList;
    }

    //get particular admin detail

    public Admin getAdmin(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_ADMIN + " WHERE " + KEY_ADMIN_ID + " =? ";
        cursor = db.rawQuery(query,new String[]{id});
        if(cursor!=null)
            cursor.moveToFirst();
        Admin admin = new Admin();
        admin.setAdmin_id(cursor.getString(0));
        admin.setAdmin_name(cursor.getString(1));
        admin.setAdmin_password(cursor.getString(2));
        admin.setAdmin_email((cursor.getString(3)));
        admin.setAdmin_manages(Integer.parseInt(cursor.getString(4)));

        return admin;

    }

    //get admin count
    public int getAdminCount()
    {
        SQLiteDatabase db  = this.getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_ADMIN;

        cursor = db.rawQuery(query,null);
        int cursorCount = cursor.getCount();
        db.close();

        return cursorCount;
    }

    public Boolean checkAdminManages(int manages) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_ADMIN;
        cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                if (Integer.parseInt(cursor.getString(4)) == manages)
                    return true;
            } while (cursor.moveToNext());

        }
        return false;
    }

    public void addLeave(String id,String startDate, String endDate, String remark){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_LEAVE_STUDENT_ID,id);
        values.put(KEY_LEAVE_START,startDate);
        values.put(KEY_LEAVE_END,endDate);
        values.put(KEY_LEAVE_REMARK,remark);

        db.insert(TABLE_LEAVE,null,values);
        db.close();
    }
    public Boolean checkLeave(String id)
    {
        SQLiteDatabase db  = this.getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_LEAVE+" WHERE " + KEY_LEAVE_STUDENT_ID+ " =? ";

        cursor = db.rawQuery(query,new String[]{id});
        int cursonCount = cursor.getCount();
        db.close();

        if(cursonCount>0)
            return true;
        else
            return false;

    }
    public List<Leave> getLeave(String id)
    {


        List<Leave> leaveList = new ArrayList<Leave>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_LEAVE + " WHERE " + KEY_LEAVE_STUDENT_ID+ " =? ";
        cursor = db.rawQuery(query,new String[]{id});
        if(cursor.moveToFirst()){
            do{
                Leave leave = new Leave();
                leave.setId(cursor.getString(0));
                leave.setStartDate(cursor.getString(1));
                leave.setEndDate(cursor.getString(2));
                leave.setRemark(cursor.getString(3));

                leaveList.add(leave);
            }while (cursor.moveToNext());
        }
        return leaveList;
    }

    public void Recharge(String id, int b,Date rechargeDate)
    {
        /*
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        String rDate = dateFormat.format(rechargeDate);*/

        String rDate = "14-11-2018";
        Log.d(TAG, "Recharge: todays date " +rDate);

        SQLiteDatabase db = this.getWritableDatabase();
        String strSQL = "UPDATE " + TABLE_STUDENT +" SET " + KEY_STUDENT_BALANCE +" =? ," + KEY_STUDENT_RECHARGE_DATE
        + " =? " + "WHERE "+KEY_STUDENT_ID + "=?";

        db.execSQL(strSQL,new String[]{Integer.toString(b),rDate,id});
    }

    public TimeTableObject getTimeTable(int messNumber,int Day)
    {
        Log.d(TAG, "getTimeTable: messNumber and day="  + messNumber + " " + Day);

        SQLiteDatabase db = this.getReadableDatabase();
        //String query = "SELECT * FROM " + TABLE_TIMETABLE + " WHERE " + KEY_TT_NUMBER + " =? " +"AND " +KEY_TT_DAY +"=?";
        String query = "SELECT * FROM "+ TABLE_TIMETABLE +" WHERE " + KEY_TT_NUMBER + " =? " + "AND " + KEY_TT_DAY
                +" =? ";
        cursor = db.rawQuery(query,new String[]{Integer.toString(messNumber),Integer.toString(Day)});

        if(cursor!=null && cursor.moveToFirst())

        {

            TimeTableObject tt = new TimeTableObject();
            tt.setTimeTableMessNumber(cursor.getInt(0));
            tt.setTimeTableDay(cursor.getInt(1));
            tt.setBreakfast(cursor.getString(2));

            tt.setLunch(cursor.getString(3));
            tt.setDinner(cursor.getString(4));
            cursor.close();

            return tt;
        }

        return null;
    }

    public Boolean updateTimeTable(String b,String l,String d,int m,int day)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String strSQL = "UPDATE " + TABLE_TIMETABLE +" SET " + KEY_TT_BREAKFAST +" =? ," + KEY_TT_LUNCH
                + " =? ," + KEY_TT_DINNER +" =? " + "WHERE "+KEY_TT_NUMBER + "=? " + "AND " +KEY_TT_DAY
                +" =?";

        db.execSQL(strSQL,new String[]{b,l,d,Integer.toString(m)
        ,Integer.toString(day)});
        return true;
    }
}
