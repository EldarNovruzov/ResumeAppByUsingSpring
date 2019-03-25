package com.mycompany.service.impl;

import com.mycompany.entity.Skill;
import com.mycompany.impl.SkillRepositoryCustom;
import com.mycompany.service.inter.SkillServiceInter;
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
