package com.example.cruddatabasekata.Repository;

import com.example.cruddatabasekata.Models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatedoriaRepository  extends JpaRepository<Categoria,Long> {
}
