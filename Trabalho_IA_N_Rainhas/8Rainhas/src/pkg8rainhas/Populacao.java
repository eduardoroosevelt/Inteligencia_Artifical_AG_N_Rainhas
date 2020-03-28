/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8rainhas;

import static pkg8rainhas.Main.colisaoMax;

/**
 *
 * @author Eduardo
 */
public class Populacao {

    private Individuo[] individuos;
    private int tamPopulacao;
    private int numRainha;

    public Populacao(int tamPop, boolean individuosAleatorios, int rainhas) {
        numRainha = rainhas;
        tamPopulacao = tamPop;
        individuos = new Individuo[tamPop];

        for (int i = 0; i < individuos.length; i++) {

            if (individuosAleatorios) {
                individuos[i] = new Individuo(true, rainhas);
            } else {
                individuos[i] = null;
            }
        }
    }

    public void setIndividuo(Individuo individuo) {
        for (int i = 0; i < tamPopulacao; i++) {
            if (individuos[i] == null) {
                individuos[i] = individuo;
                return;
            }
        }
    }

    public void ordenaPopulacao() {
        boolean trocou = true;
        while (trocou) {
            trocou = false;
            for (int i = 0; i < tamPopulacao - 1; i++) {

                if (individuos[i].getFitness() > individuos[i + 1].getFitness()) {

                    Individuo temp = individuos[i];
                    individuos[i] = individuos[i + 1];
                    individuos[i + 1] = temp;
                    trocou = true;
                }
            }
        }
    }

    public double getMediaAptidao() {
        return getTotalAptidao() / getNumIndividuos();
    }

    public int getNumIndividuos() {
        int num = 0;
        for (int i = 0; i < tamPopulacao; i++) {
            if (individuos[i] != null) {
                num++;
            }
        }
        return num;
    }

    public int getTotalAptidaoInvertida() {
        int total = 0;

        for (int i = 0; i < tamPopulacao; i++) {
            int parada = getIndividuo(i).getFitness();

            parada = colisaoMax + 1 - parada;
            total += parada;
        }
        return total;
    }

    public int getTotalAptidao() {
        int total = 0;
        for (int i = 0; i < tamPopulacao; i++) {
            if (individuos[i] != null) {
                total += individuos[i].getFitness();
            }
        }
        return total;
    }

    public Individuo[] getIndividuos() {
        return individuos;
    }

    public Individuo getIndividuo(int posicao) {
        return individuos[posicao];
    }

}
