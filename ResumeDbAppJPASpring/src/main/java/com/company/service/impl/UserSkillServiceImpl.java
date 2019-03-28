package com.company.service.impl;

import com.company.entity.UserSkill;
import com.company.impl.UserSkillRepositoryCustom;
import com.company.service.inter.UserSkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserSkillServiceImpl implements UserSkillServiceInter {

    @Qualifier("userSkillRepositoryCustomImpl")
    @Autowired
    private UserSkillRepositoryCustom userSkill;

    @Override
    public List<UserSkill> getAllSkillByUserId(int id) {
        return userSkill.getAllSkillByUserId(id);
    }

    @Override
    public boolean insertUserSkill(UserSkill u) {
        return userSkill.insertUserSkill(u);
    }

    @Override
    public boolean updateUserSkill(UserSkill u) {
        return userSkill.updateUserSkill(u);
    }

    @Override
    public boolean removeUserSkill(int id) {
        return userSkill.removeUserSkill(id);
    }
}
