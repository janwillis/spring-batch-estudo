package br.com.santander.spring.batch.domain.entity.postgres;

import br.com.santander.spring.batch.constants.SchemaConstants;
import br.com.santander.spring.batch.domain.entity.AbstracteEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.time.LocalDate;


@Entity
@Table(name = "TB_PESSOA", schema = SchemaConstants.ENTIDADES)
public class Pessoa extends AbstracteEntity <Long> {

    @Serial
    private static final long serialVersionUID = 1L;


    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;


}
