package br.com.anteros.security.model;

import java.io.Serializable;
import java.util.List;

import br.com.anteros.persistence.metadata.annotation.Cascade;
import br.com.anteros.persistence.metadata.annotation.Column;
import br.com.anteros.persistence.metadata.annotation.Entity;
import br.com.anteros.persistence.metadata.annotation.Fetch;
import br.com.anteros.persistence.metadata.annotation.ForeignKey;
import br.com.anteros.persistence.metadata.annotation.GeneratedValue;
import br.com.anteros.persistence.metadata.annotation.Id;
import br.com.anteros.persistence.metadata.annotation.Index;
import br.com.anteros.persistence.metadata.annotation.Indexes;
import br.com.anteros.persistence.metadata.annotation.SequenceGenerator;
import br.com.anteros.persistence.metadata.annotation.Table;
import br.com.anteros.persistence.metadata.annotation.type.CascadeType;
import br.com.anteros.persistence.metadata.annotation.type.FetchMode;
import br.com.anteros.persistence.metadata.annotation.type.FetchType;
import br.com.anteros.persistence.metadata.annotation.type.GeneratedType;

/*
 * Recurso
 * 
 * Classe que representa o objeto que será controlado o acesso pelo usuário dentro de um sistema.
 * Ex: Formulário, relatório, etc. Terá uma lista de ações específicas que serão atribuídas posteriormente
 * a qualquer objeto que extenda Seguranca como um Papel, um Usuario ou um Grupo.
 * 
 */
@Entity
@Table(name = "SEGURANCARECURSO")
@Indexes(value = {
		@Index(name = "UK_SEGURANCARECURSO_NOME_RECURSO", columnNames = { "ID_SISTEMA, NOME_RECURSO"}, unique = true) })
public class Resource implements Serializable {

	/*
	 * Identificação do Recurso
	 */
	@Id
	@Column(name = "ID_RECURSO", length = 8)
	@GeneratedValue(strategy = GeneratedType.AUTO)
	@SequenceGenerator(sequenceName = "SEQ_RECURSO", initialValue = 1)
	private Long id;

	/*
	 * Nome do Recurso
	 */
	@Column(name = "NOME_RECURSO", length = 40, required = true)
	private String nome;

	/*
	 * Descrição do Recurso
	 */
	@Column(name = "DS_RECURSO", length = 40, required = true)
	private String descricao;

	/*
	 * Lista de Ações que serão controladas acesso para um Recurso.
	 */
	@Fetch(type = FetchType.LAZY, mode = FetchMode.ONE_TO_MANY, mappedBy = "recurso")
	@Cascade(values = CascadeType.DELETE_ORPHAN)
	private List<Action> acoes;

	/*
	 * Sistema a qual pertence o Recurso.
	 */
	@ForeignKey(type = FetchType.EAGER)
	@Column(name = "ID_SISTEMA", inversedColumn = "ID_SISTEMA")
	private System sistema;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Action> getAcoes() {
		return acoes;
	}

	public void setAcoes(List<Action> acoes) {
		this.acoes = acoes;
	}

	public System getSistema() {
		return sistema;
	}

	public void setSistema(System sistema) {
		this.sistema = sistema;
	}

}
