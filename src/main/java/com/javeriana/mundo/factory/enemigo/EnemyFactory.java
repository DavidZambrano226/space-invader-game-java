package com.javeriana.mundo.factory.enemigo;

import com.javeriana.mundo.*;


public class EnemyFactory  {

    public Enemigo getEnemy(TypeEnemy typeEnemy, Nivel nivel, int posx, int posy){
        switch (typeEnemy) {
            case CALAMAR:
                return new InvasorCalamar(nivel.getVelocidadEnemigos(),posx,posy, nivel.getVidaEnemigos(), nivel.getAnchoEnemigos(), nivel.getAltoEnemigos(),
                        Enemigo.DERECHA);
            case CANGREJO:
                return new InvasorCangrejo(nivel.getVelocidadEnemigos(),posx,
                        posy, nivel.getVidaEnemigos(), nivel.getAnchoEnemigos(), nivel.getAltoEnemigos(),
                        Enemigo.DERECHA);
            case PULPO:
                return new InvasorPulpo(nivel.getVelocidadEnemigos(),posx,
                        posy, nivel.getVidaEnemigos(), nivel.getAnchoEnemigos(), nivel.getAltoEnemigos(),
                        Enemigo.DERECHA);
            default:
                System.out.println("Enemigo no existe");
        }
        return null;
    }
}
