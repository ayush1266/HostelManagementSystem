package org.thakur.ayush.hostelmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Student_Dashboard extends AppCompatActivity {

    private Button logout;
    private Button checkAcDetails;
    private Button applyLeave;
    private Button checkTimeTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar


        Intent i = getIntent();
        final Student student = (Student)i.getSerializableExtra("passedObject");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__dashboard);
        final TextView nameText;
        final Intent intentLogout = new Intent(Student_Dashboard.this, Student_Main.class);
        final Intent intentAcDetails = new Intent(Student_Dashboard.this,StudentAcDetails.class);
        final Intent intentLeave = new Intent(Student_Dashboard.this,studnetLeaveApplication.class);
        final Intent intentTimeTable = new Intent(Student_Dashboard.this,TimeTable.class);
        nameText = findViewById(R.id.DashboardtitleName);
        logout = findViewById(R.id.studentLogoutButton);
        checkAcDetails = findViewById(R.id.buttonCheckAccountDetails);
        applyLeave = findViewById(R.id.buttonApplyForLeave);
        checkTimeTable = findViewById(R.id.buttonchecktimetable);
        nameText.setText(student.getName());
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        checkAcDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentAcDetails.putExtra("passedObject",student);
                startActivity(intentAcDetails);
            }
        });
        applyLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentLeave.putExtra("passedObject",student);
                startActivity(intentLeave);
            }
        });

        checkTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentTimeTable.putExtra("passedObject",student);
                startActivity(intentTimeTable);
            }
        });
        //Toast.makeText(Student_Dashboard.this.getApplicationContext(),"welcome" + student.getName(),Toast.LENGTH_SHORT).show();


    }
}
