package com.web.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "fileupload")
@AllArgsConstructor
public class FileVo {

    public FileVo(){};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_num")
    private long filenum;

    @Column(name = "board_num")
    private long boardnum;

    @Column(name = "filename")
    private String filename;

    @Column(name = "fileoriname")
    private String fileOriname;

    @Column(name = "fileurl")
    private String fileurl;
    
}