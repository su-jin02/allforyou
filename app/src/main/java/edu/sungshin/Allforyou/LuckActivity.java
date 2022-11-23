package edu.sungshin.Allforyou;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class LuckActivity extends Fragment {
    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy.MM.dd");

    TextView calendarTV;
    TextView todayluckTV;
    TextView todayluckTV2;
    TextView animalluckTV;
    TextView starluckTV;

    String todayluckstr;
    String todayluckstr2;
    String animalluckstr;
    String starluckstr;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_luck, container, false);

        calendarTV = (TextView) v.findViewById(R.id.calendarTV);
        todayluckTV = (TextView) v.findViewById(R.id.todaylucktext1);
        todayluckTV2 = (TextView) v.findViewById(R.id.todaylucktext2);
        animalluckTV = (TextView) v.findViewById(R.id.animallucktext);
        starluckTV = (TextView) v.findViewById(R.id.starlucktext);

        calendarTV.setText(getTime());

        String[] randomText1 = getResources().getStringArray(R.array.todayluckText);
        Random random1 = new Random();
        int n1 = random1.nextInt(randomText1.length-1);
        todayluckTV.setMovementMethod(new ScrollingMovementMethod());
        todayluckTV.setText(randomText1[n1]);
        todayluckTV.setScrollY(0);

        todayluckTV2.setMovementMethod(new ScrollingMovementMethod());
        String[] randomText2 = getResources().getStringArray(R.array.todayluckDetail);
        todayluckTV2.setText(randomText2[n1]);
        todayluckTV2.setScrollY(0);

        String[] randomText3 = getResources().getStringArray(R.array.animalluckText);
        Random random3 = new Random();
        int n3 = random3.nextInt(randomText3.length-1);
        animalluckTV.setMovementMethod(new ScrollingMovementMethod());
        animalluckTV.setText(randomText3[n3]);
        animalluckTV.setScrollY(0);

        String[] randomText4 = getResources().getStringArray(R.array.starluckText);
        Random random4 = new Random();
        int n4 = random4.nextInt(randomText4.length-1);
        starluckTV.setMovementMethod(new ScrollingMovementMethod());
        starluckTV.setText(randomText4[n4]);
        starluckTV.setScrollY(0);

        return v;
    }

    private String getTime(){
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

}

