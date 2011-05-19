/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.persistence;

import me.techbot.eventos.Evento;
import me.techbot.eventos.gui.utils.Utils;
import net.sourceforge.floggy.persistence.Filter;
import net.sourceforge.floggy.persistence.Persistable;

/**
 *
 * @author mauricio
 */
public class EventoFilter implements Filter {

    private Evento evento;
    
    public EventoFilter( Evento evento ) {
        this.evento = evento;
    }

    public boolean matches(Persistable p) {
    
        Evento outroEvento = (Evento) p;
        
        boolean result = false;
        
        if ( this.evento.getOrganizador() != null ) {
            result = this.evento.getOrganizador().equals( outroEvento.getOrganizador() );
        }
        
        if ( this.evento.getTipoDeEvento() != null ) {
            result = this.evento.getTipoDeEvento().equals( outroEvento.getTipoDeEvento() );
        }
        
        if ( this.evento.getDataDeInicio() != null && this.evento.getDataDeTermino() != null  ) {
            result = 
                    Utils.between( this.evento.getDataDeInicio() , outroEvento.getDataDeInicio(), outroEvento.getDataDeTermino())
                    || Utils.between( this.evento.getDataDeTermino() , outroEvento.getDataDeInicio(), outroEvento.getDataDeTermino());
            
        }
        
        return result;
    }
    
    
    
}
