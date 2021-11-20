package br.com.desperdiciozero.controller;


import br.com.desperdiciozero.model.Cliente;
import br.com.desperdiciozero.model.Pedido;
import br.com.desperdiciozero.repository.ClienteRepository;
import br.com.desperdiciozero.repository.PedidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reobra")
public class PedidoController {

    private PedidoRepository pedidoRepository;
    private ClienteRepository clienteRepository;

    public PedidoController(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/pedido")
    public ResponseEntity<List<Pedido>> listarPedidos(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/pedido/{id}")
    public ResponseEntity<Pedido> getPedido(@PathVariable("id") long id){
        Pedido pedido = pedidoRepository.getById(id);
        return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
    }

    @PostMapping("/pedido")
    public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoRepository.save(pedido);
        return new ResponseEntity<Pedido>(novoPedido, HttpStatus.CREATED);
    }

    @GetMapping("/pedido/cliente/{idCliente}")
    public ResponseEntity<List<Pedido>> getPedidosPorCliente(@PathVariable("idCliente") long idCliente){
        Cliente cliente = clienteRepository.getById(idCliente);
        List<Pedido> pedidos = pedidoRepository.findByCliente(cliente);
        return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
    }

}
