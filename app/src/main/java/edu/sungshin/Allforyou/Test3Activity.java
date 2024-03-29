package edu.sungshin.Allforyou;
import static edu.sungshin.Allforyou.MainActivity.n;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Test3Activity extends Fragment implements onBackPressedListener {
    private int count = 0;

    Button start;

    @Override
    public void onBackPressed() {
            getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
            getActivity().getSupportFragmentManager().popBackStack();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_test3_1, container, false);
        start = (Button) view.findViewById(R.id.start);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Test3Activity3.class);
                startActivity(intent);
            }
        });
        return view;
    }
}