package br.com.santander.spring.batch.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;

    private String nome;

    private LocalDate dataNascimento;

//
//    @Column(name = "SEXO")
//    @Converter
//    private SexoEnum sexo;

}
