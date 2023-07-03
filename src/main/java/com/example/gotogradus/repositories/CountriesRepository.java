package com.example.gotogradus.repositories;

import com.example.gotogradus.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<Country, Integer> {
}
