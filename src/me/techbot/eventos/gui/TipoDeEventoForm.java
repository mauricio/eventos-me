/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui;

import me.techbot.eventos.gui.utils.Utils;
import me.techbot.eventos.gui.utils.ApplicationForm;
import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.TextField;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import java.util.Vector;
import me.techbot.eventos.TipoDeEvento;
import net.sourceforge.floggy.persistence.PersistableManager;

/**
 *
 * @author mauricio
 */
public class TipoDeEventoForm extends ApplicationForm implements ActionListener {

    private TextField nome;
    private TextArea descricao;
    
    private Command enviarCommand;
    private Command voltarCommand;
    private TipoDeEvento tipoDeEvento;
    
    public TipoDeEventoForm( HomeMidlet midlet, TipoDeEvento tipoDeEvento ) {
        super(midlet);
        Form f = new Form("Adicionar/Editar Evento");
        
        Label label = new Label("Nome");
        f.addComponent(label);

        this.nome = new TextField();
        f.addComponent(this.nome);
        
        label = new Label( "Descrição" );
        f.addComponent(label);
        
        this.descricao = new TextArea( 5, 20);
        f.addComponent( this.descricao );
        
        this.enviarCommand = new Command( "Enviar" );
        f.addCommand( this.enviarCommand);
        
        this.voltarCommand = new Command( "Voltar" );
        f.addCommand( this.voltarCommand );
        
        f.addCommandListener(this);
        
        f.show();
        
        this.tipoDeEvento = tipoDeEvento;
        
        Utils.set( this.tipoDeEvento.getNome() , this.nome);
        Utils.set( this.tipoDeEvento.getDescricao() , this.descricao);
        
    }

    public TipoDeEventoForm( HomeMidlet midlet ) {
        this(midlet, new TipoDeEvento());
    }
    
    public void actionPerformed(ActionEvent ae) {
    
        if ( ae.getSource() == this.enviarCommand ) {
            
            Vector erros = new Vector();
            
            if ( Utils.isEmpty( this.nome ) ) {
                erros.addElement( "Você deve preencher o nome" );
            }
            
            if ( Utils.isEmpty( this.descricao ) ) {
                erros.addElement( "Voce deve preencher a descrição" );
            }
            
            if ( erros.size() == 0 ) {
                
                try {
                    
                    this.tipoDeEvento.setNome( this.nome.getText() );
                    this.tipoDeEvento.setDescricao( this.nome.getText() );
                    
                    PersistableManager.getInstance().save( this.tipoDeEvento );
                    Utils.showSuccessMessage("Tipo de evento criado/atualizado com sucesso", this.getMidlet());
                    this.goToTiposDeEventosList();
                } catch ( Exception e ) {
                    throw new RuntimeException(e.getMessage());
                }
            } else {
               Utils.showValidationError(erros, this.getMidlet());
            }
            
            return;
        }
        
        if ( ae.getSource() == this.voltarCommand ) {
            this.goToTiposDeEventosList();
            return;
        }
        
    }
   
    
    
}
