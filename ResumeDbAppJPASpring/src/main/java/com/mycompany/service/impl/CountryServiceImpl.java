package com.mycompany.service.impl;

import com.mycompany.entity.Country;
import com.mycompany.impl.CountryRepositoryCustom;
import com.mycompany.service.inter.CountryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryServiceInter {

    @Qualifier("countryRepositoryCustomImpl")
    @Autowired
    private CountryRepositoryCustom cr;

    @Override
    public List<Country> getallCountry() {
        return cr.getallCountry();
    }

    @Override
    public List<Country> getallCountrybyId(int id) {
        return cr.getallCountrybyId(id);
    }
}
