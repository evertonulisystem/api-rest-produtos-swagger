package br.gotasdetecnologia.apirest.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="TBL_Produto")
public class Produto implements Serializable{
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Criando automaticamente os ID; No POST não precisa passar o id
	private long id;
	
	private String nome;
	
	private Integer handle;
	
	//@NotNull(message="O valor do Handle Participante não pode ser nulo.")
	//@Min(value=1, message="O campo deve ter mais de um caracter.")
	
	//@NotEmpty(message="O valor do Handle Participante não pode ser nulo.")
	
	@NotBlank(message="o valor nao pode ser vazio")
	private String handleParticipante;
	
	public String getHandleParticipante() {
		return handleParticipante;
	}

	public void setHandleParticipante(String handleParticipante) {
		this.handleParticipante = handleParticipante;
	}

	public void setHandle(Integer handle) {
		this.handle = handle;
	}

	private BigDecimal quantidade;
	
	private BigDecimal preco;
	
	private LocalDateTime dtCadastro; 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getHandle() {
		return handle;
	}

	public void setHandle(int handle) {
		this.handle = handle;
	}

	
	public LocalDateTime getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(LocalDateTime dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
	
	
	
	

}
