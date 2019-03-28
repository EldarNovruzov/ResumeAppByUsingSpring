/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.Skill;
import com.company.inter.AbstractDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author Acer
 */
@Repository
public class SkillRepositoryCustomImpl extends AbstractDAO implements SkillRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Skill> getallSkills() {
        Query q= em.createQuery("select s from Skill s ");
        return q.getResultList();
    }

    @Override
    public List<Skill> getallSkillsbyId(int id) {
        Query q = em.createQuery("select s from Skill s where s.id=:id");
        return q.getResultList();
    }

    @Override

    public boolean updateSkill(Skill u) {

        em.merge(u);
        return true;
    }

    public boolean insertSkill(Skill skl) {
        em.persist(skl);
        return true;
    }

    @Override

    public boolean removeSkill(int id) {
        Skill skill = em.find(Skill.class, id);
        em.remove(skill);
        return true;
    }

    @Override

    public List<Skill> getByName(String sname) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Skill> cbq = cb.createQuery(Skill.class);
        Root<Skill> from = cbq.from(Skill.class);

        CriteriaQuery<Skill> cqn = cbq.where(cb.equal(from.get("name"), sname));

        Query query= em.createQuery(cqn);

        return query.getResultList();

    }

}
