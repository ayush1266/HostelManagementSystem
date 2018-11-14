package org.thakur.ayush.hostelmanagementsystem;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RechargeAccount extends AppCompatActivity {

    EditText inputID;
    EditText inputRechargeAmount;
    Button Go;
    Button Confirm;
    String id;
    TextView name;
    TextView balance;
    TextView success;
    Student rechargeStudent;
    StringToDate std =new StringToDate();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge_account);
        final DatabaseHandler db = new DatabaseHandler(this);
        inputID = findViewById(R.id.inputEnterIdForRecharge);
        inputRechargeAmount = findViewById(R.id.EnterRechargeAmount);
        Go = (Button)findViewById(R.id.buttonRechargeGo);
        Confirm = findViewById(R.id.ButtonConfirmRecharge);
        name = findViewById(R.id.NameofRechargeStudent);
        balance = findViewById(R.id.existingBalance);
        success = findViewById(R.id.successful);
        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id= inputID.getText().toString();

                if(db.existStudent(id))
                {
                    Log.d("inside loop", "onClick: student exist");
                        rechargeStudent = db.getStudent(id);
                        name.setVisibility(View.VISIBLE);
                        name.setText(rechargeStudent.getName().toString());

                        long diff = std.getCurrentDate().getTime()- std.stringToDate((rechargeStudent.getRechargeDate())).getTime();
                        diff/=8.64e+7;
                        //rechargeStudent = db.getStudent(rechargeStudent.getId());
                        //Log.d(TAG, "onCreate: difference " + student.getBalance() + " " +diff);
                        //rechargeStudent.setBalance(rechargeStudent.getBalance() - 100*((int)diff));

                        final int currentBalance = rechargeStudent.getBalance() - 100*((int)diff);

                        balance.setVisibility(View.VISIBLE);
                        balance.setText(Integer.toString(currentBalance));

                        inputRechargeAmount.setVisibility(View.VISIBLE);

                        Confirm.setVisibility(View.VISIBLE);

                        Confirm.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {


                                Log.d("recharging", "onClick: setting " + std.getCurrentDate());
                                db.Recharge(id,currentBalance + Integer.parseInt(inputRechargeAmount.getText().toString()),std.getCurrentDate());
                                success.setVisibility(View.VISIBLE);

                                name.setText("UPDATED BALANCE");
                                rechargeStudent = db.getStudent(id);
                                inputRechargeAmount.setVisibility(View.INVISIBLE);
                                Confirm.setVisibility(View.INVISIBLE);
                                balance.setText(Integer.toString(rechargeStudent.getBalance()));
                            }
                        });
                }
                else
                {
                    balance.setVisibility(View.VISIBLE);
                    balance.setText("NO ID " + inputID.getText() +" EXIST");
                }
            }
        });

    }
}
