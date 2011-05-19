/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui.utils;

import com.sun.lwuit.Container;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.TextField;
import com.sun.lwuit.layouts.BoxLayout;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mauricio
 */
public class DateField extends Container {

    private String name;
    private TextField day;
    private TextField month;
    private TextField year;
    
    public DateField( String name, Date date ) {
        super( new BoxLayout( BoxLayout.X_AXIS ) );
        this.name = name;
        
        this.day = new TextField( 2 );
        this.month = new TextField( 2 );
        this.year = new TextField( 4 );
        
        Label label = new Label( name );
        
        this.addComponent( label );
        this.addComponent( this.day );
        this.addComponent( this.month );
        this.addComponent( this.year );
        this.setDate(date);
    }

    public DateField( String name ) {
        this( name, new Date() );
    }
    
    public void setDate( Date date ) {
        Calendar calendar  = Calendar.getInstance();
        calendar.setTime(date);
                this.day.setText( Integer.toString( calendar.get( Calendar.DAY_OF_MONTH ) ) );
        this.month.setText( Integer.toString( calendar.get( Calendar.MONTH ) ) );
        this.year.setText( Integer.toString( calendar.get( Calendar.YEAR ) ) );
        
        this.day.setConstraint( TextArea.NUMERIC );
        this.month.setConstraint( TextArea.NUMERIC );
        this.year.setConstraint( TextArea.NUMERIC );
    }
        
    
    public Date getDate() {
        Calendar calendar = Calendar.getInstance();
        
        try {
            if ( this.day.getText() != null ) {
                calendar.set( Calendar.DAY_OF_MONTH , Integer.valueOf( this.day.getText() ).intValue());
            }
            
            if ( this.month.getText() != null ) {
                calendar.set( Calendar.MONTH, Integer.valueOf( this.month.getText() ).intValue() );    
            }
            
            if ( this.year.getText() != null ) {
                calendar.set( Calendar.YEAR, Integer.valueOf( this.year.getText() ).intValue() );    
            }
            
            
            
        } catch ( Exception e ) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        
        
        return calendar.getTime();
    }
    
}
