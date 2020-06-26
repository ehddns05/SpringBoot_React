package com.web.demo.controller;

import java.util.List;

import com.web.demo.model.Schedule;
import com.web.demo.service.ScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {
    
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping(value="/schedule/add")
    public void signUp(@RequestBody Schedule entity) {
        System.out.println("/schedule/add");
        scheduleService.save_schedule(entity);
    }

    @GetMapping(value="/schedule/myschedule")
    public List<Schedule> getMySchedule(){

        return scheduleService.getMySchedule();
    }
}