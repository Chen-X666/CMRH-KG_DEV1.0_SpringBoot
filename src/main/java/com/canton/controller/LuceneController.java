package com.canton.controller;

import com.canton.service.LuceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther ChenX
 * @Date 2020.4.7
 **/
@Controller
public class LuceneController {
    @Autowired
    private LuceneService luceneService;

    @RequestMapping(value = "/lucene-getcontents")
    @ResponseBody
    public List<String> getKeyword(@RequestParam("keyword") String keyword) throws Exception
    {
        return luceneService.getKeyword(keyword);
    }
}
