package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @GetMapping()
    @ResponseBody
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        return "Hello " + name + "!";
    }
    String[] names = {"William", "Javier" ,"Justin"};

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/random")
    @ResponseBody
    public String randomGreeting(){
        int rnd = new Random().nextInt(names.length);
        return "Hello " + names[rnd] + "!";
    }

    @GetMapping("/{name1}/{name2}")
    @ResponseBody
    public String greetTwo(@PathVariable String name1, @PathVariable String name2){
        return "Hello, " + name1 + " and " + name2 + "!";
    }

    @GetMapping("{name1}/to/{name2}")
    @ResponseBody
    public String oneGreetsAnother(@PathVariable String name1, @PathVariable String name2){
        return name1 + " says hello to " + name2 + "!";
    }
}
