package edu.sungshin.Allforyou;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.auth.User;

import edu.sungshin.Allforyou.LoginActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    EditText name, id, pw, pw2, email, birth;
    Button btn1;
    TextView pwmsg , pwcheck;
    RadioGroup radio_group;
    RadioButton radio_button_man, radio_button_woman, radio_button_else;
    Calendar myCalendar = Calendar.getInstance();



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
        pwmsg = findViewById(R.id.pwmsg);
        pwcheck = findViewById(R.id.pwcheck);
        btn1 = findViewById(R.id.btn1);
        radio_group = findViewById(R.id.radio_group);
        radio_button_man = findViewById(R.id.radio_button_man);
        radio_button_woman = findViewById(R.id.radio_button_woman);
        radio_button_else = findViewById(R.id.radio_button_else);
        EditText et_date = (EditText) findViewById(R.id.birth);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("User");

        EditText et_Date = (EditText) findViewById(R.id.birth);
        et_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SignupActivity.this, myDatePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


//        pwcheck.setOnClickListener(v -> {
//            if (pw.getText().toString().equals(pw2.getText().toString())) {
//                pwcheck.setText("일치");
//            } else {
//                Toast.makeText(SignupActivity.this, "비밀번호가 다릅니다.", Toast.LENGTH_LONG).show();
//            }
//        });

        //비번 조건
        pw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {

                String password = pw.getText().toString().trim();
                if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%^~*#?&]).{8,15}.$", password))
                {
                    pwmsg.setTextColor(Color.parseColor("#F11135"));
                    pwmsg.setText("조건에 맞추어 비밀번호를 설정해주세요");
                }
                else{
                    pwmsg.setTextColor(Color.parseColor("#4CAF50"));
                    pwmsg.setText("적합한 비밀번호입니다.");
                }


            }
        });

        //비번 일치 확인
        pw2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (pw.getText().toString().equals(pw2.getText().toString())) {
                    pwcheck.setText("일치");
                    pwcheck.setTextColor(Color.parseColor("#4CAF50"));
                }
                else{
                    pwcheck.setText("불일치");
                    pwcheck.setTextColor(Color.parseColor("#F11135"));
                }

            }
        });

        /*
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(radio_group.getCheckedRadioButtonId()){
                    case R.id.radio_button_man:
                        break;
                    case R.id.radio_button_woman:
                        break;
                    case R.id.radio_button_else:
                        break;
                }
            }
        });

         */

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String stremail = email.getText().toString().trim();
                String strpw = pw.getText().toString().trim();
                String strpw2 = pw2.getText().toString().trim();
                String strbirth = et_date.getText().toString().trim();
                radio_group = findViewById(R.id.radio_group);

                if (strpw.equals(strpw2) && (strbirth.length() != 0) && (radio_group.getCheckedRadioButtonId() != 0)) {
                    mFirebaseAuth.createUserWithEmailAndPassword(stremail, strpw).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            //가입 성공시
                            if (task.isSuccessful()) {
                                FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                                String stremail = firebaseUser.getEmail();
                                String uid = firebaseUser.getUid();
                                String strbirth = et_date.getText().toString().trim();
                                String strname = name.getText().toString().trim();
                                String strpw = pw.getText().toString().trim();

                                HashMap<Object, String> hashMap = new HashMap<>();
                                hashMap.put("uid", uid);
                                hashMap.put("birth", strbirth);
                                hashMap.put("email", stremail);
                                hashMap.put("name", strname);
                                hashMap.put("pw", strpw);

                                mDatabaseRef.child(uid).setValue(hashMap);

                                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();

                                Toast.makeText(SignupActivity.this, "회원가입 성공", Toast.LENGTH_SHORT).show();

                            } else {

                                Toast.makeText(SignupActivity.this, "회원가입 실패", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                } else {
                    Toast.makeText(SignupActivity.this, "비밀번호가 다릅니다.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void updateLabel () {
        String myFormat = "yyyy/MM/dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);

        EditText et_date = (EditText) findViewById(R.id.birth);
        et_date.setText(sdf.format(myCalendar.getTime()));
    }


}






