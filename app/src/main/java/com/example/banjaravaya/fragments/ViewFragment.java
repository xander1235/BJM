package com.example.banjaravaya.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.banjaravaya.R;

public class ViewFragment extends Fragment {

    String basic;

    public ViewFragment(String basic) {
        // Required empty public constructor
        this.basic = basic;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        TextView textView = view.findViewById(R.id.text);
        textView.setText(basic);
        return view;
    }
}