package edu.sungshin.Allforyou;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

    public class Test3ActivityResult extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.test3result);

            ImageButton btnReturn = (ImageButton) findViewById(R.id.returnbtn);

            btnReturn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    finish();
                }
            });

        }

    }


