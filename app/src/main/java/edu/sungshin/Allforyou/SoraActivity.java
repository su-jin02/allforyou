package edu.sungshin.Allforyou;

import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.Random;

public class SoraActivity extends Fragment implements onBackPressedListener {
    ImageView img,imageV,image;
    ImageButton start, stop;
    TextView text;
    MainActivity activity;
    long pressedTime = 0;
    @Override
    public void onBackPressed() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setTitle("종료").setMessage("정말로 앱을 종료하시겠습니까?");
        builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        android.app.AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_sora, container, false);

        String mp3Path = Environment.getExternalStorageDirectory().getPath();
        final MediaPlayer mplayer = MediaPlayer.create(getActivity(), R.raw.sora);
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
                    mplayer.start();
                    mplayer.setLooping(true);
                    img.setVisibility(View.VISIBLE);
                    imageV.setVisibility(View.INVISIBLE);
                    start.setClickable(false);
                    stop.setClickable(true);
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    mplayer.pause();
                    img.setVisibility(View.INVISIBLE);
                    image.setVisibility(View.VISIBLE);
                    String[] randomText = getResources().getStringArray(R.array.randomText);
                    Random random = new Random();
                    int n = random.nextInt(randomText.length - 1);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                    dlg.setTitle("소라고동");
                    dlg.setMessage(randomText[n]);
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                    start.setClickable(true);
                    stop.setClickable(false);
            }
        });

        stop.setClickable(false);
        return v;




    }

}
