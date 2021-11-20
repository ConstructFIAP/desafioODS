package br.com.desperdiciozero.repository;

import br.com.desperdiciozero.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
