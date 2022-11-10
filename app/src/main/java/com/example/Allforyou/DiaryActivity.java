package com.example.Allforyou;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class DiaryActivity extends Fragment {

    CalendarView calendarView;
    Button btnadd;
    EditText edittext;
    String fileName;


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_diary, container, false);

        Button btnadd = v.findViewById(R.id.btnadd);
        EditText edittext = v.findViewById(R.id.edittext);
        CalendarView calendarView = v.findViewById(R.id.calendarView);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        // 처음 실행시에 설정할 내용
        fileName = Integer.toString(cYear) + "_" + Integer.toString(cMonth + 1)
                + "_" + Integer.toString(cDay) + ".txt";

        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = getActivity().openFileInput(fileName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
            btnadd.setText("수정 하기");
        } catch (IOException e) {
            edittext.setHint("해당 날짜 일기 없음");
            btnadd.setText("새로 저장");
        }
        String str = diaryStr;

        edittext.setText(str);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + "_"
                        + Integer.toString(monthOfYear + 1) + "_"
                        + Integer.toString(dayOfMonth) + ".txt";

                String diaryStr = null;
                FileInputStream inFs;
                try {
                    inFs = getActivity().openFileInput(fileName);
                    byte[] txt = new byte[500];
                    inFs.read(txt);
                    inFs.close();
                    diaryStr = (new String(txt)).trim();
                    btnadd.setText("수정 하기");
                } catch (IOException e) {
                    edittext.setHint("해당 날짜 일기 없음");
                    btnadd.setText("새로 저장");
                }
                String str = diaryStr;

                edittext.setText(str);
                btnadd.setEnabled(true);
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = getActivity().openFileOutput(fileName,
                            Context.MODE_PRIVATE);
                    String str = edittext.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
//                    Toast.makeText(getApplicationContext(),
//                            fileName + " 이 저장됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }
            }
        });

        return v;
    }

}

