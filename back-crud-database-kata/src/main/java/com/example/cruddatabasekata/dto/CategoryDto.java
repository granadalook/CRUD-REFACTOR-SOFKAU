package com.example.cruddatabasekata.dto;

import com.example.cruddatabasekata.entity.Note;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDto {

    private Long       id;
    private String     name;
    private List<Note> notes = new ArrayList<>();
}

