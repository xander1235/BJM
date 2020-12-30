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
public class ReqAddProfessionalInfo implements Serializable {

    private String education;

    @SerializedName("education_details")
    private String educationDetails;

    @SerializedName("employed_in")
    private String employedIn;

    @SerializedName("occupation")
    private String occupation;

    @SerializedName("occupation_details")
    private String occupationDetails;

    @SerializedName("currency_type")
    private String currencyType;

    @SerializedName("annual_income")
    private String annualIncome;

    private String college;
}
