package com.example.cruddatabasekata.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "Categoria")
@Table(name = "categoria")
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long  id ;
    @NotBlank(message = "Name  es obligatorio")
    private  String name;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Tarea> tarea = new ArrayList<>();

    public Categoria addTarea(Tarea tarea) {
        this.tarea.add(tarea);

        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tarea> getTarea() {
        return tarea;
    }

    public void setTarea(List<Tarea> tarea) {
        this.tarea = tarea;
    }
}
