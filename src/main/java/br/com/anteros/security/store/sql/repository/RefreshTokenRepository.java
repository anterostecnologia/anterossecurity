package br.com.anteros.security.store.sql.repository;

import br.com.anteros.persistence.session.repository.SQLRepository;
import br.com.anteros.security.model.RefreshToken;

public interface RefreshTokenRepository  extends SQLRepository<RefreshToken, Long> {
	
	RefreshToken findByTokenId(String tokenId);

    boolean deleteByTokenId(String tokenId);


}
