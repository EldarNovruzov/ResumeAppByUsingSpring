package com.company.impl;

import com.company.entity.AdminLogin;
import com.company.inter.AbstractDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
public class AdminLoginRepositoryCustomImpl extends AbstractDAO implements AdminLoginRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<AdminLogin> getAll() {
        Query qr = em.createQuery("select al from AdminLogin  al");

        return qr.getResultList();
    }

}
