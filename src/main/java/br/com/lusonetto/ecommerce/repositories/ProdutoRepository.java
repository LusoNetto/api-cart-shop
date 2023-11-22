package br.com.lusonetto.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lusonetto.ecommerce.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
