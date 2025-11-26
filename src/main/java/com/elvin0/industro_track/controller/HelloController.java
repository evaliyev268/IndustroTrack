package com.elvin0.industro_track.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
@GetMapping("/hello")

    public String hello(){
    return "Hello, IndustroTrack";
}


}
