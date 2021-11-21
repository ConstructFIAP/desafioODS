package br.com.desperdiciozero.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ProdutoMercadoId.class)
@Table(name="ods_produto_mercado")
public class ProdutoMercado implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_produto")
    private Produto produto;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_mercado")
    private Mercado mercado;

    @Column(name="preco")
    private BigDecimal preco;

    @Column(name="data_validade")
    private String dataValidade;

}
