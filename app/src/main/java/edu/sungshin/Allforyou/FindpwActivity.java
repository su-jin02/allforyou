package edu.sungshin.Allforyou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class FindpwActivity extends AppCompatActivity {

    //private FirebaseAuth mFirebaseAuth;
    //private DatabaseReference mDatabaseRef;
    private FirebaseAuth auth;
    DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("User");;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findpw);

        EditText email = (EditText) findViewById(R.id.email);
        EditText pw = (EditText) findViewById(R.id.pw);
        EditText name = (EditText) findViewById(R.id.name);
        Button btn = (Button) findViewById(R.id.btn);

        auth= FirebaseAuth.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDatabaseRef.child(auth.getCurrentUser().getUid()).child("pw").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String userbirth = dataSnapshot.getValue(String.class);
                        pw.setText(userbirth);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
                    }
                });

            }
        });



    }
}
