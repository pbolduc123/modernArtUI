package maahs.coursera.assignments.modernartui;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ColorFragment extends Fragment {

    private TextView tv;

    public ColorFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color, container, false);
        tv = (TextView) view.findViewById(R.id.colorTextView);
        return view;
    }


    public void setBackgroundColor(int argb) {
        tv.setBackgroundColor(argb);
    }
}
