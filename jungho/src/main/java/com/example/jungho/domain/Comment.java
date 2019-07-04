package com.example.jungho.domain;


import lombok.ToString;

import javax.persistence.*;


@ToString
@Entity
public class Comment {

    @Id
    //primary key
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;

    @Column
    private int pno;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment() {
    }
}
