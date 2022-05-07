package com.example.cruddatabasekata.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Category")
@Table(name = "category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "NOMBRE ES REQUERIDO")
    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Note> notes = new ArrayList<>();

    /**
     * Method that add up a new note to the category
     */
    public Category addNote(Note note) {
        this.notes.add(note);

        return this;
    }
}
