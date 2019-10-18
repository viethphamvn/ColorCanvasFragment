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

    public spinnerfragment() {
        // Required empty public constructor
    }
    private SelectedColorInterface fragmentParent;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_spinnerfragment, container, false);

        ColorAdapter colorAdapter = new ColorAdapter(getActivity(), color.length, color);
        ListView colorlist = v.findViewById(R.id.colorlistview);
        colorlist.setAdapter(colorAdapter);

        colorlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String color_name = ((TextView)view).getText().toString();
                fragmentParent.selectedcolor(color_name);
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
