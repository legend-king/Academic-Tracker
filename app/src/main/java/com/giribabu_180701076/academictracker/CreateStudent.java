package com.giribabu_180701076.academictracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateStudent extends AppCompatActivity {
    Button submit;
    EditText rollno, email, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_student);

        submit = findViewById(R.id.studentSubmitBtn);
        rollno = findViewById(R.id.studenteditTextId);
        email = findViewById(R.id.studenteditTextEmail);
        pass = findViewById(R.id.studenteditTextPassword);
        DBHelper db = new DBHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollno1 = rollno.getText().toString();
                String email1 = email.getText().toString();
                String pass1 = pass.getText().toString();

                if (rollno1.equals("")){
                    rollno.setError("Roll no can't be empty");
                }
                else if (email1.equals("")){
                    email.setError("Email can't be empty");
                }
                else if (pass1.length()<6){
                    pass.setError("Password should be at least 6 characters");
                }
                else{
                    boolean inserted = db.insertData(rollno1, email1, pass1, "student");
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