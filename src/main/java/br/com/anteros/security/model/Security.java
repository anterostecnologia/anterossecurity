package br.com.anteros.security.model;

import java.io.Serializable;
import java.util.Set;

import br.com.anteros.persistence.metadata.annotation.BooleanValue;
import br.com.anteros.persistence.metadata.annotation.Cascade;
import br.com.anteros.persistence.metadata.annotation.Column;
import br.com.anteros.persistence.metadata.annotation.DiscriminatorColumn;
import br.com.anteros.persistence.metadata.annotation.Entity;
import br.com.anteros.persistence.metadata.annotation.Fetch;
import br.com.anteros.persistence.metadata.annotation.GeneratedValue;
import br.com.anteros.persistence.metadata.annotation.Id;
import br.com.anteros.persistence.metadata.annotation.Inheritance;
import br.com.anteros.persistence.metadata.annotation.JoinColumn;
import br.com.anteros.persistence.metadata.annotation.JoinTable;
import br.com.anteros.persistence.metadata.annotation.SequenceGenerator;
import br.com.anteros.persistence.metadata.annotation.Table;
import br.com.anteros.persistence.metadata.annotation.type.BooleanType;
import br.com.anteros.persistence.metadata.annotation.type.CascadeType;
import br.com.anteros.persistence.metadata.annotation.type.FetchMode;
import br.com.anteros.persistence.metadata.annotation.type.FetchType;
import br.com.anteros.persistence.metadata.annotation.type.GeneratedType;
import br.com.anteros.persistence.metadata.annotation.type.InheritanceType;

/*
 * Seguranca
 * 
 * Classe abstrata que vai representar qualquer objeto que necessite de controle de acesso a determinados
 * Recursos/Ações dentro de um Sistema.
 */
@Entity
@Table(name = "SEGURANCA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TP_SEGURANCA", length = 40)
public abstract class Security implements Serializable {

	/*
	 * Identificação do Objeto de Segurança
	 */
	@Id
	@Column(name = "ID_SEGURANCA", length = 8)
	@GeneratedValue(strategy = GeneratedType.AUTO)
	@SequenceGenerator(sequenceName = "SEQ_SEGURANCA", initialValue = 1)
	private Long id;

	@Column(name = "NOME", length = 40, required = true)
	private String nome;

	@Column(name = "DESCRICAO", length = 40, required = true)
	private String descricao;

	@Column(name = "TP_SEGURANCA", length = 30, required = true)
	private String tipoSeguranca;

	/*
	 * Lista de Ações permitidas para um determinado objeto de Segurança.
	 */
	@Fetch(type = FetchType.LAZY, mode = FetchMode.MANY_TO_MANY)
	@JoinTable(name = "SEGURANCAACAOACAO", joinColumns = @JoinColumn(name = "ID_SEGURANCA"), inversedJoinColumns = @JoinColumn(name = "ID_ACAO"))
	private Set<Action> acoes;

	/*
	 * Lista de horários de acesso permitidos para um determinado objeto de
	 * Segurança.
	 */
	@Fetch(type = FetchType.LAZY, mode = FetchMode.ONE_TO_MANY, mappedBy = "seguranca")
	@Cascade(values = { CascadeType.DELETE_ORPHAN })
	private Set<SecurityAccess> horarioAcessoSistema;

	/*
	 * Email do usuário
	 */
	@Column(name = "EMAIL", length = 250)
	private String email;

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

	public Set<Action> getAcoes() {
		return acoes;
	}

	public void setAcoes(Set<Action> acoes) {
		this.acoes = acoes;
	}

	public Set<SecurityAccess> getHorarioAcessoSistema() {
		return horarioAcessoSistema;
	}

	public void setHorarioAcessoSistema(
			Set<SecurityAccess> horarioAcessoSistema) {
		this.horarioAcessoSistema = horarioAcessoSistema;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipoSeguranca() {
		return tipoSeguranca;
	}

	public void setTipoSeguranca(String tipoSeguranca) {
		this.tipoSeguranca = tipoSeguranca;
	}

	
}
