package edu.sungshin.Allforyou;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TintTypedArray;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import edu.sungshin.Allforyou.MainActivity;
import edu.sungshin.Allforyou.SignupActivity;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    //FirebaseAuth auth;
    DatabaseReference mDatabaseRef;
    private DatabaseReference mdatabaseRef;
    PreferenceManager myPre;
    String sign = "false";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        //FirebaseUser user = mFirebaseAuth.getCurrentUser();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Allforyou");
        mdatabaseRef = FirebaseDatabase.getInstance().getReference().child("User");

        Button button = (Button)findViewById(R.id.btn1);
        TextView register = (TextView)findViewById(R.id.signin);
        TextView findpw = (TextView)findViewById(R.id.findpw);

        EditText etext1 = (EditText) findViewById(R.id.etext1);
        EditText etext2 = (EditText) findViewById(R.id.etext2);


        //자동로그인
        FirebaseUser user = mFirebaseAuth.getCurrentUser();

        if(user!= null){
        user.getIdToken(true).addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<GetTokenResult> task) {
                if(task.isSuccessful()) {
                    String idToken = task.getResult().getToken();
                    Intent homeMove_intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(homeMove_intent);
                }
            }
        });
    }


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
                            sign = "true";
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                            Toast.makeText(LoginActivity.this, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show();

                        }
                        else {
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

}