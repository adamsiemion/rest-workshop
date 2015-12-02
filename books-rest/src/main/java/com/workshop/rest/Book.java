package com.workshop.rest;

import org.springframework.hateoas.ResourceSupport;

public class Book extends ResourceSupport {
    private Integer bookid;
    private String name;
    private boolean active = true;

    Book() {}

    public Book(Integer bookid, String name) {
        this.bookid = bookid;
        this.name = name;
    }

    public Book(Integer bookid, String name, boolean active) {
        this.bookid = bookid;
        this.name = name;
        this.active = active;
    }


    public Book(String name) {
        this.name = name;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
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

        if (!bookid.equals(book.bookid)) return false;
        return name.equals(book.name);

    }

    @Override
    public int hashCode() {
        int result = bookid.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
