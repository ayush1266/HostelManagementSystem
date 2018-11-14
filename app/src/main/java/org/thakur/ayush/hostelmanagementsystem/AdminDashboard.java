package org.thakur.ayush.hostelmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AdminDashboard extends AppCompatActivity {

    TextView name;
    TextView manages;
    Button adminLogout;
    Button getStudentList;
    Button getGuestList;
    Button changeTimeTable;
    Button recharge;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
       requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
       getSupportActionBar().hide(); //hide the title bar

       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        Intent i = getIntent();
        final Admin admin = (Admin)i.getSerializableExtra("passedObject");
        final  Intent intentLogout = new Intent(AdminDashboard.this,Admin_login.class);
        name = findViewById(R.id.adminNameHeading);
        manages = findViewById(R.id.adminManagesHeading);
        getStudentList = findViewById(R.id.buttonTotalStudentsList);
        getGuestList = findViewById(R.id.buttonNumberOfGuestsList);
        changeTimeTable = findViewById(R.id.buttonChangeTimeTable);
        recharge= findViewById(R.id.buttonRecharge);
        adminLogout = findViewById(R.id.adminLogoutButton);
        adminLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        name.setText(admin.getAdmin_name());
        manages.setText("Manages Mess Number: " +Integer.toString(admin.getAdmin_manages()));
        final Intent intentStudentList = new Intent(AdminDashboard.this,TotalStudentList.class);
        final Intent intentGuestList = new Intent(AdminDashboard.this,TotalGuestList.class);
        final Intent intentREcharge = new Intent(AdminDashboard.this,RechargeAccount.class);
        final Intent intentChnagetimeTable = new Intent(AdminDashboard.this,ChangeTimeTable.class);
        getStudentList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intentStudentList);
            }
        });
        getGuestList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentGuestList.putExtra("passedObject",admin);
                startActivity(intentGuestList);
            }
        });
        recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentREcharge);
            }
        });
        changeTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentChnagetimeTable.putExtra("passedObject",admin);
                startActivity(intentChnagetimeTable);
            }
        });
    }
}
