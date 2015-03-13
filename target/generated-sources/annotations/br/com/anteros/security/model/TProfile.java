package br.com.anteros.security.model;

import static br.com.anteros.persistence.dsl.osql.types.PathMetadataFactory.*;

import br.com.anteros.persistence.dsl.osql.types.path.*;

import br.com.anteros.persistence.dsl.osql.types.PathMetadata;
import javax.annotation.Generated;
import br.com.anteros.persistence.dsl.osql.types.Path;


/**
 * TProfile is a query type for Profile
 */
@Generated("br.com.anteros.persistence.apt.codegen.EntitySerializer")
public class TProfile extends EntityPathBase<Profile> {

    private static final long serialVersionUID = -189051145L;

    public static final TProfile profile = new TProfile("profile");

    public final TSecurity _super = new TSecurity(this);

    //inherited
    public final SetPath<Action, TAction> acoes = _super.acoes;

    //inherited
    public final StringPath descricao = _super.descricao;

    //inherited
    public final StringPath email = _super.email;

    //inherited
    public final SetPath<SecurityAccess, TSecurityAccess> horarioAcessoSistema = _super.horarioAcessoSistema;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final br.com.anteros.persistence.dsl.osql.types.IndexHint idx_PK_SEGURANCA;

    //inherited
    public final StringPath nome = _super.nome;

    //inherited
    public final StringPath tipoSeguranca = _super.tipoSeguranca;

    public TProfile(String variable) {
        super(Profile.class, forVariable(variable));
        this.idx_PK_SEGURANCA = _super.idx_PK_SEGURANCA;
    }

    public TProfile(Path<? extends Profile> path) {
        super(path.getType(), path.getMetadata());
        this.idx_PK_SEGURANCA = _super.idx_PK_SEGURANCA;
    }

    public TProfile(PathMetadata<?> metadata) {
        super(Profile.class, metadata);
        this.idx_PK_SEGURANCA = _super.idx_PK_SEGURANCA;
    }

}

