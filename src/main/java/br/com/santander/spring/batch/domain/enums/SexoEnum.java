package br.com.santander.spring.batch.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum SexoEnum {

    FEMININO(1,"FEMININO"),
    MASCULINO( 2,"MASCULINO"),
    OUTROS(3,"OUTROS");

    private  static final Map<Integer, SexoEnum> LOOKUP_BY_CODIGO = new HashMap<>();

    static {
        for (SexoEnum sexo : SexoEnum.values()){
            LOOKUP_BY_CODIGO.put(sexo.getCodigo(),sexo);
        }
    }

    private final Integer codigo;

    private final String descricao;
}
