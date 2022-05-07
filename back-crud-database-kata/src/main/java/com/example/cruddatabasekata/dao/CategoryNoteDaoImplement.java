package com.example.cruddatabasekata.dao;


import com.example.cruddatabasekata.entity.Category;
import com.example.cruddatabasekata.entity.Note;
import com.example.cruddatabasekata.repository.CategoryRepository;
import com.example.cruddatabasekata.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryNoteDaoImplement implements CategoryNoteDao{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category createNote(Note note) {
        Long categoryId = note.getFkCategoryId();
        Category category = categoryRepository.findById(categoryId).get();
        category.addNote(note);
        noteRepository.save(note);
        return categoryRepository.save(category);
    }

    @Override
    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Note note) {
        noteRepository.deleteById(note.getId());
    }

    @Override
    public void deleteCategory(Category category) {
        Category categoryToBeDeleted = categoryRepository.findById(category.getId()).get();
        if(categoryToBeDeleted.getNotes().size() > 0){
            categoryToBeDeleted.getNotes().forEach(note -> noteRepository.deleteById(note.getId()));
        }
        categoryRepository.deleteById(category.getId());
    }
}
