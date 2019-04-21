package com.company.controller;


import com.company.dto.ResponseDTO;
import com.company.dto.UserDTO;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserServiceInter userService;

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getUsers(
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

        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.of(userDTOS));
    }

    @GetMapping("/foo")
    public ResponseEntity<ResponseDTO> foo(
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

        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.of(userDTOS));
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id") Integer id){
        User user = userService.getbyID(id);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.of(new UserDTO(user)));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") Integer id){
        User user = userService.getbyID(id);

        userService.removeUser(id);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.of(new UserDTO(user),"Successfully Deleted"));
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseDTO> addUser(
            @RequestBody UserDTO userDTO){

        User u=new User();
        u.setName(userDTO.getName());
        u.setSurname(userDTO.getSurname());
        u.setPassword(userDTO.getPassword());
        userService.addUser(u);

        UserDTO udt=new UserDTO();
        udt.setId(u.getId());
        udt.setName(u.getName());
        udt.setSurname(u.getSurname());
        udt.setPassword(u.getPassword());

        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.of(udt,
                "Successfully Added"));
    }


}
