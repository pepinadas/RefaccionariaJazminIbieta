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

    //Muestra una refaccion por su id
    @GetMapping("/refaccion/api/{id}")
    ResponseEntity<Refaccion> id(@PathVariable(required = true, name = "id") int id){
        return new ResponseEntity<>(tienda.id(id), HttpStatus.OK);
    }

    //Muestra todo el contenido
    @GetMapping("/refaccion/api")
    ResponseEntity<ArrayList<Refaccion>> getRefaccion(){
        return new ResponseEntity<>(tienda.getDb(), HttpStatus.OK);
    }


    //Post
    //Vender
    @PostMapping("/vender")
    public ResponseEntity<Boolean> vender(@RequestBody(required = true)Refaccion refa1){
        return new ResponseEntity<>(tienda.comprar(refa1.getId()),HttpStatus.OK);
    }

    @PostMapping("/devolver")
    public ResponseEntity<Boolean> devolver(@RequestBody(required = true)Refaccion refa1){
        return new ResponseEntity<>(tienda.regresar(refa1.getId()),HttpStatus.OK);
    }

    //Patch
    //Editar un producto ya existente
    @PatchMapping("/editar/producto")
    public ResponseEntity<Refaccion> editarProducto(@RequestBody(required = true)Refaccion refaccion){
        return new ResponseEntity<>(tienda.editar(refaccion.getId(), refaccion), HttpStatus.OK);
    }

//    @PatchMapping("/editar/carrito")
//    public ResponseEntity<?> editarCarrito(@RequestBody(required = true) Clase que creara Jaz ) {
//    }

    //Delete
    //Borrar un producto
    @DeleteMapping("/borrar/producto")
    public ResponseEntity<?> borrarAlgo(@RequestBody(required = true) Refaccion refaccion) {
        return new ResponseEntity<>(tienda.eliminar(refaccion.getId()), HttpStatus.GONE);
    }
}
