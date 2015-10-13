package br.com.anteros.security.model;

import static br.com.anteros.persistence.dsl.osql.types.PathMetadataFactory.*;

import br.com.anteros.persistence.dsl.osql.types.path.*;

import br.com.anteros.persistence.dsl.osql.types.PathMetadata;
import javax.annotation.Generated;
import br.com.anteros.persistence.dsl.osql.types.Path;
import br.com.anteros.persistence.dsl.osql.types.path.PathInits;


/**
 * TAccessTimeInterval is a query type for AccessTimeInterval
 */
@Generated("br.com.anteros.persistence.apt.codegen.EntitySerializer")
public class TAccessTimeInterval extends EntityPathBase<AccessTimeInterval> {

    private static final long serialVersionUID = 1230770216L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final TAccessTimeInterval accessTimeInterval = new TAccessTimeInterval("accessTimeInterval");

    public final NumberPath<Long> diaDaSemana = createNumber("diaDaSemana", Long.class);

    public final StringPath horaFinal = createString("horaFinal");

    public final StringPath horaInicial = createString("horaInicial");

    public final TAccessTime horarioAcesso;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public TAccessTimeInterval(String variable) {
        this(AccessTimeInterval.class, forVariable(variable), INITS);
    }

    public TAccessTimeInterval(Path<? extends AccessTimeInterval> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public TAccessTimeInterval(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public TAccessTimeInterval(PathMetadata<?> metadata, PathInits inits) {
        this(AccessTimeInterval.class, metadata, inits);
    }

    public TAccessTimeInterval(Class<? extends AccessTimeInterval> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.horarioAcesso = inits.isInitialized("horarioAcesso") ? new TAccessTime(forProperty("horarioAcesso")) : null;
    }

    public Path<?>[] all() {
    	return new Path[]{diaDaSemana,horaFinal,horaInicial,horarioAcesso,id};
    }
}

