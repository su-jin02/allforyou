package edu.sungshin.Allforyou;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;

import org.checkerframework.checker.units.qual.C;


public class Test1Activity extends Fragment implements onBackPressedListener {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24;
    Integer cnt1=0;
    Integer cnt2=0;
    Integer cnt3=0;
    Integer cnt4=0;
    TextView txt1,txt2,txt3,txt4,txt5;
    String text;

    @Override
    public void onBackPressed() {
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
        getActivity().getSupportFragmentManager().popBackStack();
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.activity_test1, container, false);
        btn1=(Button) v.findViewById(R.id.btn1); btn13=(Button)v.findViewById(R.id.btn13);
        btn2=(Button) v.findViewById(R.id.btn2); btn14=(Button)v.findViewById(R.id.btn14);
        btn3=(Button) v.findViewById(R.id.btn3); btn15=(Button)v.findViewById(R.id.btn15);
        btn4=(Button) v.findViewById(R.id.btn4); btn16=(Button)v.findViewById(R.id.btn16);
        btn5=(Button) v.findViewById(R.id.btn5); btn17=(Button)v.findViewById(R.id.btn17);
        btn6=(Button) v.findViewById(R.id.btn6); btn18=(Button)v.findViewById(R.id.btn18);
        btn7=(Button) v.findViewById(R.id.btn7); btn19=(Button)v.findViewById(R.id.btn19);
        btn8=(Button) v.findViewById(R.id.btn8); btn20=(Button)v.findViewById(R.id.btn20);
        btn9=(Button) v.findViewById(R.id.btn9); btn21=(Button)v.findViewById(R.id.btn21);
        btn10=(Button) v.findViewById(R.id.btn10); btn22=(Button)v.findViewById(R.id.btn22);
        btn11=(Button) v.findViewById(R.id.btn11); btn23=(Button)v.findViewById(R.id.btn23);
        btn12=(Button) v.findViewById(R.id.btn12); btn24=(Button) v.findViewById(R.id.btn24);
        txt1=(TextView)v.findViewById(R.id.text1);
        txt2=(TextView)v.findViewById(R.id.text2);
        txt3=(TextView)v.findViewById(R.id.text3);
        txt4=(TextView)v.findViewById(R.id.text4);


        btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                    btn1.setBackgroundColor(Color.parseColor("#DDD3F8"));
                    btn2.setBackgroundColor(Color.TRANSPARENT);

