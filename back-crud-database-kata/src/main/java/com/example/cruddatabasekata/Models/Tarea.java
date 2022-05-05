package com.example.cruddatabasekata.Models;


import lombok.Data;

import javax.persistence.*;

@Entity(name = "Tarea")
@Table(name = "tarea")
@Data
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
     private  String title;
     private boolean  ok;
     private long KeyCategoriaId;
}
