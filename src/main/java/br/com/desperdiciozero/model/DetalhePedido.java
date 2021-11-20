package br.com.desperdiciozero.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name="reobra_detalhe_pedido")
public class DetalhePedido implements Serializable {

    @Id
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_pedido")
    private Pedido pedido;

    @Id
    @OneToOne
    @JoinColumn(name="id_produto")
    private Produto produto;

    @Column(name="quantidade")
    private int quantidade;

    @Column(name="preco")
    private BigDecimal preco;

    @Column(name="desconto")
    private BigDecimal desconto;

}
