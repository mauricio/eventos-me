/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui.utils;

import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.table.TableLayout;
import java.util.Vector;
import me.techbot.eventos.gui.HomeMidlet;

/**
 *
 * @author mauricio
 */
public abstract class ObjectForm extends ApplicationForm implements ActionListener {

    private Form form;
    private String[] properties;
    
    private Command enviarCommand;
    private Command voltarCommand;
    
    private String title;
    
    public ObjectForm( HomeMidlet midlet, String title, String[] properties ) {
        super(midlet);    
        this.properties = properties;
        this.title = title;
        this.form = new Form( this.title );
        this.form.setLayout( new BoxLayout( BoxLayout.Y_AXIS ) );
    }

    public void addTextAreas(String[] names) {
        super.addTextAreas(this.form, names);
    }

    public void addTextFields( String[] names) {
        super.addTextFields(this.form, names);
    }

    public Form getForm() {
        return form;
    }
    
    public void show() {
        
        this.enviarCommand = new Command( "Enviar" );
        this.form.addCommand( this.enviarCommand);
        
        this.voltarCommand = new Command( "Voltar" );
        this.form.addCommand( this.voltarCommand );
        
        this.form.addCommandListener(this);
        this.form.show();        
    }

    public void actionPerformed(ActionEvent ae) {
        
        if ( ae.getSource() == this.voltarCommand ) {
            this.voltar();
            return;
        }
        
        if ( ae.getSource() == this.enviarCommand ) {
            
            
             Vector erros = this.validateEmpty();
            
            if ( erros.size() == 0 ) {
                
                try {
                    
                    this.enviar();
                    
                } catch ( Exception e ) {
                    e.printStackTrace();
                    throw new RuntimeException(e.getMessage());
                }
            } else {
               Utils.showValidationError(erros, this.getMidlet());
            }
            
            return;
            
        }
        
    }

    public String[] getProperties() {
        return properties;
    }
    
    public abstract void voltar();
    public abstract void enviar() throws Exception;
    
}
