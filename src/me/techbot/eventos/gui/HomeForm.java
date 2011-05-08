/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui;

import me.techbot.eventos.gui.utils.ApplicationForm;
import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.FlowLayout;

/**
 *
 * @author mauricio
 */
public class HomeForm extends ApplicationForm implements ActionListener {

    private Button eventos;
    private Button tiposDeEventos;
    private Button organizadores;

    public HomeForm( HomeMidlet midlet ) {
        super(midlet);

        Form f = new Form("Hello, LWUIT!");

        f.setLayout(new FlowLayout());

        this.eventos = new Button("Eventos");
        this.eventos.addActionListener(this);

        this.tiposDeEventos = new Button("Tipos de eventos");
        this.tiposDeEventos.addActionListener(this);

        this.organizadores = new Button("Organizadores");
        this.organizadores.addActionListener(this);

        f.addComponent(this.eventos);
        f.addComponent(this.tiposDeEventos);
        f.addComponent(this.organizadores);

        Command command = new Command( "Sair" );
        f.addCommand(command);
        
        f.show();
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == this.eventos) {
            return;
        }

        if (ae.getSource() == this.tiposDeEventos) {
            this.goToTiposDeEventosList();
            return;
        }

        if (ae.getSource() == this.organizadores) {
            return;
        }

        this.destroy();
        
    }
}
