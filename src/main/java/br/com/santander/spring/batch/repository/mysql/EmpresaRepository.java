package br.com.santander.spring.batch.repository.mysql;

import br.com.santander.spring.batch.domain.entity.mysql.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long> {

}
