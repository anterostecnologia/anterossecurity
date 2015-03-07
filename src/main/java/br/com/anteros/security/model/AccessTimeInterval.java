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
 * HorarioAcessoIntervalo
 * 
 * Classe que representa o intervalo de Horário de Acesso que será permitido ao Usuário utilizar o sistema.
 * 
 * @author Edson Martins edsonmartins2005@gmail.com
 */
@Entity
@Table(name = "SEGURANCAHORARIOINTERVALO")
public class AccessTimeInterval implements Serializable {

	
	/*
	 * Identificação
	 */
	@Id
	@Column(name = "ID_HORARIO_INTERVALO", length = 8)
	@GeneratedValue(strategy = GeneratedType.AUTO)
	@SequenceGenerator(sequenceName = "SEQ_HORARIO_INTERVALO", initialValue = 1)
	private Long id;
	
	/*
	 * Horário de acesso a qual pertence o intervalo
	 */
	@ForeignKey(type = FetchType.EAGER)
	@Column(name = "ID_HORARIO", inversedColumn = "ID_HORARIO", required = true)
	private AccessTime horarioAcesso;

	/*
	 * Dia da semana
	 */
	@Column(name = "DIA_SEMANA", length = 2, required = true)
	private Long diaDaSemana;

	/*
	 * Hora Inicial
	 */
	//@Temporal(type = TemporalType.DATE_TIME)
	@Column(name = "HORA_INICIAL", required = true, length=4)
	private String horaInicial;

	/*
	 * Hora Final
	 */
	//@Temporal(type = TemporalType.DATE_TIME)
	@Column(name = "HORA_FINAL", required = true, length=4)
	private String horaFinal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(Long diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	
	public AccessTime getHorarioAcesso() {
		return horarioAcesso;
	}

	public void setHorarioAcesso(AccessTime horarioAcesso) {
		this.horarioAcesso = horarioAcesso;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

}
