package edu.sungshin.Allforyou;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class TestallresultActivity extends Fragment {
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
            ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.activity_testallresult, container, false);

            Button btn11 = (Button) rootview.findViewById(R.id.btn11);
            Button btn21 = (Button) rootview.findViewById(R.id.btn21);
            Button btn31 = (Button) rootview.findViewById(R.id.btn31);

            btn11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onFragmentChange(4);
                }
            });


            btn21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onFragmentChange(5);
                }
            });

            btn31.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onFragmentChange(6);
                }
            });

            return rootview;
        }
    }