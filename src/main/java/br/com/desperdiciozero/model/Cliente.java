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
@Table(name="reobra_cliente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente {

    @Id
    @SequenceGenerator(name = "seqCliente", sequenceName = "seqCliente", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "seqCliente")
    @Column(name="id")
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="nascimento")
    private String nascimento;

    @Column(name="endereco")
    private String endereco;

    @Column(name="telefone")
    private String telefone;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

}
