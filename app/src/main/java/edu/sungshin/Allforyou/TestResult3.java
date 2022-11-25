package edu.sungshin.Allforyou;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TestResult3 extends AppCompatActivity {
    TextView text1, text2, text3, text4, text5;
    RadioButton r11, r12, r13, r14, r21, r22, r31, r32, r33, r34, r35, r36, r41, r42, r43, r44, r51, r52, r53;
    RadioGroup radio1, radio2, radio3, radio4, radio5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test3result);

        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        text5 = (TextView) findViewById(R.id.text5);
        r11 = (RadioButton) findViewById(R.id.r11);
        r12 = (RadioButton) findViewById(R.id.r12);
        r13 = (RadioButton) findViewById(R.id.r13);
        r14 = (RadioButton) findViewById(R.id.r14);
        r21 = (RadioButton) findViewById(R.id.r21);
        r22 = (RadioButton) findViewById(R.id.r22);
        r31 = (RadioButton) findViewById(R.id.r31);
        r32 = (RadioButton) findViewById(R.id.r32);
        r33 = (RadioButton) findViewById(R.id.r33);
        r34 = (RadioButton) findViewById(R.id.r34);
        r35 = (RadioButton) findViewById(R.id.r35);
        r36 = (RadioButton) findViewById(R.id.r36);
        r41 = (RadioButton) findViewById(R.id.r41);
        r42 = (RadioButton) findViewById(R.id.r42);
        r43 = (RadioButton) findViewById(R.id.r43);
        r44 = (RadioButton) findViewById(R.id.r44);
        r51 = (RadioButton) findViewById(R.id.r51);
        r52 = (RadioButton) findViewById(R.id.r52);
        r53 = (RadioButton) findViewById(R.id.r53);
        radio1 = (RadioGroup) findViewById(R.id.radio1);
        radio2 = (RadioGroup) findViewById(R.id.radio2);
        radio3 = (RadioGroup) findViewById(R.id.radio3);
        radio4 = (RadioGroup) findViewById(R.id.radio4);
        radio5 = (RadioGroup) findViewById(R.id.radio5);


        radio1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.r11:
                        text1.setText("내적 사고 활동을 회피하고 억제하는 경향을 반영하며,내성적인 성격의 사람이 많다");
                        break;
                    case R.id.r12:
                        text1.setText("내적 인지 활동을 매우 중요하게 여기며,자아가 몹시 강하고 고집이 세다. 자기 주장이 틀려도 인정하지 않으며 대인관계에서 좌절감을 경험하여 내적 공상 속에서 즐거움과 욕구를 충족함");
                        break;
                    case R.id.r13:
                        text1.setText("공상에 많이 몰두하고 있으며,생각이 많고 심한 경우 우울증이나 자폐적 공상이 있을 수 있음");
                        break;
                    case R.id.r14:
                        text1.setText("강박적인 경향이 있으며,과거에 지나치게 집착하며 불안한 심리 상태를 가지고 있음");
                        break;
                }
            }
        });


        radio2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.r21:
                        text2.setText("적당한 연기는 일반적이나, 과한 연기의 경우 애정 욕구의 결핍감을 나타냄");
                        break;
                    case R.id.r22:
                        text2.setText("강박 증세가 있으며, 가족과의 관계에 지나치게 집착하고 있을 수 있음");
                        break;

                }
            }
        });


        radio3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.r31:
                        text3.setText("정서적으로 고립된 상태로 대인 기피증이 있을 수 있음");
                        break;
                    case R.id.r32:
                        text3.setText("환경과의 접촉을 꺼리는 경우가 있으며, 다른 사람과의 관계를 맺고 싶은 욕구는 있으나 거부감 등의 양가감정을 지니고 있음. 대인관계의 능력이 부족하며 자신의 경계를 침범당하기를 두려워함");
                        break;
                    case R.id.r33:
                        text3.setText("자신의 사회적인 위치에 관심이 많은 사람에게 나타나며, 정서적 따뜻함을 받고 싶은 욕구가 있으며 남들이 자신을 평가하는 것을 지나치게 신경 쓰기에 정신적으로 피곤함");
                        break;
                    case R.id.r34:
                        text3.setText("타인과 만나는 것을 어려워하거나 불편해서 싫어하는 경우가 다수이며, 세상으로 나가는 좀 더 다른 길을 찾고 싶은 소망을 의미함");
                        break;
                    case R.id.r35:
                        text3.setText("외부 환경이나 대인고의 접촉에 대해 매우 방어적이고 경계하며, 편집증적 경향이 강한 사람들에게 나타남");
                        break;
                    case R.id.r36:
                        text3.setText("다른 사람과의 관계에 집착하는 경향을 지니며, 디테일하게 그릴수록 그 정도가 심함");
                        break;

                }
            }
        });
        radio4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.r41:
                        text4.setText("남들이 나를 보지 못하도록 회피하는 경향이 있음");
                        break;
                    case R.id.r42:
                        text4.setText("성적 요구를 표현하며, 과하게 자신을 개방하고 남들과 관계를 맺고싶어함. 타인과 생각 이상으로 가까워지고 싶어하는 소망을 지니며 가족이나 주변 사람의 사생활을 침범하지 않는 성격이기도 함");
                        break;
                    case R.id.r43:
                        text4.setText("자신의 집을 불편하고 답답하게 생각하거나 안정적인 가정을 원하는 것임");
                        break;

                    case R.id.r44:
                        text4.setText("자신이 외로운 감정이나 감추고 싶은 마음이 있음을 뜻함");
                        break;

                }
            }
        });
        radio5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.r51:
                        text5.setText("가정형편이나 상황에 불만을 가지고 있고 벗어나고 싶은 욕망을 나타냄");
                        break;
                    case R.id.r52:
                        text5.setText("가족 관계를 비롯한 친밀한 관계에 대해 거절이나 거부당한 느낌을 가지며, 자신감이 부족하고 열등감, 부적절감, 자기비하적 태도 등을 반영함");
                        break;
                    case R.id.r53:
                        text5.setText("가족 구성원들과 마음이 맞지 않으며, 가족들과 함께하고 싶지 않음을 의미함");
                        break;

                }
            }
        });

    }
}

