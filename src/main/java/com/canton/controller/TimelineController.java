package com.canton.controller;

import com.canton.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther ChenX
 * @Date 2020.4.3
 * 时间轴
 **/
@Controller
public class TimelineController {
    @Autowired
    private TimelineService timelineService;

    @RequestMapping(value = "/timeline-getall")
    @ResponseBody
    public String getAll() {
        return timelineService.getAll();
    }

}

