package com.example.mobileprogramming_3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class SignupActivity extends AppCompatActivity {
    TextView back;
    EditText name,id,pw,pw2,email;
    Button pwcheck, submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.name);
        email=findViewById(R.id.email);
        pw=findViewById(R.id.pw1);
        pw2=findViewById(R.id.pw2);


        pwcheck = findViewById(R.id.pwcheck);
        pwcheck.setOnClickListener(v -> {
            if(pw.getText().toString().equals(pw2.getText().toString())){
                pwcheck.setText("일치");
            }else{
                Toast.makeText(SignupActivity.this, "비밀번호가 다릅니다.", Toast.LENGTH_LONG).show();
            }
        });


        submit = findViewById(R.id.btn1);
        submit.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });



    }
}