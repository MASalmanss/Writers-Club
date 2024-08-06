package com.MASalmanss.writers_club.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/deneme")
    @PreAuthorize("isAuthenticated()")
    public String gonder(){
        return "hahaha";
    }
}
