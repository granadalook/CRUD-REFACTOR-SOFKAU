package com.example.cruddatabasekata.Controllers;

import com.example.cruddatabasekata.Models.Categoria;
import com.example.cruddatabasekata.Models.Tarea;
import com.example.cruddatabasekata.Service.CategoriaTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:3000/")
public class Controller {

    @Autowired
    private CategoriaTareaService service;

    @GetMapping("get/categorias")
    public List<Categoria> getAllCategorias(){
        return service.getCategoria();
    }
    @GetMapping("get/tareas")
    public List<Tarea> getAllTareas(){
        return service.getTarea();
    }

    @PostMapping(path ="create/categoria")
    public Categoria createCategoria(@RequestBody Categoria category){
        return service.createCategoria(category);

    }
    @PostMapping(path ="create/tarea")
    public Categoria createTarea(@RequestBody Tarea tarea){
        return service.createTarea(tarea);
    }
    @PutMapping(path = "update/categoria/{id}")
    public Categoria createCategoria(@RequestBody Categoria category,@PathVariable(value = "id") Long id){
        return service.createCategoria(category);
    }

    @PutMapping(path ="update/tarea")
    public Categoria updateTarea(@RequestBody Tarea tarea){
        return service.updateTarea(tarea);
    }

    @DeleteMapping(path ="delete/categoria")
    public void deleteCategoria(@RequestBody Categoria category){
        service.deleteCategoria(category);
    }

    @DeleteMapping(path ="delete/tarea")
    public void deleteTarea(@RequestBody Tarea tarea){
        service.deleteTarea(tarea);
    }
}