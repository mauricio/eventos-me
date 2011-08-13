/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui.utils;

import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.TextField;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import me.techbot.eventos.gui.HomeForm;
import me.techbot.eventos.gui.HomeMidlet;
import me.techbot.eventos.gui.TiposDeEventoList;

/**
 *
 * @author mauricio
 */
public class ApplicationForm {
    
    private HomeMidlet midlet;
    private Hashtable textFields = new Hashtable();

    public ApplicationForm(HomeMidlet midlet) {
        this.midlet = midlet;
    }
    
    public void addTextFields( Form form, String[] names ) {
        for ( int x = 0; x < names.length; x++ ) {
            Label label = new Label(names[x]);
            form.addComponent(label);
            
            TextField textField = new TextField();
            form.addComponent(textField);
                        
            this.textFields.put( names[x] , textField);   
        }
    }

    public void addTextAreas( Form form, String[] names ) {
        for ( int x = 0; x < names.length; x++ ) {
            Label label = new Label(names[x]);
            form.addComponent(label);
            
            TextArea textField = new TextArea();
            form.addComponent(textField);
                        
            this.textFields.put( names[x] , textField);   
        }
    }    
    
    public String getTextValue( String property ) {
        
        TextArea field = (TextArea) this.textFields.get( property );
        return field.getText();
        
    }
    
    public void setTextValue( String property, String value ) {
        
        if ( value != null ) {
            TextArea field = (TextArea) this.textFields.get(property);
            field.setText(value);    
        }
        
    }
    
    public boolean isEmpty( String property ) {
        
        String value = this.getTextValue(property);
        
        if ( value != null && value.trim().length() > 0 ) {
            return false;
        } else {
            return true;
        }
        
    }
    
    public Vector validateEmpty() {
        
        Vector errors = new Vector();
        
        Enumeration keys = this.textFields.keys();
        
        while ( keys.hasMoreElements() ) {
            
            String key = (String) keys.nextElement();
            
            String value = this.getTextValue( key );
            
            if ( value == null || value.trim().length() == 0 ) {
                errors.addElement( key + " deve ser preenchido" );
            }
            
        }
        
        
        return errors;
    }
    
    public Hashtable getTextValues() {
        
        Hashtable values = new Hashtable();
        Enumeration enumeration = values.keys();
        
        while ( enumeration.hasMoreElements() ) {
            String key = (String) enumeration.nextElement();
            values.put(key, this.getTextValue(key));
        }
        
        return values;
        
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
