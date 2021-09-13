package com.k19.models;

public class employeeModel {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String address;
    private String contact;
    private String gentle;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(final String contact) {
        this.contact = contact;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getGentle() {
        return this.gentle;
    }

    public void setGentle(final String gentle) {
        this.gentle = gentle;
    }
}
