package com.example.banjaravaya.pojos.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location implements Serializable {

    private String country;

    private String state;

    private String city;

    private String citizenship;

    private String town;
}
