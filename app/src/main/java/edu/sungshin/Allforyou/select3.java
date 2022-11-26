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

public class select3 extends AppCompatActivity {
    RadioGroup radio3;
    Button save3,btn31,btn32,btn33,btn34,btn35,btn36,btn37;
    TextView t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.select3);

        final TextView t3 = (TextView) findViewById(R.id.t3);
        final RadioGroup radio3 = (RadioGroup) findViewById(R.id.radio3);
        Button save3 = (Button) findViewById(R.id.save3);

        save3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(radio3.getCheckedRadioButtonId()){
                    case R.id.btn31:
                        int id1 = radio3.getCheckedRadioButtonId();
                        RadioButton rb1 = (RadioButton) findViewById(id1);
                        t3.setText(rb1.getText().toString());
                        break;

                    case R.id.btn32:
                        int id2 = radio3.getCheckedRadioButtonId();
                        RadioButton rb2 = (RadioButton) findViewById(id2);
                        t3.setText(rb2.getText().toString());
                        break;
                    case R.id.btn33:
                        int id3 = radio3.getCheckedRadioButtonId();
                        RadioButton rb3 = (RadioButton) findViewById(id3);
                        t3.setText(rb3.getText().toString());
                        break;
                    case R.id.btn34:
                        int id4 = radio3.getCheckedRadioButtonId();
                        RadioButton rb4 = (RadioButton) findViewById(id4);
                        t3.setText(rb4.getText().toString());
                        break;
                    case R.id.btn35:
                        int id5 = radio3.getCheckedRadioButtonId();
                        RadioButton rb5 = (RadioButton) findViewById(id5);
                        t3.setText(rb5.getText().toString());
                        break;
                    case R.id.btn36:
                        int id6 = radio3.getCheckedRadioButtonId();
                        RadioButton rb6 = (RadioButton) findViewById(id6);
                        t3.setText(rb6.getText().toString());
                        break;
                    case R.id.btn37:
                        int id7 = radio3.getCheckedRadioButtonId();
                        RadioButton rb7 = (RadioButton) findViewById(id7);
                        t3.setText(rb7.getText().toString());
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"색을 먼저 선택해주세요",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}



