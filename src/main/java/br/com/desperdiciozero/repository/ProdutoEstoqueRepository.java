package br.com.desperdiciozero.repository;

import br.com.desperdiciozero.model.Loja;
import br.com.desperdiciozero.model.Produto;
import br.com.desperdiciozero.model.ProdutoEstoque;
import br.com.desperdiciozero.model.ProdutoEstoqueId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoEstoqueRepository extends JpaRepository<ProdutoEstoque, ProdutoEstoqueId> {

    public ProdutoEstoque findByProdutoAndLoja(Produto produto, Loja loja);

}
