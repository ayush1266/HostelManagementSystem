package org.thakur.ayush.hostelmanagementsystem;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class studnetLeaveApplication extends AppCompatActivity {


    StringToDate std =new StringToDate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studnet_leave_application);
        final DatabaseHandler db = new DatabaseHandler(this);
        final Button btnSubmit;
        final EditText startDate;
        final EditText enddate;
        final EditText remark;
        Intent i = getIntent();
        final Student student = (Student) i.getSerializableExtra("passedObject");

        btnSubmit = findViewById(R.id.btnLeaveSubmit);
        startDate = findViewById(R.id.leavestartinput);
        enddate = findViewById(R.id.leaveEndInput);
        remark = findViewById(R.id.leaveReamrk);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.addLeave(student.getId(),startDate.getText().toString(),enddate.getText().toString()
                        ,remark.getText().toString());
                Date date = std.stringToDate(enddate.getText().toString());

                //Toast.makeText(studnetLeaveApplication.this,"LEAVE REGISTERED",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }



}


