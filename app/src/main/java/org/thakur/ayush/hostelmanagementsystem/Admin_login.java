package org.thakur.ayush.hostelmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Admin_login extends AppCompatActivity {
    private TextView ID;
    private TextView password;
    private Button login;
    Admin currentAdmin = new Admin();
    DatabaseHandler db = new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        ID = findViewById(R.id.admin_login_username);
        password = findViewById(R.id.admin_login_password);
        login = findViewById(R.id.admin_login_button);
        final Intent intent1 = new Intent(Admin_login.this, AdminDashboard.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(db.checkAdmin(ID.getText().toString(),password.getText().toString()))
                {
                    currentAdmin=db.getAdmin(ID.getText().toString());
                    Admin admin = db.getAdmin(ID.getText().toString());
                    Toast.makeText(Admin_login.this.getApplicationContext(),"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    intent1.putExtra("passedObject",admin);
                    startActivity(intent1);
                }
                else
                {
                    Toast.makeText(Admin_login.this.getApplicationContext(),"INVALID ID OR PASSWORD",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
