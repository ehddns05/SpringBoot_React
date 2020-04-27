package com.web.demo.model;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num")
    private long num;

    @Column
    private String id;

    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String password;

    public User(){}

    @Builder
    public User(String id, String password){
        id = this.id;
        password = this.password;
    }

    @Builder
    public User(long num, String id, String password, String name, int age){
        num = this.num;
        id = this.id;
        password = this.password;
        name = this.name;
        age = this.age;
    }
}