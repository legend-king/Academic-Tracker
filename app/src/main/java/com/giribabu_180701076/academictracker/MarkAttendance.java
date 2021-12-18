package com.giribabu_180701076.academictracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MarkAttendance extends AppCompatActivity {
    Button submit;
    EditText regNo, attPer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance);

        submit = findViewById(R.id.markAttBtn);
        regNo = findViewById(R.id.studentRegNo);
        attPer = findViewById(R.id.studentAttendance);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reg = regNo.getText().toString();
                String att = attPer.getText().toString();
                int a = Integer.parseInt(att);

                if (a<0 || a>100){
                    attPer.setError("Percentage should be between 0-100");
                }
                else if (reg.equals("")){
                    regNo.setError("Reg Number cannot be empty");
                }
                else{
                    Toast.makeText(getApplicationContext(), "Attendance updated successfully", Toast.LENGTH_SHORT).show();
                    startActivity(getIntent());
                    finish();
                }
            }
        });
    }
}