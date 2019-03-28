/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.EmploymentHistory;
import com.company.inter.AbstractDAO;
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
public class EmploymentHistoryRepositoryCustomImpl extends AbstractDAO implements EmploymentHistoryRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<EmploymentHistory> getallEmploymentHistorybyuserId(int userId) {
        Query query = em.createQuery("select eh from EmploymentHistory eh where eh.user.id=:usid ");
        query.setParameter("usid",userId);
        return query.getResultList();
    }

}
