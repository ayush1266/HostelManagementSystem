package org.thakur.ayush.hostelmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class Student_Main extends AppCompatActivity {

    private Button login;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__main);

        login =findViewById(R.id.login);
        signup  = findViewById(R.id.signup);
        final Intent intent1 = new Intent(Student_Main.this, Student_Login.class);
        final Intent intent2 = new Intent(Student_Main.this, Student_Signup.class);
        login.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

                     startActivity(intent1);

                 }
             }
        );
        signup.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

                     startActivity(intent2);

                 }
             }
        );
    }
}