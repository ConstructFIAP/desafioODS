package br.com.desperdiciozero.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
public class ProdutoMercadoId implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_produto")
    private Produto produto;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_mercado")
    private Mercado mercado;

}
