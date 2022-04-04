package com.example.webapiandmockserver.controllers;

import com.example.webapiandmockserver.services.CatApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    private final CatApiService apiService;

    public MainController(CatApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }

    @PostMapping("/clicked")
    public String getFact(Model model) {
        model.addAttribute("content", apiService.getFact());
        return "fragments :: fact-content";
    }
}
