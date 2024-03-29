package br.com.desperdiciozero.controller;


import br.com.desperdiciozero.model.Cliente;
import br.com.desperdiciozero.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dzero")
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> listarClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable("id") long id){
        Cliente cliente = clienteRepository.getById(id);
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteRepository.save(cliente);
        return new ResponseEntity<Cliente>(novoCliente, HttpStatus.CREATED);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> excluirCliente(@PathVariable("id") long id) {
        clienteRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
