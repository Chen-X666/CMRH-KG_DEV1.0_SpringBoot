package com.canton.controller;

import com.canton.service.CountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther ChenX
 * @Date 2020.10.18
 **/
@RestController
@RequestMapping(value = "/count", produces="application/json;charset=utf-8")
@CrossOrigin//允许跨域访问
public class CountController {
    @Autowired
    private CountService countService;

    @GetMapping("/getCount")
    @ApiOperation(value="获取三元组 实体 关系 书籍数量")
    @ResponseBody
    public Map<String, Integer> getCount() {
        return countService.countAll();
    }
}
