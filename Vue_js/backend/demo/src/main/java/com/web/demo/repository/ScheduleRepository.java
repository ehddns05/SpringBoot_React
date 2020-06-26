package com.web.demo.repository;

import java.util.List;
import java.util.Optional;

import com.web.demo.model.Schedule;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
    List<Schedule> findByUserid(String userid);
}