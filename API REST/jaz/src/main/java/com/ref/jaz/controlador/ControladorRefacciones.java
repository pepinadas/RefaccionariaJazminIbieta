package com.ref.jaz.controlador;

import com.ref.jaz.modelo.Refaccion;
import com.ref.jaz.modelo.Tienda;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorRefacciones {
    Tienda tienda = new Tienda();

    //Get


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
