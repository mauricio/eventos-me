/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui.utils;

import com.sun.lwuit.TextArea;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import net.sourceforge.floggy.persistence.FloggyException;
import net.sourceforge.floggy.persistence.Persistable;
import net.sourceforge.floggy.persistence.PersistableManager;
import net.sourceforge.floggy.persistence.SingleObjectSet;

/**
 *
 * @author mauricio
 */
public class Utils {

    public static Vector addAll( Vector destination, Vector origin ) {

        for ( int x = 0; x < origin.size(); x++ ) {
            destination.addElement( origin.elementAt( x ) );
        }

        return destination;
    }

    public static Vector vectorOf( Object object ) {

        Vector vector = Utils.list( object.getClass() );
        Vector objects = new Vector();

        objects.addElement(object);

        addAll( objects, vector );

        return objects;
    }

    public static boolean between( Date data, Date inicio, Date termino ) {

        boolean result = false;

        if ( data.getTime() > inicio.getTime() && data.getTime() < termino.getTime() ) {
            result  = true;
        }

        return result;
    }

    public static final void persist( Persistable p ) {
        try {
            PersistableManager.getInstance().save(p);
        } catch (FloggyException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
    }

    public static final Date toDate( int year, int month, int day ) {

        Calendar calendar = Calendar.getInstance();

        calendar.set( Calendar.YEAR , year);
        calendar.set( Calendar.MONTH , month);
        calendar.set( Calendar.DAY_OF_MONTH , day);

        return calendar.getTime();

    }

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
            return toVector(result);

        } catch ( Exception e ) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static Vector toVector( SingleObjectSet set ) {
            Vector objects = new Vector();

            try {
            for ( int x = 0; x < set.size(); x++ ) {
                objects.addElement( set.get(x) );
            }
            } catch ( Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }

            return objects;
    }

    public static void set( String value, TextArea component ) {
        if ( value != null ) {
            component.setText(value);
        }
    }



}
