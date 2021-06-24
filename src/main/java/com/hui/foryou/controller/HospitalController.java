package com.hui.foryou.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @PostMapping("/info")
    public void info() {
        System.out.println("info");
    }
}
