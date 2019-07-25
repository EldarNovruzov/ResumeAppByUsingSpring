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
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(method = RequestMethod.GET,value ="/userupdate")
    public ModelAndView userDetailUpdateIndex(
            @RequestParam(value = "id",required = false) Integer id,
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "surname",required = false) String surname
    ){
        ModelAndView mv=new ModelAndView("userdetailJstl");

        User s= userServiceInter.getbyID(id);
        s.setName(name);
        s.setSurname(surname);
        userServiceInter.updateUser(s);

        List<UserSkill> asu =usi.getAllSkillByUserId(id);
        mv.addObject("listskill",asu);
        mv.addObject("user", s);

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
