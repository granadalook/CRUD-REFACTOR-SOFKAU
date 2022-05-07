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
    public Category createNote(@RequestBody Note note){
        return service.createNote(note);
    }

    @PutMapping("update/note")
    public Category updateNote(@RequestBody Note note){
        return service.updateNote(note);
    }

    @DeleteMapping("delete/category")
    public void deleteCategory(@RequestBody Category category){
        service.deleteCategory(category);
    }

    @DeleteMapping("delete/note")
    public void deleteNote(@RequestBody Note note){
        service.deleteNote(note);
    }
}
