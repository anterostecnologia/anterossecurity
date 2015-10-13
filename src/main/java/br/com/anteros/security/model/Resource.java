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

/**
 * Recurso
 * 
 * Classe que representa o objeto que será controlado o acesso pelo usuário dentro de um sistema.
 * Ex: Formulário, relatório, etc. Terá uma lista de ações específicas que serão atribuídas posteriormente
 * a qualquer objeto que extenda Seguranca como um Papel, um Usuario ou um Grupo.
 * 
 * @author Edson Martins edsonmartins2005@gmail.com
 */
@Entity
@Table(name = "SEGURANCARECURSO")
@Indexes(value = {
		@Index(name = "UK_SEGURANCARECURSO_NOME_RECUR", columnNames = { "ID_SISTEMA, NOME_RECURSO"}, unique = true) })
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sistema == null) ? 0 : sistema.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resource other = (Resource) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sistema == null) {
			if (other.sistema != null)
				return false;
		} else if (!sistema.equals(other.sistema))
			return false;
		return true;
	}

}
