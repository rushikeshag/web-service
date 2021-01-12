package com.lotusstack.webservices.db;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "Description about the users")
public class User {

    private Integer id;
    @Size(min = 2, message = "Name Should be at least 2 character.")
    private String name;
    @Past
    @ApiModelProperty(notes = "Birthdate should be in the past.")
    private Date dob;

    public User(Integer id, String name, Date dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setId(Integer integer) {
        this.id = integer;
    }
}
