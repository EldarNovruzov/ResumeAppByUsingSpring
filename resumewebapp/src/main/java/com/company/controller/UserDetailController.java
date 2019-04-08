package com.company.controller;


import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.form.UserDetailForm;
import com.company.form.UserForm;
import com.company.service.inter.UserServiceInter;
import com.company.service.inter.UserSkillServiceInter;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserDetailController {

    @Autowired
    private UserServiceInter userServiceInter;

    @Autowired
    private UserSkillServiceInter usi;

    @RequestMapping(method = RequestMethod.POST,value ="/userdelete")
    public ModelAndView userDetailIndex(@ModelAttribute("user") UserForm udf){
        userServiceInter.removeUser(udf.getId());
        ModelAndView mv=new ModelAndView("users");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST,value ="/userupdate")
    public ModelAndView userDetailUpdateIndex(@ModelAttribute("detailform") UserDetailForm udfm){
       User s= userServiceInter.getbyID(udfm.getId());
       s.setName(udfm.getName());
       s.setSurname(udfm.getSurname());
        userServiceInter.updateUser(s);
        ModelAndView mv=new ModelAndView("userdetailJstl");
        return mv;
    }


    @RequestMapping(method = RequestMethod.GET,value = "/userdetail")
    public ModelAndView detailGetIndex(@ModelAttribute("user") UserForm udf){
        try {
            ModelAndView m = new ModelAndView("userdetailJstl");
            User u = userServiceInter.getbyID(udf.getId());
            if (u == null) {
                throw new IllegalArgumentException("There is no user with this id");
            }
            List<UserSkill> asu =usi.getAllSkillByUserId(udf.getId());
            m.addObject("listskill",asu);
            m.addObject("user", u);
            return m;
        }
        catch (Exception ex){
            ex.printStackTrace();
            ModelAndView mv=new ModelAndView("error");
            String message = ex.getMessage();
            mv.addObject("ms",message);
            return mv;
        }
    }

}
