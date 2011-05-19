/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui;

import com.sun.lwuit.ComboBox;
import com.sun.lwuit.Label;
import java.util.Vector;
import me.techbot.eventos.Evento;
import me.techbot.eventos.Organizador;
import me.techbot.eventos.TipoDeEvento;
import me.techbot.eventos.gui.utils.Constantes;
import me.techbot.eventos.gui.utils.DateField;
import me.techbot.eventos.gui.utils.ObjectForm;
import me.techbot.eventos.gui.utils.Utils;
import net.sourceforge.floggy.persistence.PersistableManager;

/**
 *
 * @author mauricio
 */
public class EventoForm extends ObjectForm {

    private Evento evento;
    private ComboBox organizadores;
    private ComboBox tipos;
    private DateField dataDeInicio;
    private DateField dataDeTermino;
    
    public EventoForm(HomeMidlet midlet, Evento evento) {
        super(midlet, "Adicionar/Editar Evento", new String[]{Constantes.NOME});
        this.evento = evento;

        this.addTextFields(this.getProperties());
        
        this.dataDeInicio = new DateField( "Início" , evento.getDataDeInicio() );
        this.getForm().addComponent( this.dataDeInicio );
        
        this.dataDeTermino = new DateField( "Término", evento.getDataDeTermino() );
        this.getForm().addComponent( this.dataDeTermino );
        
        Label label = new Label("Organizador");
        this.getForm().addComponent(label);
        
        this.organizadores = new ComboBox(Utils.list(Organizador.class));
        this.getForm().addComponent(this.organizadores);

        label = new Label("Tipo de Evento");
        this.getForm().addComponent(label);

        this.tipos = new ComboBox(Utils.list(TipoDeEvento.class));
        this.getForm().addComponent(this.tipos);

        if ( this.evento.getTipoDeEvento() != null ) {
            this.tipos.setSelectedItem( this.evento.getTipoDeEvento() );
        }

        if ( this.evento.getOrganizador() != null ) {
            this.organizadores.setSelectedItem( this.evento.getOrganizador() );
        }
        
        this.show();
    }

    public EventoForm(HomeMidlet midlet) {
        this(midlet, new Evento());
    }

    public void enviar() throws Exception {

        Vector erros = new Vector();

        if ( this.organizadores.getSelectedItem() == null ) {
            erros.addElement( "Você deve selecionar um organizador" );
        }
        
        if ( this.tipos.getSelectedItem() == null ) {
            erros.addElement( "Você deve selecionar um tipo" );
        }
        
        if (erros.size() == 0) {
            this.evento.setNome(this.getTextValue(Constantes.NOME));
            this.evento.setTipoDeEvento( (TipoDeEvento) this.tipos.getSelectedItem() );
            this.evento.setOrganizador( (Organizador) this.organizadores.getSelectedItem() );
            this.evento.setDataDeInicio( this.dataDeInicio.getDate() );
            this.evento.setDataDeTermino( this.dataDeTermino.getDate() );
            
            PersistableManager.getInstance().save(this.evento);

            Utils.showSuccessMessage("Evento criado/atualizado com sucesso", this.getMidlet());
            this.voltar();
        } else {
            Utils.showValidationError(erros, this.getMidlet());
        }



    }

    public void voltar() {
        new BuscarEventosForm(this.getMidlet());
    }
}
