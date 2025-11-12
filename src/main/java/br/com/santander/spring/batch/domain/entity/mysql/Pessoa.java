package br.com.santander.spring.batch.domain.entity.mysql;

import br.com.santander.spring.batch.constants.SchemaConstants;
import br.com.santander.spring.batch.domain.entity.AbstracteEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.time.LocalDate;

@Entity
@Table(name = "TB_PESSOA")
public class Pessoa extends AbstracteEntity <Long> {

    @Serial
    private static final long serialVersionUID = 1L;


    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;


}
