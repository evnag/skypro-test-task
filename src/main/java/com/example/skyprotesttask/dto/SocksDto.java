package com.example.skyprotesttask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


/**
 * The type Socks dto.
 */
@Data
public class SocksDto {
    @JsonProperty("color")
    private String color;
    @JsonProperty("cottonPart")
    private Integer cottonPart;
    @JsonProperty("quantity")
    private Integer quantity;
}
