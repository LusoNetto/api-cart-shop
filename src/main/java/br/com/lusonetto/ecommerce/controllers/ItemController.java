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

import br.com.lusonetto.ecommerce.models.Item;
import br.com.lusonetto.ecommerce.repositories.ItemRepository;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping()
    List<Item> all() {
        return itemRepository.findAll();
    }

    @PostMapping()
    Item newItem(@RequestBody Item newItem) {
        return itemRepository.save(newItem);
    }

    @GetMapping("/{id}")
    Item one(@PathVariable Long id) {

        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum item encontrado"));
    }

    @PutMapping("/{id}")
    Item replaceItem(@RequestBody Item newItem, @PathVariable Long id) {

        return itemRepository.findById(id)
                .map(item -> {
                    item.setQuantidade(newItem.getQuantidade());
                    item.setProduto(newItem.getProduto());
                    return itemRepository.save(item);
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    return itemRepository.save(newItem);
                });
    }

    @DeleteMapping("/{id}")
    void deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }
}
