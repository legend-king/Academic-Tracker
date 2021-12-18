package com.giribabu_180701076.academictracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    Button submitBtn;
    EditText name, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        submitBtn = findViewById(R.id.adminSubmitBtn);
        name = findViewById(R.id.adminName);
        pass = findViewById(R.id.adminPass);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();
                String pass1 = pass.getText().toString();

                if (name1.equals("")){
                    name.setError("Name can't be blank");
                }
                else if (pass1.equals("")){
                    pass.setError("Password can't be blankk");
                }
                else if (name1.equals("admin") && pass1.equals("admin1234")){
                    Intent intent = new Intent(getApplicationContext(), AdminDashboard.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Username or password is wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}