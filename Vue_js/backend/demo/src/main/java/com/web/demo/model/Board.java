package com.web.demo.model;



import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "board")
@AllArgsConstructor
public class Board {
    
    //underScore problem -> set Colume name
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_num")
    private long boardnum;

    @Column
    private String board_title;

    @Column
    private String writer;
    @Column
    private int hits;
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date date;
    @Column
    private String context;

    public Board(){}
}