package com.web.demo.controller;

import java.security.Principal;
import java.util.List;

import com.web.demo.model.Board;
import com.web.demo.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class BoardContoller {

    @Autowired
    BoardService service;

    @PostMapping(value="/user/save_board")
    public void saveBoard(@RequestPart(value = "board") Board entity, @AuthenticationPrincipal Principal principal, 
            @RequestPart(required = false, value="file") MultipartFile file) {
                
        System.out.println("saveBoard");
        if(file != null )System.out.println(file);
        entity.setWriter(principal.getName());
        service.save_board(entity, file);
    }

    @PostMapping(value="/board/findAll")
    public List<Board> findAll() {
        System.out.println("findAll");
        return service.findAll();
    }

    @GetMapping(value="/board/getBoardDetail")
    public Board getBoardDetail(@RequestParam int boardnum) {
        System.out.println("getBoardDetail");
        return service.getBoardDetail(boardnum);
    }

    @GetMapping(value="/board/filedownload")
    public void filedownload(@RequestParam int boardnum) {
        System.out.println("filedownload");
        service.filedownload(boardnum);
    }
}