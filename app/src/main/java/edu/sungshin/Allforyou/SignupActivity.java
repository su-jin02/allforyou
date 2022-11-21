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
    EditText name, id, pw, pw2, email;
    Button btn1, birth;
    TextView pwmsg , pwcheck;
    RadioGroup radio_group;
    RadioButton radio_button_man, radio_button_woman, radio_button_else;
    Calendar myCalendar = Calendar.getInstance();
    String strsex;
    boolean chk;

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
        radio_button_man = (RadioButton) findViewById(radio_group.getCheckedRadioButtonId());
        radio_button_woman = (RadioButton) findViewById(radio_group.getCheckedRadioButtonId());
        radio_button_else = (RadioButton) findViewById(radio_group.getCheckedRadioButtonId());
        radio_button_man = findViewById(R.id.radio_button_man);
        radio_button_woman = findViewById(R.id.radio_button_woman);
        radio_button_else = findViewById(R.id.radio_button_else);
        Button et_date = (Button) findViewById(R.id.birth);
        chk = false;

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("User");

        Button et_Date = (Button) findViewById(R.id.birth);
        et_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SignupActivity.this, myDatePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

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
                if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%^~*#?&]).{7,14}.$", password))
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


        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(radio_group.getCheckedRadioButtonId() == R.id.radio_button_man){
                    strsex = radio_button_man.getText().toString();
                    chk = true;
                }
                if(radio_group.getCheckedRadioButtonId() == R.id.radio_button_woman){
                    strsex = radio_button_woman.getText().toString();
                    chk = true;
                }
                if(radio_group.getCheckedRadioButtonId() == R.id.radio_button_else){
                    strsex = radio_button_else.getText().toString();
                    chk = true;
                }
            }
        });



        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String stremail = email.getText().toString().trim();
                String strpw = pw.getText().toString().trim();
                String strpw2 = pw2.getText().toString().trim();
                String strname = name.getText().toString().trim();
                String strbirth = et_date.getText().toString().trim();
                radio_group = findViewById(R.id.radio_group);
                String strbutton = strsex;


                if ((strname.length() == 0) && (stremail.length() == 0) && (strpw.length() == 0) && (strpw2.length() == 0) && (strbirth.length() == 0) && (chk != true)) {
                    Toast.makeText(SignupActivity.this, "정보를 입력해주세요", Toast.LENGTH_LONG).show();
                    return;
                }
                if ((String) pwmsg.getText() != "적합한 비밀번호입니다.") {
                    Toast.makeText(SignupActivity.this, "비밀번호 조건이 맞지 않습니다", Toast.LENGTH_SHORT).show();
                    return;
                }

                if ((String) pwcheck.getText() != "일치") {
                    Toast.makeText(SignupActivity.this, "비밀번호가 동일하지 않습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }


                mFirebaseAuth.createUserWithEmailAndPassword(stremail, strpw).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        //가입 성공시
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            String stremail = firebaseUser.getEmail();
                            String uid = firebaseUser.getUid();
                            //String strbirth = et_date.getText().toString().trim();
                            //String strname = name.getText().toString().trim();
                            String strpw = pw.getText().toString().trim();

                            HashMap<Object, String> hashMap = new HashMap<>();
                            hashMap.put("uid", uid);
                            hashMap.put("birth", strbirth);
                            hashMap.put("email", stremail);
                            hashMap.put("name", strname);
                            hashMap.put("pw", strpw);
                            hashMap.put("sex", strbutton);

                            mDatabaseRef.child(uid).setValue(hashMap);

                            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();

                            Toast.makeText(SignupActivity.this, "회원가입에 성공했습니다", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(SignupActivity.this, "이미 존재하는 회원입니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }


    private void updateLabel () {
        String myFormat = "yyyy/MM/dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);

        Button et_date = (Button) findViewById(R.id.birth);
        et_date.setText(sdf.format(myCalendar.getTime()));
    }


}






