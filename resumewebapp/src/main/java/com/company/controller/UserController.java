package com.company.controller;


import com.company.entity.User;
import com.company.form.UserForm;
import com.company.service.DummyService;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
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

    @RequestMapping(method = RequestMethod.GET,value = "/users")
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

    @RequestMapping(method = RequestMethod.GET,value = "/usersM")
    public ModelAndView indexM(@Valid @ModelAttribute("user") UserForm us, BindingResult bindingResult){
        ModelAndView mv=new ModelAndView("users");

        if (bindingResult.hasErrors()){
            return mv;
        }

        List<User> list= userServiceInter.getAll(us.getName(),us.getSurname(),us.getNationalityIdbyRequest());

        mv.addObject("list",list);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public  String login(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public  String logoutPage(){
        return "logout";
    }

    @Autowired
    DummyService dummyService;

    @RequestMapping(method = RequestMethod.GET, value = "/foo")
    public  String foo(){
        System.out.println("foo in controller");
        dummyService.foo();
        return "users";
    }

    @ModelAttribute("user")
    public UserForm getEmptyUserForm(){
        return new UserForm();
    }

}