                return false;
            }
        });
        btn2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                    btn2.setBackgroundColor(Color.parseColor("#DDD3F8"));
                    btn1.setBackgroundColor(Color.TRANSPARENT);

                return false;
            }
        });
        btn3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                    btn3.setBackgroundColor(Color.parseColor("#DDD3F8"));
                    btn4.setBackgroundColor(Color.TRANSPARENT);

                return false;
            }
        });
        btn4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
                    btn4.setBackgroundColor(Color.parseColor("#DDD3F8"));
                    btn3.setBackgroundColor(Color.TRANSPARENT);
                }
                return false;
            }
        });
        btn5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
                    btn5.setBackgroundColor(Color.parseColor("#DDD3F8"));
                    btn6.setBackgroundColor(Color.TRANSPARENT);
                }
                return false;
            }
        });
        btn6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                btn6.setBackgroundColor(Color.parseColor("#DDD3F8"));
                btn5.setBackgroundColor(Color.TRANSPARENT);
                return false;
            }
        });
        btn7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
                    btn7.setBackgroundColor(Color.parseColor("#DDD3F8"));
                    btn8.setBackgroundColor(Color.TRANSPARENT);
                    cnt1++;
                }
                button1();
                return false;
            }
        });
        btn8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
                    btn8.setBackgroundColor(Color.parseColor("#DDD3F8"));
                    btn7.setBackgroundColor(Color.TRANSPARENT);
                    cnt1--;
                }
                button1();
                return false;
            }
        });
        btn9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                btn9.setBackgroundColor(Color.parseColor("#DDD3F8"));
                btn10.setBackgroundColor(Color.TRANSPARENT);

                return false;
            }
        });
        btn10.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                btn10.setBackgroundColor(Color.parseColor("#DDD3F8"));
                btn9.setBackgroundColor(Color.TRANSPARENT);
                return false;
            }
        });
        btn11.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                btn11.setBackgroundColor(Color.parseColor("#DDD3F8"));
                btn12.setBackgroundColor(Color.TRANSPARENT);
                return false;
            }
        });
        btn12.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                btn12.setBackgroundColor(Color.parseColor("#DDD3F8"));
                btn11.setBackgroundColor(Color.TRANSPARENT);
                return false;
            }
        });
        btn13.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                btn13.setBackgroundColor(Color.parseColor("#DDD3F8"));
                btn14.setBackgroundColor(Color.TRANSPARENT);
                return false;
            }
        });
        btn14.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                btn14.setBackgroundColor(Color.parseColor("#DDD3F8"));
                btn13.setBackgroundColor(Color.TRANSPARENT);
                return false;
            }
        });
        btn15.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                btn15.setBackgroundColor(Color.parseColor("#DDD3F8"));
                btn16.setBackgroundColor(Color.TRANSPARENT);
                return false;
            }
        });
        btn16.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                btn16.setBackgroundColor(Color.parseColor("#DDD3F8"));
                btn15.setBackgroundColor(Color.TRANSPARENT);
                return false;
            }
        });
        btn17.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                btn17.setBackgroundColor(Color.parseColor("#DDD3F8"));
                btn18.setBackgroundColor(Color.TRANSPARENT);
                return false;
            }
        });
        btn18.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                btn18.setBackgroundColor(Color.parseColor("#DDD3F8"));
                btn17.setBackgroundColor(Color.TRANSPARENT);
                return false;
            }
        });
        btn19.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
                    btn19.setBackgroundColor(Color.parseColor("#DDD3F8"));
                    btn20.setBackgroundColor(Color.TRANSPARENT);
                    cnt2++;
                }
                button2();
                return false;
            }
        });
        btn20.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
                    btn20.setBackgroundColor(Color.parseColor("#DDD3F8"));
                    btn19.setBackgroundColor(Color.TRANSPARENT);
                    cnt2--;
                }
                button2();
                return false;
            }
        });
        btn21.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
                    btn21.setBackgroundColor(Color.parseColor("#DDD3F8"));
                    btn22.setBackgroundColor(Color.TRANSPARENT);
                    cnt3++;
                }
                button3();
                return false;
            }
        });
        btn22.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
                    btn22.setBackgroundColor(Color.parseColor("#DDD3F8"));
                    btn21.setBackgroundColor(Color.TRANSPARENT);
                    cnt3--;
                }
                button3();
                return false;
            }
        });
        btn23.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
                    btn23.setBackgroundColor(Color.parseColor("#DDD3F8"));
                    btn24.setBackgroundColor(Color.TRANSPARENT);
                    cnt4++;
                }
                button4();
                return false;
            }
        });
        btn24.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
                    btn24.setBackgroundColor(Color.parseColor("#DDD3F8"));
                    btn23.setBackgroundColor(Color.TRANSPARENT);
                    cnt4--;
                }
                button4();
                return false;
            }
        });



        return v;
    }
    public void button1(){
        if(cnt1>0)
            txt1.setText("N");
        else if(cnt1<=0)
            txt1.setText("S");
    }
    public void button2(){
        if(cnt2>0)
            txt2.setText("E");
        else if(cnt2<=0)
            txt2.setText("I");
    }
    public void button3(){
        if(cnt3>0)
            txt3.setText("T");
        else if(cnt3<=0)
            txt3.setText("F");
    }
    public void button4(){
        if(cnt4>0)
            txt4.setText("P");
        else if(cnt4<=0)
            txt4.setText("J");
    }


}