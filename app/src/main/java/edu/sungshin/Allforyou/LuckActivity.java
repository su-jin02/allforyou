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
        //animalluckTV = (TextView) v.findViewById(R.id.animallucktext);
        //starluckTV = (TextView) v.findViewById(R.id.starlucktext);

        calendarTV.setText(getTime());

        todayluckTV.setMovementMethod(new ScrollingMovementMethod());
        DocumentReference docRef1 = db.collection("todayluck").document("todayluck");
        docRef1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        todayluckstr = String.valueOf(document.getData());
                        todayluckTV.setText(todayluckstr);
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
        todayluckTV.setScrollY(0);

        todayluckTV2.setMovementMethod(new ScrollingMovementMethod());
        DocumentReference docRef2 = db.collection("todayluck2").document("todayluck2");
        docRef1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        todayluckstr2 = String.valueOf(document.getData());
                        todayluckTV2.setText(todayluckstr2);
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
        todayluckTV2.setScrollY(0);

        return v;
    }

    private String getTime(){
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

}

