/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos;

import java.util.Date;
import java.util.Vector;
import me.techbot.eventos.gui.utils.Utils;
import me.techbot.eventos.persistence.EventoFilter;
import net.sourceforge.floggy.persistence.FloggyException;
import net.sourceforge.floggy.persistence.Persistable;
import net.sourceforge.floggy.persistence.PersistableManager;

/**
 *
 * @author mauricio
 */
public class Evento implements Persistable {

    private String nome;
    private Date dataDeInicio = new Date();
    private Date dataDeTermino = new Date();
    private TipoDeEvento tipoDeEvento;
    private Organizador organizador;

    public String toString() {
        
        StringBuffer buffer = new StringBuffer();
        
        if ( this.nome != null ) {
            buffer.append( " Nome: " + this.nome );
        }
        
        if ( this.dataDeInicio != null ) {
            buffer.append( " Data de Início: " + this.dataDeInicio  );
        }
        
        if ( this.dataDeTermino != null ) {
            buffer.append( " Data de Término: " + this.dataDeTermino );
        }
        
        if ( this.tipoDeEvento != null ) {
            buffer.append( " Tipo de Evento: " + this.tipoDeEvento );
        }
        
        if ( this.organizador != null ) {
            buffer.append( " Organizador: " + this.organizador );
        }
        
        return buffer.toString();
    }
    
    public Date getDataDeInicio() {
        return dataDeInicio;
    }

    public Date getDataDeTermino() {
        return dataDeTermino;
    }

    public void setDataDeInicio(Date dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public void setDataDeTermino(Date dataDeTermino) {
        this.dataDeTermino = dataDeTermino;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public TipoDeEvento getTipoDeEvento() {
        return tipoDeEvento;
    }

    public void setTipoDeEvento(TipoDeEvento tipoDeEvento) {
        this.tipoDeEvento = tipoDeEvento;
    }

    public int hashCode() {
        return this.getNome().hashCode();
    }
    
    
    
    
    public boolean equals(Object o) {
    
        boolean result = false;
        
        if ( o instanceof Evento ) {
            
            Evento e = (Evento) o;
            result = this.getNome().equals( e.getNome() );
            
        }
        
        return result;
        
    }
    
    public static Vector buscar( Evento evento ) {
        try {
            EventoFilter filter = new EventoFilter(evento);
            
            return Utils.toVector( PersistableManager.getInstance().find( Evento.class , filter, null) );
        } catch (FloggyException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
        
        
    }
    
}
