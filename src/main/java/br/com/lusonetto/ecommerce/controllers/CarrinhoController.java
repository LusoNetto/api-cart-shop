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

import br.com.lusonetto.ecommerce.models.Carrinho;
import br.com.lusonetto.ecommerce.repositories.CarrinhoRepository;

@RestController
@RequestMapping(value = "/carrinhos")
public class CarrinhoController {
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    CarrinhoController(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    @GetMapping()
    List<Carrinho> all() {
        return carrinhoRepository.findAll();
    }

    @PostMapping()
    Carrinho newCarrinho(@RequestBody Carrinho newCarrinho) {
        return carrinhoRepository.save(newCarrinho);
    }

    @GetMapping("/{id}")
    Carrinho one(@PathVariable Long id) {

        return carrinhoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum carrinho encontrado"));
    }

    @PutMapping("/{id}")
    Carrinho replaceCarrinho(@RequestBody Carrinho newCarrinho, @PathVariable Long id) {

        return carrinhoRepository.findById(id)
                .map(carrinho -> {
                    carrinho.setItems(newCarrinho.getItems());
                    carrinho.setCliente(newCarrinho.getCliente());
                    return carrinhoRepository.save(carrinho);
                })
                .orElseGet(() -> {
                    newCarrinho.setId(id);
                    return carrinhoRepository.save(newCarrinho);
                });
    }

    @DeleteMapping("/{id}")
    void deleteCarrinho(@PathVariable Long id) {
        carrinhoRepository.deleteById(id);
    }
}
