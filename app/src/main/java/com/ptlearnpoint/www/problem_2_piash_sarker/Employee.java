package com.ptlearnpoint.www.problem_2_piash_sarker;

/**
 * Created by PT on 2/3/2017.
 */

public class Employee {

    private String id ;
    private String firstName ;
    private String lastName ;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;
    private String country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Employee(){

    }
    public Employee(String id, String firstName, String lastName,String phone ,  String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.country = country;
    }
    public Employee( String firstName, String lastName,String phone ,  String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.country = country;
    }

}
