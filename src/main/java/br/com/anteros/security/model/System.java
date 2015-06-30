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

import br.com.anteros.persistence.metadata.annotation.Column;
import br.com.anteros.persistence.metadata.annotation.Entity;
import br.com.anteros.persistence.metadata.annotation.Fetch;
import br.com.anteros.persistence.metadata.annotation.GeneratedValue;
import br.com.anteros.persistence.metadata.annotation.Id;
import br.com.anteros.persistence.metadata.annotation.Index;
import br.com.anteros.persistence.metadata.annotation.Indexes;
import br.com.anteros.persistence.metadata.annotation.SequenceGenerator;
import br.com.anteros.persistence.metadata.annotation.Table;
import br.com.anteros.persistence.metadata.annotation.type.FetchMode;
import br.com.anteros.persistence.metadata.annotation.type.FetchType;
import br.com.anteros.persistence.metadata.annotation.type.GeneratedType;

/**
 * Sistema
 * 
 * Classe que representa um Sistema que necessite de controle de acesso de Recursos/Ações.
 * 
 * @author Edson Martins edsonmartins2005@gmail.com
 */
@Entity
@Table(name = "SEGURANCASISTEMA")
@Indexes(value = {
		@Index(name = "UK_SEGURANCASISTEMA_NOME_SIST", columnNames = { "NOME_SISTEMA"}, unique = true) })
public class System implements Serializable {

	/*
	 * Identificação do Sistema
	 */
	@Id
	@Column(name = "ID_SISTEMA", length = 8)
	@GeneratedValue(strategy = GeneratedType.AUTO)
	@SequenceGenerator(sequenceName = "SEQ_SISTEMA", initialValue = 1)
	private Long id;

	/*
	 * Nome do Sistema
	 */
	@Column(name = "NOME_SISTEMA", length = 40, required = true)
	private String nome;

	/*
	 * Descrição do Sistema
	 */
	@Column(name = "DS_SISTEMA", length = 40, required = true)
	private String descricao;

	/*
	 * Lista de Recursos que pertencem a um Sistema.
	 */
	@Fetch(type = FetchType.LAZY, mode = FetchMode.ONE_TO_MANY, mappedBy = "sistema")
	private Set<Resource> recursos;

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

	public Set<Resource> getRecursos() {
		return recursos;
	}

	public void setRecursos(Set<Resource> recursos) {
		this.recursos = recursos;
	}

	

}
