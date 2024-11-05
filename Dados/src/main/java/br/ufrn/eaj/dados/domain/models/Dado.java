package br.ufrn.eaj.dados.domain.models;

import java.util.Random;

public class Dado {
    private int face;

    private Random random;

    public Dado() {
        this.random = new Random();
    }

    public int jogarDado() {
        this.face = random.nextInt(1, 6);
        return this.face;
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
