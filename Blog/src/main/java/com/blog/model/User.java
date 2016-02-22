package com.blog.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Column(name = "userid", nullable = false)
    @Id
    @GeneratedValue
    private int userid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = { CascadeType.ALL })
    public List<Entry> entries;

    public User() {
    }

    public User(String name, String lastname, String username, String email) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
    }

    public User(int userid, String name, String lastname, String username, String email) {
        this.userid = userid;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
