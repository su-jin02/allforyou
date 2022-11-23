package edu.sungshin.Allforyou;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DiaryActivity extends Fragment {

    myDBHelper myHelper;
    SQLiteDatabase sqlDB;
    CalendarView calendarView;
    EditText edt;
    TextView date;
    Button btn;
    String fileName;

    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "eduDB", null, 1);
        }


        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE eduDiary ( diaryDate char(10), content varchar(500));");
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS eduDiary");
            onCreate(db);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_diary, container, false);


        calendarView = v.findViewById(R.id.calendarView);
        edt = v.findViewById(R.id.edt);
        btn = v.findViewById(R.id.btn);
        date = v.findViewById(R.id.date);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);
        myHelper = new myDBHelper(getActivity());

        //오늘 날짜 지정
        Date mDate;
        SimpleDateFormat mFormat = new SimpleDateFormat("yyyy.MM.dd");
        mDate = new Date(System.currentTimeMillis());
        date.setText(mFormat.format(mDate));


        //일기장 저장
        fileName = Integer.toString(cYear) + "_"
                + Integer.toString(cMonth) + "_"
                + Integer.toString(cDay + 1);

        sqlDB = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB.rawQuery("SELECT * FROM eduDiary WHERE diaryDate = '" +
                fileName + "';", null);

        if (cursor.getCount() == 0) {
            edt.setText("");
            edt.setHint("일기 없음");
            btn.setText("새로 저장");
        } else {
            cursor.moveToNext();
            edt.setText(cursor.getString(0));
            btn.setText("수정하기");
        }
        cursor.close();
        sqlDB.close();
        btn.setEnabled(true);


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int monthOfMonth, int dayOfMonth) {
                fileName = Integer.toString(year) + "_"
                        + Integer.toString(monthOfMonth + 1) + "_"
                        + Integer.toString(dayOfMonth);

                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT content FROM eduDiary WHERE diaryDate = '" + fileName + "';", null);
                if (cursor.getCount() == 0) {
                    edt.setText("");
                    edt.setHint("일기 없음");
                    btn.setText("새로 저장");
                } else {
                    cursor.moveToNext();
                    edt.setText(cursor.getString(0));
                    btn.setText("수정하기");
                }
                cursor.close();
                sqlDB.close();
                btn.setEnabled(true);
            }

        });


        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (btn.getText().equals("수정하기")) {
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("UPDATE eduDiary SET content = '" + edt.getText().toString() +
                            "' WHERE diaryDate = '" + fileName + "';");
                    sqlDB.close();
                    Toast.makeText(getActivity().getApplicationContext(), "내용이 수정되었습니다.", Toast.LENGTH_SHORT).show();

                } else {
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("INSERT INTO eduDiary (diaryDate, content) VALUES ('" + fileName + "' , '" + edt.getText().toString() + "');");
                    sqlDB.close();
                    Toast.makeText(getActivity().getApplicationContext(), "내용이 저장되었습니다.", Toast.LENGTH_SHORT).show();
                    btn.setText("수정하기");
                }

            }

        });


        return v;

    }




}