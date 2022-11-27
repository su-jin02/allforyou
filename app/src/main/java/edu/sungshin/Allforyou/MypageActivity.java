package edu.sungshin.Allforyou;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MypageActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    String sign;
    DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("User");
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        ImageButton mypgbackBtn = (ImageButton) findViewById(R.id.mypgbackBtn);
        TextView myname = (TextView) findViewById(R.id.name);
        TextView mybirth = (TextView) findViewById(R.id.birth);
        TextView mygender = (TextView) findViewById(R.id.gender);
        Button logout = (Button) findViewById(R.id.logout);
        Button delete = (Button) findViewById(R.id.delete);
        auth= FirebaseAuth.getInstance();
        //mysign = "true";


        //로그아웃
       logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Toast.makeText(MypageActivity.this, "로그아웃 되었습니다.", Toast.LENGTH_LONG).show();
                finish();
                //sign = "false";
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

        //회원탈퇴
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert_confirm = new AlertDialog.Builder(MypageActivity.this);
                alert_confirm.setMessage("정말 계정을 삭제 할까요?").setCancelable(false).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                FirebaseUser user = auth.getCurrentUser();
                                user.delete()
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                //sign = "false";
                                                Toast.makeText(MypageActivity.this, "계정이 삭제 되었습니다.", Toast.LENGTH_LONG).show();
                                                finish();
                                                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                            }
                                        });
                            }
                        }
                );
                alert_confirm.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MypageActivity.this, "취소", Toast.LENGTH_LONG).show();
                    }
                });
                alert_confirm.show();
            }
        });

        /*
        mDatabaseRef.child(auth.getCurrentUser().getUid()).child("signup").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                sign = dataSnapshot.getValue(String.class);
                //sign = "false";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

         */



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