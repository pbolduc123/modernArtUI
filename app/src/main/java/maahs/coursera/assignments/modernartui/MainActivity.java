package maahs.coursera.assignments.modernartui;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private static final String URL = "http://www.moma.org/";
    private final List<ColorFragment> fragments = new ArrayList<>(10);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        fragments.add((ColorFragment)fragmentManager.findFragmentById(R.id.fragment1));
        fragments.add((ColorFragment)fragmentManager.findFragmentById(R.id.fragment2));
        fragments.add((ColorFragment)fragmentManager.findFragmentById(R.id.fragment3));
        fragments.add((ColorFragment)fragmentManager.findFragmentById(R.id.fragment4));
        fragments.add((ColorFragment)fragmentManager.findFragmentById(R.id.fragment5));
        fragments.add((ColorFragment)fragmentManager.findFragmentById(R.id.fragment6));
        fragments.add((ColorFragment)fragmentManager.findFragmentById(R.id.fragment7));
        fragments.add((ColorFragment)fragmentManager.findFragmentById(R.id.fragment8));
        fragments.add((ColorFragment)fragmentManager.findFragmentById(R.id.fragment9));
        fragments.add((ColorFragment)fragmentManager.findFragmentById(R.id.fragment10));

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateColorFragments(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        updateColorFragments(0);
    }

    private void updateColorFragments(int progress) {
        for (int i = 0; i < fragments.size();  i++) {
            ColorFragment colorFragment = fragments.get(i);
            if(i == 1 || i == 7)
                colorFragment.setBackgroundColor(Color.rgb(progress, 0, 255));
            if(i == 0 || i == 6 || i == 8)
                colorFragment.setBackgroundColor(Color.rgb(255, progress, 0));
            if(i == 2 || i == 4)
                colorFragment.setBackgroundColor(Color.LTGRAY);
            if(i == 3 || i == 5)
                colorFragment.setBackgroundColor(Color.rgb(progress, 255, 0));
            if(i == 9)
                colorFragment.setBackgroundColor(Color.rgb(progress, 255, progress));
        }
    }

    private int getGreen(int i) {
        return Math.round(((i % 2) + 1) / 2f * 255f);
    }

    private int getRed(int progress, int i) {
        return Math.round(i % 3 * progress / 100f * 255f);
    }

    private int getBlue(int i) {
        return Math.round(((i % 3) + 1) / 3f * 255f);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.more_info) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setPositiveButton(R.string.visit_moma, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                    startActivity(intent);
                }
            });
            builder.setNegativeButton(R.string.not_now, null);
            builder.setTitle(R.string.more_information_title);
            builder.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
