/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8rainhas;

import java.awt.image.ImageConsumer;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Eduardo
 */
public class Main {

	static Individuo ind1;
	static Individuo ind2;
	static ArrayList<Populacao> geracao = new ArrayList<Populacao>();
	static Random gerador = new Random();
	static int taxaDeMutacao = 2;
	static int TamPopu = 100;
	static int Nrainhas = 9;
	static int NumeroDeGeracoes = 20000;
	static int colisaoMax;
	static Individuo melhor;
	static int PosicaoGeracao;

	public static void main(String[] args) {
		


		try {
			Scanner in 		= new Scanner(System.in);
			
			System.out.println("Taxa de mutação (Para teste experimente colocar 2)");			
			taxaDeMutacao		= in.nextInt();
			
			System.out.println("Tamanho da populacao  (Para teste experimente colocar 100)");
			TamPopu				= in.nextInt();
			
			System.out.println("Tamannho do tabuleiro (Se colocar mais de 15 perigoso dar erro por fa"
					+ "lta de memoria. Para teste experimente colocar 8 ou 9)");
			Nrainhas			= in.nextInt();
			
			System.out.println("Numero de Gerações (Para teste experimente colocar 20000)");
			NumeroDeGeracoes	= in.nextInt();


				
			System.out.println("");
			System.out.println("");
			System.out.println("-------------------------------------------");
			System.out.println("");
			System.out.println("");
			
			// ArrayList<Individuo> Populacao = new ArrayList<Individuo>();
			Populacao Populacao = new Populacao(TamPopu, false, Nrainhas);
			Individuo ind;
			colisaoMax = Nrainhas + 1;
			int i = 0;

			/*     ind = new Individuo(false);
        ind.adicionar(0, 1);
        ind.adicionar(1, 6);
        ind.adicionar(2, 3);
        ind.adicionar(3, 7);
        ind.adicionar(4, 4);
        ind.adicionar(5, 2);
        ind.adicionar(6, 0);
        ind.adicionar(7, 5);
        ind.calcularFitness();
        System.out.println(ind.getFitness());
        Populacao.setIndividuo(ind);

        ind = new Individuo(false);
        ind.adicionar(0, 2);
        ind.adicionar(1, 0);
        ind.adicionar(2, 3);
        ind.adicionar(3, 1);
        ind.adicionar(4, 5);
        ind.adicionar(5, 7);
        ind.adicionar(6, 4);
        ind.adicionar(7, 6);
        ind.calcularFitness();

        Populacao.setIndividuo(ind);

       ind = new Individuo(false);
        ind.adicionar(0, 0);
        ind.adicionar(1, 2);
        ind.adicionar(2, 4);
        ind.adicionar(3, 6);
        ind.adicionar(4, 1);
        ind.adicionar(5, 3);
        ind.adicionar(6, 5);
        ind.adicionar(7, 7);
        ind.calcularFitness();
        Populacao.setIndividuo(ind);   */
			while (i <= TamPopu) {
				ind = new Individuo(true, Nrainhas);
				ind.calcularFitness();

				Populacao.setIndividuo(ind);
				i++;

			}

			Populacao.ordenaPopulacao();
			melhor = Populacao.getIndividuo(0);
			geracao.add(Populacao);
			System.out.println("Geracao: " + (geracao.size() - 1) + " --- Melhor fitness: " + geracao.get(geracao.size() - 1).getIndividuo(0).getFitness());

			// while (geracao.size() <= NumeroDeGeracoes) {
			while (fitnessBom()) {
				ind1 = selecaoRodaDaRoleta(geracao.get(geracao.size() - 1));
				ind2 = selecaoRodaDaRoleta(geracao.get(geracao.size() - 1));

				System.out.println("Geracao: " + (geracao.size() - 1) + " --- Melhor fitness: " + geracao.get(geracao.size() - 1).getIndividuo(0).getFitness());

				Populacao = cruzamento();
				geracao.add(Populacao);
				/* if (melhor.getFitness() > geracao.get(geracao.size() - 1).getIndividuo(0).getFitness()) {
                melhor = geracao.get(geracao.size() - 1).getIndividuo(0);
                PosicaoGeracao = geracao.size() - 1;
            }*/
			}
			System.out.println("\nColisao maxima: " + colisaoMax);
			System.out.println("\nNumero de rainhas: " + Nrainhas);
			System.out.println("Tamanho da populacao: " + TamPopu);
			System.out.println("Melhor geracao: " + PosicaoGeracao);
			System.out.println("Fitness: " + melhor.getFitness());

			String q = "";
			for (int f = 0; f < Nrainhas; f++) {
				q += " " + melhor.getRainha(f);
			}
			System.out.println("Rainhas nas posisoes: " + q);

			System.out.println(melhor.getTabuleiro());
		}catch(Exception err) {
			System.out.println(err);
		}
	}

