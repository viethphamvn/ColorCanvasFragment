package edu.temple.colorcanvasfragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link spinnerfragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link spinnerfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class spinnerfragment extends Fragment {
    private static final String ARG_PARAM1 = "color_array";

    private String[] color;
    private ListView listView;

    private OnFragmentInteractionListener mListener;

    public spinnerfragment() {
        // Required empty public constructor
    }


    public static spinnerfragment newInstance(String[] color) {
        spinnerfragment fragment = new spinnerfragment();
        Bundle args = new Bundle();
        args.putStringArray(ARG_PARAM1, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            color = getArguments().getStringArray(ARG_PARAM1);
        } else {
            throw new NullPointerException();
        }

        ColorAdapter colorAdapter = new ColorAdapter(getActivity(), color.length, color);
        ListView colorlist = (ListView)getView().findViewById(R.id.colorlistview);
        colorlist.setAdapter(colorAdapter);

        colorlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String color_name = ((TextView)view).getText().toString();
                ((SelectedColor)parent).selectedcolor(color_name);
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spinnerfragment, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface SelectedColor {
        // TODO: Update argument type and name
        void selectedcolor(String color_name);
    }
}
