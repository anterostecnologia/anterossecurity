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

    public final br.com.anteros.persistence.dsl.osql.types.IndexHint idx_IX_SEGURANCA_ID_HORARIO;

    public final br.com.anteros.persistence.dsl.osql.types.IndexHint idx_PK_SEGURANCA;

    public final br.com.anteros.persistence.dsl.osql.types.IndexHint idx_SEGURANCA_PERFIL;

    public final br.com.anteros.persistence.dsl.osql.types.IndexHint idx_UK_SEGURANCA_LOGIN;

    //inherited
    public final StringPath nome = _super.nome;

    //inherited
    public final StringPath tipoSeguranca = _super.tipoSeguranca;

    public TProfile(String variable) {
        super(Profile.class, forVariable(variable));
        this.idx_IX_SEGURANCA_ID_HORARIO = _super.idx_IX_SEGURANCA_ID_HORARIO;
        this.idx_PK_SEGURANCA = _super.idx_PK_SEGURANCA;
        this.idx_SEGURANCA_PERFIL = _super.idx_SEGURANCA_PERFIL;
        this.idx_UK_SEGURANCA_LOGIN = _super.idx_UK_SEGURANCA_LOGIN;
    }

    public TProfile(Path<? extends Profile> path) {
        super(path.getType(), path.getMetadata());
        this.idx_IX_SEGURANCA_ID_HORARIO = _super.idx_IX_SEGURANCA_ID_HORARIO;
        this.idx_PK_SEGURANCA = _super.idx_PK_SEGURANCA;
        this.idx_SEGURANCA_PERFIL = _super.idx_SEGURANCA_PERFIL;
        this.idx_UK_SEGURANCA_LOGIN = _super.idx_UK_SEGURANCA_LOGIN;
    }

    public TProfile(PathMetadata<?> metadata) {
        super(Profile.class, metadata);
        this.idx_IX_SEGURANCA_ID_HORARIO = _super.idx_IX_SEGURANCA_ID_HORARIO;
        this.idx_PK_SEGURANCA = _super.idx_PK_SEGURANCA;
        this.idx_SEGURANCA_PERFIL = _super.idx_SEGURANCA_PERFIL;
        this.idx_UK_SEGURANCA_LOGIN = _super.idx_UK_SEGURANCA_LOGIN;
    }

}

