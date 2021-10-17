package br.gotasdetecnologia.apirest.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController //Aqui a diferença da aplicação com Model. Ou seja, retorna um objeto e não uma visão. dispensa uso do ResponseBody. E enviaremos o obje de dominio como resp. HTTP no formato JSON ( entendido para consumo do postman por exe)
@RequestMapping(value="/api")
@Api//(value="API REST Produtos Tecnológicos")
@CrossOrigin(origins="*") //Liberando acesso a todos que queiram utilizar
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Listagem dos Produtos")
	public List<Produto> listaprodutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value="Procurar por um produto")
	public Produto listaProdutosPorId(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}
	
	@PostMapping(path="/produto")
	@ApiOperation(value="Cadastrar novo Produto")
	public Produto salvarProduto(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping(path="/produto") //o ID é passado no proprio postman
	@ApiOperation(value="Exclusão de Produto")
	public void excluirRegistroPorId(@RequestBody Produto produto){
		produtoRepository.delete(produto);
	}
	
	@PutMapping(path="/produto") //o ID é passado no proprio postman
	public Produto atualizarRegistroPorId(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
	
	
	
	
	
	

}
