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
public class Organizador implements Persistable {
    
    private String nome;
    private String ramo;
    private String contato;

    public String toString() {
        return this.getNome();
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public boolean equals(Object o) {
        
        boolean result = false;
        
        if ( o instanceof Organizador ) {
         
            Organizador organizador = (Organizador) o;
            result = this.getNome().equals( organizador.getNome() );
            
        }
        
        return result;
        
    }
    
    
    
}
