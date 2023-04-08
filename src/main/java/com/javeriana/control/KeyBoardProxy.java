package com.javeriana.control;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class KeyBoardProxy implements KeyListener, IKeyBoard {
    private Teclado teclado;

    public KeyBoardProxy(Teclado teclado) {
        this.teclado = teclado;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        List<Integer> validKeys = new ArrayList<>();
        validKeys.add(KeyEvent.VK_SPACE);
        validKeys.add(KeyEvent.VK_LEFT);
        validKeys.add(KeyEvent.VK_RIGHT);
        validKeys.add(KeyEvent.VK_ESCAPE);
        validKeys.add(KeyEvent.VK_P);
        validKeys.add(KeyEvent.VK_ENTER);

        if (!validKeys.contains(e.getKeyCode())) {
            System.err.println("The key pressed does not valid key " + e.getKeyChar());
            JOptionPane.showMessageDialog(
                    null,
                    "La tecla presionada no es correcta. Pulse Enter para iniciar o revise las instrucciones.",
                    "Tecla Incorrecta",
                    JOptionPane.ERROR_MESSAGE);
            return;

        }

        this.teclado.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
