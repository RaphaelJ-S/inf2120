package tp4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Phrase extends ArrayList< String > {
    /**
     * Tableau contenant les 'Mot Vide' possibles.
     * Reference : https://www.ranks.nl/stopwords/french
     */
    public static String [] MOT_VIDE = {
    		"alors", "au", "aucuns", "aussi", "autre", "avant", "avec", "avoir",
            "bon", "ca", "car", "ce", "cela", "ces", "ceux", "chaque", "ci",
            "comme", "comment", "dans", "debut", "dedans", "dehors", "depuis",
            "des", "devrait", "doit", "donc", "dos", "du", "elle", "elles", "en",
            "encore", "essai", "est", "et", "etaient", "etat", "ete", "etions",
            "etre", "eu", "fait", "faites", "fois", "font", "hors", "ici", "il",
            "ils", "je", "juste", "la", "la", "le", "les", "leur", "ma",
            "maintenant", "mais", "meme", "mes", "mien", "moins", "mon", "mot",
            "ni", "nommes", "notre", "nous", "ou", "par", "parce", "pas", "peu",
            "peut", "plupart", "pour", "pourquoi", "quand", "que", "quel",
            "quelle", "quelles", "quels", "qui", "sa", "sans", "ses", "seulement",
            "si", "sien", "son", "sont", "sous", "soyez", "sujet", "sur", "ta",
            "tandis", "tellement", "tels", "tes", "ton", "tous", "tout", "tres",
            "trop", "tu", "voient", "vont", "votre", "vous", "vu"
    };

    public Phrase(){}

    public Phrase( Collection< String > collection ) {
        super( collection );
    }

    /**
     * QUESTION 3
     *
     * Enleve les 'Mot Vide' de la Phrase sans changer l'ordre des autres Mots.
     */
    public void nettoyer() {
    	
    	for(int i = 0 ; i < this.size() ; i++) {
	    	int debut = 0;
	    	int fin = MOT_VIDE.length - 1;
	    	while (debut < fin) {
	    		int milieu = (debut + fin)/2;
	    		if(this.get(i).compareToIgnoreCase(MOT_VIDE[milieu]) <= 0) {
	    			fin = milieu;
	    		}else {
	    			debut = milieu + 1;
	    		}
	    	}
	    	if ( this.get(i).compareToIgnoreCase(MOT_VIDE[debut]) == 0) {
	    		this.set(i, "");
	    	}
    	}
    	for ( int i = this.size() -1 ; i >= 0 ; i--) {
    		if ( this.get(i).isEmpty()) {
    			this.remove(i);
    		}
    	}
    }
}
