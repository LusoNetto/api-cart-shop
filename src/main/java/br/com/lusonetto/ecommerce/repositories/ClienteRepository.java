package br.com.lusonetto.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lusonetto.ecommerce.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
