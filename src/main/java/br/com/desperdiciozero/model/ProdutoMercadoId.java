package br.com.desperdiciozero.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class ProdutoMercadoId implements Serializable {

    private Long idProduto;
    private Long idMercado;

}
