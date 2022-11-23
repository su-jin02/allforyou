package edu.sungshin.Allforyou;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class TestallresultActivity extends Fragment {
    Button btn1,btn2,btn3;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.activity_testallresult, container, false);
        btn1=(Button) v.findViewById(R.id.btn1);
        btn2=(Button) v.findViewById(R.id.btn2);
        btn3=(Button) v.findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Test1_result_show.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Test3ActivityResult.class);
                startActivity(intent);
            }
        });
        return v;

    }

}