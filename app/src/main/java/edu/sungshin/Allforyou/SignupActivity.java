package edu.sungshin.Allforyou;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.auth.User;

import edu.sungshin.Allforyou.LoginActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;


public class SignupActivity extends AppCompatActivity {

    EditText name, id, pw, pw2, email, birth;
    Button pwcheck,btn1;
    Calendar myCalendar = Calendar.getInstance();

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference mdatabase = database.getReference();


    DatePickerDialog.OnDateSetListener myDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        pw = findViewById(R.id.pw1);
        pw2 = findViewById(R.id.pw2);

        EditText et_Date = (EditText) findViewById(R.id.birth);
        et_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SignupActivity.this, myDatePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        pwcheck = findViewById(R.id.pwcheck);
        pwcheck.setOnClickListener(v -> {
            if (pw.getText().toString().equals(pw2.getText().toString())) {
                pwcheck.setText("일치");
            } else {
                Toast.makeText(SignupActivity.this, "비밀번호가 다릅니다.", Toast.LENGTH_LONG).show();
            }


        });

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(v -> {

            writeNewUser(name.getText().toString());

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });


    }

    private void updateLabel () {
        String myFormat = "yyyy/MM/dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);

        EditText et_date = (EditText) findViewById(R.id.birth);
        et_date.setText(sdf.format(myCalendar.getTime()));
    }

    private void writeNewUser(String name) {
        User user = new User(name);
        mdatabase.child("users").child(name).setValue(user);

    }

}






