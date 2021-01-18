package com.lotusstack.webservices.db;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    Post() {
    }

    public Post(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
