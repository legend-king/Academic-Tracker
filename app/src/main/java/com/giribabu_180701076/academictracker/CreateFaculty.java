package com.giribabu_180701076.academictracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateFaculty extends AppCompatActivity {
    Button submit;
    EditText staffCode, email, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_faculty);
        submit = findViewById(R.id.facultySubmitBtn);
        staffCode = findViewById(R.id.facultyeditTextId);
        email = findViewById(R.id.facultyeditTextEmail);
        pass = findViewById(R.id.facultyeditTextPassword);

        DBHelper db = new DBHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String staffCode1 = staffCode.getText().toString();
                String email1 = email.getText().toString();
                String pass1 = pass.getText().toString();

                if (staffCode1.equals("")){
                    staffCode.setError("Roll no can't be empty");
                }
                else if (email1.equals("")){
                    email.setError("Email can't be empty");
                }
                else if (pass1.length()<6){
                    pass.setError("Password should be at least 6 characters");
                }
                else{
                    boolean inserted = db.insertData(staffCode1, email1, pass1, "student");
                    if (!inserted){
                        Toast.makeText(getApplicationContext(), "Unable to create an account", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Created Account Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(getIntent());
                        finish();
                    }
                }
            }
        });
    }
}