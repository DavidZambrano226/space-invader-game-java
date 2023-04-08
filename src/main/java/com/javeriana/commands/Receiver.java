package com.javeriana.commands;

import com.javeriana.InterfazSpaceInvaders;

public class Receiver {
    private InterfazSpaceInvaders interfazSpaceInvaders;

    public Receiver(InterfazSpaceInvaders interfazSpaceInvaders) {
        this.interfazSpaceInvaders = interfazSpaceInvaders;
    }

    public void pause() {
        interfazSpaceInvaders.modificarFuncionamiento(false);
        interfazSpaceInvaders.cambiarPausa(true);
    }

    public void play() {
        interfazSpaceInvaders.modificarFuncionamiento(true);
        interfazSpaceInvaders.cambiarPausa(false);
        interfazSpaceInvaders.iniciarTodosLosHilos();
    }

    public void closeGame() {
        interfazSpaceInvaders.cerrar();
    }

}
