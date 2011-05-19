/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.techbot.eventos.gui;

import com.sun.lwuit.Button;
import com.sun.lwuit.Display;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;
import java.io.IOException;
import javax.microedition.midlet.*;
import me.techbot.eventos.gui.utils.Fixtures;
import net.sourceforge.floggy.persistence.FloggyException;
import net.sourceforge.floggy.persistence.PersistableManager;

/**
 * @author mauricio
 */
public class HomeMidlet extends MIDlet {

    private Button eventos;
    private Button tiposDeEventos;
    private Button organizadores;

    public void startApp() {
        Display.init(this);

        Fixtures.load();
        
        try {
            Resources r = Resources.open("/tema.res");
            UIManager.getInstance().setThemeProps(r.getTheme("businessTheme"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

        new HomeForm(this);


    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
        try {
            PersistableManager.getInstance().shutdown();
        } catch (FloggyException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
    }
}
