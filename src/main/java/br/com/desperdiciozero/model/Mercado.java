package br.com.desperdiciozero.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ods_mercado")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
public class Mercado {

    @Id
    @SequenceGenerator(name = "odsSeqMercado", sequenceName = "odsSeqMercado", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "odsSeqMercado")
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "endereco")
    private String endereco;

    @OneToMany(mappedBy = "mercado")
    @JsonIgnore
    private List<ProdutoMercado> produtosMercado;

    public Mercado(long idMercado) {
        this.id = idMercado;
    }
}
