package org.thakur.ayush.hostelmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TotalGuestList extends AppCompatActivity {
    TextView date;
    TextView mess;
    TextView totalGuest;
    ListView listGuestName;
    StringToDate std = new StringToDate();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_guest_list);
        DatabaseHandler db = new DatabaseHandler(this);
        date = findViewById(R.id.headingDate);
        mess = findViewById(R.id.headingMess);
        totalGuest =    findViewById(R.id.headingguestNumber);
        listGuestName = findViewById(R.id.guestListView);

        Intent i = getIntent();
        final Admin admin = (Admin)i.getSerializableExtra("passedObject");

        final ArrayList<String> guestList= new ArrayList<String>();

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(std.getCurrentDate());
        date.setText(formattedDate);

        mess.setText("Mess Number:- " +Integer.toString(admin.getAdmin_manages()));

        //getting guest list
        int c=0;
        List<Student> studentList = db.getAllStudents();
        for(Student student:studentList)
        {   if(student.getMessNumber()==admin.getAdmin_manages()) {
            if (db.checkLeave(student.getId())) {
                List<Leave> leaveList = db.getLeave(student.getId());
                for (Leave leave : leaveList) {
                    Date startdate = std.stringToDate(leave.getStartDate());
                    Date endDate = std.stringToDate(leave.getEndDate());
                    Date currentDate = std.getCurrentDate();
                    if (!(currentDate.before(endDate) && currentDate.after(startdate))) {
                        guestList.add(student.getName());
                        c++;
                    }
                }
            } else {
                c++;
                guestList.add(student.getName());
            }
        }

        }
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.listrowlayout,guestList);
        listGuestName.setDividerHeight(5);

        listGuestName.setAdapter(adapter);

        totalGuest.setText("Total guest = "+ Integer.toString(c));
    }
}
