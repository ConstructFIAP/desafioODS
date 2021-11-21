package br.com.desperdiciozero.controller;


import br.com.desperdiciozero.model.Cliente;
import br.com.desperdiciozero.model.InstCaridade;
import br.com.desperdiciozero.repository.InstCaridadeRepository;
import br.com.desperdiciozero.repository.MercadoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dzero")
public class InstCaridadeController {
    private InstCaridadeRepository instCaridadeRepository;

    public InstCaridadeController(MercadoRepository mercadoRepository, InstCaridadeRepository instCaridadeRepository) {
        this.instCaridadeRepository = instCaridadeRepository;
    }

    @GetMapping("/caridade")
    public ResponseEntity<List<InstCaridade>> listarInstCaridade(){
        List<InstCaridade> instCaridadeList = instCaridadeRepository.findAll();
        return new ResponseEntity<List<InstCaridade>>(instCaridadeList, HttpStatus.OK);
    }

    @GetMapping("/caridade/{id}")
    public ResponseEntity<InstCaridade> getInstCaridade(@PathVariable("id") long id){
        InstCaridade instCaridade = instCaridadeRepository.getById(id);
        return new ResponseEntity<InstCaridade>(instCaridade, HttpStatus.OK);
    }

    @PostMapping("/caridade")
    public ResponseEntity<InstCaridade> salvarInstCaridade(@RequestBody InstCaridade instCaridade) {
        InstCaridade novaInstCaridade = instCaridadeRepository.save(instCaridade);
        return new ResponseEntity<InstCaridade>(novaInstCaridade, HttpStatus.CREATED);
    }

    @DeleteMapping("/caridade/{id}")
    public ResponseEntity<?> excluirInstCaridade(@PathVariable("id") long id) {
        instCaridadeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
