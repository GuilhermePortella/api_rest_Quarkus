package dev.guilherme;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import io.quarkus.arc.Lock;
import io.quarkus.arc.Lock.Type;

/**
 *
 * @author Guilherme
 */

@Lock
@ApplicationScoped
public class FrutasService {
    
    @Inject
    IdentificadorTransacao identificadorTransacao;
    
    @Lock(value = Type.READ, time = 50, unit = TimeUnit.SECONDS)
    public List<Fruta> list(){
        System.out.println(identificadorTransacao.getIdentificacaoTransacao());
        return Fruta.listAll();
    }
    
    @Transactional
    public void novaFruta(InserirFrutaDTO inserirFrutaDTO){
        System.out.println(identificadorTransacao.getIdentificacaoTransacao());
        Fruta fruta = new Fruta();
        fruta.nome = inserirFrutaDTO.getNome();
        fruta.quantidade = inserirFrutaDTO.getQuantidade();
        fruta.persist();
    }
}
