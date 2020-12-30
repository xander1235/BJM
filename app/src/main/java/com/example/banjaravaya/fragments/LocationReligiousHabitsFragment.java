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

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.banjaravaya.R;
import com.example.banjaravaya.pojos.dtos.Habits;
import com.example.banjaravaya.pojos.dtos.Location;
import com.example.banjaravaya.pojos.dtos.ReligiousInfo;
import com.example.banjaravaya.pojos.requests.ReqAddLocationReligiousHabits;

import java.util.Arrays;
import java.util.List;

public class LocationReligiousHabitsFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    List<String> countries = Arrays.asList("cm", "ft");
    List<String> states = Arrays.asList("Father", "mother");
    List<String> cities = Arrays.asList("Daughter", "Son");
    List<String> citizenshipList = Arrays.asList("Lambadi", "Gormati");
    List<String> stars = Arrays.asList("Single", "Married", "Divorced");
    List<String> rasiList = Arrays.asList("Normal", "Physically challenged");
    List<String> kujaDoshamList = Arrays.asList("Normal", "Physically challenged");
    List<String> eatingHabits = Arrays.asList("Lambadi", "Gormati");
    List<String> drinkingHabits = Arrays.asList("Single", "Married", "Divorced");
    List<String> smokingHabits = Arrays.asList("Normal", "Physically challenged");

    String country, state, city, citizenship, star, rasi, kujaDosham, eatingHabit, drinkingHabit, smokingHabit;

    public LocationReligiousHabitsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location_religious_habits, container, false);

        Spinner countriesSpinner = view.findViewById(R.id.countrySpinner);
        Spinner statesSpinner = view.findViewById(R.id.stateSpinner);
        Spinner citiesSpinner = view.findViewById(R.id.citySpinner);
        Spinner citizenshipSpinner = view.findViewById(R.id.citizenshipSpinner);
        Spinner starsSpinner = view.findViewById(R.id.starSpinner);
        Spinner rasiSpinner = view.findViewById(R.id.rasiSpinner);
        Spinner kujaDoshamSpinner = view.findViewById(R.id.kujaDoshamSpinner);
        Spinner eatingSpinner = view.findViewById(R.id.eatingSpinner);
        Spinner drinkingSpinner = view.findViewById(R.id.drinkingSpinner);
        Spinner smokingSpinner = view.findViewById(R.id.smokingSpinner);

        countriesSpinner.setOnItemSelectedListener(this);
        statesSpinner.setOnItemSelectedListener(this);
        citiesSpinner.setOnItemSelectedListener(this);
        citizenshipSpinner.setOnItemSelectedListener(this);
        starsSpinner.setOnItemSelectedListener(this);
        rasiSpinner.setOnItemSelectedListener(this);
        kujaDoshamSpinner.setOnItemSelectedListener(this);
        eatingSpinner.setOnItemSelectedListener(this);
        drinkingSpinner.setOnItemSelectedListener(this);
        smokingSpinner.setOnItemSelectedListener(this);


        ArrayAdapter countriesAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, countries);
        countriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countriesSpinner.setAdapter(countriesAdapter);

        ArrayAdapter statesAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, states);
        statesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statesSpinner.setAdapter(statesAdapter);

        ArrayAdapter citiesAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, cities);
        citiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citiesSpinner.setAdapter(citiesAdapter);

        ArrayAdapter citizenshipAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, citizenshipList);
        citizenshipAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citizenshipSpinner.setAdapter(citizenshipAdapter);

        ArrayAdapter starsAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, stars);
        starsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        starsSpinner.setAdapter(starsAdapter);

        ArrayAdapter rasiAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, rasiList);
        rasiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rasiSpinner.setAdapter(rasiAdapter);

        ArrayAdapter kujaDoshamAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, kujaDoshamList);
        kujaDoshamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kujaDoshamSpinner.setAdapter(kujaDoshamAdapter);

        ArrayAdapter eatingAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, eatingHabits);
        eatingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citizenshipSpinner.setAdapter(eatingAdapter);

        ArrayAdapter drinkingAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, drinkingHabits);
        drinkingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        starsSpinner.setAdapter(drinkingAdapter);

        ArrayAdapter smokingAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, smokingHabits);
        smokingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rasiSpinner.setAdapter(smokingAdapter);

        final EditText town = view.findViewById(R.id.town);

        Button submit = view.findViewById(R.id.save);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location location = Location.builder()
                        .country(country)
                        .state(state)
                        .city(city)
                        .citizenship(citizenship)
                        .town(town.getText().toString())
                        .build();
                ReligiousInfo religiousInfo = ReligiousInfo.builder()
                        .star(star)
                        .rasi(rasi)
                        .kujaDosham(kujaDosham)
                        .build();
                Habits habits = Habits.builder()
                        .eatingHabit(eatingHabit)
                        .drinkingHabit(drinkingHabit)
                        .smokingHabit(smokingHabit)
                        .build();
                ReqAddLocationReligiousHabits reqAddLocationReligiousHabits = ReqAddLocationReligiousHabits.builder()
                        .location(location)
                        .religiousInfo(religiousInfo)
                        .habits(habits)
                        .build();

                Log.i("LRHINFO Details", reqAddLocationReligiousHabits.toString());
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentLayout, new FamilyFragment());
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        switch (adapterView.getId()) {
            case R.id.countrySpinner:
                country = countries.get(position);
                Log.i("Country", country);
                break;
            case R.id.stateSpinner:
                state = states.get(position);
                Log.i("State", state);
                break;
            case R.id.citySpinner:
                city = cities.get(position);
                Log.i("City", city);
                break;
            case R.id.citizenshipSpinner:
                citizenship = citizenshipList.get(position);
                Log.i("Citizenship", citizenship);
                break;
            case R.id.starSpinner:
                star = stars.get(position);
                Log.i("Star", star);
                break;
            case R.id.rasiSpinner:
                rasi = rasiList.get(position);
                Log.i("Rasi", rasi);
                break;
            case R.id.kujaDoshamSpinner:
                kujaDosham = kujaDoshamList.get(position);
                Log.i("Kuja Dosham", kujaDosham);
                break;
            case R.id.eatingSpinner:
                eatingHabit = eatingHabits.get(position);
                Log.i("Eating Habit", eatingHabit);
                break;
            case R.id.drinkingSpinner:
                drinkingHabit = drinkingHabits.get(position);
                Log.i("Drinking Habit", drinkingHabit);
                break;
            case R.id.smokingSpinner:
                smokingHabit = smokingHabits.get(position);
                Log.i("Smoking Habit", smokingHabit);
                break;
            default:
                Log.e("Unknown spinner id", adapterView.getId() + "");
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}