package com.ref.jaz.jaz.controlador;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ref.jaz.jaz.modelo.Refaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Controller
public class Principal {

    private final WebClient webClient;

    @Autowired
    public Principal(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/inicio")
    public String index(Model model) throws JsonProcessingException {
        String url = "http://127.0.0.1:8081/refaccion/api";
        String url1 = "http://127.0.0.1:8081/refaccion/api/0";

        Flux<Refaccion> refaccionFlux = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Refaccion>() {
                });
        List<Refaccion> result = refaccionFlux.collectList().block();

        Mono<Refaccion> refaccionMono = webClient.get()
                .uri(url1)
                .retrieve()
                .bodyToMono(Refaccion.class);

        // Bloquea y espera la respuesta
        Refaccion result1 = refaccionMono.block();


        model.addAttribute("refaccion", result);
        model.addAttribute("refaccion1", result1);
        return "index";
    }

    //@GetMapping("/editar")
    //public String getAll(//Model model) throws JsonProcessingException {
    //    String url = "http://127.0.0.1:8081/editar/producto";
    // String url1 = "http://127.0.0.1:8081/borrar/producto";
    //  String url2 = "http://127.0.0.1:8081/agregar";


}




