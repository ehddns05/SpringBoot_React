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

    @Column(name = "id")
    private String username;

    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String password;

    public User(){}

    @Builder
    public User(String username, String password){
        username = this.username;
        password = this.password;
    }

    @Builder
    public User(long num, String username, String password, String name, int age){
        num = this.num;
        username = this.username;
        password = this.password;
        name = this.name;
        age = this.age;
    }
}