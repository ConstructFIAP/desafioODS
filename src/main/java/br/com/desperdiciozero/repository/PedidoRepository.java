package br.com.desperdiciozero.repository;

import br.com.desperdiciozero.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}

