package br.com.anteros.security.model;

import java.util.List;

import br.com.anteros.persistence.metadata.annotation.DiscriminatorValue;
import br.com.anteros.persistence.metadata.annotation.Entity;
import br.com.anteros.persistence.metadata.annotation.Fetch;
import br.com.anteros.persistence.metadata.annotation.JoinColumn;
import br.com.anteros.persistence.metadata.annotation.JoinTable;
import br.com.anteros.persistence.metadata.annotation.type.FetchMode;
import br.com.anteros.persistence.metadata.annotation.type.FetchType;

/*
 * Grupo
 * 
 * Classe que representa um Grupo de Usuários no sistema. Possui uma lista de Ações as quais 
 * também serão atribuídas aos membros do Grupo.
 */

@Entity
@DiscriminatorValue(value = "GRUPO")
public class Group extends Security {

	/*
	 * Lista de membros do Grupo (Usuários)
	 */
	@Fetch(type = FetchType.LAZY, mode = FetchMode.MANY_TO_MANY)
	@JoinTable(name = "SEGURANCAGRUPOMEMBRO", joinColumns = @JoinColumn(name = "ID_GRUPO", referencedColumnName = "ID_SEGURANCA"), inversedJoinColumns = @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_SEGURANCA"))
	private List<User> membros;

	public List<User> getMembros() {
		return membros;
	}

	public void setMembros(List<User> membros) {
		this.membros = membros;
	}

}
