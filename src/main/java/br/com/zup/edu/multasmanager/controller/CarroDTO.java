package br.com.zup.edu.multasmanager.controller;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.zup.edu.multasmanager.model.Carro;
import br.com.zup.edu.multasmanager.model.Cliente;

public class CarroDTO {
	
	@NotBlank
	private String placa;
	
	@NotBlank
	@Size(min=11,max=11)
	private String renavan;
	
	@NotBlank
	private String marca;
	
	@NotBlank
	private String modelo;
	
	@NotBlank
	private String chassi;
	
	@Positive
	@NotNull
	private Integer ano;
	
	@Positive
	@NotNull
	private BigDecimal valor;

	public CarroDTO(@NotBlank String placa, @NotBlank @Size(min = 11, max = 11) String renavan, @NotBlank String marca,
			@NotBlank String modelo, @NotBlank String chassi, @Positive @NotNull Integer ano,
			@Positive @NotNull BigDecimal valor) {
		this.placa = placa;
		this.renavan = renavan;
		this.marca = marca;
		this.modelo = modelo;
		this.chassi = chassi;
		this.ano = ano;
		this.valor = valor;
	}
	
	public CarroDTO() {
		
	}
	
	public Carro paraCarro(Cliente cliente) {
		return new Carro(placa,renavan,marca,modelo,chassi,ano,valor,cliente);
	}

	public String getPlaca() {
		return placa;
	}

	public String getRenavan() {
		return renavan;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getChassi() {
		return chassi;
	}

	public Integer getAno() {
		return ano;
	}

	public BigDecimal getValor() {
		return valor;
	}

}
