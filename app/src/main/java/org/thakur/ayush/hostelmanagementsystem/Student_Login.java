package org.thakur.ayush.hostelmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Student_Login extends AppCompatActivity {


    private TextView ID;
    private TextView password;
    private Button login;
    Student currentStudent = new Student();
    DatabaseHandler db = new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__login);
        ID = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);
        login = findViewById(R.id.student_login);
        final Intent intent1 = new Intent(Student_Login.this, Student_Dashboard.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(db.checkStudent(ID.getText().toString(),password.getText().toString()))
                {
                    currentStudent=db.getStudent(ID.getText().toString());
                    Log.d("login", "onClick: " + currentStudent.getBalance());
                    intent1.putExtra("passedObject",currentStudent);
                    startActivity(intent1);
                    Toast.makeText(Student_Login.this.getApplicationContext(),"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(Student_Login.this.getApplicationContext(),"INVALID ID OR PASSWORD",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
