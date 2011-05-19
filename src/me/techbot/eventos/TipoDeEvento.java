/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos;

import net.sourceforge.floggy.persistence.Persistable;

/**
 *
 * @author mauricio
 */
public class TipoDeEvento implements Persistable {
    
    private String nome;
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        return this.getNome();
    }

    public boolean equals(Object o) {
        
        boolean result = false;
        
        if ( o instanceof TipoDeEvento ) {
            TipoDeEvento t = (TipoDeEvento) o;
            result = t.getNome().equals( this.getNome() );
        }
        
        return result;
    }
    
    
    
}
