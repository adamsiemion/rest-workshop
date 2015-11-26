package com.workshop.rest;

public class UserDtoV1 {

    private Long id;
    private String firstName;
    private String lastName;

    UserDtoV1() { }

    public UserDtoV1(User user) {
        this.id = user.getId();
        final String name = user.getName() != null ? user.getName() : "";
        this.firstName = name.contains(" ") ? name.substring(0, name.indexOf(" ")) : name;
        this.lastName = name.contains(" ") ? name.substring(name.indexOf(" ") + 1) : "";
    }

    public User convert() {
        return new User(id, firstName + " " + lastName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
