package com.homework.springSecurity.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "visitor")
public class Visitor//i didnt name it User because it reserved key word in  PG/SQL
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    @NotEmpty(message = "username can't be empty")
    @Size(min = 2, max = 100, message = "username should be between 2 and 100 characters")
    private String username;
    @Column(name = "age")
    @Min(value = 1,message = "minimal age is 1 ")
    @Max(value = 120,message = "maximum age is 120 ")
    private int age;
    @Column(name="password")
    private String password;
    @Column(name="role")
    private String role;
    @Column(name = "createdat")
    private Date createdAt;

    public Visitor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
