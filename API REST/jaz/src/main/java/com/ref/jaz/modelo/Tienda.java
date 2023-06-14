package com.ref.jaz.modelo;


import com.ref.jaz.persistencia.RefaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Tienda {
    private  RefaccionRepository refaccionRepo;

    @Autowired
    public Tienda(RefaccionRepository refaccionRepo){
        this.refaccionRepo=refaccionRepo;
    }

    //Agrega una nueva refaccion
    public Refaccion save(Refaccion refaccion){
        return this.refaccionRepo.save(refaccion);
    }

    //Metodo Delete

    public void delete(int id){
        this.refaccionRepo.deleteById(id);
    }

    }


