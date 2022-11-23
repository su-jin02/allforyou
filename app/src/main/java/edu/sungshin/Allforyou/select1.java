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
import androidx.appcompat.app.AppCompatActivity;




public class select1 extends AppCompatActivity {
    RadioGroup radio1;
    Button save1;
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
                int id = radio1.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(id);
                t1.setText(rb.getText().toString());

            }


        });
    }
}



