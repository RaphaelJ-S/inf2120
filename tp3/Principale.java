package tp3;

import java.util.Scanner;

/**
 * @auteur Raphael Jacob-Simard
 * @CodePermanant JACR26038907
 * @Cours INF2120
 * @Groupe 30
 */
/**
 *Affiche les nGrammes de deux phrases et calcule la comparaisons entre les deux
 */
public class Principale {
	public static final String MSG_SOL_PHRASE1 = "Entrez la phrase générée : ";
	public static final String MSG_SOL_PHRASE2 = "Entrez la phrase cible : ";
	/**
	 * Calcule le cardinal de l'intersection, le rappel, la precision et la 
	 * f-mesure entre les deux nGrammes donnes en parametre et les affiche.
	 * 
	 * @param phrase1 Un nGramme que l'on souhaite comparer
	 * @param phrase2 Un nGramme que l'on souhaite comparer
	 */
	public static void calculCardRappPresFmes
			(nGramme phrase1, nGramme phrase2) {
		int cardinalFin = 0;
		double rappel = 0.0;
		double precision = 0.0;
		double fMesure = 0.0;
		String presCardinal = "";
		String presRappel = "";
		String presPrecision = "";
		String presFMesure = "";
		
		for(int i = 1 ; i < 5 ; i++) {
			cardinalFin = phrase1.calculCardinalIntersection(phrase2, i);
			rappel = phrase2.calculRappelPrecision(cardinalFin, i);
			precision = phrase1.calculRappelPrecision(cardinalFin, i);
			fMesure = phrase1.fMesure(rappel, precision);
			if(i == 4) {
				presCardinal += "c" + i + " = " + cardinalFin + ".";
				presRappel += "r" + i + " = " + rappel + ".";
				presPrecision += "q" + i + " = " + precision + ".";
				presFMesure += "F" + i + " = " + fMesure + ".";
			}else {
				presCardinal += "c" + i + " = " + cardinalFin + ", ";
				presRappel += "r" + i + " = " + rappel + ", ";
				presPrecision += "q" + i + " = " + precision + ", ";
				presFMesure += "F" + i + " = " + fMesure + ", ";
			}
		}
		System.out.print(presCardinal + "\n" + presRappel + "\n" 
					+ presPrecision + "\n" + presFMesure + "\n");
	}
	/**
	 * Demande l'entree de deux phrases, les converti en nGramme et affiche le
	 * contenu de ces nGrammes.
	 */
	public static void main (String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print(MSG_SOL_PHRASE1);
		String phrase1 = sc.nextLine();
		
		System.out.print(MSG_SOL_PHRASE2);
		String phrase2 = sc.nextLine();
		
		sc.close();
	
		nGramme premier = new nGramme(phrase1);
		nGramme deuxieme = new nGramme(phrase2);

		premier.montrer(1);
		deuxieme.montrer(2);

		calculCardRappPresFmes(premier, deuxieme);
	}
}
