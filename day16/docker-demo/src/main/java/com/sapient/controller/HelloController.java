package com.sapient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping
    public ModelAndView method() {
        return new ModelAndView("redirect:" + "https://www.youtube.com/watch?v=dQw4w9WgXcQ");
    }
}
