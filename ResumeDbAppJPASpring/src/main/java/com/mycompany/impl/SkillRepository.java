package com.mycompany.impl;

import com.mycompany.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill,Integer>, SkillRepositoryCustom {
}
