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

public class select3 extends AppCompatActivity {
    RadioGroup radio3;
    Button save3;
    TextView t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.select3);

        final TextView t2 = (TextView) findViewById(R.id.t3);
        final RadioGroup radio2 = (RadioGroup) findViewById(R.id.radio3);
        Button save3 = (Button) findViewById(R.id.save3);

        save3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int id = radio3.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(id);
                t3.setText(rb.getText().toString());

            }


        });

    }
}
