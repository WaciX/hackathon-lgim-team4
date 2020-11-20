package com.lgim.hackathon.team4.crime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@MongoEntity(collection="ThePerson")
public class CrimeDetail {
    private String crimeId;
    private LocalDate date;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String crimeType;
    private String outcomeCategory;
    private String context;
}
