package com.giribabu_180701076.academictracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentLogin extends AppCompatActivity {
    Button submit;
    EditText email, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        submit = findViewById(R.id.studentLoginBtn);
        email = findViewById(R.id.studentLoginMail);
        pass = findViewById(R.id.studentLoginPassword);

        DBHelper db = new DBHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1 = email.getText().toString();
                String pass1 = pass.getText().toString();
                if (db.checkPasswordCorrect(email1, pass1)) {
                    Intent intent = new Intent(getApplicationContext(), StudentDashboard.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}