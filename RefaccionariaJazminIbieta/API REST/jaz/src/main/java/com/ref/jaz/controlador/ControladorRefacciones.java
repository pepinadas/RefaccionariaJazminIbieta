package com.ref.jaz.controlador;

import com.ref.jaz.modelo.Refaccion;
import com.ref.jaz.modelo.Tienda;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorRefacciones {
    Tienda tienda = new Tienda();

    //Get
    @GetMapping("/refaccion/api/{id}")
    ResponseEntity<Refaccion> id(@RequestBody(required = true)Refaccion refaccion){
        return new ResponseEntity<>(tienda.id(refaccion.getId()), HttpStatus.OK);
    }


    //Post


    //Patch

    @PatchMapping("/editar/producto")
    public ResponseEntity<Refaccion> editarProducto(@RequestBody(required = true)Refaccion refaccion){
        return new ResponseEntity<>(tienda.editar(refaccion.getId(), refaccion), HttpStatus.OK);
    }
//    @PatchMapping("/editar/carrito")
//    public ResponseEntity<?> editarCarrito(@RequestBody(required = true) Clase que creara Jaz ) {
//    }

    //Delete
    @DeleteMapping("/borrar/producto")
    public ResponseEntity<?> borrarAlgo(@RequestBody(required = true) Refaccion refaccion) {
        return new ResponseEntity<>(tienda.eliminar(refaccion.getId()), HttpStatus.GONE);
    }
}
