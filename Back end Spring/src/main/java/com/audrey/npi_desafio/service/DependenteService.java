package com.audrey.npi_desafio.service;

import com.audrey.npi_desafio.dto.DependenteDTO;
import com.audrey.npi_desafio.model.Dependente;
import com.audrey.npi_desafio.repository.DependenteRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DependenteService {
        @Autowired
        private DependenteRepository dependenteRepository;
        @Autowired
        private ModelMapper modelMapper;

        private static final String NOT_FOUND_EXCEPTION_HANDLER = "Dependente não encontrado por este id.";
        public DependenteDTO Entity_To_Dto(Dependente dependente) {
            modelMapper.getConfiguration()
                    .setMatchingStrategy(MatchingStrategies.LOOSE);
            DependenteDTO dependenteDTO = new DependenteDTO();
            dependenteDTO = modelMapper.map(dependente, DependenteDTO.class);
            return dependenteDTO;
        }

        public Dependente Dto_To_Entity(DependenteDTO dependenteDTO){
            modelMapper.getConfiguration()
                    .setMatchingStrategy(MatchingStrategies.LOOSE);
            Dependente dependente = new Dependente();
            dependente = modelMapper.map(dependenteDTO,Dependente.class);
            return dependente;
        }

        public List<DependenteDTO> listAll(){
            return dependenteRepository.findAll().stream().map(this::Entity_To_Dto).collect(Collectors.toList());
        }
        public Dependente addDependente(Dependente dependente){
            return dependenteRepository.save(dependente);

        }
        public ResponseEntity<Dependente> findDependenteById(Long id){
            return dependenteRepository.findById(id)
                    .map(dependente -> ResponseEntity.ok().body(dependente) )
                    .orElse(ResponseEntity.notFound().build());
        }
        public ResponseEntity <Dependente> updateDependenteById(Dependente dependente, Long id){
            return dependenteRepository.findById(id)
                    .map(updateDependente -> {
                        updateDependente.setNome(dependente.getNome());
                        updateDependente.setIdade(dependente.getIdade());

                        Dependente update = dependenteRepository.save(updateDependente);
                        return ResponseEntity.ok().body(update);
                    }).orElse(ResponseEntity.notFound().build());
        }
        public ResponseEntity <Object> deleteDependenteById(Long id){
            return dependenteRepository.findById(id)
                    .map(deleteDependente ->{
                        dependenteRepository.deleteById(id);
                        return ResponseEntity.noContent().build();
                    }).orElse(ResponseEntity.notFound().build());
        }


    }
