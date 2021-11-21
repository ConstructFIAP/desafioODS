package br.com.desperdiciozero.repository;

import br.com.desperdiciozero.model.ProdutoMercado;
import br.com.desperdiciozero.model.ProdutoMercadoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoMercadoRepository extends JpaRepository<ProdutoMercado, ProdutoMercadoId> {

}
