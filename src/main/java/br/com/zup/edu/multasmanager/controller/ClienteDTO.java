package br.com.zup.edu.multasmanager.controller;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import br.com.zup.edu.multasmanager.model.Cliente;

public class ClienteDTO {
	
	@NotBlank
	@Length(max = 25)
	private String nome;
	
	@NotBlank
	@Length(max = 25)
	private String sobrenome;
	
	@NotBlank
	@CPF
	private String cpf;
	
	@Positive
	@NotNull
	private Integer rg;
	
	@NotBlank
	@Length(min = 30, max = 200)
	private String endereco;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Length(min = 14, max = 14)
	private String telefone;

	public ClienteDTO(@NotBlank @Length(min = 25, max = 25) String nome,
			@NotBlank @Length(min = 25, max = 25) String sobrenome, @NotBlank @CPF String cpf,
			@Positive @NotNull Integer rg, @NotBlank @Length(min = 30, max = 200) String endereco,
			@NotBlank @Email String email, @NotBlank @Length(min = 14, max = 14) String telefone) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}
	
	
	public ClienteDTO() {
		
	}
	
	public Cliente paraCliente() {
		return new Cliente(nome,sobrenome,cpf,rg,endereco,email,telefone);
	}
	
	
	public String getNome() {
		return nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}


	public String getCpf() {
		return cpf;
	}


	public Integer getRg() {
		return rg;
	}


	public String getEndereco() {
		return endereco;
	}


	public String getEmail() {
		return email;
	}


	public String getTelefone() {
		return telefone;
	}
	
}
