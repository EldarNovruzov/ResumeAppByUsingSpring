/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.impl;

import com.mycompany.entity.Country;
import com.mycompany.inter.AbstractDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author Acer
 */
@Repository
public class CountryRepositoryCustomImpl extends AbstractDAO implements CountryRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Country> getallCountry() {
        Query q = em.createQuery("select c from Country c");
        return q.getResultList();
    }

    @Override
    public List<Country> getallCountrybyId(int id) {
        Query q = em.createQuery("select c from Country c where c.id=:cid");
        q.setParameter("cid",id);
        return q.getResultList();
    }

}
