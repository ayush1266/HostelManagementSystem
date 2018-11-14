package org.thakur.ayush.hostelmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button admin;
    private Button student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        admin =findViewById(R.id.admin);
        student  = findViewById(R.id.student);
        final Intent intent1 = new Intent(this, Student_Main.class);
        final Intent intent2 = new Intent(this, Admin_Main.class);
        admin.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {

                                         startActivity(intent2);

                                     }
                                 }
        );
        student.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {

                                          startActivity(intent1);

                                      }
                                  }
        );


    }
}
