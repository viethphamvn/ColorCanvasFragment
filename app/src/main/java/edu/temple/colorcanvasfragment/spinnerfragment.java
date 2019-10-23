package edu.temple.colorcanvasfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;


public class spinnerfragment extends Fragment {
    private static final String ARG_PARAM1 = "color_array";
    private static final String ARG_PARAM2 = "color_display_array";

    private String[] color;
    private String[] color_display;

    public spinnerfragment() {
        // Required empty public constructor
    }
    private SelectedColorInterface fragmentParent;

    public static spinnerfragment newInstance(String[] color, String[] color_display) {
        spinnerfragment fragment = new spinnerfragment();
        Bundle args = new Bundle();
        args.putStringArray(ARG_PARAM1, color);
        args.putStringArray(ARG_PARAM2, color_display);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            color = getArguments().getStringArray(ARG_PARAM1);
            color_display = getArguments().getStringArray(ARG_PARAM2);
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_spinnerfragment, container, false);

        ColorAdapter colorAdapter = new ColorAdapter(getActivity(), color.length, color, color_display);
        Spinner spinner = v.findViewById(R.id.colorspinner);
        spinner.setAdapter(colorAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color_name = color[position];
                fragmentParent.selectedcolor(color_name);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof SelectedColorInterface) {
            fragmentParent = (SelectedColorInterface) context;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface SelectedColorInterface {
        // TODO: Update argument type and name
        void selectedcolor(String color_name);
    }
}
