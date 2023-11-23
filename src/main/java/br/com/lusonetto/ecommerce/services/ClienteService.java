package br.com.lusonetto.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lusonetto.ecommerce.models.Carrinho;
import br.com.lusonetto.ecommerce.models.Cliente;
import br.com.lusonetto.ecommerce.repositories.CarrinhoRepository;
import br.com.lusonetto.ecommerce.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    CarrinhoRepository carrinhoRepository;

    public Cliente newCliente(Cliente cliente){
        Carrinho carrinho = carrinhoRepository.save(new Carrinho());
        cliente.setCarrinho(carrinho);
        return clienteRepository.save(cliente);
    }
}
