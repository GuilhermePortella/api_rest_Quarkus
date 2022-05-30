package dev.guilherme;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.profile.IfBuildProfile;

/**
 *
 * @author Guilherme
 */
class IdentificadorTransacaoProducer {
    
    @Produces
    @DefaultBean
    @RequestScoped
    public IdentificadorTransacao produceTeste() {
        return new IdentificadorTransacao("Teste-");
    }
    
    @Produces
    @IfBuildProfile("prod")
    @RequestScoped
    public IdentificadorTransacao produceProd() {
        return new IdentificadorTransacao("Prod-");
    }
    
}
