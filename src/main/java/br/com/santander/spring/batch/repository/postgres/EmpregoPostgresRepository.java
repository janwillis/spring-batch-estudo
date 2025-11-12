package br.com.santander.spring.batch.repository.postgres;

import br.com.santander.spring.batch.domain.entity.postgres.Emprego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpregoPostgresRepository extends JpaRepository<Emprego,Long> {

}
