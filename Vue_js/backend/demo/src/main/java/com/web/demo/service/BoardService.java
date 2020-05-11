package com.web.demo.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.web.demo.model.Board;
import com.web.demo.repository.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    @Autowired
    BoardRepository repo;

    @Transactional
    public void save_board(Board board){
        // setLocaltime
        board.setDate(Timestamp.valueOf(LocalDateTime.now()));
        repo.save(board);
        System.out.println(board);
    }

    public List<Board> findAll() {
        return (List<Board>)repo.findAll();
    }

    public Board getBoardDetail(int boardnum) {
        System.out.println(boardnum);
        Optional<Board> boardEntityWrapper = repo.findByBoardnum(boardnum);
        
        return boardEntityWrapper.get();
    }
}