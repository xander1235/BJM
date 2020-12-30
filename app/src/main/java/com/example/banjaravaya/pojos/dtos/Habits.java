package com.example.banjaravaya.pojos.dtos;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Habits implements Serializable {

    @SerializedName("eating_habit")
    private String eatingHabit;

    @SerializedName("drinking_habit")
    private String drinkingHabit;

    @SerializedName("smoking_habit")
    private String smokingHabit;
}
