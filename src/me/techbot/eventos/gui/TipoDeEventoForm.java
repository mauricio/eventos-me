/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui;

import me.techbot.eventos.gui.utils.Utils;
import com.sun.lwuit.Command;
import com.sun.lwuit.events.ActionListener;
import me.techbot.eventos.TipoDeEvento;
import me.techbot.eventos.gui.utils.Constantes;
import me.techbot.eventos.gui.utils.ObjectForm;
import net.sourceforge.floggy.persistence.PersistableManager;

/**
 *
 * @author mauricio
 */
public class TipoDeEventoForm extends ObjectForm implements ActionListener {

    private Command enviarCommand;
    private Command voltarCommand;
    private TipoDeEvento tipoDeEvento;

    public TipoDeEventoForm(HomeMidlet midlet, TipoDeEvento tipoDeEvento) {
        super(midlet, "Adicionar/Editar Tipo de Evento", new String[]{Constantes.NOME, Constantes.DESCRICAO});

        this.addTextFields( new String[] { Constantes.NOME } );
        this.addTextAreas( new String[] { Constantes.DESCRICAO } );
        
        this.tipoDeEvento = tipoDeEvento;

        this.setTextValue(Constantes.NOME, this.tipoDeEvento.getNome());
        this.setTextValue(Constantes.DESCRICAO, this.tipoDeEvento.getDescricao());

        this.show();
    }

    public TipoDeEventoForm(HomeMidlet midlet) {
        this(midlet, new TipoDeEvento());
    }

    public void enviar() throws Exception {
        this.tipoDeEvento.setNome(this.getTextValue(Constantes.NOME));
        this.tipoDeEvento.setDescricao(this.getTextValue(Constantes.DESCRICAO));

        PersistableManager.getInstance().save(this.tipoDeEvento);
        Utils.showSuccessMessage("Tipo de evento criado/atualizado com sucesso", this.getMidlet());
        this.goToTiposDeEventosList();
    }

    public void voltar() {
        this.goToTiposDeEventosList();

    }
}
