package com.company.controller;


import com.company.dto.UserDTO;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserServiceInter userService;

    @GetMapping("/users")
    public ResponseEntity getUsers(
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "surname",required = false) String surname,
            @RequestParam(value = "nid",required = false) Integer nid
    ){
        List<User> users=userService.getAll(name,surname,nid);

        List<UserDTO> userDTOS=new ArrayList<>();
        for (int i=0;i<users.size();i++){
            User user = users.get(i);
            userDTOS.add(new UserDTO(user));
        }

        return ResponseEntity.status(HttpStatus.OK).body(userDTOS);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getUsers(@PathVariable("id") Integer id){
        List<User> users=userService.getAll(null,null,null);

        List<UserDTO> userDTOS=new ArrayList<>();
        for (int i=0;i<users.size();i++){
            User user = users.get(i);
            userDTOS.add(new UserDTO(user));
        }

        return ResponseEntity.status(HttpStatus.OK).body(userDTOS);
    }
}
