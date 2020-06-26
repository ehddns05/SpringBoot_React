package com.web.demo.service;

import java.util.List;
import java.util.Optional;

import com.web.demo.model.Schedule;
import com.web.demo.repository.ScheduleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    
    @Autowired
    private ScheduleRepository repo;

    public void save_schedule(Schedule schedule) {

        schedule.setUserid(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        repo.save(schedule);
    }

    public List<Schedule> getMySchedule(){
        List<Schedule> schedules = repo.findByUserid(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return schedules;
    }
}