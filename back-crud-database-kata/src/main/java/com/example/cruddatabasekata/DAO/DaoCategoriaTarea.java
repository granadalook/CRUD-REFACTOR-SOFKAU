package com.example.cruddatabasekata.DAO;

import com.example.cruddatabasekata.Models.Categoria;
import com.example.cruddatabasekata.Models.Tarea;

import java.util.List;

public interface DaoCategoriaTarea {
    List<Categoria> getCategoria();
    void  deleteTarea( Tarea tarea);
    void  deleteCategoria(Categoria categoria); Categoria crearCategoria (Categoria categoria);
    Categoria crearTarea(Tarea tarea);
    Categoria updateTarea( Tarea tarea);
}
