/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.impl;


import com.mycompany.entity.UserSkill;
import com.mycompany.inter.AbstractDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserSkillRepositoryCustomImpl extends AbstractDAO implements UserSkillRepositoryCustom {

@PersistenceContext
EntityManager em;

    @Override

    public List<UserSkill> getAllSkillByUserId(int id) {
        Query createQuery = em.createQuery("select us from UserSkill us where us.user.id=:userid");
        createQuery.setParameter("userid", id);
        return createQuery.getResultList();
    }



    public boolean insertUserSkill(UserSkill u) {
        em.persist(u);
        return true;
    }



    public boolean updateUserSkill(UserSkill u) {
       em.merge(u);
        return true;
    }



    @Override

    public boolean removeUserSkill(int id) {
        UserSkill us= em.find(UserSkill.class,id);

        em.remove(us);
        return true;
    }

}