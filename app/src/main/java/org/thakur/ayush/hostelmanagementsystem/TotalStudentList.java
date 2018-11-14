package org.thakur.ayush.hostelmanagementsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TotalStudentList extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_student_list);
        DatabaseHandler db =new DatabaseHandler(this);
        List<Student> studentList = db.getAllStudents();
        final ListView listview1 = (ListView) findViewById(R.id.listView1);
        final ListView listView2 = (ListView) findViewById(R.id.listView2);
        final ArrayList<String> listName = new ArrayList<String>();
        final ArrayList<String> listMess = new ArrayList<String>();
        for(Student student:studentList) {
            listName.add(student.getName());
            listMess.add("Mess Number: "+ student.getMessNumber());
        }
        //adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, my_array);
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.listrowlayout,listName);
        listview1.setDividerHeight(5);

        listview1.setAdapter(adapter);

        ArrayAdapter adapter2 = new ArrayAdapter(this,R.layout.listrowlayout,listMess);
        listView2.setDividerHeight(5);
        listView2.setAdapter(adapter2);


    }
}
