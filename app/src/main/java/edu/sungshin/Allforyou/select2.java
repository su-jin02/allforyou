package edu.sungshin.Allforyou;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class select2 extends AppCompatActivity {
    RadioGroup radio2;
    Button save2,btn21,btn22,btn23,btn24,btn25,btn26,btn27;
    TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.select2);

        final TextView t2 = (TextView) findViewById(R.id.t2);
        final RadioGroup radio2 = (RadioGroup) findViewById(R.id.radio1);
        Button save2 = (Button) findViewById(R.id.save2);

        save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(radio2.getCheckedRadioButtonId()){
                    case R.id.btn21:
                        int id1 = radio2.getCheckedRadioButtonId();
                        RadioButton rb1 = (RadioButton) findViewById(id1);
                        t2.setText(rb1.getText().toString());
                        break;

                    case R.id.btn22:
                        int id2 = radio2.getCheckedRadioButtonId();
                        RadioButton rb2 = (RadioButton) findViewById(id2);
                        t2.setText(rb2.getText().toString());
                        break;
                    case R.id.btn23:
                        int id3 = radio2.getCheckedRadioButtonId();
                        RadioButton rb3 = (RadioButton) findViewById(id3);
                        t2.setText(rb3.getText().toString());
                        break;
                    case R.id.btn24:
                        int id4 = radio2.getCheckedRadioButtonId();
                        RadioButton rb4 = (RadioButton) findViewById(id4);
                        t2.setText(rb4.getText().toString());
                        break;
                    case R.id.btn25:
                        int id5 = radio2.getCheckedRadioButtonId();
                        RadioButton rb5 = (RadioButton) findViewById(id5);
                        t2.setText(rb5.getText().toString());
                        break;
                    case R.id.btn26:
                        int id6 = radio2.getCheckedRadioButtonId();
                        RadioButton rb6 = (RadioButton) findViewById(id6);
                        t2.setText(rb6.getText().toString());
                        break;
                    case R.id.btn27:
                        int id7 = radio2.getCheckedRadioButtonId();
                        RadioButton rb7 = (RadioButton) findViewById(id7);
                        t2.setText(rb7.getText().toString());
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"색을 먼저 선택해주세요",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}


