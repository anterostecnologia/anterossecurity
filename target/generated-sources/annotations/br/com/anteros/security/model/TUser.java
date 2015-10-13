package br.com.anteros.security.model;

import static br.com.anteros.persistence.dsl.osql.types.PathMetadataFactory.*;

import br.com.anteros.persistence.dsl.osql.types.path.*;

import br.com.anteros.persistence.dsl.osql.types.PathMetadata;
import javax.annotation.Generated;
import br.com.anteros.persistence.dsl.osql.types.Path;
import br.com.anteros.persistence.dsl.osql.types.path.PathInits;


/**
 * TUser is a query type for User
 */
@Generated("br.com.anteros.persistence.apt.codegen.EntitySerializer")
public class TUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1981471037L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final TUser user = new TUser("user");

    public final TSecurity _super = new TSecurity(this);

    //inherited
    public final SetPath<Action, TAction> acoes = _super.acoes;

    public final BooleanPath alterarSenhaProximoLogin = createBoolean("alterarSenhaProximoLogin");

    public final BooleanPath boAdministrador = createBoolean("boAdministrador");

    public final BooleanPath boHorarioLivre = createBoolean("boHorarioLivre");

    public final BooleanPath contaBloqueada = createBoolean("contaBloqueada");

    public final BooleanPath contaDesativada = createBoolean("contaDesativada");

    //inherited
    public final StringPath descricao = _super.descricao;

    //inherited
    public final StringPath email = _super.email;

    public final ListPath<Group, TGroup> grupos = this.<Group, TGroup>createList("grupos", Group.class, TGroup.class, PathInits.DIRECT2);

    public final TAccessTime horarioAcesso;

    //inherited
    public final SetPath<SecurityAccess, TSecurityAccess> horarioAcessoSistema = _super.horarioAcessoSistema;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final br.com.anteros.persistence.dsl.osql.types.IndexHint idx_IX_SEGURANCA_ID_HORARIO;

    public final br.com.anteros.persistence.dsl.osql.types.IndexHint idx_PK_SEGURANCA;

    public final br.com.anteros.persistence.dsl.osql.types.IndexHint idx_SEGURANCA_PERFIL;

    public final br.com.anteros.persistence.dsl.osql.types.IndexHint idx_UK_SEGURANCA_LOGIN;

    public final StringPath login = createString("login");

    //inherited
    public final StringPath nome = _super.nome;

    public final TProfile perfil;

    public final BooleanPath permiteAlterarSenha = createBoolean("permiteAlterarSenha");

    public final BooleanPath permiteMultiplosLogins = createBoolean("permiteMultiplosLogins");

    public final StringPath senha = createString("senha");

    public final BooleanPath senhaNuncaExpira = createBoolean("senhaNuncaExpira");

    //inherited
    public final StringPath tipoSeguranca = _super.tipoSeguranca;

    public TUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public TUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public TUser(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public TUser(PathMetadata<?> metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public TUser(Class<? extends User> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.horarioAcesso = inits.isInitialized("horarioAcesso") ? new TAccessTime(forProperty("horarioAcesso")) : null;
        this.perfil = inits.isInitialized("perfil") ? new TProfile(forProperty("perfil")) : null;
        this.idx_IX_SEGURANCA_ID_HORARIO = _super.idx_IX_SEGURANCA_ID_HORARIO;
        this.idx_PK_SEGURANCA = _super.idx_PK_SEGURANCA;
        this.idx_SEGURANCA_PERFIL = _super.idx_SEGURANCA_PERFIL;
        this.idx_UK_SEGURANCA_LOGIN = _super.idx_UK_SEGURANCA_LOGIN;
    }

    public Path<?>[] all() {
    	return new Path[]{alterarSenhaProximoLogin,boAdministrador,boHorarioLivre,contaBloqueada,contaDesativada,descricao,email,horarioAcesso,id,login,nome,perfil,permiteAlterarSenha,permiteMultiplosLogins,senha,senhaNuncaExpira,tipoSeguranca};
    }
}

