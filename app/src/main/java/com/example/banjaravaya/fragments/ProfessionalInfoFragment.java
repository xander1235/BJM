package com.example.banjaravaya.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.banjaravaya.R;
import com.example.banjaravaya.pojos.requests.ReqAddProfessionalInfo;

import java.util.Arrays;
import java.util.List;

public class ProfessionalInfoFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    List<String> educationList = Arrays.asList("B.Sc", "M.Sc");
    List<String> employedInList = Arrays.asList("Government", "Private", "Self-Employed");
    List<String> occupationList = Arrays.asList("Agriculture & Farming", "Manager");
    List<String> currencyTypeList = Arrays.asList("INR", "USD");
    List<String> annualIncomeList = Arrays.asList("3-4", "4-5", "5-6");

    String education, employedIn, occupation, currencyType, annualIncome;

    public ProfessionalInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_professional_info, container, false);

        Spinner educationSpinner = view.findViewById(R.id.educationSpinner);
        Spinner employedInSpinner = view.findViewById(R.id.employedInSpinner);
        Spinner occupationSpinner = view.findViewById(R.id.occupationSpinner);
        Spinner currencyTypeSpinner = view.findViewById(R.id.currencyTypeSpinner);
        Spinner annualIncomeSpinner = view.findViewById(R.id.annualIncomeSpinner);

        educationSpinner.setOnItemSelectedListener(this);
        employedInSpinner.setOnItemSelectedListener(this);
        occupationSpinner.setOnItemSelectedListener(this);
        currencyTypeSpinner.setOnItemSelectedListener(this);
        annualIncomeSpinner.setOnItemSelectedListener(this);

        ArrayAdapter educationAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, educationList);
        educationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        educationSpinner.setAdapter(educationAdapter);

        ArrayAdapter employedInAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, employedInList);
        employedInAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        employedInSpinner.setAdapter(employedInAdapter);

        ArrayAdapter occupationAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, occupationList);
        occupationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        occupationSpinner.setAdapter(occupationAdapter);

        ArrayAdapter currencyTypeAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, currencyTypeList);
        currencyTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencyTypeSpinner.setAdapter(occupationAdapter);

        ArrayAdapter annualIncomeAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, annualIncomeList);
        annualIncomeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        annualIncomeSpinner.setAdapter(annualIncomeAdapter);

        final EditText educationDetail, occupationDetail, college;

        educationDetail = view.findViewById(R.id.educationDetail);
        occupationDetail = view.findViewById(R.id.occupationDetail);
        college = view.findViewById(R.id.college);

        Button submit = view.findViewById(R.id.save);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReqAddProfessionalInfo reqAddProfessionalInfo = ReqAddProfessionalInfo.builder()
                        .education(education)
                        .educationDetails(educationDetail.getText().toString())
                        .employedIn(employedIn)
                        .occupation(occupation)
                        .occupationDetails(occupationDetail.getText().toString())
                        .currencyType(currencyType)
                        .annualIncome(annualIncome)
                        .college(college.getText().toString())
                        .build();

                Log.i("Professional Info", reqAddProfessionalInfo.toString());
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentLayout, new LocationReligiousHabitsFragment());
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        switch (adapterView.getId()) {
            case R.id.educationSpinner:
                education = educationList.get(position);
                Log.i("education", education);
                break;
            case R.id.employedInSpinner:
                employedIn = employedInList.get(position);
                Log.i("employed in", employedIn);
                break;
            case R.id.occupationSpinner:
                occupation = occupationList.get(position);
                Log.i("occupation", occupation);
                break;
            case R.id.currencyTypeSpinner:
                currencyType = currencyTypeList.get(position);
                Log.i("currency type", currencyType);
                break;
            case R.id.annualIncomeSpinner:
                annualIncome = annualIncomeList.get(position);
                Log.i("annual income", annualIncome);
                break;
            default:
                Log.e("Unknown spinner id", adapterView.getId() + "");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}