package edu.sungshin.Allforyou;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    static int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new edu.sungshin.Allforyou.LuckActivity()).commit();

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.item_fragment1:
                        getSupportFragmentManager().beginTransaction().replace(
                                R.id.main_frame, new LuckActivity()).commit();
                        break;
                    case R.id.item_fragment2:
                        getSupportFragmentManager().beginTransaction().replace(
                                R.id.main_frame, new SoraActivity()).commit();
                        break;
                    case R.id.item_fragment3:
                        getSupportFragmentManager().beginTransaction().replace(
                                R.id.main_frame, new TestActivity()).commit();
                        break;
                    case R.id.item_fragment4:
                        getSupportFragmentManager().beginTransaction().replace(
                                R.id.main_frame, new TestallresultActivity()).commit();
                        break;
                    case R.id.item_fragment5:
                        getSupportFragmentManager().beginTransaction().replace(
                                R.id.main_frame, new DiaryActivity()).commit();
                        break;
                }
                return true;
            }


        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.mypage_menu:
                Intent intent = new Intent(getApplicationContext(), MypageActivity.class);
                startActivity(intent);
                return true;

            case android.R.id.home: {
                if(n!=0) {
                    n = 0;
                    onBackPressed();
                }
                else if (n==0)
                    onBackPressed2();
                return true;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed2() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("종료").setMessage("정말로 앱을 종료하시겠습니까?");
            builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    android.os.Process.killProcess(android.os.Process.myPid());
                }
            });
            builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(n==0) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("종료").setMessage("정말로 앱을 종료하시겠습니까?");
                builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        moveTaskToBack(true);
                        finishAndRemoveTask();
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                });
                builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        }
        else {
            onBackPressed();
        }
        return false;
    }

    public void onFragmentChange(int index){
        if(index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Test1Activity()).addToBackStack(null).commit();
            n=1;
        }

        else if(index == 2){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Test2Activity()).addToBackStack(null).commit();
            n=1;
        }
        else if(index == 3){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Test3Activity()).addToBackStack(null).commit();
            n=1;
        }
        else if(index == 4){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new This_is_Result1()).addToBackStack(null).commit();
            n=1;
        }
         else if(index == 5){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Test2_Result()).addToBackStack(null).commit();
            n=1;
        }
        else if(index == 6){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Test3_Result()).addToBackStack(null).commit();
            n=1;
        }
    }


}