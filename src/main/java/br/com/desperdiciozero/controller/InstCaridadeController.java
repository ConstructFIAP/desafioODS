package br.com.desperdiciozero.controller;


import br.com.desperdiciozero.model.InstCaridade;
import br.com.desperdiciozero.repository.InstCaridadeRepository;
import br.com.desperdiciozero.repository.MercadoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<InstCaridade> getLoja(@PathVariable("id") long id){
        InstCaridade instCaridade = instCaridadeRepository.getById(id);
        return new ResponseEntity<InstCaridade>(instCaridade, HttpStatus.OK);
    }

}
