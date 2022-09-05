package ru.spring.ppr1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JavaSpringController {



    @GetMapping("/")
    public String greeting(Model model) {
        int a = 0;
        a = 1;
        model.addAttribute("title", a);
        return "home";
    }

    @GetMapping("/calc")
    public String Calc(Model model) {
        model.addAttribute("title", 167);
        return "home";
    }

    @GetMapping("/res")
    public String Res(@RequestParam(value = "number1", required = false, defaultValue = "1") int a,
                      @RequestParam(value = "number2", required = false, defaultValue = "2") int b,
                      Model model) {
        int c = a+b;
        model.addAttribute("answer", c);
        return "result";
    }

    @PostMapping("/res")
    public String Result(@RequestParam(value = "number1", required = false, defaultValue = "1") int a,
                      @RequestParam(value = "number2", required = false, defaultValue = "2") int b,
                      @RequestParam(value = "action", required = false) String act,
                      Model model) {

        int c = 0;

        switch (act) {
            case "+" -> {
                c = a + b;
            }
            case "-" -> {
                c = a - b;
            }
            case "*" -> {
                c = a * b;
            }
            case "/" -> {
                c = a / b;
            }
        }
        model.addAttribute("answer", c);
        return "result";
    }
}
