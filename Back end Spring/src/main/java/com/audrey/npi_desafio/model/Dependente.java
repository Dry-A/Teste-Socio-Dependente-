package com.audrey.npi_desafio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "cadastro_dependente")
public class Dependente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome deve ser preenchido!")
    @Size(min = 5, max = 50)
    private String nome;

    @NotNull
    @Min(value = 0)
    private int idade;

    @ManyToMany(mappedBy = "dependentes")
    private List<Socio> socios = new ArrayList<>();
}