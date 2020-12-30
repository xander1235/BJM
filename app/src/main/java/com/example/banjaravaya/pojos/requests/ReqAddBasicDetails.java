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
public class ReqAddBasicDetails implements Serializable {

    private static final Long serialVersionUID = 1L;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("sur_name")
    private String surName;

    private String dob;

    private String email;

    private String height;

    @SerializedName("height_type")
    private String heightType;

    @SerializedName("profile_created_by")
    private String profileCreatedBy;

    @SerializedName("profile_created_for")
    private String profileCreatedFor;

    @SerializedName("mother_tongue")
    private String motherTongue;

    @SerializedName("martial_status")
    private String martialStatus;

    @SerializedName("physical_status")
    private String physicalStatus;
}
