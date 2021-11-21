package br.com.desperdiciozero.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ods_produto")
public class Produto {

    @Id
    @SequenceGenerator(name = "odsSeqProduto", sequenceName = "odsSeqProduto", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "odsSeqProduto")
    @Column(name="id")
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="organico")
    private boolean organico;

    @Column(name="dataValidade")
    private String dataValidade;

    @Column(name="caminho_imagem")
    private String caminho_imagem;

}
