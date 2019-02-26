package com.github.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lidefu
 * @date 2019/2/26 12:16
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("1")
    public String test1(){
        return "success";
    }

}
