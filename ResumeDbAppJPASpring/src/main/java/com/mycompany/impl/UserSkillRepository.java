package com.mycompany.impl;

import com.mycompany.entity.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSkillRepository extends JpaRepository<UserSkill,Integer>,UserSkillRepositoryCustom{
}
