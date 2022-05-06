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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public long getKeyCategoriaId() {
        return KeyCategoriaId;
    }

    public void setKeyCategoriaId(long keyCategoriaId) {
        KeyCategoriaId = keyCategoriaId;
    }


}
