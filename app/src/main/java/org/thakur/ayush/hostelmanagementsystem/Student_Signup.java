package org.thakur.ayush.hostelmanagementsystem;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Student_Signup extends AppCompatActivity {

    private EditText Name;
    private EditText Id;
    private EditText Password;
    private EditText Phone;
    private EditText MessNumber;
    private Button signup;
    private TextView totalNumber;
    private EditText joindate;
    SimpleDateFormat sfd =new SimpleDateFormat("dd-mm-yyyy");
    private static final String TAG = "Signup Activity";
    DatabaseHandler db = new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_signup);
        Name = findViewById(R.id.s_name);
        Id = findViewById(R.id.s_id);
        Password = findViewById(R.id.s_pass);
        Phone = findViewById(R.id.s_phone);
        signup = findViewById(R.id.student_signup);
        MessNumber = findViewById(R.id.s_MessNumber);
        totalNumber=findViewById(R.id.s_totalnumber);
        joindate=findViewById(R.id.s_joinDate);

        totalNumber.setText(Integer.toString(db.getStudentCount()));


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.addStudent(Id.getText().toString(),Name.getText().toString(), Phone.getText().toString(),
                        Password.getText().toString(),Integer.parseInt(MessNumber.getText().toString())
                        ,joindate.getText().toString(),joindate.getText().toString());
                Toast.makeText(Student_Signup.this.getApplicationContext(),"SIGNUP SUCCESSFUL",Toast.LENGTH_SHORT).show();
                totalNumber.setText(Integer.toString(db.getStudentCount()));
                Log.d(TAG, "onClick: "+ db.getStudentCount());
                Id.setText("");
                Name.setText("");
                Phone.setText("");
                Password.setText("");
                MessNumber.setText("");
            }
        });


    }



}
