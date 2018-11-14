package org.thakur.ayush.hostelmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TimeTable extends AppCompatActivity {

    private Button mon;
    private Button tues;
    private Button wed;
    private Button thrus;
    private Button fri;
    private Button sat;
    private Button sun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        Intent i = getIntent();
        final Student student = (Student)i.getSerializableExtra("passedObject");
        Log.d("tt", "onCreate: " + student.getMessNumber());
        final Intent intentTimeTableShow= new Intent(TimeTable.this,TimeTableShow.class);
        mon = findViewById(R.id.Monday);
        tues = findViewById(R.id.tuesday);
        wed = findViewById(R.id.wednesday);
        thrus = findViewById(R.id.THRUS);
        fri = findViewById(R.id.friday);
        sat = findViewById(R.id.sat);
        sun = findViewById(R.id.SUN);

        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putInt("messNumber",student.getMessNumber());
                extras.putInt("Day",1);
                intentTimeTableShow.putExtras(extras);
                startActivity(intentTimeTableShow);

            }
        });
        tues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle extras = new Bundle();
                extras.putInt("messNumber",student.getMessNumber());
                extras.putInt("Day",2);
                intentTimeTableShow.putExtras(extras);
                startActivity(intentTimeTableShow);
            }
        });

        wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putInt("messNumber",student.getMessNumber());
                extras.putInt("Day",3);
                intentTimeTableShow.putExtras(extras);
                startActivity(intentTimeTableShow);
            }
        });

        thrus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putInt("messNumber",student.getMessNumber());
                extras.putInt("Day",4);
                intentTimeTableShow.putExtras(extras);
                startActivity(intentTimeTableShow);
            }
        });
        fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putInt("messNumber",student.getMessNumber());
                extras.putInt("Day",5);
                intentTimeTableShow.putExtras(extras);
                startActivity(intentTimeTableShow);
            }
        });

        sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putInt("messNumber",student.getMessNumber());
                extras.putInt("Day",6);
                intentTimeTableShow.putExtras(extras);
                startActivity(intentTimeTableShow);
            }
        });

        sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putInt("messNumber",student.getMessNumber());
                extras.putInt("Day",7);
                intentTimeTableShow.putExtras(extras);
                startActivity(intentTimeTableShow);
            }
        });

    }
}
