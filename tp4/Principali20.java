package tp4;
/**
 * @auteur Raphael Jacob-Simard
 * @CodePermanant JACR26038907
 * @Cours INF2120
 * @Groupe 30
 */
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Principali20 {
    /**
     * QUESTION 1
     *
     * Cette methode tri le tableau.
     * Le tri est fait comme le tri slection, mais a chaque tour de la boucle
     * interne, vous devez choisir le minimum et le maximum.
     * Lorsque la boucle interne les a trouve, alors elle les places au bon
     * endroit.
     *
     * ************************************************************************
     * Placez votre analyse de complexite temporelle ici, analyse de pire cas :
     * 
     * Comme le tri selection normal, la complexite du pire cas est la meme que
     * celle du meilleur puisqu'il n'y a pas de mechanisme pour ignorer certains
     * cas.
     *
     * Le tri selectionDouble fait deux comparaisons par boucles puisqu'il
     * compare le maximum et le minimum chaque fois et la boucle retricie de 
     * deux par passsage.  la complexite ressemble a:
     *
     * 2(n-1) + 2(n-3) + 2(n-5) + ... +2
     * =n(n-2)/2 + (n-1)/2
     * =1/2(n^2 -2) + 1/2(n-1)
     * qui est de complexite O(n^2)
     *
     * ************************************************************************
     *
     * @param tab Le tableau a trier.
     * @param <E> Le type des elements du tableau.  Le tri utilise le comparateur
     *           de ce type (Comparable).
     */
	public static < E extends Comparable<E>> void triDoubleSelection( E[] tab) {
		int k = tab.length - 1;
		for(int i = 0 ; i <= k - 1; i++) {
			int posMin = i;
			int posMax = k;
			E minimum = tab[i];
			E maximum = tab[i];
			for (int j = i + 1 ; j <= k ; j++ ) {
				if(minimum.compareTo(tab[j]) > 0) {
					posMin = j;
					minimum = tab[j];
				}else if(maximum.compareTo(tab[j]) < 0) {
					posMax = j;
					maximum = tab[j];
				}
			}
			tab[posMin] = tab[i];
			tab[i] = minimum;
			tab[posMax] = tab[k];
			tab[k] = maximum;
			k--;			
		}
	}


    /**
     * QUESTION 2
     *
     * type F : equals.
     *
     * ************************************************************************
     * Placez votre Lamda ici :
     *
     * Function<String, Boolean> fonction = x -> x.length() >= 5 
				&& (x.charAt(0) >= 'A' && x.charAt(0) <= 'Z');
     *
     *
     * ************************************************************************
     *
     * @param tab Le tableau a classer.
     * @param classification Une fonction qui transforme les éléments en éléments utiliés
     *                       pour la comparaison et la classification.
     * @param <E> Type des éléments de bases
     * @param <F> Type des éléments transformés
     */
    public static < E, F >
    void classer( E [] tab, Function< E, F > classification ) {
    	for ( int i = 1 ; i < tab.length ; i++) {
			int j = i - 1;
			E tmp = tab[i];
			while ( j >= 0 && !classification.apply(tab[j]).equals
					(classification.apply(tmp))) {
				tab[j+1] = tab[j];
				j--;
			}
			tab[j+1] = tmp;
		}
    }




    public static void main( String [] argv ) {
    	Phrase p = new Phrase( Arrays.asList( "il", "devrait", "y", "avoir", "une", "valeur", "sur", "la", "pile" ) );
        List< String > r = Arrays.asList( "y", "une", "valeur", "pile" );

        p.nettoyer();
        System.out.println(p);
    }
}
