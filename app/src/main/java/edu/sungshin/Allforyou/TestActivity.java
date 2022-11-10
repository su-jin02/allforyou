package edu.sungshin.Allforyou;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class TestActivity extends  Fragment {
    edu.sungshin.Allforyou.MainActivity activity;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        activity = (MainActivity)getActivity();
    }

    @Override
    public void onDetach(){
        super.onDetach();
        activity = null;
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.activity_test, container, false);

        Button btn1 = (Button) rootview.findViewById(R.id.btn1);
        Button btn2 = (Button) rootview.findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onFragmentChange(1);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onFragmentChange(2);
            }
        });


        return rootview;
    }



}