package com.example.cruddatabasekata.Repository;

import com.example.cruddatabasekata.Models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository  extends JpaRepository<Tarea,Long>{
}
