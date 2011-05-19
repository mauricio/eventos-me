/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui;

import java.util.Vector;
import me.techbot.eventos.Evento;
import me.techbot.eventos.gui.utils.TableForm;
import me.techbot.eventos.gui.utils.Utils;

/**
 *
 * @author mauricio
 */
public class EventosList extends TableForm  {

    public EventosList(HomeMidlet midlet, Vector objects) {
        super(midlet, "Lista de eventos", objects);
    }

    public EventosList( HomeMidlet midlet ) {
        this( midlet, Utils.list(Evento.class) );
    }

    public void adicionar() {
        new EventoForm(this.getMidlet());
    }

    public void editar(Object object) {
        new EventoForm(this.getMidlet(), (Evento) object);
    }
   
}