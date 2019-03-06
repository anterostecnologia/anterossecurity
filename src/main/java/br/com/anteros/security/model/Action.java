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

import br.com.anteros.persistence.metadata.annotation.BooleanValue;
import br.com.anteros.persistence.metadata.annotation.Column;
import br.com.anteros.persistence.metadata.annotation.Entity;
import br.com.anteros.persistence.metadata.annotation.ForeignKey;
import br.com.anteros.persistence.metadata.annotation.GeneratedValue;
import br.com.anteros.persistence.metadata.annotation.Id;
import br.com.anteros.persistence.metadata.annotation.SequenceGenerator;
import br.com.anteros.persistence.metadata.annotation.Table;
import br.com.anteros.persistence.metadata.annotation.type.BooleanType;
import br.com.anteros.persistence.metadata.annotation.type.FetchType;
import br.com.anteros.persistence.metadata.annotation.type.GeneratedType;
import br.com.anteros.security.store.domain.IAction;
import br.com.anteros.security.store.domain.IResource;

/**
 * Ação
 * 
 * Classe que representa Ação executada por um Usuário dentro de um sistema.
 * 
 * @author Edson Martins edsonmartins2005@gmail.com
 */
@Entity
@Table(name = "SEGURANCAACAO")
public class Action implements Serializable, IAction {

	/*
	 * Identificador da Ação
	 */
	@Id
	@Column(name = "ID_ACAO", length = 8)
	@GeneratedValue(strategy = GeneratedType.AUTO)
	@SequenceGenerator(sequenceName = "SEQ_ACAO", initialValue = 1)
	private Long id;

	/*
	 * Nome da Ação
	 */
	@Column(name = "ACAO", length = 250, required = true)
	private String nome;

	/*
	 * Descrição da Ação
	 */
	@Column(name = "DS_ACAO", length = 250, required = true)
	private String descricao;

	/*
	 * Recurso do sistema a qual pertence a Ação
	 */
	@ForeignKey(type = FetchType.EAGER)
	@Column(name = "ID_RECURSO", inversedColumn = "ID_RECURSO", required = true)
	private Resource recurso;

	/*
	 * Categoria a qual pertence a ação
	 */
	@Column(name = "CATEGORIA", length = 30, required = true)
	private String categoria;

	/*
	 * Ação ativa?
	 */
	@BooleanValue(falseValue = "N", trueValue = "S", type = BooleanType.STRING)
	@Column(name = "BO_ATIVA", length = 1, required = true, defaultValue = "'S'")
	private Boolean ativa;

	/*
	 * Nome da Ação
	 */
	@Column(name = "VERSAO", length = 15, required = false, defaultValue = "'0.0.0.0'")
	private String versao;

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

	public Resource getRecurso() {
		return recurso;
	}

	public void setRecurso(Resource recurso) {
		this.recurso = recurso;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public Boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativa == null) ? 0 : ativa.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((recurso == null) ? 0 : recurso.hashCode());
		result = prime * result + ((versao == null) ? 0 : versao.hashCode());
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
		Action other = (Action) obj;
		if (ativa == null) {
			if (other.ativa != null)
				return false;
		} else if (!ativa.equals(other.ativa))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
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
		if (recurso == null) {
			if (other.recurso != null)
				return false;
		} else if (!recurso.equals(other.recurso))
			return false;
		if (versao == null) {
			if (other.versao != null)
				return false;
		} else if (!versao.equals(other.versao))
			return false;
		return true;
	}


	public Action() {

	}

	public Action(String actionName, String description, String category, IResource resource, String version) {
		this.setNome(actionName);
		this.setDescricao(description);
		this.setCategoria(category);
		this.setRecurso((br.com.anteros.security.model.Resource) resource);
		this.setVersao(version);
	}		

	@Override
	public String getActionId() {
		return this.getId()+"";
	}

	@Override
	public IResource getResource() {
		return (IResource) this.getRecurso();
	}
	
	@Override
	public String getActionName() {
		return getNome();
	}

	@Override
	public boolean isActive() {
		return getAtiva();
	}

	@Override
	public void setActive(boolean value) {
		this.setAtiva(value); 
	}
	

	public static Action of(String actionName, String description, String category, IResource resource,
			String version) {
		return new Action(actionName,description,category,resource,version);
	}

	@Override
	public String getCategory() {
		return this.getCategoria();
	}

	@Override
	public void setCategory(String category) {
		this.setCategoria(category);
	}

	@Override
	public String getVersion() {
		return this.getVersao();
	}



}
