/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui;

import me.techbot.eventos.Organizador;
import me.techbot.eventos.gui.utils.TableForm;
import me.techbot.eventos.gui.utils.Utils;

/**
 *
 * @author mauricio
 */
public class OrganizadoresList extends TableForm {

    public OrganizadoresList(HomeMidlet midlet) {
        super(midlet, "Lista de Organizadores" , Utils.list(Organizador.class));
    }
    
    
    public void editar(Object object) {
        new OrganizadorForm( this.getMidlet() , (Organizador) object );
    }

    public void adicionar() {
        new OrganizadorForm( this.getMidlet() );
    }
    
}
