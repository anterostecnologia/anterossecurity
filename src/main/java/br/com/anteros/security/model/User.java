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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.anteros.persistence.metadata.annotation.BooleanValue;
import br.com.anteros.persistence.metadata.annotation.Column;
import br.com.anteros.persistence.metadata.annotation.DiscriminatorValue;
import br.com.anteros.persistence.metadata.annotation.Entity;
import br.com.anteros.persistence.metadata.annotation.Fetch;
import br.com.anteros.persistence.metadata.annotation.ForeignKey;
import br.com.anteros.persistence.metadata.annotation.JoinColumn;
import br.com.anteros.persistence.metadata.annotation.JoinTable;
import br.com.anteros.persistence.metadata.annotation.Transient;
import br.com.anteros.persistence.metadata.annotation.type.BooleanType;
import br.com.anteros.persistence.metadata.annotation.type.FetchMode;
import br.com.anteros.persistence.metadata.annotation.type.FetchType;
import br.com.anteros.security.store.domain.IAction;
import br.com.anteros.security.store.domain.IProfile;
import br.com.anteros.security.store.domain.IUser;

/**
 * Usuario
 * 
 * Classe que representa um usuário dentro de um Sistema. Pode ser uma Pessoa ou até mesmo um usuário virtual como
 * o próprio Sistema.
 * 
 * @author Edson Martins edsonmartins2005@gmail.com
 */

@Entity
@DiscriminatorValue(value = "USUARIO")
public class User extends Security implements IUser {

	/*
	 * Login do usuário
	 */
	@Column(name = "LOGIN", length = 20)
	private String login;

	/*
	 * Senha do usuário
	 */
	@Column(name = "SENHA", length = 100)
	private String senha;

	/*
	 * O usuário deve alterar a senha no próximo Login?
	 */
	@BooleanValue(trueValue = "S", falseValue = "N", type=BooleanType.STRING)
	@Column(name = "BO_ALTERAR_SENHA_PROX_LOGIN", required = true, defaultValue = "'N'")
	private Boolean alterarSenhaProximoLogin;

	/*
	 * O usuário pode alterar a senha?
	 */
	@BooleanValue(trueValue = "S", falseValue = "N", type=BooleanType.STRING)
	@Column(name = "BO_PERMITE_ALTERAR_SENHA", required = true, defaultValue = "'N'")
	private Boolean permiteAlterarSenha;

	/*
	 * Permite o usuário efetuar vários logins em um mesmo sistema?
	 */
	@BooleanValue(trueValue = "S", falseValue = "N", type=BooleanType.STRING)
	@Column(name = "BO_PERMITE_MULTIPLOS_LOGINS", required = true, defaultValue = "'N'")
	private Boolean permiteMultiplosLogins;

	/*
	 * A senha do usuário nunca expira?
	 */
	@BooleanValue(trueValue = "S", falseValue = "N", type=BooleanType.STRING)
	@Column(name = "BO_SENHA_NUNCA_EXPIRA", required = true, defaultValue = "'N'")
	private Boolean senhaNuncaExpira;

	/*
	 * Conta do usuário está desativada?
	 */
	@BooleanValue(trueValue = "S", falseValue = "N", type=BooleanType.STRING)
	@Column(name = "BO_CONTA_DESATIVADA", required = true, defaultValue = "'N'")
	private Boolean contaDesativada=Boolean.FALSE;

	/*
	 * Conta do usuário está bloqueada?
	 */
	@BooleanValue(trueValue = "S", falseValue = "N", type=BooleanType.STRING)
	@Column(name = "BO_CONTA_BLOQUEADA", required = true, defaultValue = "'N'")
	private Boolean contaBloqueada=Boolean.FALSE;
	
	
	@BooleanValue(falseValue = "N", trueValue = "S", type=BooleanType.STRING)
	@Column(name = "BO_HORARIO_LIVRE", length = 1, required = true, defaultValue = "'N'")
	private Boolean boHorarioLivre;

	@BooleanValue(falseValue = "N", trueValue = "S", type=BooleanType.STRING)
	@Column(name = "BO_ADMINISTRADOR", length = 1, required = true, defaultValue = "'N'")
	private Boolean boAdministrador;

	/*
	 * Horário de acesso do usuário
	 */
	@ForeignKey(type = FetchType.EAGER)
	@Column(name = "ID_HORARIO", inversedColumn = "ID_HORARIO")
	private AccessTime horarioAcesso;

