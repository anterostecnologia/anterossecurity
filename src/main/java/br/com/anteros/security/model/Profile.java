package br.com.anteros.security.model;

import br.com.anteros.persistence.metadata.annotation.DiscriminatorValue;
import br.com.anteros.persistence.metadata.annotation.Entity;


/*
 * Pefil
 * 
 * Classe que representa um perfil de um Usuário dentro de um sistema. Ações poderão ser
 * atribuidas a um perfil e consequentemente estarão atribuídas aos usuários que possuírem o perfil.
 * 
 */

@Entity
@DiscriminatorValue(value = "PERFIL")
public class Profile extends Security {

	
}
