package com.example.prote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.GridView;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag4 extends Fragment {
GridView gridView;
GridAdapter gridAdapter;
String[] name;
int[] image;
    public Frag4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_frag4, container, false);
        WebView btbweb=(WebView) v.findViewById(R.id.wbaz);

        btbweb.loadUrl("file:///android_asset/samycontactlist.html");

       /* Button button=(Button)v.findViewById(R.id.btnazm) ;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"hhhhhhhhhhhhhhhhhhhhhh",Toast.LENGTH_SHORT);
            }
        });*/
        return v;
    }
}
