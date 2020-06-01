package com.web.demo.repository;

import com.web.demo.model.FileVo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileVo, Long>{
    public FileVo findByBoardnum(long boardnum);
}