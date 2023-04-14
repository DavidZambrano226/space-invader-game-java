package com.javeriana.decorator;

import com.javeriana.mundo.Disparo;
import com.javeriana.mundo.interfac.AccionProyectil;

public abstract class DisparoDecorador implements AccionProyectil {
    Disparo disparoGrawp;
    public  DisparoDecorador (Disparo disparo){
        disparoGrawp = disparo;
    }
    public  DisparoDecorador (int x, int y){
        this.disparoGrawp = new Disparo(x, y);
    }
    public abstract void shoot();
    public Disparo getDisparoGrawp() {
        return disparoGrawp;
    }

    public void setDisparoGrawp(Disparo disparoGrawp) {
        this.disparoGrawp = disparoGrawp;
    }
}

