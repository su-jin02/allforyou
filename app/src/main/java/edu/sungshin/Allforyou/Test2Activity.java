package edu.sungshin.Allforyou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Test2Activity extends Fragment implements onBackPressedListener {
    private int count=0;

Button option1text,option2text,option3text,option4text,result;

    @Override
    public void onBackPressed() {
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_test2, container, false);
        option1text=(Button)view.findViewById(R.id.option1text);
        option2text=(Button)view.findViewById(R.id.option2text);
        option3text=(Button)view.findViewById(R.id.option3text);
        option4text=(Button)view.findViewById(R.id.option4text);

        option1text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getContext(), select1.class);
                startActivity(intent1);
            }
        });
        option2text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getContext(), select2.class);
                startActivity(intent2);
            }
        });
        option3text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getContext(), select3.class);
                startActivity(intent3);
            }
        });
        option4text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getContext(), select4.class);
                startActivity(intent4);
            }
        });

 
        return view;

    }

}