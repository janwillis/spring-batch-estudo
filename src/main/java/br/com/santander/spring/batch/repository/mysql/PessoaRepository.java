package br.com.santander.spring.batch.repository.mysql;

import br.com.santander.spring.batch.domain.entity.mysql.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository  extends JpaRepository< Pessoa,Long> {

}
