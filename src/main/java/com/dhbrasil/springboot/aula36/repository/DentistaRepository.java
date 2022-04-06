package com.dhbrasil.springboot.aula36.repository;

import com.dhbrasil.springboot.aula36.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistaRepository extends JpaRepository<Dentista, Integer> {

    //

}
