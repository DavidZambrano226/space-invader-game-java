package com.javeriana.hilos;

import com.javeriana.InterfazSpaceInvaders;
import com.javeriana.mundo.NaveJugador;
import com.javeriana.mundo.SpaceInvaders;

public class SpaceInvaderStartFacade {

    private HiloEnemigos hilitoEnemigo;

    private HiloDisparoJugador hilitoDisparo;

    private HiloDisparoEnemigos hilitoEnemigoDisparo;

    private HiloAnimacionEnemigos hilitoAnimacion;
    private HiloAuxiliarCreaDisparo hilitoAuxiliar;

    private SpaceInvaders mundo;

    private InterfazSpaceInvaders instance;

    public void startHiloEnemigo(SpaceInvaders mundo, InterfazSpaceInvaders instance) {
        for (int i = 0; i < mundo.getPartidaActual().getEnemigos().length; i++) {
            for (int j = 0; j < mundo.getPartidaActual().getEnemigos()[0].length; j++) {
                if (mundo.getPartidaActual().getEnemigos()[i][j] != null) {
                    hilitoEnemigo = new HiloEnemigos(mundo.getPartidaActual().getEnemigos()[i][j], instance);
                    hilitoEnemigo.start();
                }
            }
        }
    }

    private void startHiloAuxiliar( SpaceInvaders mundo, InterfazSpaceInvaders instance) {

        hilitoAuxiliar = new HiloAuxiliarCreaDisparo(mundo.getPartidaActual(), instance);
        hilitoAuxiliar.start();
    }


    private void startHiloAnimacion(SpaceInvaders mundo, InterfazSpaceInvaders instance) {
        for (int i = 0; i < mundo.getPartidaActual().getEnemigos().length; i++) {
            for (int j = 0; j < mundo.getPartidaActual().getEnemigos()[0].length; j++) {
                if (mundo.getPartidaActual().getEnemigos()[i][j] != null) {
                    hilitoAnimacion = new HiloAnimacionEnemigos(mundo.getPartidaActual().getEnemigos()[i][j], instance);
                    hilitoAnimacion.start();
                }
            }
        }
    }

    private void startHiloDisparoEnemigo(SpaceInvaders mundo, InterfazSpaceInvaders instance) {
        hilitoEnemigoDisparo = new HiloDisparoEnemigos(mundo.getPartidaActual(), instance, mundo);
        hilitoEnemigoDisparo.start();
    }

    private void startHiloJugador(SpaceInvaders mundo, InterfazSpaceInvaders instance) {
        hilitoDisparo = new HiloDisparoJugador((NaveJugador) mundo.getJugadorActual(), instance,
                mundo.getPartidaActual().getEnemigos(), mundo.getPartidaActual());
        hilitoDisparo.start();
    }

    public void startKeyboardPlayer() {
        startHiloJugador(this.mundo,this.instance);
    }

    public void iniciarJuego(SpaceInvaders mundo, InterfazSpaceInvaders instance) {
        this.mundo = mundo;
        this.instance = instance;
        startHiloAuxiliar(mundo, instance);
        startHiloEnemigo(mundo, instance);
        startHiloAnimacion(mundo, instance);
        startHiloDisparoEnemigo(mundo, instance);
        startHiloJugador(mundo, instance);
    }

    public void detenerJuego() {
        // hilitoAuxiliar.interrupt();
        hilitoAuxiliar = null;
        hilitoDisparo = null;
        hilitoEnemigoDisparo = null;
        hilitoEnemigo = null;
    }



}
