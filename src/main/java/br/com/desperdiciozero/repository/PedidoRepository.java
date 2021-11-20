package br.com.desperdiciozero.repository;

import br.com.desperdiciozero.model.Cliente;
import br.com.desperdiciozero.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    public List<Pedido> findByCliente(Cliente cliente);

}

