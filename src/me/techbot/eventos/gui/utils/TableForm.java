/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui.utils;

import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.List;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import java.util.Vector;
import me.techbot.eventos.gui.HomeMidlet;
import net.sourceforge.floggy.persistence.Persistable;
import net.sourceforge.floggy.persistence.PersistableManager;

/**
 *
 * @author mauricio
 */
public abstract class TableForm extends ApplicationForm implements ActionListener {

    private Vector objects;
    private Button editar;
    private Button remover;
    private Command voltar;
    private Command adicionar;
    private List list;

    public TableForm(HomeMidlet midlet, String title, Vector objects) {
        super(midlet);

        this.objects = objects;

        Form form = new Form(title);

        form.setLayout( new BorderLayout() );
        
        Vector vector = new Vector();

        for (int x = 0; x < objects.size(); x++) {
            vector.addElement(objects.elementAt(x).toString());
        }

        this.list = new List(vector);

        form.addComponent( BorderLayout.CENTER ,  this.list);
        
        this.voltar = new Command("Voltar");
        form.addCommand(this.voltar);

        this.adicionar = new Command("Adicionar");
        form.addCommand(this.adicionar);

        form.addCommandListener(this);

        if (this.list.size() == 0) {
            Label label = new Label("Não há itens");
            form.addComponent( BorderLayout.CENTER, label);
        } else {

            this.editar = new Button("Editar Selecionado");
            this.editar.addActionListener(this);

            this.remover = new Button("Remover Selecionado");
            this.remover.addActionListener(this);            
            
            Container container = new Container(new BoxLayout( BoxLayout.X_AXIS ));
            
            container.addComponent( this.editar );
            container.addComponent(this.remover);

            form.addComponent( BorderLayout.SOUTH, container);

        }

        form.show();

    }

    public void actionPerformed(ActionEvent ae) {

        if (this.voltar == ae.getSource()) {
            this.goToHomeForm();
            return;
        }

        if (this.adicionar == ae.getSource()) {
            this.adicionar();
            return;
        }

        int index = this.list.getSelectedIndex();

        if (!isValidIndex(index)) {
            Utils.showErrorMessage("Seleção inválida", this.getMidlet());
            return;
        }

        if (this.editar == ae.getSource()) {
            this.editar(this.getObject(index));
            return;
        }


        if (this.remover == ae.getSource()) {
            this.remover(index);
            return;
        }

    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < this.list.size();
    }

    public abstract void editar(Object object);

    public abstract void adicionar();

    public Vector getObjects() {
        return objects;
    }

    public Object getObject(int index) {
        return this.objects.elementAt(index);
    }

    private void remover(int index) {

        try {
            PersistableManager.getInstance().delete((Persistable) this.objects.elementAt(index));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        this.list.getModel().removeItem(index);
        this.objects.removeElementAt(index);

        Utils.showSuccessMessage("Objeto removido com sucesso", this.getMidlet());

    }
}
