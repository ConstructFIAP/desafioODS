package br.com.desperdiciozero.controller;


import br.com.desperdiciozero.model.Loja;
import br.com.desperdiciozero.repository.LojaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reobra")
public class LojaController {
    private LojaRepository lojaRepository;

    public LojaController(LojaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }

    @GetMapping("/loja")
    public ResponseEntity<List<Loja>> listarLojas(){
        List<Loja> lojas = lojaRepository.findAll();
        return new ResponseEntity<List<Loja>>(lojas, HttpStatus.OK);
    }

    @GetMapping("/loja/{id}")
    public ResponseEntity<Loja> getLoja(@PathVariable("id") long id){
        Loja loja = lojaRepository.getById(id);
        return new ResponseEntity<Loja>(loja, HttpStatus.OK);
    }

}
