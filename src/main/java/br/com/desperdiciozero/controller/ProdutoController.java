package br.com.desperdiciozero.controller;


import br.com.desperdiciozero.model.Mercado;
import br.com.desperdiciozero.model.Produto;
import br.com.desperdiciozero.model.ProdutoMercado;
import br.com.desperdiciozero.repository.MercadoRepository;
import br.com.desperdiciozero.repository.ProdutoMercadoRepository;
import br.com.desperdiciozero.repository.ProdutoRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/dzero")
public class ProdutoController {

    private ProdutoRepository produtoRepository;
    private MercadoRepository mercadoRepository;
    private ProdutoMercadoRepository produtoMercadoRepository;

    public ProdutoController(ProdutoRepository produtoRepository, MercadoRepository mercadoRepository, ProdutoMercadoRepository produtoMercadoRepository) {
        this.produtoRepository = produtoRepository;
        this.mercadoRepository = mercadoRepository;
        this.produtoMercadoRepository = produtoMercadoRepository;
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> listarProdutos(){
        List<Produto> produtos = produtoRepository.findAll();
        return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> getProduto(@PathVariable("id") long id){
        Produto produto = produtoRepository.getById(id);
        return new ResponseEntity<Produto>(produto, HttpStatus.OK);
    }

    @RequestMapping(value = "/produtos/imagem/{id}", method = RequestMethod.GET, produces = "image/jpg")
    public @ResponseBody byte[] getImagem(@PathVariable("id") long id)  {
        try {

            String nomeArquivo = produtoRepository.getById(id).getCaminho_imagem();
            Resource resource = new ClassPathResource(nomeArquivo);
            InputStream is = resource.getInputStream();
            BufferedImage img = ImageIO.read(is);
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", bao);
            return bao.toByteArray();
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoRepository.save(produto);
        return new ResponseEntity<Produto>(novoProduto, HttpStatus.CREATED);
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable("id") long id) {
        produtoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/produtos/mercado/{idMercado}")
    public ResponseEntity<List<ProdutoMercado>> getProdutosDeMercado(@PathVariable("idMercado") long idMercado){
        Mercado mercado = mercadoRepository.getById(idMercado);
        List<ProdutoMercado> produtos = mercado.getProdutosMercado();
        return new ResponseEntity<List<ProdutoMercado>>(produtos, HttpStatus.OK);
    }

    @PostMapping("/produtos/mercado/{idMercado}")
    public ResponseEntity<ProdutoMercado> salvarProdutoEmMercado(@PathVariable("idMercado") long idMercado, @RequestBody ProdutoMercado produtoMercado) {
        Mercado mercado = mercadoRepository.getById(idMercado);
        produtoMercado.setMercado(mercado);
        ProdutoMercado novoProduto = produtoMercadoRepository.save(produtoMercado);
        return new ResponseEntity<ProdutoMercado>(novoProduto, HttpStatus.CREATED);
    }

}
