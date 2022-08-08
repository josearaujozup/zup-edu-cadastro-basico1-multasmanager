package br.com.zup.edu.multasmanager.model;

import br.com.zup.edu.multasmanager.utils.CpfUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length=25)
	private String nome;
	
	@Column(nullable = false, length=25)
	private String sobrenome;
	
	@Column(nullable = false, length=14)
	private String cpf;

	@Column(nullable = false, unique = true, length = 64) // unico
	private String hashDoCpf;

	@Column(nullable = false)
	private Integer rg;
	
	@Column(nullable = false, length=200)
	private String endereco;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false, length=14)
	private String telefone;

	public Cliente(String nome, String sobrenome, String cpf, Integer rg, String endereco, String email,
			String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = CpfUtils.anonymize(cpf);
		this.hashDoCpf = CpfUtils.hash(cpf);
		this.rg = rg;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}
	
	/**
	 * @deprecated construtor é de uso do hibernate
	 */
	@Deprecated
	public Cliente() {
		
	}

	public Long getId() {
		return id;
	}

}
