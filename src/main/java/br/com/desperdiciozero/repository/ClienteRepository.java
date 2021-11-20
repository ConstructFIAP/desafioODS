package br.com.desperdiciozero.repository;

import br.com.desperdiciozero.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
