package com.javeriana.decorator;

import com.javeriana.mundo.Disparo;


public class DisparoZic extends DisparoDecorador {
    public DisparoZic (Disparo disparo){
        super(disparo);

    }

    @Override
    public void shoot() {
        super.disparoGrawp.shoot();
        disparoGrawp.setPosY(disparoGrawp.getPosY() -20);
    }

}