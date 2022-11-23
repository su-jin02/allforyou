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

public class select4 extends AppCompatActivity {
    RadioGroup radio4;
    Button save4;
    TextView t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.select4);

        final TextView t4 = (TextView) findViewById(R.id.t4);
        final RadioGroup radio4= (RadioGroup) findViewById(R.id.radio4);
        Button save4 = (Button) findViewById(R.id.save4);

        save4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int id = radio4.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(id);
                t4.setText(rb.getText().toString());

            }


        });
    }
}
