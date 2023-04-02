package com.audrey.npi_desafio.controller;

import com.audrey.npi_desafio.dto.DependenteDTO;
import com.audrey.npi_desafio.model.Dependente;
import com.audrey.npi_desafio.repository.DependenteRepository;
import com.audrey.npi_desafio.service.DependenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dependentes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DependenteController {
    @Autowired
    private DependenteRepository dependenteRepository;
    @Autowired
    private DependenteService dependenteService;

    @GetMapping
    public List<DependenteDTO> getAll() {
        return dependenteService.listAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Dependente> getById(@PathVariable Long id) {
        return dependenteService.findDependenteById(id);
    }
    @PostMapping
    public Dependente post(@Valid @RequestBody Dependente dependente) {
        return dependenteService.addDependente(dependente);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Dependente> put(@PathVariable Long id, @Valid @RequestBody Dependente dependente) {

        return dependenteService.updateDependenteById(dependente, id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity <Object> delete(@PathVariable Long id) {

        return dependenteService.deleteDependenteById(id);

    }


}

