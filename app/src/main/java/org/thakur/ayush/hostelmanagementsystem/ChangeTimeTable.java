package org.thakur.ayush.hostelmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ChangeTimeTable extends AppCompatActivity {

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
        setContentView(R.layout.activity_change_time_table);

        Intent i = getIntent();
        final Admin admin = (Admin) i.getSerializableExtra("passedObject");
        Log.d("ctt", "onCreate: " + admin.getAdmin_manages());
        final Intent intentPutTimeTable= new Intent(ChangeTimeTable.this,PutNewTimeTable.class);
        mon = findViewById(R.id.MondayChangeTT);
        tues = findViewById(R.id.tuesdayChangeTT);
        wed = findViewById(R.id.wednesdayChangeTT);
        thrus = findViewById(R.id.THRUSChangeTT);
        fri = findViewById(R.id.fridayChangeTT);
        sat = findViewById(R.id.satChangeTT);
        sun = findViewById(R.id.SUNChangeTT);

        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putInt("messNumber", admin.getAdmin_manages());
                extras.putInt("Day",1);
                intentPutTimeTable.putExtras(extras);
                startActivity(intentPutTimeTable);

            }
        });
        tues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle extras = new Bundle();
                extras.putInt("messNumber", admin.getAdmin_manages());
                extras.putInt("Day",2);
                intentPutTimeTable.putExtras(extras);
                startActivity(intentPutTimeTable);
            }
        });

        wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putInt("messNumber", admin.getAdmin_manages());
                extras.putInt("Day",3);
                intentPutTimeTable.putExtras(extras);
                startActivity(intentPutTimeTable);
            }
        });

        thrus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putInt("messNumber", admin.getAdmin_manages());
                extras.putInt("Day",4);
                intentPutTimeTable.putExtras(extras);
                startActivity(intentPutTimeTable);
            }
        });
        fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putInt("messNumber", admin.getAdmin_manages());
                extras.putInt("Day",5);
                intentPutTimeTable.putExtras(extras);
                startActivity(intentPutTimeTable);
            }
        });

        sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putInt("messNumber", admin.getAdmin_manages());
                extras.putInt("Day",6);
                intentPutTimeTable.putExtras(extras);
                startActivity(intentPutTimeTable);
            }
        });

        sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putInt("messNumber", admin.getAdmin_manages());
                extras.putInt("Day",7);
                intentPutTimeTable.putExtras(extras);
                startActivity(intentPutTimeTable);
            }
        });

    }
}
