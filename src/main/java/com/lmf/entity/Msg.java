package com.lmf.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "msg")
public class Msg implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  long id;

    public  long user_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;

    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public  String content;
    public  long createdAt;


}
