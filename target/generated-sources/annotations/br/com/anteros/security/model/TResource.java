package br.com.anteros.security.model;

import static br.com.anteros.persistence.dsl.osql.types.PathMetadataFactory.*;

import br.com.anteros.persistence.dsl.osql.types.path.*;

import br.com.anteros.persistence.dsl.osql.types.PathMetadata;
import javax.annotation.Generated;
import br.com.anteros.persistence.dsl.osql.types.Path;
import br.com.anteros.persistence.dsl.osql.types.path.PathInits;


/**
 * TResource is a query type for Resource
 */
@Generated("br.com.anteros.persistence.apt.codegen.EntitySerializer")
public class TResource extends EntityPathBase<Resource> {

    private static final long serialVersionUID = -904419200L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final TResource resource = new TResource("resource");

    public final ListPath<Action, TAction> acoes = this.<Action, TAction>createList("acoes", Action.class, TAction.class, PathInits.DIRECT2);

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final br.com.anteros.persistence.dsl.osql.types.IndexHint idx_UK_SEGURANCARECURSO_NOME_RECUR;

    public final StringPath nome = createString("nome");

    public final TSystem sistema;

    public TResource(String variable) {
        this(Resource.class, forVariable(variable), INITS);
    }

    public TResource(Path<? extends Resource> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public TResource(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public TResource(PathMetadata<?> metadata, PathInits inits) {
        this(Resource.class, metadata, inits);
    }

    public TResource(Class<? extends Resource> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.sistema = inits.isInitialized("sistema") ? new TSystem(forProperty("sistema")) : null;
        this.idx_UK_SEGURANCARECURSO_NOME_RECUR = new br.com.anteros.persistence.dsl.osql.types.IndexHint(this,"UK_SEGURANCARECURSO_NOME_RECUR");
    }

    public Path<?>[] all() {
    	return new Path[]{descricao,id,nome,sistema};
    }
}

