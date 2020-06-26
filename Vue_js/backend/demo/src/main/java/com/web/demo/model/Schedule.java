package com.web.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "schedule")
@AllArgsConstructor
public class Schedule {
    
    public Schedule(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_num")
    private long schedulenum;

    @Column(name = "user_id")
    private String userid;

    @Column(columnDefinition = "json")
    private String category;

    @Column
    private String title;
    @Column
    private String context;

    @Column
    private Date time;
}