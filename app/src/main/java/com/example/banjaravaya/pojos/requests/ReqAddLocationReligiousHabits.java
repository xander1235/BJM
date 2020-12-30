package com.example.banjaravaya.pojos.requests;

import com.example.banjaravaya.pojos.dtos.Habits;
import com.example.banjaravaya.pojos.dtos.Location;
import com.example.banjaravaya.pojos.dtos.ReligiousInfo;
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
public class ReqAddLocationReligiousHabits implements Serializable {

    private Location location;

    @SerializedName("religious_info")
    private ReligiousInfo religiousInfo;

    private Habits habits;
}
