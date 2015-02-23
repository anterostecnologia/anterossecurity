package br.com.anteros.security.model;

import static br.com.anteros.persistence.dsl.osql.types.PathMetadataFactory.*;

import br.com.anteros.persistence.dsl.osql.types.path.*;

import br.com.anteros.persistence.dsl.osql.types.PathMetadata;
import javax.annotation.Generated;
import br.com.anteros.persistence.dsl.osql.types.Path;


/**
 * TTerminal is a query type for Terminal
 */
@Generated("br.com.anteros.persistence.apt.codegen.EntitySerializer")
public class TTerminal extends EntityPathBase<Terminal> {

    private static final long serialVersionUID = -1744603410L;

    public static final TTerminal terminal = new TTerminal("terminal");

    public final StringPath descricao = createString("descricao");

    public final StringPath enderecoIP = createString("enderecoIP");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public TTerminal(String variable) {
        super(Terminal.class, forVariable(variable));
    }

    public TTerminal(Path<? extends Terminal> path) {
        super(path.getType(), path.getMetadata());
    }

    public TTerminal(PathMetadata<?> metadata) {
        super(Terminal.class, metadata);
    }

}

