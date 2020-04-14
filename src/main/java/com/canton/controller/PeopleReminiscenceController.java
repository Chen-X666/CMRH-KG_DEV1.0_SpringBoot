package com.canton.controller;

import com.canton.service.PeopleReminiscenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther ChenX
 * @Date 2020.4.14
 **/
@Controller
public class PeopleReminiscenceController {
    @Autowired
    private PeopleReminiscenceService peoplereminiscence ;

    @RequestMapping(value = "/peoplereminiscence-getpeople")
    @ResponseBody
    public String getAll(@RequestParam("people") String people) {
        return peoplereminiscence.getPeople(people);
    }


}
