package com.audrey.npi_desafio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "cadastro_socio")
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não informado. Insira o nome do Sócio!")
    @Size(min = 5, max = 50)
    private String nome;

    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal renda;

    @NotNull
    private boolean ativo;

    @ManyToMany
    @JoinTable(name = "socio_dependente",
            joinColumns = @JoinColumn(name = "id_socio"),
            inverseJoinColumns = @JoinColumn(name = "id_dependente"))
    private List<Dependente> dependentes = new ArrayList<>();
}
