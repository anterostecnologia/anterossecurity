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

import br.com.anteros.persistence.metadata.annotation.Column;
import br.com.anteros.persistence.metadata.annotation.Entity;
import br.com.anteros.persistence.metadata.annotation.ForeignKey;
import br.com.anteros.persistence.metadata.annotation.GeneratedValue;
import br.com.anteros.persistence.metadata.annotation.Id;
import br.com.anteros.persistence.metadata.annotation.SequenceGenerator;
import br.com.anteros.persistence.metadata.annotation.Table;
import br.com.anteros.persistence.metadata.annotation.type.FetchType;
import br.com.anteros.persistence.metadata.annotation.type.GeneratedType;

/**
 *SegurancaHorarioAcesso
 *
 * Classe que representa os terminais e sistemas que um usuário pode acessar em um de
 * determinado horário de acesso
 * 
 * @author Edson Martins edsonmartins2005@gmail.com
 */

@Entity
@Table(name = "SEGURANCAACESSO")
public class SecurityAccess implements Serializable {

	/*
	 * Identificador do segurança horário de acesso
	 */
	@Id
	@Column(name = "ID_ACESSO", length = 8)
	@GeneratedValue(strategy = GeneratedType.AUTO)
	@SequenceGenerator(sequenceName = "SEQ_ACESSO", initialValue = 1)
	private Long id;

	/*
	 * Identificador do horário de acesso
	 */
	@ForeignKey(type = FetchType.EAGER)
	@Column(name = "ID_HORARIO", required = true)
	private AccessTime horarioAcesso;

	/*
	 * Identificador do segurança
	 */
	@ForeignKey(type = FetchType.EAGER)
	@Column(name = "ID_SEGURANCA", required = true)
	private Security seguranca;

	/*
	 * Terminal de acesso
	 */
	@ForeignKey(type = FetchType.EAGER)
	@Column(name = "ID_TERMINAL", required = true)
	private Terminal terminal;

	/*
	 * Identificador do sistema
	 */
	@ForeignKey(type = FetchType.EAGER)
	@Column(name = "ID_SISTEMA", required = true)
	private System sistema;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Security getSeguranca() {
		return seguranca;
	}

	public void setSeguranca(Security seguranca) {
		this.seguranca = seguranca;
	}

	public AccessTime getHorarioAcesso() {
		return horarioAcesso;
	}

	public void setHorarioAcesso(AccessTime horarioAcesso) {
		this.horarioAcesso = horarioAcesso;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public System getSistema() {
		return sistema;
	}

	public void setSistema(System sistema) {
		this.sistema = sistema;
	}

}
