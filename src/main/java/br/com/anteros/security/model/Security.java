/*******************************************************************************
 * Copyright 2012 Anteros Tecnologia
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package br.com.anteros.security.model;

import java.io.Serializable;
import java.util.Set;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;

import br.com.anteros.persistence.metadata.annotation.Cascade;
import br.com.anteros.persistence.metadata.annotation.Column;
import br.com.anteros.persistence.metadata.annotation.DiscriminatorColumn;
import br.com.anteros.persistence.metadata.annotation.Entity;
import br.com.anteros.persistence.metadata.annotation.Fetch;
import br.com.anteros.persistence.metadata.annotation.GeneratedValue;
import br.com.anteros.persistence.metadata.annotation.Id;
import br.com.anteros.persistence.metadata.annotation.Index;
import br.com.anteros.persistence.metadata.annotation.Indexes;
import br.com.anteros.persistence.metadata.annotation.Inheritance;
import br.com.anteros.persistence.metadata.annotation.JoinColumn;
import br.com.anteros.persistence.metadata.annotation.JoinTable;
import br.com.anteros.persistence.metadata.annotation.SequenceGenerator;
import br.com.anteros.persistence.metadata.annotation.Table;
import br.com.anteros.persistence.metadata.annotation.type.CascadeType;
import br.com.anteros.persistence.metadata.annotation.type.FetchMode;
import br.com.anteros.persistence.metadata.annotation.type.FetchType;
import br.com.anteros.persistence.metadata.annotation.type.GeneratedType;
import br.com.anteros.persistence.metadata.annotation.type.InheritanceType;

/**
 * Seguranca
 * 
 * Classe abstrata que vai representar qualquer objeto que necessite de controle de acesso a determinados
 * Recursos/Ações dentro de um Sistema.
 * 
 * @author Edson Martins edsonmartins2005@gmail.com
 */
@Entity
@Table(name = "SEGURANCA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TP_SEGURANCA", length = 40)
@Indexes({ @Index(name = "PK_SEGURANCA", columnNames = {"ID_SEGURANCA"}),
	@Index(name = "IX_SEGURANCA_ID_HORARIO", columnNames = {"ID_HORARIO"}),
	@Index(name = "SEGURANCA_PERFIL", columnNames = {"ID_PERFIL"}),
	@Index(name = "UK_SEGURANCA_LOGIN", columnNames = {"LOGIN"})})
public abstract class Security implements Serializable {

	
	public static final String SECURITY_PACKAGE = "br.com.anteros.security.model";
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
	@Fetch(type = FetchType.LAZY, mode = FetchMode.MANY_TO_MANY, statement="SELECT AC.*, REC.*, SIS.* FROM  SEGURANCAACAOACAO SACAO, SEGURANCAACAO AC, SEGURANCARECURSO REC, SEGURANCASISTEMA SIS WHERE SACAO.ID_SEGURANCA = :ID_SEGURANCA AND AC.ID_ACAO = SACAO.ID_ACAO AND REC.ID_RECURSO = AC.ID_RECURSO AND SIS.ID_SISTEMA = REC.ID_SISTEMA")
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
	@Required
	@Column(name = "EMAIL", length = 250)
	private String email;
	
	@Column(name="UUID", length = 40)
	private String uuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

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
