package edu.sungshin.Allforyou;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MypageActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("User");;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        ImageButton mypgbackBtn = (ImageButton) findViewById(R.id.mypgbackBtn);
        TextView myname = (TextView) findViewById(R.id.name);
        TextView mybirth = (TextView) findViewById(R.id.birth);
        TextView mygender = (TextView) findViewById(R.id.gender);

        auth= FirebaseAuth.getInstance();

        mDatabaseRef.child(auth.getCurrentUser().getUid()).child("birth").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String userbirth = dataSnapshot.getValue(String.class);
                mybirth.setText(userbirth);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        mDatabaseRef.child(auth.getCurrentUser().getUid()).child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String username = dataSnapshot.getValue(String.class);
                myname.setText(username);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        mDatabaseRef.child(auth.getCurrentUser().getUid()).child("sex").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String usersex = dataSnapshot.getValue(String.class);
                mygender.setText(usersex);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });



        mypgbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}