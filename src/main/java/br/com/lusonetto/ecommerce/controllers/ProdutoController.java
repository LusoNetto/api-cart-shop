package br.com.lusonetto.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lusonetto.ecommerce.models.Produto;
import br.com.lusonetto.ecommerce.repositories.ProdutoRepository;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping()
    List<Produto> all() {
        return produtoRepository.findAll();
    }

    @PostMapping()
    Produto newProduto(@RequestBody Produto newProduto) {
        return produtoRepository.save(newProduto);
    }

    @GetMapping("/{id}")
    Produto one(@PathVariable Long id) {

        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum produto encontrado"));
    }

    @PutMapping("/{id}")
    Produto replaceProduto(@RequestBody Produto newProduto, @PathVariable Long id) {

        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setNome(newProduto.getNome());
                    produto.setPreco(newProduto.getPreco());
                    return produtoRepository.save(produto);
                })
                .orElseGet(() -> {
                    newProduto.setId(id);
                    return produtoRepository.save(newProduto);
                });
    }

    @DeleteMapping("/{id}")
    void deleteProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}
