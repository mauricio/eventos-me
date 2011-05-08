/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui.utils;

import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import me.techbot.eventos.gui.HomeForm;
import me.techbot.eventos.gui.HomeMidlet;
import me.techbot.eventos.gui.TiposDeEventoList;

/**
 *
 * @author mauricio
 */
public class ApplicationForm {
    
    private HomeMidlet midlet;

    public ApplicationForm(HomeMidlet midlet) {
        this.midlet = midlet;
    }
    
    public HomeMidlet getMidlet() {
        return midlet;
    }

    public void setMidlet(HomeMidlet midlet) {
        this.midlet = midlet;
    }

    public void destroy () {
        this.midlet.notifyDestroyed();
    }
    
    public void goToHomeForm() {
        new HomeForm(this.getMidlet());
    }
    
    public void goToTiposDeEventosList() {
        new TiposDeEventoList(this.getMidlet());
    }
    
}
