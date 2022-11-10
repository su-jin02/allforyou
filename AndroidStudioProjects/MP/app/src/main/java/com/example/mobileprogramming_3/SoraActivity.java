package com.example.Allforyou;

import android.content.Intent;
import android.os.Bundle;
import android.view.FocusFinder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.Random;

public class SoraActivity extends Fragment {
    ImageView img,imageV,image;
    ImageButton start, stop;
    TextView text;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_sora, container, false);

        ImageView img=v.findViewById(R.id.img);
        ImageView imageV=v.findViewById(R.id.imageV);
        ImageView image=v.findViewById(R.id.image);
        ImageButton start=v.findViewById(R.id.startIB);
        ImageButton stop=v.findViewById(R.id.stopIB);
        TextView text=v.findViewById(R.id.text);

        Glide.with(this).load(R.raw.yuio).into(img);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setVisibility(View.VISIBLE);
                imageV.setVisibility(View.INVISIBLE);

            }
        });



        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setVisibility(View.INVISIBLE);
                image.setVisibility(View.VISIBLE);
                String[] randomText=getResources().getStringArray(R.array.randomText);
                Random random=new Random();
                int n=random.nextInt(randomText.length-1);
                AlertDialog.Builder dlg= new AlertDialog.Builder(getActivity());
                dlg.setTitle("소라고동");
                dlg.setMessage(randomText[n]);
                dlg.setPositiveButton("확인",null);
                dlg.show();
            }
        });
        return v;




    }
}
