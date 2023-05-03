package com.ref.jaz.jaz.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class Principal {

    private final WebClient webClient;

    @Autowired
    public Principal(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/inicio")
    public String getInicio(Model model){
        String uri = "http:/localhost:8081/refaccion/api";
        model.addAttribute("uri", uri);
        return "index";
    }

}

//        RestTemplate restConsumer = new RestTemplate();
//