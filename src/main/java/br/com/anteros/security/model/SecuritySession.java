package br.com.anteros.security.model;

import java.io.Serializable;
import java.util.Date;

import br.com.anteros.persistence.metadata.annotation.Column;
import br.com.anteros.persistence.metadata.annotation.Entity;
import br.com.anteros.persistence.metadata.annotation.ForeignKey;
import br.com.anteros.persistence.metadata.annotation.GeneratedValue;
import br.com.anteros.persistence.metadata.annotation.Id;
import br.com.anteros.persistence.metadata.annotation.SequenceGenerator;
import br.com.anteros.persistence.metadata.annotation.Table;
import br.com.anteros.persistence.metadata.annotation.Temporal;
import br.com.anteros.persistence.metadata.annotation.type.FetchType;
import br.com.anteros.persistence.metadata.annotation.type.GeneratedType;
import br.com.anteros.persistence.metadata.annotation.type.TemporalType;

/**
 * 
 * @author eduardogreco
 *
 */

@Entity
@Table(name = "SEGURANCASESSAO")
public class SecuritySession implements Serializable {

	/*
	 * Identificação do Objeto de sessão
	 */
	@Id
	@Column(name = "ID_SESSAO", length = 8)
	@GeneratedValue(strategy = GeneratedType.AUTO)
	@SequenceGenerator(sequenceName = "SEQ_SEGURANCASESSAO", initialValue = 1)
	private Long id;

	/*
	 * Id. da sessão no banco de dados
	 */
	@Column(name = "ID_SESSAO_BANCODADOS", length = 8, required = true)
	private Long idSessaoBancoDados;

	/*
	 * Usuário da sessão
	 */
	@ForeignKey(type = FetchType.EAGER)
	@Column(name = "ID_USUARIO", inversedColumn = "ID_SEGURANCA", required = true)
	private Security usuario;

	/*
	 * Data/hora do login da sessão
	 */
	@Temporal(TemporalType.DATE_TIME)
	@Column(name = "DH_LOGIN_SESSAO", required = true)
	private Date dhLoginSessao;

	/*
	 * Data/hora do logout da sessão
	 */
	@Temporal(TemporalType.DATE_TIME)
	@Column(name = "DH_LOGOUT_SESSAO")
	private Date dhLogoutSessao;

	/*
	 * Endereço IP
	 */
	@Column(name = "ENDERECO_IP_CLIENTE", length = 20, required = true)
	private String enderecoIP;

	/*
	 * Nome do sistema
	 */
	@Column(name = "SISTEMA", length = 30, required = true)
	private String sistema;

	/*
	 * Versão do sistema
	 */
	@Column(name = "VERSAO", length = 15, required = true)
	private String versao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSessaoBancoDados() {
		return idSessaoBancoDados;
	}

	public void setIdSessaoBancoDados(Long idSessaoBancoDados) {
		this.idSessaoBancoDados = idSessaoBancoDados;
	}

	public Security getUsuario() {
		return usuario;
	}

	public void setUsuario(Security usuario) {
		this.usuario = usuario;
	}

	public Date getDhLoginSessao() {
		return dhLoginSessao;
	}

	public void setDhLoginSessao(Date dhLoginSessao) {
		this.dhLoginSessao = dhLoginSessao;
	}

	public Date getDhLogoutSessao() {
		return dhLogoutSessao;
	}

	public void setDhLogoutSessao(Date dhLogoutSessao) {
		this.dhLogoutSessao = dhLogoutSessao;
	}

	public String getEnderecoIP() {
		return enderecoIP;
	}

	public void setEnderecoIP(String enderecoIP) {
		this.enderecoIP = enderecoIP;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

}
