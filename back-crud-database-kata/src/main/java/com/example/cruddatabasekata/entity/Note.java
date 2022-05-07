package com.example.cruddatabasekata.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "Note")
@Table(name = "note")
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "TITULO ES REQUERIDO")
    private String title;

    private Boolean done;

    private Long fkCategoryId;
}
