package dev.guilherme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;

/**
 *
 * @author Guilherme
 */
@Entity
public class Fruta extends PanacheEntity{
    
    public String nome;
    public int quantidade;
}