	/*
	 * Grupos que o usuário é membro
	 */
	@Fetch(type = FetchType.LAZY, mode = FetchMode.MANY_TO_MANY)
	@JoinTable(name = "SEGURANCAGRUPOMEMBRO", joinColumns = @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_SEGURANCA"), inversedJoinColumns = @JoinColumn(name = "ID_GRUPO", referencedColumnName = "ID_SEGURANCA"))
	private List<Group> grupos;

	/*
	 * Perfil (papel) do usuário dentro do sistema
	 */
	@ForeignKey(type = FetchType.EAGER)
	@Column(name = "ID_PERFIL", inversedColumn = "ID_SEGURANCA")
	private Profile perfil;

	public Boolean getAlterarSenhaProximoLogin() {
		return alterarSenhaProximoLogin;
	}

	public void setAlterarSenhaProximoLogin(Boolean alterarSenhaProximoLogin) {
		this.alterarSenhaProximoLogin = alterarSenhaProximoLogin;
	}

	public Boolean getPermiteAlterarSenha() {
		return permiteAlterarSenha;
	}

	public void setPermiteAlterarSenha(Boolean permiteAlterarSenha) {
		this.permiteAlterarSenha = permiteAlterarSenha;
	}

	public Boolean getSenhaNuncaExpira() {
		return senhaNuncaExpira;
	}

	public void setSenhaNuncaExpira(Boolean senhaNuncaExpira) {
		this.senhaNuncaExpira = senhaNuncaExpira;
	}

	public Boolean getContaDesativada() {
		return contaDesativada;
	}

	public void setContaDesativada(Boolean contaDesativada) {
		this.contaDesativada = contaDesativada;
	}

	public Boolean getContaBloqueada() {
		return contaBloqueada;
	}

	public void setContaBloqueada(Boolean contaBloqueada) {
		this.contaBloqueada = contaBloqueada;
	}

	public Boolean getPermiteMultiplosLogins() {
		return permiteMultiplosLogins;
	}

	public void setPermiteMultiplosLogins(Boolean permiteMultiplosLogins) {
		this.permiteMultiplosLogins = permiteMultiplosLogins;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// public HorarioAcesso getHorarioAcesso() {
	// return horarioAcesso;
	// }
	//
	// public void setHorarioAcesso(HorarioAcesso horarioAcesso) {
	// this.horarioAcesso = horarioAcesso;
	// }

	public List<Group> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Group> grupos) {
		this.grupos = grupos;
	}

	public Profile getPerfil() {
		return perfil;
	}

	public void setPerfil(Profile perfil) {
		this.perfil = perfil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Transient
	public boolean isExpirada() {
		return (contaBloqueada || contaDesativada);
	}
	
	public Boolean getBoHorarioLivre() {
		return boHorarioLivre;
	}

	public void setBoHorarioLivre(Boolean boHorarioLivre) {
		this.boHorarioLivre = boHorarioLivre;
	}

	public Boolean getBoAdministrador() {
		return boAdministrador;
	}

	public void setBoAdministrador(Boolean boAdministrador) {
		this.boAdministrador = boAdministrador;
	}

	public AccessTime getHorarioAcesso() {
		return horarioAcesso;
	}

	public void setHorarioAcesso(AccessTime horarioAcesso) {
		this.horarioAcesso = horarioAcesso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public String getUserId() {
		return this.getId()+"";
	}

	@Override
	public String getPassword() {
		return this.getSenha();
	}

	@Override
	public String getAvatar() {
		return this.getAvatar();
	}

	@Override
	public boolean isPasswordNeverExpire() {
		return this.getSenhaNuncaExpira();
	}

	@Override
	public boolean isInactiveAccount() {
		return this.getContaDesativada();
	}

	@Override
	public boolean isBlockedAccount() {
		return this.getContaBloqueada();
	}

	@Override
	public boolean isAdministrator() {
		return this.getBoAdministrador();
	}

	@Override
	public Set<IAction> getActionList() {
		Set<IAction> result = new HashSet<IAction>();
		for (Action action : this.getAcoes()) {
			result.add((IAction) action);
		}
		return result;
	}

	@Override
	public IProfile getUserProfile() {
		return (IProfile) this.getPerfil();
	}

}