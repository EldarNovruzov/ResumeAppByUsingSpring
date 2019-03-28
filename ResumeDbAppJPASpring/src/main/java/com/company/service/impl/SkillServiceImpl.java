package com.company.service.impl;

import com.company.entity.Skill;
import com.company.impl.SkillRepositoryCustom;
import com.company.service.inter.SkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class SkillServiceImpl implements SkillServiceInter {


    @Qualifier("skillRepositoryCustomImpl")
    @Autowired
    private SkillRepositoryCustom skill;

    @Override
    public List<Skill> getallSkills() {
        return skill.getallSkills();
    }

    @Override
    public List<Skill> getallSkillsbyId(int id) {
        return skill.getallSkillsbyId(id);
    }

    @Override
    public boolean updateSkill(Skill u) {
        return skill.updateSkill(u);
    }

    @Override
    public boolean removeSkill(int id) {
        return skill.removeSkill(id);
    }

    @Override
    public List<Skill> getByName(String name) {
        return skill.getByName(name);
    }

    @Override
    public boolean insertSkill(Skill skl) {
        return skill.insertSkill(skl);
    }
}
