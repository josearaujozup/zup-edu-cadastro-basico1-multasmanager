package br.com.zup.edu.multasmanager.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Acidente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDateTime dataHoraAcontecimento;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false)
	private String estado;
	
	@Column(nullable = false)
	private String logradouro;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private String cep;
	
	@Column(nullable = false)
	private String observacoes;
	
	@ManyToOne(optional = false)
	private Carro carro;
	
	
	public Acidente(LocalDateTime dataHoraAcontecimento, String cidade, String estado, String logradouro, String bairro,
			String cep, String observacoes, Carro carro) {
		this.dataHoraAcontecimento = dataHoraAcontecimento;
		this.cidade = cidade;
		this.estado = estado;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.observacoes = observacoes;
		this.carro = carro;
	}
	
	/**
	 * @deprecated construtor é de uso do hibernate
	 */
	@Deprecated
	public Acidente() {
		
	}
	
	public Long getId() {
		return id;
	}
	
}
