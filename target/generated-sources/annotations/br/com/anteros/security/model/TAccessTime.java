package br.com.anteros.security.model;

import static br.com.anteros.persistence.dsl.osql.types.PathMetadataFactory.*;

import br.com.anteros.persistence.dsl.osql.types.path.*;

import br.com.anteros.persistence.dsl.osql.types.PathMetadata;
import javax.annotation.Generated;
import br.com.anteros.persistence.dsl.osql.types.Path;
import br.com.anteros.persistence.dsl.osql.types.path.PathInits;


/**
 * TAccessTime is a query type for AccessTime
 */
@Generated("br.com.anteros.persistence.apt.codegen.EntitySerializer")
public class TAccessTime extends EntityPathBase<AccessTime> {

    private static final long serialVersionUID = -1359824317L;

    public static final TAccessTime accessTime = new TAccessTime("accessTime");

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<AccessTimeInterval, TAccessTimeInterval> intervalos = this.<AccessTimeInterval, TAccessTimeInterval>createList("intervalos", AccessTimeInterval.class, TAccessTimeInterval.class, PathInits.DIRECT2);

    public TAccessTime(String variable) {
        super(AccessTime.class, forVariable(variable));
    }

    public TAccessTime(Path<? extends AccessTime> path) {
        super(path.getType(), path.getMetadata());
    }

    public TAccessTime(PathMetadata<?> metadata) {
        super(AccessTime.class, metadata);
    }

    public Path<?>[] all() {
    	return new Path[]{descricao,id,intervalos};
    }
}

