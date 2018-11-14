package org.thakur.ayush.hostelmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TimeTableShow extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table_show);

        final TextView dayHvalue;
        final TextView breakfast;
        final TextView lunch;
        final TextView dinner;

        final String days[] ={"MONDAY","TUESDAY","WEDNESDAY","THRUSDAY","FRIDAY","SATURDAT","SUNDAY"};


        Bundle extras = getIntent().getExtras();
        Integer messNumber = extras.getInt("messNumber");
        Integer day = extras.getInt("Day");

        Log.d("timetableshow", "onCreate: " + messNumber);
        dayHvalue = findViewById(R.id.DayHeading);
        breakfast = findViewById(R.id.BREAKFASTvalues);
        lunch =findViewById(R.id.LUNCHvalues);
        dinner = findViewById(R.id.DINNERvalues);

        DatabaseHandler db = new DatabaseHandler(this);

        TimeTableObject tt  = db.getTimeTable(messNumber,day);

        dayHvalue.setText(days[tt.getTimeTableDay()-1]);
        breakfast.setText(tt.getBreakfast());
        lunch.setText(tt.getLunch());
        dinner.setText(tt.getDinner());

    }
}
