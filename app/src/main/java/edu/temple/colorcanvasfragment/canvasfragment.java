package edu.temple.colorcanvasfragment;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link canvasfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class canvasfragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "color_name";

    // TODO: Rename and change types of parameters
    private String mParam1;


    public canvasfragment() {
        // Required empty public constructor
    }

    public static canvasfragment newInstance(String param1) {
        canvasfragment fragment = new canvasfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout v = (LinearLayout)inflater.inflate(R.layout.fragment_canvasfragment, container, false);
        try {
            v.setBackgroundColor(Color.parseColor(mParam1));
        } catch (Exception e){
            v.setBackgroundColor(Color.WHITE);
        }
        return v;
}

}
