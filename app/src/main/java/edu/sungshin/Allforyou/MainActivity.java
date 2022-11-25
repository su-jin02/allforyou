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
                onBackPressed();
                return true;
            }

        }
        return super.onOptionsItemSelected(item);
    }


    public void onFragmentChange(int index){
        if(index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Test1Activity()).addToBackStack(null).commit();
        }

        else if(index == 2){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Test2Activity()).addToBackStack(null).commit();
        }
        else if(index == 3){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Test3Activity()).addToBackStack(null).commit();
        }
        else if(index == 4){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new This_is_Result1()).addToBackStack(null).commit();
        }
         else if(index == 5){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Test2_Result()).addToBackStack(null).commit();
        }
        else if(index == 6){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Test3_Result()).addToBackStack(null).commit();
        }
    }


}