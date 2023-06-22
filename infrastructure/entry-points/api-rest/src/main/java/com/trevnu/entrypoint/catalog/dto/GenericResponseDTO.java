package com.trevnu.entrypoint.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponseDTO {
    private Instant timestamp;
    private Integer status;
    private String message;
}
