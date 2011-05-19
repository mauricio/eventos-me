/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui.utils;

import me.techbot.eventos.Evento;
import me.techbot.eventos.Organizador;
import me.techbot.eventos.TipoDeEvento;

/**
 *
 * @author mauricio
 */
public class Fixtures {

    public static void load() {
        
        Organizador organizador1 = new Organizador();
        organizador1.setContato( "000 000 0000" );
        organizador1.setNome( "José" );
        organizador1.setRamo( "Casamentos" );

        Organizador organizador2 = new Organizador();
        organizador2.setContato( "000 000 0000" );
        organizador2.setNome( "Maria" );
        organizador2.setRamo( "Festas" );        
        
        TipoDeEvento tipoDeEvento1 = new TipoDeEvento();
        tipoDeEvento1.setNome( "Tecnologia" );
        tipoDeEvento1.setDescricao( "In Baltimore" );
        
        TipoDeEvento tipoDeEvento2 = new TipoDeEvento();
        tipoDeEvento2.setNome( "Turismo" );
        tipoDeEvento2.setDescricao( "In São Paulo" );        

        Evento evento1 = new Evento();
        evento1.setNome( "RailsConf" );
        evento1.setDataDeInicio( Utils.toDate(2011, 5, 17) );
        evento1.setDataDeTermino( Utils.toDate(2011, 5, 20) );
        evento1.setOrganizador(organizador1);
        evento1.setTipoDeEvento(tipoDeEvento1);

        Evento evento2 = new Evento();
        evento2.setDataDeInicio( Utils.toDate(2011, 9, 17) );
        evento2.setDataDeTermino( Utils.toDate(2011, 9, 20) );
        evento2.setNome( "QCon" );
        evento2.setOrganizador(organizador2);
        evento2.setTipoDeEvento(tipoDeEvento2);        
        
        Utils.persist(organizador1);
        Utils.persist(organizador2);
        Utils.persist( tipoDeEvento1 );
        Utils.persist( tipoDeEvento2 );
        Utils.persist( evento1 );
        Utils.persist( evento2 );
        
        
        
    }    
    
}
