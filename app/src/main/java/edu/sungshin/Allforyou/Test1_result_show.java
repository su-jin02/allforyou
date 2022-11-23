package edu.sungshin.Allforyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Test1_result_show extends AppCompatActivity {
    TextView text,text2,text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1_result_show);
        text=(TextView) findViewById(R.id.text);
        text2=(TextView) findViewById(R.id.text2);
        text1=(TextView)findViewById(R.id.text1);



    }
}