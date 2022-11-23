package edu.sungshin.Allforyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class Test1_Result extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,button;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1_result);
        btn1=(Button) findViewById(R.id.btn1); btn9=(Button)findViewById(R.id.btn9); img1=(ImageView)findViewById(R.id.img1); img9=(ImageView)findViewById(R.id.img9);
        btn2=(Button) findViewById(R.id.btn2); btn10=(Button)findViewById(R.id.btn10); img2=(ImageView)findViewById(R.id.img2); img10=(ImageView)findViewById(R.id.img10);
        btn3=(Button) findViewById(R.id.btn3); btn11=(Button)findViewById(R.id.btn11);  img3=(ImageView)findViewById(R.id.img3); img11=(ImageView)findViewById(R.id.img11);
        btn4=(Button) findViewById(R.id.btn4); btn12=(Button)findViewById(R.id.btn12);  img4=(ImageView)findViewById(R.id.img4);  img12=(ImageView)findViewById(R.id.img12);
        btn5=(Button) findViewById(R.id.btn5); btn13=(Button)findViewById(R.id.btn13);  img5=(ImageView)findViewById(R.id.img5);  img13=(ImageView)findViewById(R.id.img13);
        btn6=(Button) findViewById(R.id.btn6); btn14=(Button)findViewById(R.id.btn14);  img6=(ImageView)findViewById(R.id.img6);  img14=(ImageView)findViewById(R.id.img14);
        btn7=(Button) findViewById(R.id.btn7); btn15=(Button)findViewById(R.id.btn15);  img7=(ImageView)findViewById(R.id.img7);  img15=(ImageView)findViewById(R.id.img15);
        btn8=(Button) findViewById(R.id.btn8); btn16=(Button) findViewById(R.id.btn16); img8=(ImageView) findViewById(R.id.img8); img16=(ImageView) findViewById(R.id.img16);
        button=(Button)findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img5.setVisibility(View.INVISIBLE);
                img6.setVisibility(View.INVISIBLE);
                img7.setVisibility(View.INVISIBLE);
                img8.setVisibility(View.INVISIBLE);
                img9.setVisibility(View.INVISIBLE);
                img10.setVisibility(View.INVISIBLE);
                img11.setVisibility(View.INVISIBLE);
                img12.setVisibility(View.INVISIBLE);
                img13.setVisibility(View.INVISIBLE);
                img14.setVisibility(View.INVISIBLE);
                img15.setVisibility(View.INVISIBLE);
                img16.setVisibility(View.INVISIBLE);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.VISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img5.setVisibility(View.INVISIBLE);
                img6.setVisibility(View.INVISIBLE);
                img7.setVisibility(View.INVISIBLE);
                img8.setVisibility(View.INVISIBLE);
                img9.setVisibility(View.INVISIBLE);
                img10.setVisibility(View.INVISIBLE);
                img11.setVisibility(View.INVISIBLE);
                img12.setVisibility(View.INVISIBLE);
                img13.setVisibility(View.INVISIBLE);
                img14.setVisibility(View.INVISIBLE);
                img15.setVisibility(View.INVISIBLE);
                img16.setVisibility(View.INVISIBLE);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.VISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img5.setVisibility(View.INVISIBLE);
                img6.setVisibility(View.INVISIBLE);
                img7.setVisibility(View.INVISIBLE);
                img8.setVisibility(View.INVISIBLE);
                img9.setVisibility(View.INVISIBLE);
                img10.setVisibility(View.INVISIBLE);
                img11.setVisibility(View.INVISIBLE);
                img12.setVisibility(View.INVISIBLE);
                img13.setVisibility(View.INVISIBLE);
                img14.setVisibility(View.INVISIBLE);
                img15.setVisibility(View.INVISIBLE);
                img16.setVisibility(View.INVISIBLE);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.VISIBLE);
                img5.setVisibility(View.INVISIBLE);
                img6.setVisibility(View.INVISIBLE);
                img7.setVisibility(View.INVISIBLE);
                img8.setVisibility(View.INVISIBLE);
                img9.setVisibility(View.INVISIBLE);
                img10.setVisibility(View.INVISIBLE);
                img11.setVisibility(View.INVISIBLE);
                img12.setVisibility(View.INVISIBLE);
                img13.setVisibility(View.INVISIBLE);
                img14.setVisibility(View.INVISIBLE);
                img15.setVisibility(View.INVISIBLE);
                img16.setVisibility(View.INVISIBLE);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img5.setVisibility(View.VISIBLE);
                img6.setVisibility(View.INVISIBLE);
                img7.setVisibility(View.INVISIBLE);
                img8.setVisibility(View.INVISIBLE);
                img9.setVisibility(View.INVISIBLE);
                img10.setVisibility(View.INVISIBLE);
                img11.setVisibility(View.INVISIBLE);
                img12.setVisibility(View.INVISIBLE);
                img13.setVisibility(View.INVISIBLE);
                img14.setVisibility(View.INVISIBLE);
                img15.setVisibility(View.INVISIBLE);
                img16.setVisibility(View.INVISIBLE);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img5.setVisibility(View.INVISIBLE);
                img6.setVisibility(View.VISIBLE);
                img7.setVisibility(View.INVISIBLE);
                img8.setVisibility(View.INVISIBLE);
                img9.setVisibility(View.INVISIBLE);
                img10.setVisibility(View.INVISIBLE);
                img11.setVisibility(View.INVISIBLE);
                img12.setVisibility(View.INVISIBLE);
                img13.setVisibility(View.INVISIBLE);
                img14.setVisibility(View.INVISIBLE);
                img15.setVisibility(View.INVISIBLE);
                img16.setVisibility(View.INVISIBLE);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img5.setVisibility(View.INVISIBLE);
                img6.setVisibility(View.INVISIBLE);
                img7.setVisibility(View.VISIBLE);
                img8.setVisibility(View.INVISIBLE);
                img9.setVisibility(View.INVISIBLE);
                img10.setVisibility(View.INVISIBLE);
                img11.setVisibility(View.INVISIBLE);
                img12.setVisibility(View.INVISIBLE);
                img13.setVisibility(View.INVISIBLE);
                img14.setVisibility(View.INVISIBLE);
                img15.setVisibility(View.INVISIBLE);
                img16.setVisibility(View.INVISIBLE);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img5.setVisibility(View.INVISIBLE);
                img6.setVisibility(View.INVISIBLE);
                img7.setVisibility(View.INVISIBLE);
                img8.setVisibility(View.VISIBLE);
                img9.setVisibility(View.INVISIBLE);
                img10.setVisibility(View.INVISIBLE);
                img11.setVisibility(View.INVISIBLE);
                img12.setVisibility(View.INVISIBLE);
                img13.setVisibility(View.INVISIBLE);
                img14.setVisibility(View.INVISIBLE);
                img15.setVisibility(View.INVISIBLE);
                img16.setVisibility(View.INVISIBLE);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img5.setVisibility(View.INVISIBLE);
                img6.setVisibility(View.INVISIBLE);
                img7.setVisibility(View.INVISIBLE);
                img8.setVisibility(View.INVISIBLE);
                img9.setVisibility(View.VISIBLE);
                img10.setVisibility(View.INVISIBLE);
                img11.setVisibility(View.INVISIBLE);
                img12.setVisibility(View.INVISIBLE);
                img13.setVisibility(View.INVISIBLE);
                img14.setVisibility(View.INVISIBLE);
                img15.setVisibility(View.INVISIBLE);
                img16.setVisibility(View.INVISIBLE);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img5.setVisibility(View.INVISIBLE);
                img6.setVisibility(View.INVISIBLE);
                img7.setVisibility(View.INVISIBLE);
                img8.setVisibility(View.INVISIBLE);
                img9.setVisibility(View.INVISIBLE);
                img10.setVisibility(View.VISIBLE);
                img11.setVisibility(View.INVISIBLE);
                img12.setVisibility(View.INVISIBLE);
                img13.setVisibility(View.INVISIBLE);
                img14.setVisibility(View.INVISIBLE);
                img15.setVisibility(View.INVISIBLE);
                img16.setVisibility(View.INVISIBLE);
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img5.setVisibility(View.INVISIBLE);
                img6.setVisibility(View.INVISIBLE);
                img7.setVisibility(View.INVISIBLE);
                img8.setVisibility(View.INVISIBLE);
                img9.setVisibility(View.INVISIBLE);
                img10.setVisibility(View.INVISIBLE);
                img11.setVisibility(View.VISIBLE);
                img12.setVisibility(View.INVISIBLE);
                img13.setVisibility(View.INVISIBLE);
                img14.setVisibility(View.INVISIBLE);
                img15.setVisibility(View.INVISIBLE);
                img16.setVisibility(View.INVISIBLE);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img5.setVisibility(View.INVISIBLE);
                img6.setVisibility(View.INVISIBLE);
                img7.setVisibility(View.INVISIBLE);
                img8.setVisibility(View.INVISIBLE);
                img9.setVisibility(View.INVISIBLE);
                img10.setVisibility(View.INVISIBLE);
                img11.setVisibility(View.INVISIBLE);
                img12.setVisibility(View.VISIBLE);
                img13.setVisibility(View.INVISIBLE);
                img14.setVisibility(View.INVISIBLE);
                img15.setVisibility(View.INVISIBLE);
                img16.setVisibility(View.INVISIBLE);
            }
        });
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img5.setVisibility(View.INVISIBLE);
                img6.setVisibility(View.INVISIBLE);
                img7.setVisibility(View.INVISIBLE);
                img8.setVisibility(View.INVISIBLE);
                img9.setVisibility(View.INVISIBLE);
                img10.setVisibility(View.INVISIBLE);
                img11.setVisibility(View.INVISIBLE);
                img12.setVisibility(View.INVISIBLE);
                img13.setVisibility(View.VISIBLE);
                img14.setVisibility(View.INVISIBLE);
                img15.setVisibility(View.INVISIBLE);
                img16.setVisibility(View.INVISIBLE);
            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img5.setVisibility(View.INVISIBLE);
                img6.setVisibility(View.INVISIBLE);
                img7.setVisibility(View.INVISIBLE);
                img8.setVisibility(View.INVISIBLE);
                img9.setVisibility(View.INVISIBLE);
                img10.setVisibility(View.INVISIBLE);
                img11.setVisibility(View.INVISIBLE);
                img12.setVisibility(View.INVISIBLE);
                img13.setVisibility(View.INVISIBLE);
                img14.setVisibility(View.VISIBLE);
                img15.setVisibility(View.INVISIBLE);
                img16.setVisibility(View.INVISIBLE);
            }
        });
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img5.setVisibility(View.INVISIBLE);
                img6.setVisibility(View.INVISIBLE);
                img7.setVisibility(View.INVISIBLE);
                img8.setVisibility(View.INVISIBLE);
                img9.setVisibility(View.INVISIBLE);
                img10.setVisibility(View.INVISIBLE);
                img11.setVisibility(View.INVISIBLE);
                img12.setVisibility(View.INVISIBLE);
                img13.setVisibility(View.INVISIBLE);
                img14.setVisibility(View.INVISIBLE);
                img15.setVisibility(View.VISIBLE);
                img16.setVisibility(View.INVISIBLE);
            }
        });
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img5.setVisibility(View.INVISIBLE);
                img6.setVisibility(View.INVISIBLE);
                img7.setVisibility(View.INVISIBLE);
                img8.setVisibility(View.INVISIBLE);
                img9.setVisibility(View.INVISIBLE);
                img10.setVisibility(View.INVISIBLE);
                img11.setVisibility(View.INVISIBLE);
                img12.setVisibility(View.INVISIBLE);
                img13.setVisibility(View.INVISIBLE);
                img14.setVisibility(View.INVISIBLE);
                img15.setVisibility(View.INVISIBLE);
                img16.setVisibility(View.VISIBLE);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ByteArrayOutputStream stream=new ByteArrayOutputStream();
                Bitmap bitmap=((BitmapDrawable)img1.getDrawable()).getBitmap();
                float scale=(float) (1020/(float)bitmap.getWidth());
                int img_w=(int)(bitmap.getWidth()*scale);
                int img_h=(int)(bitmap.getHeight()*scale);
                Bitmap resize=Bitmap.createScaledBitmap(bitmap,img_w,img_h,true);
                resize.compress(Bitmap.CompressFormat.PNG,100,stream);
                byte[]array=stream.toByteArray();

                Intent intent=new Intent(getApplicationContext(),Test1_result_show.class);
                intent.putExtra("image",array);

                startActivity(intent);
            }
        });
    }
}