package br.com.santander.spring.batch.repository.postgres;

import br.com.santander.spring.batch.domain.entity.postgres.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaPostgresRepository extends JpaRepository< Pessoa,Long> {

}
