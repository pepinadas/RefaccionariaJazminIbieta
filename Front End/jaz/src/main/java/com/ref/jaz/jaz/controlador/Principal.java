package com.ref.jaz.jaz.controlador;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ref.jaz.jaz.modelo.Refaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


    @GetMapping("/editar")
    public String agregar(Model model) throws JsonProcessingException {
        return "CUD";
    }

    @GetMapping("/catalogo")
    public String catalogo(Model model) throws JsonProcessingException {
        return "catalogo";
    }


    @PostMapping(value = "/edicion/")
    public String cambiar(
            @ModelAttribute("id") int id,
            @ModelAttribute("imagen") String imagen,
            @ModelAttribute("modelo") String modelo,
            @ModelAttribute("descripcion") String descripcion,
            @ModelAttribute("marca") String marca,
            @ModelAttribute("costo") double costo,
            @ModelAttribute("categoria") String categoria,
            @ModelAttribute("cantidad") int cantidad,
            @ModelAttribute("metodo") String metodo,
            Model model
    ){

        Refaccion refaccion = new Refaccion(id, imagen,modelo,descripcion,marca,costo,categoria,cantidad);
        System.out.println("cambiar " + refaccion);
        String url = "http://127.0.0.1:8081/agregar";
        String url1 = "http://127.0.0.1:8081/editar/producto";
        String url2 = "http://127.0.0.1:8081/borrar/producto/" + id;

        String result = "";

        if (metodo.equals("agregar")) {
            Mono<String> resultMono = webClient.post()
                    .uri(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(refaccion)
                    .retrieve()
                    .bodyToMono(String.class);
            result = resultMono.block();
        } else if (metodo.equals("editar")) {
            Mono<String> resultMono = webClient.patch()
                    .uri(url1)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(refaccion)
                    .retrieve()
                    .bodyToMono(String.class);
            result = resultMono.block();
        } else if (metodo.equals("borrar")) {
            webClient
                    .delete()
                    .uri(url2)
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block();
        } else {
            Mono<String> resultMono = webClient.post()
                    .uri(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(refaccion)
                    .retrieve()
                    .bodyToMono(String.class);
            result = resultMono.block();
        }


        model.addAttribute("refaccion", result);

        return "CUD";


    }


}




