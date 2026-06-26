package com.resources.model;

public class Customer {
    private Long id;
    private String firstName;
    private String middleInitial;
    private String surname;
    private String address;
    private String contactNumber;
    private String nickname;
    
    public Customer() {}
    
    public Customer(String firstName, String surname, String contactNumber) {
        this.firstName = firstName;
        this.surname = surname;
        this.contactNumber = contactNumber;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getMiddleInitial() { return middleInitial; }
    public void setMiddleInitial(String middleInitial) { this.middleInitial = middleInitial; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
}