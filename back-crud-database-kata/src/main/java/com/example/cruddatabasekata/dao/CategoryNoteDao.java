package com.example.cruddatabasekata.dao;

import com.example.cruddatabasekata.entity.Category;
import com.example.cruddatabasekata.entity.Note;

import java.util.List;

public interface CategoryNoteDao {

    List<Category> getCategories();

    Category createCategory(Category category);

    Note createNote(Note note);

    Note updateNote(Note note);

    void deleteNote(Long id);

    void deleteCategory(Long id);
}


