package com.workshop.rest.level3;

import org.springframework.hateoas.ResourceSupport;

public class User extends ResourceSupport {

    private Long userid;
    private String name;

    User() { }

    public User(String name) {
        this.name = name;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
