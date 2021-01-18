package com.lotusstack.webservices.db;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description = "Description about the users")
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 2, message = "Name Should be at least 2 character.")
    private String name;
    @Past
    @ApiModelProperty(notes = "Birthdate should be in the past.")
    private Date dob;
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    User() {

    }

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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
