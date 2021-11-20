package br.com.desperdiciozero.service;

import br.com.desperdiciozero.model.*;
import br.com.desperdiciozero.repository.ProdutoEstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private ProdutoEstoqueRepository produtoEstoqueRepository;

    public void salvarPedido(Pedido pedido) {
        List<DetalhePedido> detalhesPedido = pedido.getDetalhesPedido();
        if (!detalhesPedido.isEmpty()) {
            Produto produto;
            ProdutoEstoque produtoEstoque;
            Loja loja = pedido.getLoja();
            for (DetalhePedido detalhePedido: detalhesPedido) {
                produto = detalhePedido.getProduto();
                produtoEstoque = produtoEstoqueRepository.findByProdutoAndLoja(produto, loja);
                System.out.println(produtoEstoque.getEstoque());
            }
        }


    }

}
