package com.ref.jaz.controlador;

import com.ref.jaz.modelo.Refaccion;
import com.ref.jaz.modelo.Tienda;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorRefacciones {
    Tienda tienda = new Tienda();

    //Get


    //Post


    //Patch

    @PatchMapping("/editar/producto/{id}")
    public ResponseEntity<?> editarProductoByID(@RequestBody(required = true)Refaccion refaccion){
        return new ResponseEntity<>(tienda.editar(refaccion.getId(), refaccion), HttpStatus.OK);
    }

    //Delete


}
