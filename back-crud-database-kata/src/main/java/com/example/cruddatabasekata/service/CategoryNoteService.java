package com.example.cruddatabasekata.service;

import com.example.cruddatabasekata.dao.CategoryNoteDaoImplement;
import com.example.cruddatabasekata.entity.Category;
import com.example.cruddatabasekata.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CategoryNoteService {

    @Autowired
    private CategoryNoteDaoImplement categoryNoteService;

    public List<Category> getCategories(){
        return categoryNoteService.getCategories();
    }

    public Category createCategory(Category category){
        return categoryNoteService.createCategory(category);
    }

    public Note createNote(Note note){
        return categoryNoteService.createNote(note);
    }

    public Note updateNote(Note note){
        return categoryNoteService.updateNote(note);
    }

    public void deleteNote(Long id){
        categoryNoteService.deleteNote(id);
    }

    public void deleteCategory(Long id){
        categoryNoteService.deleteCategory(id);
    }
}
