package br.com.anteros.security.model;

import static br.com.anteros.persistence.dsl.osql.types.PathMetadataFactory.*;

import br.com.anteros.persistence.dsl.osql.types.path.*;

import br.com.anteros.persistence.dsl.osql.types.PathMetadata;
import javax.annotation.Generated;
import br.com.anteros.persistence.dsl.osql.types.Path;
import br.com.anteros.persistence.dsl.osql.types.path.PathInits;


/**
 * TAction is a query type for Action
 */
@Generated("br.com.anteros.persistence.apt.codegen.EntitySerializer")
public class TAction extends EntityPathBase<Action> {

    private static final long serialVersionUID = 936236840L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final TAction action = new TAction("action");

    public final BooleanPath ativa = createBoolean("ativa");

    public final StringPath categoria = createString("categoria");

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public final TResource recurso;

    public final StringPath versao = createString("versao");

    public TAction(String variable) {
        this(Action.class, forVariable(variable), INITS);
    }

    public TAction(Path<? extends Action> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public TAction(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public TAction(PathMetadata<?> metadata, PathInits inits) {
        this(Action.class, metadata, inits);
    }

    public TAction(Class<? extends Action> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.recurso = inits.isInitialized("recurso") ? new TResource(forProperty("recurso"), inits.get("recurso")) : null;
    }

    public Path<?>[] all() {
    	return new Path[]{ativa,categoria,descricao,id,nome,recurso,versao};
    }
}

