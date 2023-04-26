package com.example.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo1")
    @PreAuthorize("hasAnyAuthority('read', 'write')")
    public String demo1() {
        return "Demo 1";
    }

    @GetMapping("/demo2")
    @PreAuthorize("hasAuthority('read')")
    public String demo2() {
        return "Demo 2";
    }

    @GetMapping("/demo3/{tmp}")
    @PreAuthorize("#temp == authentication.name")
    public String demo3(@PathVariable("tmp") String temp) {
        return "Demo 3";
    }
}
