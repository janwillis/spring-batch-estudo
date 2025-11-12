package br.com.santander.spring.batch.domain.entity.mysql;


import br.com.santander.spring.batch.constants.SchemaConstants;
import br.com.santander.spring.batch.domain.entity.AbstracteEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serial;


@Entity
@Table(name = "TB_EMPREGO")
public class Empregro  extends AbstracteEntity<Long> {
    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PESSOA_ID",foreignKey = @ForeignKey(name = "fk_emprego_pessoa"))
    private Pessoa pessoa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPRESA_ID", foreignKey = @ForeignKey(name = "fk_emprego_empresa"))
    private Empresa empresa;

}
