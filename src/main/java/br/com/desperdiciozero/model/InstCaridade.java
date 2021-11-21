package br.com.desperdiciozero.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "ods_inst_caridade")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class InstCaridade {

    @Id
    @SequenceGenerator(name = "odsSeqCaridade", sequenceName = "odsSeqCaridade", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "odsSeqCaridade")
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "endereco")
    private String endereco;

}
