package com.AgenciaViagem.AgenciaViagem.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.AgenciaViagem.AgenciaViagem.models.Pacotes;

public interface PacotesRepository extends CrudRepository<Pacotes, String>{
    List<Pacotes> findByNome(String nome);
    Pacotes findByCodigo(String codigo);
} 

