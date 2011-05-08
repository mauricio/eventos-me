/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui;

import me.techbot.eventos.TipoDeEvento;
import me.techbot.eventos.gui.utils.TableForm;
import me.techbot.eventos.gui.utils.Utils;

/**
 *
 * @author mauricio
 */
public class TiposDeEventoList extends TableForm {

    public TiposDeEventoList( HomeMidlet midlet ) {
        super( midlet, "Lista de Tipos de Eventos", Utils.list( TipoDeEvento.class ) );
    }

    public void editar(Object object) {
    
        TipoDeEvento tipo = (TipoDeEvento) object;
        new TipoDeEventoForm(this.getMidlet(), tipo);
        
    }

    public void adicionar() {
        new TipoDeEventoForm( this.getMidlet() );
    }
    
    
    
    
}
