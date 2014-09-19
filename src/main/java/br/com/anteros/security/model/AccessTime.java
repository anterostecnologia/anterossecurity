package br.com.anteros.security.model;

import java.io.Serializable;
import java.util.List;

import br.com.anteros.persistence.metadata.annotation.Cascade;
import br.com.anteros.persistence.metadata.annotation.Column;
import br.com.anteros.persistence.metadata.annotation.Entity;
import br.com.anteros.persistence.metadata.annotation.Fetch;
import br.com.anteros.persistence.metadata.annotation.GeneratedValue;
import br.com.anteros.persistence.metadata.annotation.Id;
import br.com.anteros.persistence.metadata.annotation.SequenceGenerator;
import br.com.anteros.persistence.metadata.annotation.Table;
import br.com.anteros.persistence.metadata.annotation.type.CascadeType;
import br.com.anteros.persistence.metadata.annotation.type.FetchMode;
import br.com.anteros.persistence.metadata.annotation.type.FetchType;
import br.com.anteros.persistence.metadata.annotation.type.GeneratedType;

/*
 * HorarioAcesso
 * 
 * Classe que representa Horário de Acesso que será permitido ao Usuário utilizar o sistema.
 */
@Entity
@Table(name = "SEGURANCAHORARIO")
public class AccessTime implements Serializable {

	/*
	 * Identificação
	 */
	@Id
	@Column(name = "ID_HORARIO", length = 8)
	@GeneratedValue(strategy = GeneratedType.AUTO)
	@SequenceGenerator(sequenceName = "SEQ_HORARIO", initialValue = 1)
	private Long id;

	/*
	 * Descrição do horário de acesso
	 */
	@Column(name = "DS_HORARIO", length = 40, required = true)
	private String descricao;

	@Fetch(type = FetchType.LAZY, mode = FetchMode.ONE_TO_MANY, mappedBy = "horarioAcesso")
	@Cascade(values = CascadeType.DELETE_ORPHAN)
	private List<AccessTimeInterval> intervalos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<AccessTimeInterval> getIntervalos() {
		return intervalos;
	}

	public void setIntervalos(List<AccessTimeInterval> intervalos) {
		this.intervalos = intervalos;
	}
}
