package com.example.banjaravaya.fragments;

import android.annotation.SuppressLint;
import android.os.Build;
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

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.banjaravaya.R;

import java.util.Arrays;
import java.util.List;

public class BasicFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    List<String> heights = Arrays.asList("cm", "ft");
    List<String> profileCreatedByList = Arrays.asList("Father", "mother");
    List<String> profileCreatedForList = Arrays.asList("Daughter", "Son");
    List<String> motherTongueList = Arrays.asList("Lambadi", "Gormati");
    List<String> martialStatusList = Arrays.asList("Single", "Married", "Divorced");
    List<String> physicalStatusList = Arrays.asList("Normal", "Physically challenged");
    String height, profileCreatedBy, profileCreatedFor, motherTongue, martialStatus, physicalStatus;

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

        ArrayAdapter profileCreatedByAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, profileCreatedByList);
        profileCreatedByAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        profileCreatedBySpinner.setAdapter(profileCreatedByAdapter);

        ArrayAdapter profileCreatedForAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, profileCreatedForList);
        profileCreatedForAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        profileCreatedForSpinner.setAdapter(profileCreatedForAdapter);

        ArrayAdapter motherTongueAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, motherTongueList);
        motherTongueAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        motherTongueSpinner.setAdapter(motherTongueAdapter);

        ArrayAdapter martialStatusAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, martialStatusList);
        martialStatusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        martialStatusSpinner.setAdapter(martialStatusAdapter);

        ArrayAdapter physicalStatusAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, physicalStatusList);
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
                fragmentTransaction.replace(R.id.fragmentLayout, new ProfessionalInfoFragment());
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    @SuppressLint("NonConstantResourceId")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
        switch (adapterView.getId()) {
            case R.id.heightSpinner:
                height = heights.get(position);
                Log.i("height", height);
                break;
            case R.id.profileCreatedBySpinner:
                profileCreatedBy = profileCreatedByList.get(position);
                Log.i("profile created by", profileCreatedBy);
                break;
            case R.id.profileCreatedForSpinner:
                profileCreatedFor = profileCreatedForList.get(position);
                Log.i("profile created for", profileCreatedFor);
                break;
            case R.id.motherTongueSpinner:
                motherTongue = motherTongueList.get(position);
                Log.i("mother tongue", motherTongue);
                break;
            case R.id.martialStatusSpinner:
                martialStatus = martialStatusList.get(position);
                Log.i("martial status", martialStatus);
                break;
            case R.id.physicalStatusSpinner:
                physicalStatus = physicalStatusList.get(position);
                Log.i("physical status", physicalStatus);
                break;
            default:
                Log.e("Unknown spinner id", adapterView.getId() + "");
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}