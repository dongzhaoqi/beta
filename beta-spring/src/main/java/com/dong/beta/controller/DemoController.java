package com.dong.beta.controller;

import com.dong.beta.controller.domain.ParseRule;
import com.dong.beta.service.DemoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("test")
    public List<ParseRule> test(){
        return demoService.test();
    }
    @GetMapping("test2")
    public String test2(){
        return "dong";
    }
}