package tp3;

import java.util.ArrayList;
/**
 * Contient les methodes necessaire pour creer des ngrammes a partir d'une 
 * phrase, les modifier et faire quelques calculs de comparaison.
 */
public class nGramme {
	private ArrayList<ArrayList<String>> n1Gramme;
	private ArrayList<ArrayList<String>> n2Gramme;
	private ArrayList<ArrayList<String>> n3Gramme;
	private ArrayList<ArrayList<String>> n4Gramme;
	
	public static final String AFF_NG1 = "1-grammes de la phrase ";
	public static final String AFF_NG2 = "2-grammes de la phrase ";
	public static final String AFF_NG3 = "3-grammes de la phrase ";
	public static final String AFF_NG4 = "4-grammes de la phrase ";

	public nGramme(String phrase) {
		setNxGramme(phrase);	
	}
	/**
	 * Construit les nGrammes de 1 a 4 pour une phrase donnee et les mets sous
	 * forme de listes. Si la phrase est vide, retourne une liste vide.
	 * 
	 * @param phrase La phrase a transformer en nGramme
	 */
	public void setNxGramme(String phrase) {
		ArrayList<String> tableau = stringToArrayList(phrase);
		ArrayList<ArrayList<String>> arrayFin = new ArrayList<>();
		
		if(!phrase.isEmpty()) {
			for(int nbrGr = 1 ; nbrGr < 5 ; nbrGr++) {
				for(int i = 0 ; i <= tableau.size() - nbrGr; i++) {
					ArrayList<String> arrayInter = new ArrayList<>();
					
					for(int j = i ; j < i + nbrGr ; j++) {
						arrayInter.add("\"" + tableau.get(j) + "\"");
					}
					arrayFin.add(arrayInter);
				}
				switch (nbrGr){
					case 1:
						n1Gramme = arrayFin;
						break;
					case 2:
						n2Gramme = arrayFin;
						break;
					case 3:
						n3Gramme = arrayFin;
						break;
					case 4:
						n4Gramme = arrayFin;
						break;
				}
				arrayFin = new ArrayList<>();
			}
		}else {
			n1Gramme = arrayFin;
			n2Gramme = arrayFin;
			n3Gramme = arrayFin;
			n4Gramme = arrayFin;
		}
	}
	/**
	 * Separe une phrase en ne prennant que les lettres et mets chaque partie
	 * dans une ArrayList.
	 * 
	 * @param phrase La phrase que l'on desire separer
	 * @return		 Une ArrayList contenant les mots/lettres de la phrase
	 */
	public ArrayList<String> stringToArrayList(String phrase) {
		ArrayList<String> reponse =  new ArrayList<>();
		String [] tableau =	phrase.split("[^A-z]");
		int i = 0;
		
		while (i < tableau.length) {
			if(!tableau[i].isEmpty()) {
				reponse.add(tableau[i]);
			}
			i++;
		}
		return reponse;
	}
	/**
	 * retourne la valeur de l'attribut <n1Gramme>
	 * 
	 * @return l'attribut <n1Gramme>
	 */
	public ArrayList<ArrayList<String>> getN1Gramme() {
		return n1Gramme;
	}
	/**
	 * retourne la valeur de l'attribut <n2Gramme>
	 * 
	 * @return l'attribut <n2Gramme>
	 */
	public ArrayList<ArrayList<String>> getN2Gramme() {
		return n2Gramme;
	}
	/**
	 * retourne la valeur de l'attribut <n3Gramme>
	 * 
	 * @return l'attribut <n3Gramme>
	 */
	public ArrayList<ArrayList<String>> getN3Gramme() {
		return n3Gramme;
	}
	/**
	 * retourne la valeur de l'attribut <n4Gramme>
	 * 
	 * @return l'attribut <n4Gramme>
	 */
	public ArrayList<ArrayList<String>> getN4Gramme() {
		return n4Gramme;
	}
	/**
	 * Affiche tous les nGrammes
	 * 
	 * @param p1OuP2 Le nombre de la phrase(1 ou 2)
	 */
	public void montrer(int p1OuP2) {
		
		System.out.print(AFF_NG1 + p1OuP2 + " = " + modifierArrayG1(n1Gramme));
		System.out.println();
		
		System.out.print(AFF_NG2 + p1OuP2 + " = " + modifierArray(n2Gramme));
		System.out.println();

		System.out.print(AFF_NG3 + p1OuP2 + " = " + modifierArray(n3Gramme));
		System.out.println();

		System.out.print(AFF_NG4 + p1OuP2 + " = " + modifierArray(n4Gramme));
		System.out.println();

		
	}
	/**
	 * Modifie la presentation des elements de la liste donnee en parametre et
	 * la retourne sous forme de String.
	 * 
	 * @param aModifier  La liste a modifier
	 * @return 			 La liste modifiee sous forme de String
	 */
	public String modifierArray(ArrayList<ArrayList<String>> aModifier) {
		String reponse = "[";
		if(!aModifier.isEmpty()) {
			for(int i = 0 ; i < aModifier.size() ; i++) {
				reponse += "(";
				for(int j = 0 ; j < aModifier.get(i).size() ; j++) {
					if(j == aModifier.get(i).size() -1) {
						reponse += aModifier.get(i).get(j);
					}else {
						reponse += aModifier.get(i).get(j) + ",";
					}
				}
				if(i == aModifier.size() - 1) {
					reponse += ")";
				} else {
					reponse += "), ";
				}
			}
		}
		return reponse + "]";
	}
	/**
	 * Modifie la presentation des elements de la liste donnee en parametre et
	 * la retourne sous forme de String.
	 * 
	 * @param aModifier La liste a modifier
	 * @return			La liste modifiee sous forme de String
	 */
	public String modifierArrayG1(ArrayList<ArrayList<String>> aModifier) {
		String reponse = "[";
		if(!(aModifier.isEmpty())) {
			for(int i = 0 ; i < aModifier.size(); i++) {
				if (i == aModifier.size() -1 ) {
					reponse += aModifier.get(i).get(0);
				}else {
					reponse += aModifier.get(i).get(0) + ", ";
				}
			}
		}
		return reponse + "]";
	}
	/**
	 * Calcule le cardinal du n<niveau>Gramme
	 * 
	 * @param niveau Le nombre de l'attribut voulu
	 * @return	 	 Le cardinal de l'attribut voulu
	 */
	public double calculCardinal(int niveau) {
		double cardinal = 0;
		
		switch (niveau) {
			case 1:
				cardinal = n1Gramme.size();
				break;
			case 2:
				cardinal = n2Gramme.size();
				break;
			case 3:
				cardinal = n3Gramme.size();
				break;
			case 4:
				cardinal = n4Gramme.size();
		}
		return cardinal;
	}
	/**
	 * Calcule le cardinal de l'intersection entre deux n<niveau>Grammes.
	 * 
	 * @param phrase2  Le deuxieme nGramme pour lequel on veut l'intersection
	 * @param niveau   Le nombre de l'attribut voulu
	 * @return		   Le cardinal de l'intersection entre les deux nGrammes
	 */
	public int calculCardinalIntersection(nGramme phrase2, int niveau) {
		int reponse = 0;
		switch(niveau) {
			case 1:
				reponse =intersectionNGramme(n1Gramme, phrase2.n1Gramme).size();
				break;
			case 2:
				reponse =intersectionNGramme(n2Gramme, phrase2.n2Gramme).size();
				break;
			case 3:
				reponse =intersectionNGramme(n3Gramme, phrase2.n3Gramme).size();
				break;
			case 4:
				reponse =intersectionNGramme(n4Gramme, phrase2.n4Gramme).size();
				break;
		}
		return reponse;
	}
	/**
	 * Calcule le rappel ou la precision.
	 * 
	 * @param cardinalInter Le cardinal d'un nGramme
	 * @param niveau		Le nombre de l'attribut voulu
	 * @return				Le rappel ou la precision par rapport au nGramme
	 */
	public double calculRappelPrecision(int cardinalInter,int niveau) {
		double cardinal = calculCardinal(niveau);
		double resultat = 0.0;
		
		if(!(cardinal == 0)) {
			resultat = cardinalInter/cardinal;
		}
		return resultat;
	}
	/**
	 * Calcule la f-mesure entre deux phrases.
	 * 
	 * @param rappel	Le rappel entre deux phrases
	 * @param precision La precision entre deux phrases
	 * @return			la f-mesure entre deux phrases
	 */
	public double fMesure(double rappel, double precision) {
		double resultat = 0.0;
		
		if(!((rappel + precision) == 0.0)) {
			resultat =  2 * ((rappel * precision) / (rappel + precision));
		}
		
		return resultat;
	}
	/**
	 * Cree une nouvelle liste contenant l'intersection de deux listes.
	 * 
	 * @param premier	La premiere liste pour laquelle on veut l'intersection
	 * @param deuxieme  La deuxieme liste pour laquelle on veut l'intersection
	 * @return			La liste contenant l'intersection
	 */
	private ArrayList<ArrayList<String>> intersectionNGramme
				(ArrayList<ArrayList<String>> premier, 
				ArrayList<ArrayList<String>> deuxieme) {
		
		ArrayList<ArrayList<String>> reponse = new ArrayList<>();
		ArrayList<ArrayList<String>> premierTmp = clonerMinuscule(premier);
		ArrayList<ArrayList<String>> deuxiemeTmp = clonerMinuscule(deuxieme);
		
		boolean suite = false;

		for(int i = 0 ; i < premier.size(); i++) {
			int j = 0;
			suite = true;
			while(j < deuxiemeTmp.size() && suite) {
				if(premierTmp.get(i).equals(deuxiemeTmp.get(j))) {
					
					reponse.add(premier.get(i));
					deuxiemeTmp.remove(j);
					suite = false;
				}
				j++;
			}
		}
		return reponse;
	}
	/**
	 * Cree une nouvelle liste contenant les elements que la liste donnee
	 * en parametre tranformes en lettres minuscules.
	 * 
	 * @param liste La liste que l'on desire cloner en lettres minuscules
	 * @return 		Le clone de la liste donnee en parametre
	 */
	private ArrayList<ArrayList<String>> clonerMinuscule
			(ArrayList<ArrayList<String>> liste) {
		ArrayList<ArrayList<String>> reponse = new ArrayList<>();
		
		for(int i = 0 ; i < liste.size(); i++) {
			ArrayList<String> nvListe = new ArrayList<>();
			reponse.add(nvListe);
			for(int j = 0 ; j < liste.get(i).size() ; j++) {
				reponse.get(i).add(liste.get(i).get(j).toLowerCase());
			}
		}
		return reponse;
	}
	
}
