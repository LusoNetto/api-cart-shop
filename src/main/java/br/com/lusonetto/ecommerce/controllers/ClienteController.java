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

import br.com.lusonetto.ecommerce.models.Cliente;
import br.com.lusonetto.ecommerce.repositories.ClienteRepository;
import br.com.lusonetto.ecommerce.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ClienteService clienteService;

    ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping()
    List<Cliente> all() {
        return clienteRepository.findAll();
    }

    @PostMapping()
    Cliente newCliente(@RequestBody Cliente newCliente) {
        return clienteService.newCliente(newCliente);
    }

    @GetMapping("/{id}")
    Cliente one(@PathVariable Long id) {

        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum cliente encontrado"));
    }

    @PutMapping("/{id}")
    Cliente replaceCliente(@RequestBody Cliente newCliente, @PathVariable Long id) {

        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(newCliente.getNome());
                    cliente.setLogin(newCliente.getLogin());
                    cliente.setSenha(newCliente.getSenha());
                    cliente.setEmail(newCliente.getEmail());
                    cliente.setWhatsapp(newCliente.getWhatsapp());
                    return clienteRepository.save(cliente);
                })
                .orElseGet(() -> {
                    newCliente.setId(id);
                    return clienteRepository.save(newCliente);
                });
    }

    @DeleteMapping("/{id}")
    void deleteCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }
}
