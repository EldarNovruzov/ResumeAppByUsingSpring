package com.company.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserForm {

    @NotEmpty
    @Size(min=3)
    private String name;
    @NotEmpty
    private String surname;
    private Integer nationalityIdbyRequest;
    private Integer id;
    private String action;

    public UserForm() {
    }

    public UserForm(@NotEmpty @Size(min = 3) String name, @NotEmpty String surname, Integer nationalityIdbyRequest, Integer id, String action) {
        this.name = name;
        this.surname = surname;
        this.nationalityIdbyRequest = nationalityIdbyRequest;
        this.id = id;
        this.action = action;
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

    public Integer getNationalityIdbyRequest() {
        return nationalityIdbyRequest;
    }

    public void setNationalityIdbyRequest(Integer nationalityIdbyRequest) {
        this.nationalityIdbyRequest = nationalityIdbyRequest;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
