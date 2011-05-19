/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui;

import com.sun.lwuit.Button;
import com.sun.lwuit.ComboBox;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BoxLayout;
import me.techbot.eventos.Evento;
import me.techbot.eventos.Organizador;
import me.techbot.eventos.TipoDeEvento;
import me.techbot.eventos.gui.utils.ApplicationForm;
import me.techbot.eventos.gui.utils.DateField;
import me.techbot.eventos.gui.utils.Utils;

/**
 *
 * @author mauricio
 */
public class BuscarEventosForm extends ApplicationForm implements ActionListener {

    private Form form;
    private Command voltarCommand;
    private ComboBox tipos;
    private ComboBox organizadores;
    private DateField dataDeInicio;
    private DateField dataDeTermino;
    
    private Button adicionarButton;
    private Button listarButton;
    private Button buscarButton;
    
    public BuscarEventosForm(HomeMidlet midlet) {
        super(midlet);
        
        this.form = new Form("Busca de Eventos");
        this.form.setLayout( new BoxLayout( BoxLayout.Y_AXIS ) );
        
        Label label = new Label( "Tipo" );
        
        TipoDeEvento tipo = new TipoDeEvento();
        tipo.setNome( "Nenhum" );
        
        this.tipos = new ComboBox( Utils.vectorOf(tipo) );
        
        this.form.addComponent( label );
        this.form.addComponent( this.tipos );
        
        label = new Label( "Organizador" );
        
        Organizador organizador = new Organizador();
        organizador.setNome( "Nenhum" );
        
        this.organizadores = new ComboBox( Utils.vectorOf( organizador ) );
        
        this.form.addComponent( label );
        this.form.addComponent( this.organizadores );
        
        this.dataDeInicio = new DateField("Data de Início");
        this.dataDeTermino = new DateField("Data de Término");
        
        this.form.addComponent( this.dataDeInicio );
        this.form.addComponent( this.dataDeTermino );
        
        Container container = new Container();
        
        this.adicionarButton = new Button( "Novo Evento" );
        this.buscarButton = new Button("Buscar");
        this.listarButton = new Button( "Lista de Eventos" );
        
        this.adicionarButton.addActionListener(this);
        this.buscarButton.addActionListener(this);
        this.listarButton.addActionListener(this);
        
        container.addComponent( this.adicionarButton );
        container.addComponent( this.buscarButton );
        container.addComponent( this.listarButton );
        
        this.form.addComponent( container );
        
        
        this.voltarCommand = new Command( "Voltar" );
        
        this.form.addCommand( this.voltarCommand );
        this.form.addCommandListener(this);
        
        this.form.show();
    }

    public void actionPerformed(ActionEvent ae) {
    
        if ( this.voltarCommand == ae.getSource() ) {
            this.goToHomeForm();
            return;
        }
        
        if ( this.adicionarButton == ae.getSource() ) {
            new EventoForm( this.getMidlet() );
            return;
        }
        
        if ( this.listarButton == ae.getSource() ) {
            new EventosList( this.getMidlet() );
            return;
        }
        
        if ( this.buscarButton == ae.getSource() ) {
            Evento evento = new Evento();
            
            evento.setTipoDeEvento( (TipoDeEvento) this.tipos.getSelectedItem() );
            evento.setOrganizador( (Organizador) this.organizadores.getSelectedItem() );
            evento.setDataDeInicio( this.dataDeInicio.getDate() );
            evento.setDataDeTermino( this.dataDeTermino.getDate() );
            
            new EventosList( this.getMidlet(), Evento.buscar( evento ) );
            return;
        }
        
    }
    
    
    
}
