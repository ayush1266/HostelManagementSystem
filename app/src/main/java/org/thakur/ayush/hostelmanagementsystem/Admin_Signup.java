package org.thakur.ayush.hostelmanagementsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Admin_Signup extends AppCompatActivity {

    private EditText Name;
    private EditText Id;
    private EditText Password;
    private EditText Email;
    private EditText Manages;
    private Button signup;
    private TextView totalNumber;
    private static final String TAG = "Signup Activity";
    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__signup);
        Name = findViewById(R.id.a_name);
        Id = findViewById(R.id.a_id);
        Password = findViewById(R.id.a_password);
        Email = findViewById(R.id.a_Email);
        Manages = findViewById(R.id.a_Manages);
        signup = findViewById(R.id.a_signup1);
        totalNumber = findViewById(R.id.a_totalNumberAdmin);
        totalNumber.setText(Integer.toString(db.getAdminCount()));

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (db.checkAdminManages(Integer.parseInt(Manages.getText().toString()))) {
                    Toast.makeText(Admin_Signup.this,"DUPLICATE MANAGES ENTRY FOUND",Toast.LENGTH_LONG).show();
                } else {
                    db.addAdmin(Id.getText().toString(), Name.getText().toString(), Password.getText().toString(),
                            Email.getText().toString(), Integer.parseInt(Manages.getText().toString()));

                    Toast.makeText(Admin_Signup.this.getApplicationContext(), "SIGNUP SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onClick: " + Integer.toString(db.getAdminCount()));
                    totalNumber.setText(Integer.toString(db.getAdminCount()));
                    Log.d(TAG, "onClick: " + db.getAdminCount());
                }
                //Log.d(TAG, "onClick: " +db.getCREATE_TABLE_ADMIN());
                Id.setText("");
                Name.setText("");
                Manages.setText("");
                Password.setText("");
                Email.setText("");
            }
        });
    }
}
