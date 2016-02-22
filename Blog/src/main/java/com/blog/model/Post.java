package com.blog.model;

import java.util.Date;
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
@Table(name = "posts")
public class Post {

    @Column(name = "entryid", nullable = false)
    @Id
    @GeneratedValue
    private int postid;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "datepost", nullable = false)
    private Date datepost;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = { CascadeType.ALL })
    public List<Entry> entriesPost;

    public Post() {
    }

    public Post(String title, String description, Date datepost) {
        this.title = title;
        this.description = description;
        this.datepost = datepost;
    }

    public List<Entry> getEntriesPost() {
        return entriesPost;
    }

    public void setEntriesPost(List<Entry> entriesPost) {
        this.entriesPost = entriesPost;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatepost() {
        return datepost;
    }

    public void setDatepost(Date datepost) {
        this.datepost = datepost;
    }

}
