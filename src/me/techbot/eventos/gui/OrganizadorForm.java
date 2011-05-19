/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui;

import com.sun.lwuit.events.ActionListener;
import me.techbot.eventos.Organizador;
import me.techbot.eventos.gui.utils.Constantes;
import me.techbot.eventos.gui.utils.ObjectForm;
import me.techbot.eventos.gui.utils.Utils;
import net.sourceforge.floggy.persistence.PersistableManager;

/**
 *
 * @author mauricio
 */
public class OrganizadorForm extends ObjectForm implements ActionListener {

    private Organizador organizador;
    
    public OrganizadorForm(HomeMidlet midlet, Organizador organizador) {
        super(midlet, "Adicionar/Editar Organizador", new String[] { Constantes.NOME, Constantes.RAMO, Constantes.CONTATO });
        this.organizador = organizador;
        
        this.addTextFields( this.getProperties() );
        
        this.setTextValue( Constantes.NOME , this.organizador.getNome() );
        this.setTextValue( Constantes.RAMO , this.organizador.getRamo());
        this.setTextValue( Constantes.CONTATO , this.organizador.getContato());
        
        this.show();
        
    }

    public OrganizadorForm( HomeMidlet midlet ) {
        this( midlet, new Organizador() );
    }    
    
    public void enviar() throws Exception {
        
        this.organizador.setNome( this.getTextValue( Constantes.NOME ) );
        this.organizador.setContato( this.getTextValue( Constantes.CONTATO ) );
        this.organizador.setRamo( this.getTextValue( Constantes.RAMO ) );
        
        PersistableManager.getInstance().save( this.organizador );
        
        Utils.showSuccessMessage("Organizador criado/atualizado com sucesso", this.getMidlet());
        
        
        new OrganizadoresList(this.getMidlet());
    }

    public void voltar() {
        new OrganizadoresList(this.getMidlet());
    }
    
    
    
}
