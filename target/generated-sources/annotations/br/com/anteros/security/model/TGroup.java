package br.com.anteros.security.model;

import static br.com.anteros.persistence.dsl.osql.types.PathMetadataFactory.*;

import br.com.anteros.persistence.dsl.osql.types.path.*;

import br.com.anteros.persistence.dsl.osql.types.PathMetadata;
import javax.annotation.Generated;
import br.com.anteros.persistence.dsl.osql.types.Path;
import br.com.anteros.persistence.dsl.osql.types.path.PathInits;


/**
 * TGroup is a query type for Group
 */
@Generated("br.com.anteros.persistence.apt.codegen.EntitySerializer")
public class TGroup extends EntityPathBase<Group> {

    private static final long serialVersionUID = 1283110733L;

    public static final TGroup group = new TGroup("group1");

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

    public final ListPath<User, TUser> membros = this.<User, TUser>createList("membros", User.class, TUser.class, PathInits.DIRECT2);

    //inherited
    public final StringPath nome = _super.nome;

    //inherited
    public final StringPath tipoSeguranca = _super.tipoSeguranca;

    public TGroup(String variable) {
        super(Group.class, forVariable(variable));
    }

    public TGroup(Path<? extends Group> path) {
        super(path.getType(), path.getMetadata());
    }

    public TGroup(PathMetadata<?> metadata) {
        super(Group.class, metadata);
    }

}

