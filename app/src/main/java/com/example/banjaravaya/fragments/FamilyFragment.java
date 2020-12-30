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

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.banjaravaya.R;
import com.example.banjaravaya.pojos.requests.ReqAddFamilyDetails;

import java.util.Arrays;
import java.util.List;

public class FamilyFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    List<String> familyTypeList = Arrays.asList("cm", "ft");
    List<String> familyStatusList = Arrays.asList("Father", "mother");
    List<String> noOfBrothersList = Arrays.asList("Daughter", "Son");
    List<String> noOfSistersList = Arrays.asList("Lambadi", "Gormati");
    List<String> brothersMarriedList = Arrays.asList("Single", "Married", "Divorced");
    List<String> sistersMarriedList = Arrays.asList("Normal", "Physically challenged");

    String familyType, familyStatus, noOfBrothers, noOfSisters, brothersMarried, sistersMarried;

    public FamilyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_family, container, false);

        Spinner familyTypeSpinner = view.findViewById(R.id.familyTypeSpinner);
        Spinner familyStatusSpinner = view.findViewById(R.id.familyStatusSpinner);
        Spinner noOfBrothersSpinner = view.findViewById(R.id.brothersSpinner);
        Spinner noOfSistersSpinner = view.findViewById(R.id.sistersSpinner);
        Spinner brothersMarriedSpinner = view.findViewById(R.id.brothersMarriedSpinner);
        Spinner sistersMarriedSpinner = view.findViewById(R.id.sistersMarriedSpinner);

        familyTypeSpinner.setOnItemSelectedListener(this);
        familyStatusSpinner.setOnItemSelectedListener(this);
        noOfBrothersSpinner.setOnItemSelectedListener(this);
        noOfSistersSpinner.setOnItemSelectedListener(this);
        brothersMarriedSpinner.setOnItemSelectedListener(this);
        sistersMarriedSpinner.setOnItemSelectedListener(this);


        ArrayAdapter familyTypeAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, familyTypeList);
        familyTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        familyTypeSpinner.setAdapter(familyTypeAdapter);

        ArrayAdapter familyStatusAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, familyStatusList);
        familyStatusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        familyStatusSpinner.setAdapter(familyStatusAdapter);

        ArrayAdapter noOfBrothersAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, noOfBrothersList);
        noOfBrothersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        noOfBrothersSpinner.setAdapter(noOfBrothersAdapter);

        ArrayAdapter noOfSistersAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, noOfSistersList);
        noOfSistersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        noOfSistersSpinner.setAdapter(noOfSistersAdapter);

        ArrayAdapter brothersMarriedAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, brothersMarriedList);
        brothersMarriedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brothersMarriedSpinner.setAdapter(brothersMarriedAdapter);

        ArrayAdapter sistersMarriedAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, sistersMarriedList);
        sistersMarriedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sistersMarriedSpinner.setAdapter(sistersMarriedAdapter);

        final EditText mothersOccupation, fathersOccupation, familyOrigin, aboutMyFamily;
        mothersOccupation = view.findViewById(R.id.motherOccupation);
        fathersOccupation = view.findViewById(R.id.fatherOccupation);
        familyOrigin = view.findViewById(R.id.familyOrigin);
        aboutMyFamily = view.findViewById(R.id.aboutMyFamily);

        Button submit = view.findViewById(R.id.save);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReqAddFamilyDetails reqAddFamilyDetails = ReqAddFamilyDetails
                        .builder()
                        .familyType(familyType)
                        .familyStatus(familyStatus)
                        .noOfBrothers(noOfBrothers)
                        .noOfSisters(noOfSisters)
                        .brothersMarried(brothersMarried)
                        .sistersMarried(sistersMarried)
                        .motherOccupation(mothersOccupation.getText().toString())
                        .fatherOccupation(fathersOccupation.getText().toString())
                        .familyOrigin(familyOrigin.getText().toString())
                        .aboutMyFamily(aboutMyFamily.getText().toString())
                        .build();
                Log.i("Family Details", reqAddFamilyDetails.toString());
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentLayout, new ViewFragment(reqAddFamilyDetails.toString()));
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
            case R.id.familyTypeSpinner:
                familyType = familyTypeList.get(position);
                Log.i("Family Type", familyType);
                break;
            case R.id.familyStatusSpinner:
                familyStatus = familyStatusList.get(position);
                Log.i("Family Status", familyStatus);
                break;
            case R.id.brothersSpinner:
                noOfBrothers = noOfBrothersList.get(position);
                Log.i("No of Brothers", noOfBrothers);
                break;
            case R.id.sistersSpinner:
                noOfSisters = noOfSistersList.get(position);
                Log.i("No of Sisters", noOfSisters);
                break;
            case R.id.brothersMarriedSpinner:
                brothersMarried = brothersMarriedList.get(position);
                Log.i("Brothers married", brothersMarried);
                break;
            case R.id.sistersMarriedSpinner:
                sistersMarried = sistersMarriedList.get(position);
                Log.i("Sisters Married", sistersMarried);
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