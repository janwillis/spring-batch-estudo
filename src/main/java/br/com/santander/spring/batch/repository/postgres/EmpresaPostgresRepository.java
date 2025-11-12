package br.com.santander.spring.batch.repository.postgres;

import br.com.santander.spring.batch.domain.entity.postgres.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaPostgresRepository extends JpaRepository<Empresa,Long> {

}
