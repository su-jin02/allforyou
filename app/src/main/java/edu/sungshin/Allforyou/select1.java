package edu.sungshin.Allforyou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;




public class select1 extends AppCompatActivity {
    RadioGroup radio1;
    Button save1,btn11,btn12,btn13,btn14,btn15,btn16,btn17;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.select1);

        final TextView t1=(TextView)findViewById(R.id.t1);
        final RadioGroup radio1 = (RadioGroup)findViewById(R.id.radio1);
        Button save1=(Button)findViewById(R.id.save1);


        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               switch(radio1.getCheckedRadioButtonId()){
                   case R.id.btn11:
                    int id1 = radio1.getCheckedRadioButtonId();
                    RadioButton rb1 = (RadioButton) findViewById(id1);
                    t1.setText(rb1.getText().toString());
                    break;

                   case R.id.btn12:
                       int id2 = radio1.getCheckedRadioButtonId();
                       RadioButton rb2 = (RadioButton) findViewById(id2);
                       t1.setText(rb2.getText().toString());
                       break;
                   case R.id.btn13:
                       int id3 = radio1.getCheckedRadioButtonId();
                       RadioButton rb3 = (RadioButton) findViewById(id3);
                       t1.setText(rb3.getText().toString());
                       break;
                   case R.id.btn14:
                       int id4 = radio1.getCheckedRadioButtonId();
                       RadioButton rb4 = (RadioButton) findViewById(id4);
                       t1.setText(rb4.getText().toString());
                       break;
                   case R.id.btn15:
                       int id5 = radio1.getCheckedRadioButtonId();
                       RadioButton rb5 = (RadioButton) findViewById(id5);
                       t1.setText(rb5.getText().toString());
                       break;
                   case R.id.btn16:
                       int id6 = radio1.getCheckedRadioButtonId();
                       RadioButton rb6 = (RadioButton) findViewById(id6);
                       t1.setText(rb6.getText().toString());
                       break;
                   case R.id.btn17:
                       int id7 = radio1.getCheckedRadioButtonId();
                       RadioButton rb7 = (RadioButton) findViewById(id7);
                       t1.setText(rb7.getText().toString());
                       break;
                   default:
                       Toast.makeText(getApplicationContext(),"색을 먼저 선택해주세요",Toast.LENGTH_SHORT).show();
               }

            }
        });
    }
}



