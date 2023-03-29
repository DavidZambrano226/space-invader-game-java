package com.javeriana.mundo;

public class NivelBuilder {
    private String nivel;
    private int velocidadEnemigos;
    private int enemigos;
    private int vidaEnemigos;
    private int posXPrimerEnemigo;
    private int posYPrimerEnemigo;
    private int anchoEnemigos;
    private int altoEnemigos;

    public NivelBuilder levelNumber(int levelNumber) {
        this.nivel = String.valueOf(levelNumber);
        return this;
    }

    public NivelBuilder velocityOfEnemies(int velocity) {
        this.velocidadEnemigos = velocity;
        return this;
    }

    public NivelBuilder numberOfEnemies(int enemies) {
        this.enemigos = enemies;
        return this;
    }

    public NivelBuilder numberOfEnemyLives(int lifeEnemies) {
        this.vidaEnemigos = lifeEnemies;
        return this;
    }

    public NivelBuilder xPositionFirstEnemy(int xPosition) {
        this.posXPrimerEnemigo = xPosition;
        return this;
    }

    public NivelBuilder yPositionFirstEnemy(int yPosition) {
        this.posYPrimerEnemigo = yPosition;
        return this;
    }

    public NivelBuilder widthOfEnemies(int width) {
        this.anchoEnemigos = width;
        return this;
    }

    public NivelBuilder heightOfEnemies(int height) {
        this.altoEnemigos = height;
        return this;
    }

    public Nivel build() {
        return new Nivel(nivel,
                velocidadEnemigos,
                enemigos,
                vidaEnemigos,
                posXPrimerEnemigo,
                posYPrimerEnemigo,
                anchoEnemigos,
                altoEnemigos
        );
    }


}

