/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8rainhas;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Eduardo
 */
public class Individuo {

    private int[] RainhaDalinha;
    public int fitness;
    private String tabuleiro[][];
    private int numRainha;

    public Individuo(boolean rainhasAleatorias, int rainhas) {
        numRainha = rainhas;
        tabuleiro = new String[numRainha][numRainha];
        RainhaDalinha = new int[rainhas];
        fitness = 0;

        for (int i = 0; i < numRainha; i++) {
            RainhaDalinha[i] = -1;
        }

        for (int i = 0; i < numRainha; i++) {
            if (rainhasAleatorias) {
                RainhaDalinha[i] = this.gerarYAleatorioExclusivo();
            }
        }

    }

    public int gerarYAleatorioExclusivo() {

        int y;
        Random r;
        boolean encontrou;

        do {
            r = new Random();
            y = r.nextInt(numRainha);
            encontrou = false;

            for (int i = 0; i < numRainha; i++) {
                if (RainhaDalinha[i] == y) {
                    encontrou = true;
                    break;
                }
            }

        } while (encontrou);

        return y;
    }

    private boolean ListaCompleta() {

        for (int i = 0; i < numRainha; i++) {
            if (RainhaDalinha[i] == -1) {
                return false;
            }
        }
        return true;

    }

    public boolean adicionar(int posicao, Integer coluna) {

        if (ListaCompleta()) {
            return false;
        }
        if (coluna > numRainha) {
            return false;
        }

        RainhaDalinha[posicao] = coluna;
        return true;
    }

    public boolean calcularFitness() {
        if (RainhaDalinha.length >= numRainha) {

            // INICIALIZAÇÃO
            for (int i = 0; i < numRainha; i++) {
                for (int j = 0; j < numRainha; j++) {
                    tabuleiro[i][j] = "-";
                }
            }

            //COLOCANDO AS DEVIDAS RAINHAS NA POSIÇÃO DESEJADA NO TABULEIRO
            for (int i = 0; i < numRainha; i++) {
                //System.out.println("Linha: " +i + " Coluna: "+ RainhaDalinha.get(i));
                //System.out.println("Rainha= "+RainhaDalinha[i] +" posicao : "+i);
                tabuleiro[i][RainhaDalinha[i]] = "R";

            }

            for (int i = 0; i < numRainha; i++) {
                for (int j = i + 1; j < numRainha; j++) {
                    if (RainhaDalinha[i] == RainhaDalinha[j]) {
                        fitness++;
                        j = numRainha;
                    }
                }
            }

            int contador = 1;
            boolean TravaFrente = false;
            boolean TravaAtras = false;

            for (int i = 0; i < numRainha; i++) {

                for (int linha = i + 1; linha < numRainha; linha++) {

                    if (!TravaFrente) {
                        if ((contador + RainhaDalinha[i]) <= numRainha - 1) {

                            if (tabuleiro[linha][RainhaDalinha[i] + contador].equals("R")) {
                                fitness++;
                                // System.out.println("Linha referencia = " + i);
                                // System.out.println("Linha: " + linha + " Coluna: " + (RainhaDalinha.get(i).intValue() + contador));
                                TravaFrente = true;
                            }
                        } else {
                            TravaFrente = true;
                        }
                    }
                    if (!TravaAtras) {
                        if (contador <= RainhaDalinha[i]) {

                            if (tabuleiro[linha][RainhaDalinha[i] - contador].equals("R")) {
                                fitness++;
                                // System.out.println("Linha referencia = " + i);
                                //  System.out.println("Linha: " + linha + " Coluna: " + (RainhaDalinha.get(i).intValue() - contador));

                                TravaAtras = true;
                            }

                        } else {
                            TravaAtras = true;
                        }
                    }

                    if (TravaAtras && TravaFrente) {
                        linha = numRainha;
                    } else {
                        contador++;
                    }

                }

                contador = 1;
                TravaFrente = false;
                TravaAtras = false;
            }

            /*  for (int i = 0; i < numRainha; i++) {
                for (int j = 0; j < numRainha; j++) {
                    System.out.print(tabuleiro[i][j] + " | ");
                }
                System.out.println("\n");
            }
            System.out.println("Fitness = " + fitness);*/
            return true;
        } else {
            return false;
        }
    }

    public int[] getRainhaDalinha() {
        return RainhaDalinha;
    }

    public void setRainhaDalinha(int[] RainhaDalinha) {
        this.RainhaDalinha = RainhaDalinha;
    }

    public int getFitness() {
        return fitness;
    }

    public String getTabuleiro() {
        String texto = "";
        String sepLine = " +";
        for (int i = 0; i < numRainha; i++) {
            sepLine += "----+";
        }

        // <b>print the board:</b>
        for (int r = 0; r < numRainha; r++) {
            texto = texto + sepLine + System.getProperty("line.separator");
            texto = texto + " |";
            for (int c = 0; c < numRainha; c++) {
                String q = tabuleiro[r][c].equals("R") ? "X" : " ";
                texto = texto + " " + q + "  |";
            }
            texto = texto + System.getProperty("line.separator");
        }
        texto = texto + sepLine + System.getProperty("line.separator");

        /*
        String texto = "";
        for (int i = 0; i < numRainha; i++) {
            for (int j = 0; j < numRainha; j++) {
                texto += tabuleiro[i][j] + " | ";
            }
            texto += "\n";
        }*/
        return texto;

    }

    public int getRainha(int posicao) {
        return RainhaDalinha[posicao];
    }

}
