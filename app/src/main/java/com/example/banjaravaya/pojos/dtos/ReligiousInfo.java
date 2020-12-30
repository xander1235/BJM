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
public class ReligiousInfo implements Serializable {

    private String star;

    private String rasi;

    @SerializedName("kuja_dosham")
    private String kujaDosham;

    private String gothra;
}
