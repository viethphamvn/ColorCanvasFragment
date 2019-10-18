package edu.temple.colorcanvasfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements spinnerfragment.SelectedColorInterface {

    FragmentManager fm;
    final static String Color_Array = "color_array";
    final static String Color_Name = "color_name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerfragment sf = new spinnerfragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray(Color_Array, getResources().getStringArray(R.array.color));

        sf.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.spinner_fragment_placeholder, sf)
                .commit();

    }

    @Override
    public void selectedcolor(String color_name) {
        canvasfragment cf = new canvasfragment();
        Bundle bundle = new Bundle();
        bundle.putString(Color_Name, color_name);

        cf.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.canvas_fragment_placeholder, cf)
                .commit();
    }
}
