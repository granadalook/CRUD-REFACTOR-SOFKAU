package com.example.cruddatabasekata.Service;

import com.example.cruddatabasekata.Models.Categoria;
import com.example.cruddatabasekata.Models.Tarea;
import com.example.cruddatabasekata.Repository.CatedoriaRepository;
import com.example.cruddatabasekata.Repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class CategoriaTareaService {

    @Autowired
    CatedoriaRepository catedoriaRepository;

    @Autowired
    TareaRepository tareaRepository;

    public List<Categoria> getCategoria() {
        return catedoriaRepository.findAll();
    }

    public List<Tarea> getTarea() {
        return tareaRepository.findAll();
    }



    public Categoria createCategoria(Categoria categoria) {
        return catedoriaRepository.save(categoria);
    }


    public Categoria createTarea(Tarea tarea) {
        Long categoryId = tarea.getKeyCategoriaId();
        Categoria categoria = catedoriaRepository.findById(categoryId).get();
        categoria.addTarea(tarea);
        tareaRepository.save(tarea);
        return catedoriaRepository.save(categoria);
    }

    public Categoria updateTarea(Tarea tarea) {
        Long categoryId = tarea.getKeyCategoriaId();
        Categoria categoria = catedoriaRepository.findById(categoryId).get();
       /* if(categoria != null){
            for(Integer index = 0; index < categoria.getTarea().size(); index++){
                if(tarea.getId().equals(categoria.getTarea().get(index))){
                    categoria.getTarea().set(index, tarea);
                }
            }
        }*/
        tareaRepository.save(tarea);
        return catedoriaRepository.save(categoria);
    }
    public void deleteTarea(Tarea tarea) {
        tareaRepository.deleteById(tarea.getId());
    }
    public void deleteCategoria(Categoria categoria) {
        Categoria categoryToBeDeleted = catedoriaRepository.findById(categoria.getId()).get();
        if(categoryToBeDeleted.getTarea().size() > 0){
            categoryToBeDeleted.getTarea().forEach(tarea -> tareaRepository.deleteById(tarea.getId()));
        }
        catedoriaRepository.deleteById(categoria.getId());
    }

}
