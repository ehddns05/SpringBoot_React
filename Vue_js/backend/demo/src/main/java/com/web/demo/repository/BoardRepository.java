package com.web.demo.repository;

import java.util.Optional;

import com.web.demo.model.Board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>{

    Optional<Board> findByBoardnum(long boardnum);
}