	static Individuo selecionarMelhorFitnessTorneio() {
		Random r = new Random();
		//Melhor fitness por torneio
		Populacao p = new Populacao(2, false, Nrainhas);

		p.setIndividuo(geracao.get(geracao.size() - 1).getIndividuo(0));
		p.setIndividuo(geracao.get(geracao.size() - 1).getIndividuo(1));
		p.ordenaPopulacao();

		int pos;

		r = new Random();
		if (r.nextDouble() < 0.5) {
			pos = 0;
		} else {
			pos = 1;
		}

		return p.getIndividuo(pos);

		//Metodo da roleta
		/*
        double media = 0;
        media = geracao.get(geracao.size() -1).getMediaAptidao();

        int s = gerador.nextInt(soma - 1);
        int i = 0;
        int aux = gera.getIndividuos().get(0).getFitness();

        while (aux < s) {
            i = i + 1;
            aux = aux + gera.getIndividuos().get(i).getFitness();
        }

        indaux = gera.getIndividuos().get(i);
        return indaux;  */
	}

	static Populacao cruzamento() {
		int n = 1;
		int PontoDeCorte1;
		int PontoDeCorte2;
		Populacao NovaPopulacao = new Populacao(TamPopu, false, Nrainhas);

		// NovaPopulacao.setIndividuo(ind1);
		//NovaPopulacao.setIndividuo(ind2);
		int para = 0;
		while (n < TamPopu) {
			PontoDeCorte1 = gerador.nextInt(6);
			PontoDeCorte2 = gerador.nextInt(6);

			while ((PontoDeCorte1 == PontoDeCorte2) && (para != 20)) {
				PontoDeCorte2 = gerador.nextInt(6);
				para++;
			}
			if (PontoDeCorte1 > PontoDeCorte2) {
				int aux = PontoDeCorte1;
				PontoDeCorte1 = PontoDeCorte2;
				PontoDeCorte2 = aux;
			}
			Individuo filho1 = new Individuo(false, Nrainhas);
			Individuo filho2 = new Individuo(false, Nrainhas);
			//Individuo filho3 = new Individuo(false);

			int[] aux1 = new int[Nrainhas];
			int[] aux2 = new int[Nrainhas];
			//    int[] aux3 = new int[Nrainhas];

			for (int j = 0; j < Nrainhas; j++) {
				if (j < PontoDeCorte1 + 1) {
					try {
						aux1[j] = (ind1.getRainha(j));
						aux2[j] = (ind2.getRainha(j));

					} catch (Exception ex) {
						System.out.println(PontoDeCorte1 + " " + j);
						System.exit(0);
					}
				} else if (j < PontoDeCorte2 + 1) {
					aux1[j] = (ind1.getRainhaDalinha()[j]);
					aux2[j] = (ind2.getRainhaDalinha()[j]);

				} else {
					aux1[j] = (ind1.getRainhaDalinha()[j]);
					aux2[j] = (ind2.getRainhaDalinha()[j]);
				}

			}
			//MutaÃ§Ã£o 

			double sorteio = gerador.nextDouble();

			if (sorteio <= 0.35) {
				int posicao1 = gerador.nextInt(Nrainhas - 1);
				int posicao2 = gerador.nextInt(Nrainhas - 1);

				para = 0;
				while ((posicao1 == posicao2) && (para != 20)) {
					posicao2 = gerador.nextInt(Nrainhas - 1);
					para++;
				}

				int auxiliar = aux1[posicao2];
				aux1[posicao2] = aux1[posicao1];
				aux1[posicao1] = auxiliar;

			}
			/*else if(sorteio >= 0.66) {
                int posicao1 = gerador.nextInt(6);
                int posicao2 = gerador.nextInt(6);
                para =0;
                while ((posicao1 == posicao2) && (para != 20)) {
                    posicao2 = gerador.nextInt(6);
                    para++;
                }
                int auxiliar = aux2[posicao2];
                aux2[posicao2] = aux2[posicao1];
                aux2[posicao1] = auxiliar;
            }

            //Fim da mutaÃ§Ã£o*/
			filho1.setRainhaDalinha(aux1);
			filho1.calcularFitness();

			filho2.setRainhaDalinha(aux2);
			filho2.calcularFitness();

			NovaPopulacao.setIndividuo(filho1);
			NovaPopulacao.setIndividuo(filho2);

			n = n + 2;
		}
		return NovaPopulacao;
	}

	private static boolean fitnessBom() {

		for (int i = 0; i < TamPopu; i++) {
			if (geracao.get(geracao.size() - 1).getIndividuo(i).getFitness() == 0) {

				melhor = geracao.get(geracao.size() - 1).getIndividuo(i);

				return false;
			}

		}
		PosicaoGeracao++;
		return true;
	}

	public static Individuo selecaoRodaDaRoleta(Populacao populacao) {

		int Total = populacao.getTotalAptidaoInvertida();
		Individuo[] Roleta = new Individuo[Total];

		int IndiceRoleta = 0;
		int parada;

		for (int i = 0; i < TamPopu; i++) {

			parada = populacao.getIndividuo(i).getFitness();
			parada = colisaoMax + 1 - parada;

			while ((parada != 0) && (IndiceRoleta < Total)) {
				Roleta[IndiceRoleta] = populacao.getIndividuo(i);
				IndiceRoleta++;
				parada--;
			}

		}

		int sorteio = gerador.nextInt(Total - 1);
		Individuo ind = Roleta[sorteio];

		if (ind == null) {
			System.out.println("erro");
		}
		return ind;

	}

}
