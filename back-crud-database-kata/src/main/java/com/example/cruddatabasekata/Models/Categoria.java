package com.example.cruddatabasekata.Models;

import lombok.Data;

import javax.persistence.*;


@Entity(name = "Categoria")
@Table(name = "categoria")
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long  id ;
    private  String name;


}
