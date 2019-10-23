package edu.temple.colorcanvasfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements spinnerfragment.SelectedColorInterface {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerfragment sf = spinnerfragment.newInstance(getResources().getStringArray(R.array.color), getResources().getStringArray(R.array.color_display));

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.spinner_fragment_placeholder, sf)
                .commit();

    }

    @Override
    public void selectedcolor(String color_name) {
        canvasfragment cf = canvasfragment.newInstance(color_name);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.canvas_fragment_placeholder, cf)
                .commit();
    }
}
