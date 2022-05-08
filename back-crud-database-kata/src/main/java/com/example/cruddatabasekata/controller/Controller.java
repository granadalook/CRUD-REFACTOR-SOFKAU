package com.example.cruddatabasekata.controller;

import com.example.cruddatabasekata.entity.Category;
import com.example.cruddatabasekata.entity.Note;
import com.example.cruddatabasekata.service.CategoryNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:3000/")
public class Controller {

    @Autowired
    private CategoryNoteService service;

    @GetMapping("get/categories")
    public List<Category> getAllCategories(){
        return service.getCategories();
    }

    @PostMapping("create/category")
    public Category createCategory(@RequestBody Category category){
        return service.createCategory(category);
    }

    @PostMapping("create/note")
    public Note createNote(@RequestBody Note note){
        return service.createNote(note);
    }

    @PutMapping("update/note")
    public Note updateNote(@RequestBody Note note){
        return service.updateNote(note);
    }

    @DeleteMapping("delete/category/{id}")
    public void deleteCategory(@PathVariable Long id){
        service.deleteCategory(id);
    }

    @DeleteMapping("delete/note/{id}")
    public void deleteNote(@PathVariable Long id){
        service.deleteNote(id);
    }
}