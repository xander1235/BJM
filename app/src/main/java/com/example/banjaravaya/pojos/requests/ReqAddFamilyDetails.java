package com.example.banjaravaya.pojos.requests;

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
public class ReqAddFamilyDetails implements Serializable {

    @SerializedName("family_type")
    private String familyType;

    @SerializedName("family_status")
    private String familyStatus;

    @SerializedName("no_of_brothers")
    private String noOfBrothers;

    @SerializedName("no_of_sisters")
    private String noOfSisters;

    @SerializedName("brothers_married")
    private String brothersMarried;

    @SerializedName("sisters_married")
    private String sistersMarried;

    @SerializedName("mother_occupation")
    private String motherOccupation;

    @SerializedName("father_occupation")
    private String fatherOccupation;

    @SerializedName("family_origin")
    private String familyOrigin;

    @SerializedName("about_my_family")
    private String aboutMyFamily;
}
