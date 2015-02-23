package br.com.anteros.security.model;

import static br.com.anteros.persistence.dsl.osql.types.PathMetadataFactory.*;

import br.com.anteros.persistence.dsl.osql.types.path.*;

import br.com.anteros.persistence.dsl.osql.types.PathMetadata;
import javax.annotation.Generated;
import br.com.anteros.persistence.dsl.osql.types.Path;
import br.com.anteros.persistence.dsl.osql.types.path.PathInits;


/**
 * TSecurity is a query type for Security
 */
@Generated("br.com.anteros.persistence.apt.codegen.EntitySerializer")
public class TSecurity extends EntityPathBase<Security> {

    private static final long serialVersionUID = 385768370L;

    public static final TSecurity security = new TSecurity("security");

    public final SetPath<Action, TAction> acoes = this.<Action, TAction>createSet("acoes", Action.class, TAction.class, PathInits.DIRECT2);

    public final StringPath descricao = createString("descricao");

    public final StringPath email = createString("email");

    public final SetPath<SecurityAccess, TSecurityAccess> horarioAcessoSistema = this.<SecurityAccess, TSecurityAccess>createSet("horarioAcessoSistema", SecurityAccess.class, TSecurityAccess.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public final StringPath tipoSeguranca = createString("tipoSeguranca");

    public TSecurity(String variable) {
        super(Security.class, forVariable(variable));
    }

    public TSecurity(Path<? extends Security> path) {
        super(path.getType(), path.getMetadata());
    }

    public TSecurity(PathMetadata<?> metadata) {
        super(Security.class, metadata);
    }

}
