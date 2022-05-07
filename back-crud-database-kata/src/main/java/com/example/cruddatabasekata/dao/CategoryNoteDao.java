package com.example.cruddatabasekata.dao;

import com.example.cruddatabasekata.entity.Category;
import  com.example.cruddatabasekata.entity.Note;

import java.util.List;

public interface CategoryNoteDao {

    List<Category> getCategories();

    Category createCategory(Category category);

    Category createNote(Note note);

    Note updateNote(Note note);

    void deleteNote(Note note);

    void deleteCategory(Category category);
}
