package ua.hillel.springsecurityapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ping")
public class PingController {
    @GetMapping
    public @ResponseBody
    ResponseEntity<String> ping(){
        return ResponseEntity.ok("OK");
    }
}
