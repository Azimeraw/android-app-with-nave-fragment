package com.example.prote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class Frag1 extends Fragment {
    private AdView nadView;
    WebView nbweb;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View v = inflater.inflate(R.layout.fragment_frag1, container, false);
        nadView = (AdView)v. findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        nadView.loadAd(adRequest);
        nbweb=(WebView)v.findViewById(R.id.btnbook1);
        nbweb.getSettings().setJavaScriptEnabled(true);
        nbweb.setWebViewClient(new WebViewClient());
        nbweb.loadUrl("file:///android_asset/t.html");
        return v;
    }
}