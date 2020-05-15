package com.web.demo.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.web.demo.model.Board;
import com.web.demo.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardContoller {

    @Autowired
    BoardService service;

    @PostMapping(value="/user/save_board")
    public void signUp(@RequestBody Board entity, @AuthenticationPrincipal Principal principal, HttpServletRequest request) {
        System.out.println("signUp");
        System.out.println(principal);
        System.out.println(request);
        entity.setWriter(principal.getName());
        service.save_board(entity);
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
}