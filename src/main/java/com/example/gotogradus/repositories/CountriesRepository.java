package com.example.gotogradus.repositories;

import com.example.gotogradus.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<Country, Integer> {
}
