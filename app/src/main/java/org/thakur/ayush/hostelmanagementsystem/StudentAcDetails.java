package org.thakur.ayush.hostelmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

import org.w3c.dom.Text;

import javax.xml.datatype.Duration;

public class StudentAcDetails extends AppCompatActivity {
    private TextView name;
    private TextView Id;
    private TextView phone;
    private TextView balance;
    private TextView messNumber;
    private TextView joindate;
    private TextView rechargeDate;
    int currentBalance;
    DatabaseHandler db = new DatabaseHandler(this);
    private static final String TAG = "StudentAcDetails";
    StringToDate std = new StringToDate();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_ac_details);


        Intent i = getIntent();
        Student student = (Student)i.getSerializableExtra("passedObject");


        name  = findViewById(R.id.nameAcdetails);
        Id = findViewById(R.id.IdAcdetails);
        phone = findViewById(R.id.phoneAcDetails);
        balance = findViewById(R.id.balanceAcDetails);
        messNumber =findViewById(R.id.messNoAcDetails);
        joindate = findViewById(R.id.joindateAcDetails);
        rechargeDate = findViewById(R.id.rechargedateAcDetails);
        student.setBalance(currentBalance);
        name.setText("Name:- " +student.getName());
        Id.setText("ID:- "+student.getId());
        phone.setText("Phone No. :- "+student.getPhone_number());

        //modify balance

        long diff = std.getCurrentDate().getTime()- std.stringToDate((student.getRechargeDate())).getTime();
        diff/=8.64e+7;
        student = db.getStudent(student.getId());
        Log.d(TAG, "onCreate: difference " + student.getBalance() + " " +diff);
        student.setBalance(student.getBalance() - 100*((int)diff));
        if(student.getBalance()>2000)
            balance.setText("Balance. :- " + Integer.toString(student.getBalance()));
        else
            balance.setText("Balance. :- " + Integer.toString(student.getBalance())+ " (Low)");
        messNumber.setText("Mess Number:- " +Integer.toString(student.getMessNumber()));
        joindate.setText("Join Date:- "+ student.getJoinDate());
        rechargeDate.setText("LastRecharge:- " + student.getRechargeDate());
    }
}
