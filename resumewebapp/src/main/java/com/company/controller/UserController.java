package com.company.controller;


import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceInter userServiceInter;

//    @RequestMapping(method = RequestMethod.GET)
//    public String index(HttpServletRequest request){
//
//        String name=request.getParameter("name");
//        String surname=request.getParameter("surname");
//        String nationId=request.getParameter("nationalityId");
//
//        Integer nationalityIdbyRequest=null;
//        if (nationId!=null && !nationId.trim().isEmpty()){
//            nationalityIdbyRequest=Integer.parseInt(nationId);
//        }
//        List<User> list= userServiceInter.getAll(name,surname,nationalityIdbyRequest);
//        request.setAttribute("list",list);
//
//        return "users";
//    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "surname",required = false) String surname,
            @RequestParam(value = "nationalityId",required = false) Integer nationalityIdbyRequest
    ){
        List<User> list= userServiceInter.getAll(name,surname,nationalityIdbyRequest);

        ModelAndView mv=new ModelAndView("users");
        mv.addObject("list",list);
        return mv;
    }

}
