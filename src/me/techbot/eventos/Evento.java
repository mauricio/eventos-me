/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos;

import java.util.Date;
import net.sourceforge.floggy.persistence.Persistable;

/**
 *
 * @author mauricio
 */
public class Evento implements Persistable {

    private String nome;
    private Date data;
    private TipoDeEvento tipoDeEvento;
    private Organizador organizador;

    public String toString() {
        return this.getNome();
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public TipoDeEvento getTipoDeEvento() {
        return tipoDeEvento;
    }

    public void setTipoDeEvento(TipoDeEvento tipoDeEvento) {
        this.tipoDeEvento = tipoDeEvento;
    }
    
    
    
}
