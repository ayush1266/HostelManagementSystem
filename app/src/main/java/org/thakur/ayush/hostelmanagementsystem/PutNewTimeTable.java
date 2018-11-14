package org.thakur.ayush.hostelmanagementsystem;

import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PutNewTimeTable extends AppCompatActivity {

    private EditText breakfast;
    private EditText lunch;
    private EditText dinner;

    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_new_time_table);

        final DatabaseHandler db = new DatabaseHandler(this);

        Bundle extras = getIntent().getExtras();
        final Integer messNumber = extras.getInt("messNumber");
        final Integer day = extras.getInt("Day");

        breakfast = findViewById(R.id.enterNewBreakfast);
        lunch = findViewById(R.id.enterNewLunch);
        dinner = findViewById(R.id.enterNewDinner);

        update =findViewById(R.id.updateTimeTable);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(db.updateTimeTable(breakfast.getText().toString(),
                        lunch.getText().toString(),
                        dinner.getText().toString(),
                        messNumber,day))
                {
                    Toast.makeText(PutNewTimeTable.this,"TIME TABLE UPDATED",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(PutNewTimeTable.this,"TIME TABLE UPDATE FAILED, TRY AGAIN",Toast.LENGTH_LONG).show();
            }
        });
    }
}
