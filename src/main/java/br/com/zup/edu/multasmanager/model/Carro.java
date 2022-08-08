package br.com.zup.edu.multasmanager.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String placa;
	
	@Column(nullable = false, length = 11)
	private String renavan;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(nullable = false)
	private String modelo;
	
	@Column(nullable = false, unique = true)
	private String chassi;
	
	@Column(nullable = false)
	private Integer ano;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@ManyToOne(optional = false)
	private Cliente cliente;
	
	
	public Carro(String placa, String renavan, String marca, String modelo, String chassi, Integer ano,
			BigDecimal valor, Cliente cliente) {
		super();
		this.placa = placa;
		this.renavan = renavan;
		this.marca = marca;
		this.modelo = modelo;
		this.chassi = chassi;
		this.ano = ano;
		this.valor = valor;
		this.cliente = cliente;
	}
	
	/**
	 * @deprecated construtor é de uso do hibernate
	 */
	@Deprecated
	public Carro() {
		
	}
	
	public Long getId() {
		return id;
	}

}
