package br.com.zup.edu.multasmanager.controller;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.edu.multasmanager.model.Acidente;
import br.com.zup.edu.multasmanager.model.Carro;

public class AcidenteDTO {
	
	@NotBlank
	private String cidade;
	
	@NotBlank
	private String estado;
	
	@NotBlank
	private String logradouro;
	
	@NotBlank
	private String bairro;
	
	@NotBlank
	private String cep;
	
	@NotBlank
	private String observacoes;
	
	@PastOrPresent
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@NotNull
	private LocalDateTime dataHoraAcontecimento;

	public AcidenteDTO(@NotBlank String cidade, @NotBlank String estado, @NotBlank String logradouro,
			@NotBlank String bairro, @NotBlank String cep, @NotBlank String observacoes,
			@PastOrPresent @NotNull LocalDateTime dataHoraAcontecimento) {
		this.cidade = cidade;
		this.estado = estado;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.observacoes = observacoes;
		this.dataHoraAcontecimento = dataHoraAcontecimento;
	}
	
	public AcidenteDTO() {
		
	}
	
	public Acidente paraAcidente(Carro carro) {
		return new Acidente(dataHoraAcontecimento, cidade, estado, logradouro, bairro, cep, observacoes, carro);
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public LocalDateTime getDataHoraAcontecimento() {
		return dataHoraAcontecimento;
	}
	
	
	
}
