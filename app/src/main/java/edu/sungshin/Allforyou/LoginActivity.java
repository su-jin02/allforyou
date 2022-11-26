package edu.sungshin.Allforyou;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;

import edu.sungshin.Allforyou.MainActivity;
import edu.sungshin.Allforyou.SignupActivity;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Allforyou");

        Button button = (Button)findViewById(R.id.btn1);
        TextView register = (TextView)findViewById(R.id.signin);
        TextView findpw = (TextView)findViewById(R.id.findpw);

        EditText etext1 = (EditText) findViewById(R.id.etext1);
        EditText etext2 = (EditText) findViewById(R.id.etext2);


        //자동로그인
        mFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mFirebaseAuth.getCurrentUser();
/*
       // 현재 사용자의 idToken을 확인하여 자동 로그인 시킬지 말지 결정
        user.getIdToken(true).addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<GetTokenResult> task) {
                if(task.isSuccessful()) {
                    String idToken = task.getResult().getToken();
                    //Log.d(TAG,"아이디 토큰 = " + idToken);
                    Intent homeMove_intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(homeMove_intent);
                }
            }
        });


 */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stremail = etext1.getText().toString().trim();
                String strpw = etext2.getText().toString().trim();

                if ((stremail.length() == 0) && (strpw.length() == 0)) {
                    Toast.makeText(LoginActivity.this, "정보를 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                mFirebaseAuth.signInWithEmailAndPassword(stremail, strpw).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();

                            Toast.makeText(LoginActivity.this, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show();

                        }
                        else{
                            Toast.makeText(LoginActivity.this, "이메일/비밀번호를 다시 확인해주세요", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        findpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, FindpwActivity.class);
                startActivity(intent);
            }
        });
    }

//    fun moveMainPage(user: FirebaseUser?){
//        if( user!= null){
//            startActivity(Intent(this,MainActivity::class.java));
//            finish();
//        }
//    }
}