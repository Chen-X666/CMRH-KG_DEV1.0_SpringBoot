package com.canton;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Auther ChenX
 * @Date 2020.3.10
 **/
@MapperScan("com.canton.dao.mapper")
@SpringBootApplication()
@ServletComponentScan
public class CantonApplication {


    public static void main(String[] args) {
        SpringApplication.run(CantonApplication.class, args);
    }

}
