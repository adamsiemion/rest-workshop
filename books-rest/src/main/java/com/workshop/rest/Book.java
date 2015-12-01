package com.workshop.rest;

public class Book {
    private Integer id;
    private String name;
    private boolean active = true;

    Book() {}

    public Book(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(Integer id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }


    public Book(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!id.equals(book.id)) return false;
        return name.equals(book.name);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
