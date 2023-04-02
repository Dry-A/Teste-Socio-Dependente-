package com.audrey.npi_desafio.repository;

import com.audrey.npi_desafio.model.Dependente;
import com.audrey.npi_desafio.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {

    public List<Socio> findAllByNomeContainingIgnoreCase(@Param("nome")
                                                         String nome);

}
