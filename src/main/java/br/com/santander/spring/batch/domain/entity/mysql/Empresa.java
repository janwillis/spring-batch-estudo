package br.com.santander.spring.batch.domain.entity.mysql;

import br.com.santander.spring.batch.constants.SchemaConstants;
import br.com.santander.spring.batch.domain.entity.AbstracteEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;


@Entity
@Table(name = "TB_EMPRESSA")
public class Empresa extends AbstracteEntity<Long> {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CNPJ")
    private String cnpj;


}
