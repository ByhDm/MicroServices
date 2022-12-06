package com.example.mc3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("session_id")
    private Long session_id;

    @JsonProperty("mc1_timestamp")
    private Long mc1_timestamp;

    @JsonProperty("mc2_timestamp")
    private Long mc2_timestamp;

    @JsonProperty("mc3_timestamp")
    private Long mc3_timestamp;

    @JsonProperty("end_timestamp")
    private Long end_timestamp;
}
