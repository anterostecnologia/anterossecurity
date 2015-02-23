package br.com.anteros.security.model;

import static br.com.anteros.persistence.dsl.osql.types.PathMetadataFactory.*;

import br.com.anteros.persistence.dsl.osql.types.path.*;

import br.com.anteros.persistence.dsl.osql.types.PathMetadata;
import javax.annotation.Generated;
import br.com.anteros.persistence.dsl.osql.types.Path;
import br.com.anteros.persistence.dsl.osql.types.path.PathInits;


/**
 * TSecurityAccess is a query type for SecurityAccess
 */
@Generated("br.com.anteros.persistence.apt.codegen.EntitySerializer")
public class TSecurityAccess extends EntityPathBase<SecurityAccess> {

    private static final long serialVersionUID = 1949298614L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final TSecurityAccess securityAccess = new TSecurityAccess("securityAccess");

    public final TAccessTime horarioAcesso;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final TSecurity seguranca;

    public final TSystem sistema;

    public final TTerminal terminal;

    public TSecurityAccess(String variable) {
        this(SecurityAccess.class, forVariable(variable), INITS);
    }

    public TSecurityAccess(Path<? extends SecurityAccess> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public TSecurityAccess(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public TSecurityAccess(PathMetadata<?> metadata, PathInits inits) {
        this(SecurityAccess.class, metadata, inits);
    }

    public TSecurityAccess(Class<? extends SecurityAccess> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.horarioAcesso = inits.isInitialized("horarioAcesso") ? new TAccessTime(forProperty("horarioAcesso")) : null;
        this.seguranca = inits.isInitialized("seguranca") ? new TSecurity(forProperty("seguranca")) : null;
        this.sistema = inits.isInitialized("sistema") ? new TSystem(forProperty("sistema")) : null;
        this.terminal = inits.isInitialized("terminal") ? new TTerminal(forProperty("terminal")) : null;
    }

}

