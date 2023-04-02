package com.audrey.npi_desafio.service;

import com.audrey.npi_desafio.dto.SocioDTO;
import com.audrey.npi_desafio.model.Socio;
import com.audrey.npi_desafio.repository.SocioRepository;
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
public class SocioService {

    @Autowired
        private SocioRepository socioRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final String NOT_FOUND_EXCEPTION_HANDLER = "Id de Sócio não localizado.";
    public SocioDTO Entity_To_Dto(Socio socio) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        SocioDTO socioDTO = new SocioDTO();
        socioDTO = modelMapper.map(socio, SocioDTO.class);
        return socioDTO;
    }

    public Socio Dto_To_Entity(SocioDTO socioDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Socio socio = new Socio();
        socio = modelMapper.map(socioDTO,Socio.class);
        return socio;
    }

        public List<SocioDTO> listAll(){
            return socioRepository.findAll().stream().map(this::Entity_To_Dto).collect(Collectors.toList());
        }
        public Socio addSocio(Socio socio){
            return socioRepository.save(socio);

        }
        public ResponseEntity <Socio> findSocioById(Long id){
            return socioRepository.findById(id)
                    .map(socio -> ResponseEntity.ok().body(socio) )
                    .orElse(ResponseEntity.notFound().build());
        }
        public ResponseEntity <Socio> updateSocioById(Socio socio, Long id){
            return socioRepository.findById(id)
                    .map(updateSocio -> {
                        updateSocio.setNome(socio.getNome());
                        updateSocio.setRenda(socio.getRenda());
                        updateSocio.setAtivo(socio.isAtivo());
                        Socio update = socioRepository.save(updateSocio);
                        return ResponseEntity.ok().body(update);
                    }).orElse(ResponseEntity.notFound().build());
        }
        public ResponseEntity <Object> deleteSocioById(Long id){
            return socioRepository.findById(id)
                    .map(deleteSocio ->{
                        socioRepository.deleteById(id);
                        return ResponseEntity.noContent().build();
                    }).orElse(ResponseEntity.notFound().build());
        }


    }
