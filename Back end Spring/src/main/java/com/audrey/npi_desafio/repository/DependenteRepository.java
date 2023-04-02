package com.audrey.npi_desafio.repository;


import com.audrey.npi_desafio.model.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente,Long> {

    public List<Dependente> findAllByNomeContainingIgnoreCase(@Param("nome")
                                                               String nome);


}
