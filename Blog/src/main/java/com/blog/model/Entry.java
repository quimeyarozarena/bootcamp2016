package com.blog.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entries")
public class Entry {

    @Column(name = "entryid", nullable = false)
    @Id
    @GeneratedValue
    private int entryid;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "userid", nullable = false) // FK
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "postid", nullable = false) // FK
    private Post post;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date_entry", nullable = false)
    private Date date;

    public Entry() {
    }

    public Entry(User user, String description) {
        this.user = user;
        this.description = description;
    }

    public Entry(User user, String description, Date date) {
        this.user = user;
        this.description = description;
        this.date = date;
    }

    public Entry(int entryid, User user, String description, Date date) {
        this.entryid = entryid;
        this.user = user;
        this.description = description;
        this.date = date;
    }

    public Entry(User user, Post post, String description, Date date) {
        super();
        this.user = user;
        this.post = post;
        this.description = description;
        this.date = date;
    }

    public int getEntryid() {
        return entryid;
    }

    public void setEntryid(int entryid) {
        this.entryid = entryid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getId() {
        return entryid;
    }

    public void setId(int entryid) {
        this.entryid = entryid;
    }

    public User getUsername() {
        return user;
    }

    public void setUsername(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
