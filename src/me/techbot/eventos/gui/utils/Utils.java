/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui.utils;

import com.sun.lwuit.TextArea;
import java.util.Vector;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import net.sourceforge.floggy.persistence.PersistableManager;
import net.sourceforge.floggy.persistence.SingleObjectSet;

/**
 *
 * @author mauricio
 */
public class Utils {
    
    public static boolean isEmpty( TextArea field ) {
        String text = field.getText();
        
        if ( text != null && text.trim().length() > 0 ) {
            return false;
        } else {
            return true;
        }
    }
    
    public static String toSentence( Vector vector ) {
        
        StringBuffer buffer = new StringBuffer();
        
        for ( int x = 0; x < vector.size(); x++ ) {
          if ( x < vector.size() - 1 ) {
              buffer.append( vector.elementAt(x) + ", " );
          } else {
              buffer.append( "e " + vector.elementAt(x) );
          }
        }
            
        
        return buffer.toString();
        
    }
    
    public static void showErrorMessage( String message, MIDlet midlet ) {
        Alert alert = new Alert("Erro", message, null, AlertType.ERROR);
        Display.getDisplay(midlet).setCurrent(alert);        
    }
    
    public static void showValidationError( Vector messages, MIDlet midlet ) {
        
        Alert alert = new Alert("Erro de Validação", toSentence(messages), null, AlertType.ERROR);
        Display.getDisplay(midlet).setCurrent(alert);
        
    }
    
    public static void showSuccessMessage( String message, MIDlet midlet ) {
        Alert alert = new Alert("Sucesso", message, null, AlertType.INFO);
        Display.getDisplay(midlet).setCurrent(alert);        
    }
    
    public static Vector list( Class clazz ) {
        try {
            SingleObjectSet result = PersistableManager.getInstance().find(clazz, null, null);
            
            Vector objects = new Vector();
            
            for ( int x = 0; x < result.size(); x++ ) {
                objects.addElement( result.get(x) );
            }
            
            return objects;
            
        } catch ( Exception e ) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public static void set( String value, TextArea component ) {
        if ( value != null ) {
            component.setText(value);
        }
    }
        
        
    
}
