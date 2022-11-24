package edu.sungshin.Allforyou;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FindpwActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    EditText email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findpw);

        mFirebaseAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.email);

        Button btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stremail = email.getText().toString().trim();

                if(stremail.length() > 0){
                    mFirebaseAuth.sendPasswordResetEmail(stremail)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(FindpwActivity.this, "이메일을 보냈습니다", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else if(stremail.length() == 0){
                    Toast.makeText(FindpwActivity.this, "이메일을 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(FindpwActivity.this, "존재하지 않는 이메일입니다", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }

}
