package com.audrey.npi_desafio.controller;

import com.audrey.npi_desafio.dto.SocioDTO;
import com.audrey.npi_desafio.model.Socio;
import com.audrey.npi_desafio.repository.SocioRepository;
import com.audrey.npi_desafio.service.SocioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/socios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SocioController {
    @Autowired
    private SocioRepository socioRepository;
    @Autowired
    private SocioService socioService;
    @GetMapping
    public List<SocioDTO> getAll() {
        return socioService.listAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Socio> getById(@PathVariable Long id) {
        return socioService.findSocioById(id);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Socio>> getByNome(@PathVariable String nome){
        return ResponseEntity.ok(socioRepository.findAllByNomeContainingIgnoreCase(nome));
    }
    @PostMapping
    public Socio post(@Valid @RequestBody Socio socio) {
        return socioService.addSocio(socio);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Socio> put(@PathVariable Long id, @Valid @RequestBody Socio socio) {

        return socioService.updateSocioById(socio, id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity <Object> delete(@PathVariable Long id) {

        return socioService.deleteSocioById(id);

    }

}
