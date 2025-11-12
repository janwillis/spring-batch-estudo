package br.com.santander.spring.batch.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@MappedSuperclass   // Diz ao JPA para mapear os campos nas classes filhas
@Getter
@Setter
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public abstract class  AbstracteEntity<I extends  Serializable> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private I id;

}
