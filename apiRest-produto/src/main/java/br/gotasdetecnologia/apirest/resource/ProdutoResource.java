package br.gotasdetecnologia.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gotasdetecnologia.apirest.model.Produto;
import br.gotasdetecnologia.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping(value="/api")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public List<Produto> listaprodutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	public Produto listaProdutosPorId(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}
	
	@PostMapping(path= "/produto")
	public Produto salvarProduto(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
	
	

}