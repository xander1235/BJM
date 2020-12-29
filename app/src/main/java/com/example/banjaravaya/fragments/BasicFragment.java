package com.example.banjaravaya.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.banjaravaya.R;

import java.util.Arrays;
import java.util.List;

public class BasicFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    List<String> heights = Arrays.asList("cm", "ft");
    List<String> profileCreatedBy = Arrays.asList("Father", "mother");
    List<String> profileCratedFor = Arrays.asList("Daughter", "Son");
    List<String> motherTongue = Arrays.asList("Lambadi", "Gormati");
    List<String> martialStatus = Arrays.asList("Single", "Married", "Divorced");
    List<String> physicalStatus = Arrays.asList("Normal", "Physically challenged");

    public BasicFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_basic, container, false);

        Spinner heightSpinner = view.findViewById(R.id.heightSpinner);
        Spinner profileCreatedBySpinner = view.findViewById(R.id.profileCreatedBySpinner);
        Spinner profileCreatedForSpinner = view.findViewById(R.id.profileCreatedForSpinner);
        Spinner motherTongueSpinner = view.findViewById(R.id.motherTongueSpinner);
        Spinner martialStatusSpinner = view.findViewById(R.id.martialStatusSpinner);
        Spinner physicalStatusSpinner = view.findViewById(R.id.physicalStatusSpinner);

        heightSpinner.setOnItemSelectedListener(this);
        profileCreatedBySpinner.setOnItemSelectedListener(this);
        profileCreatedForSpinner.setOnItemSelectedListener(this);
        motherTongueSpinner.setOnItemSelectedListener(this);
        martialStatusSpinner.setOnItemSelectedListener(this);
        physicalStatusSpinner.setOnItemSelectedListener(this);


        ArrayAdapter heightAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, heights);
        heightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        heightSpinner.setAdapter(heightAdapter);

        ArrayAdapter profileCreatedByAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, profileCreatedBy);
        profileCreatedByAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        profileCreatedBySpinner.setAdapter(profileCreatedByAdapter);

        ArrayAdapter profileCreatedForAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, profileCratedFor);
        profileCreatedForAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        profileCreatedForSpinner.setAdapter(profileCreatedForAdapter);

        ArrayAdapter motherTongueAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, motherTongue);
        motherTongueAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        motherTongueSpinner.setAdapter(motherTongueAdapter);

        ArrayAdapter martialStatusAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, martialStatus);
        martialStatusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        martialStatusSpinner.setAdapter(martialStatusAdapter);

        ArrayAdapter physicalStatusAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, physicalStatus);
        physicalStatusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        physicalStatusSpinner.setAdapter(physicalStatusAdapter);

        final EditText fname, sname, email, hght, dob;
        fname = view.findViewById(R.id.firstName);
        sname = view.findViewById(R.id.surname);
        email = view.findViewById(R.id.email);
        hght = view.findViewById(R.id.height);
        dob = view.findViewById(R.id.dateOfBirth);

        Button submit = view.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Basic Details", fname.getText().toString());
                Log.i("Basic Details", sname.getText().toString());
                Log.i("Basic Details", email.getText().toString());
                Log.i("Basic Details", hght.getText().toString());
                Log.i("Basic Details", dob.getText().toString());
                String basic = fname.getText().toString() + " : " + sname.getText().toString() + " : " + email.getText().toString() + " : " + hght.getText().toString() + " : " + dob.getText().toString();

                Log.i("Basic Details", basic);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentLayout, new ViewFragment(basic));
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getContext(), heights.get(position), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}