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

public class select4 extends AppCompatActivity {
    RadioGroup radio4;
    Button save4,btn41,btn42,btn43,btn44,btn45,btn46,btn47;;
    TextView t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.select4);

        final TextView t4 = (TextView) findViewById(R.id.t4);
        final RadioGroup radio4 = (RadioGroup) findViewById(R.id.radio4);
        Button save4 = (Button) findViewById(R.id.save4);

        save4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(radio4.getCheckedRadioButtonId()){
                    case R.id.btn41:
                        int id1 = radio4.getCheckedRadioButtonId();
                        RadioButton rb1 = (RadioButton) findViewById(id1);
                        t4.setText(rb1.getText().toString());
                        break;

                    case R.id.btn42:
                        int id2 = radio4.getCheckedRadioButtonId();
                        RadioButton rb2 = (RadioButton) findViewById(id2);
                        t4.setText(rb2.getText().toString());
                        break;
                    case R.id.btn43:
                        int id3 = radio4.getCheckedRadioButtonId();
                        RadioButton rb3 = (RadioButton) findViewById(id3);
                        t4.setText(rb3.getText().toString());
                        break;
                    case R.id.btn44:
                        int id4 = radio4.getCheckedRadioButtonId();
                        RadioButton rb4 = (RadioButton) findViewById(id4);
                        t4.setText(rb4.getText().toString());
                        break;
                    case R.id.btn45:
                        int id5 = radio4.getCheckedRadioButtonId();
                        RadioButton rb5 = (RadioButton) findViewById(id5);
                        t4.setText(rb5.getText().toString());
                        break;
                    case R.id.btn46:
                        int id6 = radio4.getCheckedRadioButtonId();
                        RadioButton rb6 = (RadioButton) findViewById(id6);
                        t4.setText(rb6.getText().toString());
                        break;
                    case R.id.btn47:
                        int id7 = radio4.getCheckedRadioButtonId();
                        RadioButton rb7 = (RadioButton) findViewById(id7);
                        t4.setText(rb7.getText().toString());
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"색을 먼저 선택해주세요",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}





