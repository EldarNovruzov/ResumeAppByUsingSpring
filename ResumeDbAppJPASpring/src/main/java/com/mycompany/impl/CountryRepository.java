package com.mycompany.impl;

import com.mycompany.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Integer>,CountryRepositoryCustom {
}
