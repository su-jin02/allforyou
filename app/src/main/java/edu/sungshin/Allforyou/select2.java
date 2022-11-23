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

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class select2 extends AppCompatActivity {
    RadioGroup radio2;
    Button save2;
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
                int id = radio2.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(id);
                t2.setText(rb.getText().toString());

            }


        });

    }
}

