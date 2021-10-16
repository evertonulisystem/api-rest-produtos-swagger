package br.gotasdetecnologia.apirest.resource;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gotasdetecnologia.apirest.model.Produto;
import br.gotasdetecnologia.apirest.repository.ProdutoRepository;

@RestController //Aqui a diferença da aplicação com Model. Ou seja, retorna um objeto e não uma visão. dispensa uso do ResponseBody. E enviaremos o obje de dominio como resp. HTTP no formato JSON ( entendido para consumo do postman por exe)
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
	
	@PostMapping(path="/produto")
	public Produto salvarProduto(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping(path="/produto") //o ID é passado no proprio postman
	//@Transactional
	public void excluirRegistroPorId(@RequestBody Produto produto){
		produtoRepository.delete(produto);
	}
	
	@PutMapping(path="/produto") //o ID é passado no proprio postman
	//@Transactional
	public Produto atualizarRegistroPorId(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
	
	
	
	
	
	

}
