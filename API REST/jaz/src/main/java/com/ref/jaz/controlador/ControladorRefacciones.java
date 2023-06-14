package com.ref.jaz.controlador;

import com.ref.jaz.modelo.Refaccion;
import com.ref.jaz.modelo.Tienda;
import com.ref.jaz.persistencia.RefaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/refaccion")
public class ControladorRefacciones {

    @Autowired
    private RefaccionRepository refaccionRepo;

    //Muestra la refaccion por su ID
    //Ej. http://localhost:8081/api/refaccion/2
    @GetMapping("/{id}")
    public Optional<Refaccion> getRefa(@PathVariable int id){
        return refaccionRepo.findById(id);
    }

    //Muetra todas las refacciones
    //Ej. http://localhost:8081/api/refaccion
    @GetMapping
    public List<Refaccion> getRefa(){
        return (List<Refaccion>) refaccionRepo.findAll();
    }

    //Cambia una refacción ya existente
    //http://localhost:8081/api/refaccion ponga esto en postman y modifique una refaccion
    @PatchMapping
    public Refaccion saveAuto(@RequestBody Refaccion larefa){
        return refaccionRepo.save(larefa);
    }

    //Agrega una nueva refaccion
    //Ponga esto en postman y agregue una nueva http://localhost:8081/api/refaccion
    @PostMapping
    public ResponseEntity<Refaccion> add(@RequestBody Refaccion refaccion){
        return ResponseEntity.ok(this.refaccionRepo.save(refaccion));
    }

    //Elimina una refaccion por su ID
    //Ej. http://localhost:8081/api/refaccion/6 pruebe en postman
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if (this.refaccionRepo.existsById(id)) {
            this.refaccionRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();


    }

}
