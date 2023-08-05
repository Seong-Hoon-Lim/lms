package com.example.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class CourseController {

    @GetMapping("/all")
    public String getCourseAll() {
        return "course/all";
    }

    @GetMapping("/backend")
    public String getCourseBackend() {
        return "course/backend";
    }

    @GetMapping("/frontend")
    public String getCourseFrontend() {
        return "course/frontend";
    }

}
