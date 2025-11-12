package br.com.santander.spring.batch.repository.mysql;

import br.com.santander.spring.batch.domain.entity.mysql.Empregro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpregoRepository extends JpaRepository<Empregro,Long> {

}
