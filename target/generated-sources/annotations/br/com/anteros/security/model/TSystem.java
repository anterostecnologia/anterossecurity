package br.com.anteros.security.model;

import static br.com.anteros.persistence.dsl.osql.types.PathMetadataFactory.*;

import br.com.anteros.persistence.dsl.osql.types.path.*;

import br.com.anteros.persistence.dsl.osql.types.PathMetadata;
import javax.annotation.Generated;
import br.com.anteros.persistence.dsl.osql.types.Path;
import br.com.anteros.persistence.dsl.osql.types.path.PathInits;


/**
 * TSystem is a query type for System
 */
@Generated("br.com.anteros.persistence.apt.codegen.EntitySerializer")
public class TSystem extends EntityPathBase<System> {

    private static final long serialVersionUID = 1471859489L;

    public static final TSystem system = new TSystem("system");

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final br.com.anteros.persistence.dsl.osql.types.IndexHint idx_UK_SEGURANCASISTEMA_NOME_SISTEMA;

    public final StringPath nome = createString("nome");

    public final SetPath<Resource, TResource> recursos = this.<Resource, TResource>createSet("recursos", Resource.class, TResource.class, PathInits.DIRECT2);

    public TSystem(String variable) {
        super(System.class, forVariable(variable));
        this.idx_UK_SEGURANCASISTEMA_NOME_SISTEMA = new br.com.anteros.persistence.dsl.osql.types.IndexHint(this,"UK_SEGURANCASISTEMA_NOME_SISTEMA");
    }

    public TSystem(Path<? extends System> path) {
        super(path.getType(), path.getMetadata());
        this.idx_UK_SEGURANCASISTEMA_NOME_SISTEMA = new br.com.anteros.persistence.dsl.osql.types.IndexHint(this,"UK_SEGURANCASISTEMA_NOME_SISTEMA");
    }

    public TSystem(PathMetadata<?> metadata) {
        super(System.class, metadata);
        this.idx_UK_SEGURANCASISTEMA_NOME_SISTEMA = new br.com.anteros.persistence.dsl.osql.types.IndexHint(this,"UK_SEGURANCASISTEMA_NOME_SISTEMA");
    }

}

