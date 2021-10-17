package br.gotasdetecnologia.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gotasdetecnologia.apirest.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Produto findById(long id);

}
