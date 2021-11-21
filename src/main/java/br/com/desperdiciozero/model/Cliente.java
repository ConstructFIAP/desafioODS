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
@Table(name="ods_cliente")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente {

    @Id
    @SequenceGenerator(name = "odsSeqCliente", sequenceName = "odsSeqCliente", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "odsSeqCliente")
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

}
