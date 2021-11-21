package br.com.desperdiciozero.controller;


import br.com.desperdiciozero.model.InstCaridade;
import br.com.desperdiciozero.model.Mercado;
import br.com.desperdiciozero.repository.MercadoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dzero")
public class MercadoController {
    private MercadoRepository mercadoRepository;

    public MercadoController(MercadoRepository mercadoRepository) {
        this.mercadoRepository = mercadoRepository;
    }

    @GetMapping("/mercados")
    public ResponseEntity<List<Mercado>> listarMercados(){
        List<Mercado> mercados = mercadoRepository.findAll();
        return new ResponseEntity<List<Mercado>>(mercados, HttpStatus.OK);
    }

    @GetMapping("/mercados/{id}")
    public ResponseEntity<Mercado> getMercado(@PathVariable("id") long id){
        Mercado mercado = mercadoRepository.getById(id);
        return new ResponseEntity<Mercado>(mercado, HttpStatus.OK);
    }

    @PostMapping("/mercados")
    public ResponseEntity<Mercado> salvarMercado(@RequestBody Mercado mercado) {
        Mercado novoMercado = mercadoRepository.save(mercado);
        return new ResponseEntity<Mercado>(novoMercado, HttpStatus.CREATED);
    }

    @DeleteMapping("/mercados/{id}")
    public ResponseEntity<?> excluirMercado(@PathVariable("id") long id) {
        mercadoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
