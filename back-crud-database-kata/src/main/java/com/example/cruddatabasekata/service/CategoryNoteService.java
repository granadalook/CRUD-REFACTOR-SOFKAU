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

    public Category createNote(Note note){
        return categoryNoteService.createNote(note);
    }

    public Category updateNote(Note note){
        return categoryNoteService.updateNote(note);
    }

    public void deleteNote(Note note){
        categoryNoteService.deleteNote(note);
    }

    public void deleteCategory(Category category){
        categoryNoteService.deleteCategory(category);
    }
}
