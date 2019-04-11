package com.company.dto;

import com.company.entity.User;
import com.company.entity.UserSkill;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private Integer id;
    private String name;
    private String surname;
    private String password;
    private List<UserSkillDTO> userSkillDTOS;

    public UserDTO() {
    }

    public UserDTO(User u){
        this.id=u.getId();
        this.name=u.getName();
        this.surname=u.getSurname();
        this.password=u.getPassword();
        List<UserSkillDTO> skill=new ArrayList<>();

        List<UserSkill> userSkills=u.getUserSkillList();
        for (int i=0;i<userSkills.size();i++){
            UserSkill us=userSkills.get(i);

            skill.add(new UserSkillDTO(us));
        }
        this.userSkillDTOS=skill;
    }

    public UserDTO(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserSkillDTO> getUserSkillDTOS() {
        return userSkillDTOS;
    }

    public void setUserSkillDTOS(List<UserSkillDTO> userSkillDTOS) {
        this.userSkillDTOS = userSkillDTOS;
    }
}
