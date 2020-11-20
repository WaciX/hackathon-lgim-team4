package com.lgim.hackathon.team4.crime;

import java.time.LocalDate;
import java.util.List;

public interface CrimeRepository {

    List<CrimeDetail> findByFromDate(LocalDate localDate);
}
